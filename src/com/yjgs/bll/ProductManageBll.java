package com.yjgs.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import com.yjgs.dal.ProductDal;
import com.yjgs.dal.ProductListDal;
import com.yjgs.dal.ProductParamDal;
import com.yjgs.dal.ProductPictureDal;
import com.yjgs.dal.ProductTypeDal;
import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductList;
import com.yjgs.dcl.ProductParam;
import com.yjgs.dcl.ProductPicture;
import com.yjgs.dcl.ProductType;
import com.yjgs.enumdata.ProductPictureType;
import com.yjgs.publ.PictureDeal;

public class ProductManageBll {
	
	
	/**
	 * 添加新的类别
	 * 
	 * @param fType		类别名称
	 * @return				返回是否添加成功
	 */
	public boolean addNewType(ProductType fType) {
		
		ProductTypeDal ptDal = null;
		
		
		try {
			
			//步骤1：实例化DAL
			ptDal = new ProductTypeDal();
			
			return ptDal.addType(fType);
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：添加类别异常");
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 加载产品类别列表 
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadProductTypeList(JspWriter fOut) {
		
		ProductTypeDal ptDal = null;
		ProductListDal pDal = null;
		ArrayList<ProductType> types = null;
		
		try {
			
			//步骤1：实例化Dal获取所有类别数据
			pDal = new ProductListDal();
			
			ptDal = new ProductTypeDal();
			types = ptDal.getAllTypes();
			if(types == null) throw new Exception("当前数据库不存在任何类别数据");
			
			//步骤2：遍历类别集合，输出表格以及表单信息
			for(int i =0; i<types.size(); i++) {
				
				int productNum = 0;
				ProductList typeID = null;
				ArrayList<ProductList> products = null;
				
				//步骤2.1：获取产品数量
				
				typeID = new ProductList();
				typeID.setProductTypeID(types.get(i).getTypeID());
				products = pDal.getListByType(typeID);
				if(products == null) productNum = 0;
				else productNum = products.size();
				
				//步骤2.1：输出各表格项并绑定数据
				fOut.println("<tr>");
				fOut.println(String.format("<td>%d</td>", i+1));
				fOut.println(String.format("<td>%s</td>", types.get(i).getTypeName()));
				fOut.println(String.format("<td>%d</td>", productNum));
				fOut.println(String.format("<td class='modifyTd'><a href='#' onclick='Modify(this,%d);return false'>修改</a></td>", types.get(i).getTypeID()));
				fOut.println(String.format("<td class='deleteTd'><a href='DeleteType?typeID=%d' onclick='return sureDelete();'>删除</a></td>",types.get(i).getTypeID()));
				fOut.println("</tr>");
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品类别列表加载失败");
			e.printStackTrace();
			return;
		}
		
		
		
	}
	
	
	/**
	 * 删除一个产品类别
	 * 
	 * @param fType		类别实体类
	 * @return				返回是否成功删除
	 */
	public boolean deleteAType(ProductType fType) {
		
		ProductTypeDal ptDal = null;
		ProductDal pDal = null;
		
		try {
			
			//步骤1：实例化DAL
			ptDal = new ProductTypeDal();
			pDal = new ProductDal();
			
			
			//步骤2：更新类别下的产品的类别ID（更改为0）
			Product typeID = new Product();
			typeID.setProductTypeID(fType.getTypeID());
			if(!pDal.updateWTypeD(typeID)) {
				return false;
			}
			
			//步骤3：删除类别
			if(!ptDal.deleteType(fType)) {
				return false;
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品类别删除异常");
			e.printStackTrace();
			return false;
			
		}

		return true;
	}

	
	/**
	 * 修改一个类别名称
	 * 
	 * @param fType		类别实体类
	 * @return				返回是否成功修改
	 */
	public boolean modifyType(ProductType fType) {
		
		ProductTypeDal ptDal = null;
		
		try {
			
			ptDal = new ProductTypeDal();
			if(!ptDal.updateType(fType)) {
				return false;
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品类别修改异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 输出类别选择
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadTypeOption(JspWriter fOut) {
		
		ProductTypeDal ptDal = null;
		ArrayList<ProductType> types = null;
		
		
		try {
			
			//步骤1：获取所有的类别
			ptDal = new ProductTypeDal();
			types = ptDal.getAllTypes();
			
			//步骤2：输出下拉框表单
			fOut.println("<option value=0>请选择...</option>");
			for(ProductType aType : types) {
				
				fOut.println(String.format("<option value=%d>%s</option>",
						aType.getTypeID(),aType.getTypeName()));
			}

		} catch (Exception e) {
			
			System.out.println("业务逻辑层：加载类别选择异常");
			e.printStackTrace();
			return;
		}
		
		
	}

	/**
	 * 添加新的产品以及参数
	 * 
	 * @param fProduct		产品实体类数据
	 * @param fParams		产品参数实体类数据
	 * @return					返回产品ID
	 */
	public int addProduvtAndParams(Product fProduct,ArrayList<ProductParam> fParams) {
		
		ProductDal pDal = null;
		ProductParamDal  ppDal = null;
		int productID = 0;
		
		try {
			
			//步骤1：实例化Dal
			pDal = new ProductDal();
			ppDal = new ProductParamDal();
			
			//步骤2：添加产品信息
			productID = pDal.addProduct(fProduct);
			if (productID == 0) return 0;
			
			//步骤3：绑定产品ID到参数信息中并添加
			for(ProductParam aParam : fParams) {
				
				aParam.setProductID(productID);
				
				if(!ppDal.addParam(aParam)) return 0;
			}

		} catch (Exception e) {

			System.out.println("业务逻辑层：产品及产品参数的添加异常");
			e.printStackTrace();
			return 0;
		}
		
		return productID;
	}

	/**
	 * 加载当前产品已保存的预览图
	 * 
	 * @param productID
	 * @param fOut
	 */
	public void loadExistBrePic(int productID,JspWriter fOut ) {
		
		ProductPicture product = null;
		ArrayList<ProductPicture> pictures = null;
		ProductPictureDal ppDal = null;
		
		try {
			
			//步骤1：实例化Dal
			ppDal = new ProductPictureDal();
			
			//步骤2：调用DAL获取产品指定的预览图片
			product = new ProductPicture();
			product.setProductID(productID);
			
			pictures = ppDal.getProBrePics(product);
			
			//步骤3：遍历图片集合输出图片
			if(pictures == null) {
				
				fOut.println("<p>暂无上传预览图</p>");
				return;
			}
			
			for(ProductPicture aPicture : pictures) {
				
				fOut.println(String.format("<img src='%s' />", aPicture.getPictureBreAddr()));
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品预览图异常");
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * 获取当前产品的图片数量
	 * 
	 * @param productID			产品ID
	 * @return							返回产品预览图数量
	 */
	public int getProPicNum(int productID) {
		
		ProductPicture product = null;
		ArrayList<ProductPicture> pictures = null;
		ProductPictureDal ppDal = null;
		
		try {

			// 步骤1：实例化Dal
			ppDal = new ProductPictureDal();

			// 步骤2：调用DAL获取产品指定的预览图片
			product = new ProductPicture();
			product.setProductID(productID);

			pictures = ppDal.getProBrePics(product);

			// 步骤3：遍历图片集合输出图片
			if (pictures == null) {
				
				return 0;
			}
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品预览图异常");
			e.printStackTrace();
			return 0;
		}
		
		return pictures.size();
	}
	
	/**
	 * 添加新的产品预览图（裁减后压缩）
	 * 
	 * @param fRequest			Servlet请求
	 * @return						返回是否添加成功
	 */
	public boolean addNewProductPic(HttpServletRequest fRequest) {
		
		ProductPictureDal ppDal = null;
		PictureDeal pDeal = null;
		String imgPath = null;
		String outImgPath = null;
		String comPath = null;
		int x;
		int y;
		int w;
		int h;
		int tarWidth;
		int tarHeight;
		
		//步骤1：图片裁减
		try {
			
			//步骤1.1：获取图片裁减的相关参数
			x = (int)Math.round(Double.valueOf(fRequest.getParameter("image.x").toString()));
			y = (int)Math.round(Double.valueOf(fRequest.getParameter("image.y").toString()));
			w = (int)Math.round(Double.valueOf(fRequest.getParameter("image.width").toString())); 
			h = (int)Math.round(Double.valueOf(fRequest.getParameter("image.height").toString())); 
			tarWidth = (int)Math.round(Double.valueOf(fRequest.getParameter("tarWidth").toString())); 
			tarHeight = (int)Math.round(Double.valueOf(fRequest.getParameter("tarHeight").toString())); 
			imgPath = fRequest.getParameter("image.Path").toString(); 
			
			//步骤1.2：调用图片裁减类裁减方法进行裁减
			pDeal = new PictureDeal();
			outImgPath= pDeal.cropPicture(fRequest, imgPath, x, y, w, h,tarWidth,tarHeight,"ProductPicture");
			if(outImgPath == null) return false;
			
		} catch (Exception e) {

			System.out.println("图片裁减异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤2：图片压缩
		try {
			
			//压缩为285*180大小
			comPath = pDeal.compressPicture(fRequest, outImgPath, "ProductPicture", 285, 180);
			if(comPath == null) return false;
			
		} catch (Exception e) {
			
			System.out.println("图片压缩异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤3：添加产品图片记录
		try {
			
			//步骤1：构造产品与图片映射实体类
			String[] temp = outImgPath.split("/");
			String fileName = temp[temp.length - 1];
			
			ProductPicture picture = new ProductPicture();
			picture.setProductID(Integer.valueOf(fRequest.getParameter("productID")));
			picture.setFileName(fileName);
			picture.setDisplay(ProductPictureType.BrePicture);
			picture.setPictureAddr(outImgPath);
			picture.setPictureBreAddr(comPath);

			//步骤2：调用DAL并添加新的图片
			ppDal = new ProductPictureDal();
			if(!ppDal.addPicture(picture)) return false;
			
			
		} catch (Exception e) {

			System.out.println("图片添加异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 添加新的产品介绍
	 * 
	 * @param fProduct			产品信息（包括介绍）
	 * @param fRequest			Servlet请求
	 * @return						返回是否成功添加
	 */
	public boolean addNewProductIntroduce(Product fProduct,HttpServletRequest fRequest) {
		
		ProductDal pDal = null;
		PictureDeal picDeal = null;
		boolean isHasPic = false;
		
		try {
			
			//步骤1：实例化DAL以及Deal
			pDal = new ProductDal();
			picDeal = new PictureDeal();
			
			//步骤2：获取用户ID
			String userID = fRequest.getSession(true).getAttribute("UserID").toString();
			
			//步骤3：将介绍中的图片资源从缓存区复制到正式目录
			Pattern p = Pattern.compile("<img.*?src=['\"](../PicCache/" + userID +"/[^'\"]+?)['\"][^/>]+?/>");
			Matcher m = p.matcher(fProduct.getIntroduct());
			while(m.find()) {
				
				isHasPic = true;
				//调用图片Deal进行实际复制
				if(!picDeal.fileCopy(fRequest, m.group(1), "ProductIntroPic"))
					return false;
			}	
			//检测以上步骤是否成功进行
			if(isHasPic) {
				
				//步骤4：替换原路径为目标路径
				fProduct.setIntroduct(
						fProduct.getIntroduct().replaceAll(
								"../PicCache/" + userID +"/" , "../ProductIntroPic/")); 
			}
			
			//步骤5：调用DAL更新介绍信息
			if(!pDal.updateIntroduce(fProduct)) return false;
			
		} catch (Exception e) {

			System.out.println("产品介绍添加异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 加载产品类别下拉框的B版本（适用于产品列表的展示）
	 * 
	 * @param fOut	JSP输出对象
	 * @param fRequest Servlet请求
	 */
	public void loadTypeOption_B(JspWriter fOut,HttpServletRequest fRequest) {
		
		ProductTypeDal ptDal = null;
		ArrayList<ProductType> types = null;
		int typeID = 0;

		try {

			// 步骤1：获取所有的类别
			ptDal = new ProductTypeDal();
			types = ptDal.getAllTypes();
			
			//步骤2：获取当前类别ID
			if(fRequest.getParameter("typeID") != null) {
				
				typeID = Integer.valueOf(fRequest.getParameter("typeID"));
			}
			
			// 步骤3：输出下拉框表单
			fOut.println("<option value=0>所有类别</option>");
			for (ProductType aType : types) {

				fOut.println(String.format("<option value=%d %s>%s</option>",
						aType.getTypeID(),
						aType.getTypeID() == typeID? "selected='selected'":"", 
						aType.getTypeName()));
			}


		} catch (Exception e) {

			System.out.println("业务逻辑层：加载类别选择异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载产品列表
	 * 
	 * @param fOut			JSP输出对象
	 * @param fRequest		Servlet请求
	 */
	public void loadProductList(JspWriter fOut,HttpServletRequest fRequest) {
		
		ProductListDal pListDal = null;
		ProductParamDal ppDal = null;
		ProductList product = null;
		ArrayList<ProductList> products = null;
		int page = 1;
		
		try {
			
			//步骤1：获取产品类别以及页数数据
			product = new ProductList();
			product.setProductTypeID(0);
			if(fRequest.getParameter("typeID") != null) {
				
				product.setProductTypeID(Integer.valueOf(fRequest.getParameter("typeID")));
			}
			
			if(fRequest.getParameter("page") != null) {
				
				page = Integer.valueOf(fRequest.getParameter("page"));
			}
			
			//步骤2：实例化DAL并获取相应类别相应页数的产品数据
			ppDal = new ProductParamDal();
			
			pListDal = new ProductListDal();
			products = pListDal.getList(product, page);
			if(products == null) return;
			
			//步骤3：遍历产品列表项集合，输出表格数据
			
			//设置时间格式
			DateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
			
			for(ProductList aProduct : products) {
				
				//步骤3.1：输出行头
				fOut.println("<tr>");
				
				//步骤3.2：输出各数据
				fOut.println(String.format("<td class='proName'>%s</td>", aProduct.getProductName()));
				fOut.println(String.format("<td>%s</td>", dfs.format(aProduct.getPublishTime())));
				
//				//获取参数个数
//				ProductParam aParam = new ProductParam();
//				aParam.setProductID(aProduct.getProductID());
//				ArrayList<ProductParam> params = ppDal.getParam(aParam);
//				int paramNum = 0;
//				if(params != null) paramNum = params.size();
//				
//				fOut.println(String.format("<td>%d</td>",paramNum));
				
				//输出预览图
				//若无预览图，用默认预览图代替
				fOut.println(String.format("<td><img src='%s' width=154 height=99 /></td>"
						, aProduct.getProductBreAddr()==null? "../Image/NoBrePic.jpg":aProduct.getProductBreAddr()));
				
				fOut.println(String.format("<td><a href='ProductPage.jsp?productID=%d' >查看</a></td>"
						, aProduct.getProductID()));
				fOut.println(String.format("<td><a href='DeleteProduct?productID=%d&typeID=%d&page=%d' >删除</a></td>"
						, aProduct.getProductID(),product.getProductTypeID(),page));
				
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品列表加载异常");
			e.printStackTrace();
			return;
		}		
	}
	
	/**
	 * 加载页码
	 * 
	 * @param fOut			JSP输出对象
	 * @param fRequest		Servlet请求
	 */
	public void loadPageLinks(JspWriter fOut,HttpServletRequest fRequest) {
		
		int typeID = 0;
		int page = 1;
		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum =5;  //一组页码列表的个数
		
		try {
			
			//步骤1：获取typeID以及page
			if (fRequest.getParameter("typeID") != null) {

				typeID =  Integer.valueOf(fRequest.getParameter("typeID"));
			}

			if (fRequest.getParameter("page") != null) {

				page = Integer.valueOf(fRequest.getParameter("page"));
			}
			
			//步骤2：计算总页数
			pageNum = getPageNum(typeID);

			//步骤3：计算页码列表的开始项和结尾项
			startPage = ((page -1)/pageLinksNum) * pageLinksNum;
			if(startPage == 0) startPage = 1;
			endPage = startPage + pageLinksNum;			
			if(endPage > pageNum) endPage = pageNum;
			
			//步骤4：输出页码列表
			
			//输出“上一页”
			if(page > 1) {
				
				fOut.println(String.format("<a class='upPage' href='ProductList.jsp?typeID=%d&page=%d'>上一页 </a> "
						, typeID,page - 1));
			}
			
			//输出页码列表
			for(int i = startPage; i <= endPage; i++) {
				
				fOut.println(String.format("<a href='ProductList.jsp?typeID=%d&page=%d'>%d</a> "
						, typeID,i,i));
			}
			
			//输出“下一页”
			if(page < pageNum) {
				
				fOut.println(String.format("<a class='downPage' href='ProductList.jsp?typeID=%d&page=%d'>下一页 </a> "
						, typeID,page + 1));
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：页码列表加载异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 获取总页数
	 * 
	 * @param fTypeID		类别ID
	 * @return					总页数
	 */
	public int getPageNum(int fTypeID) {
		
		int pageSize = 5;
		int productNum = 0;
		int pageNum = 1;
		
		ProductListDal pDal = new ProductListDal();
		ProductList product = new ProductList();
		product.setProductTypeID(fTypeID);
		ArrayList<ProductList> products = pDal.getListByType(product);
		if (products == null)
			productNum = 0;
		else
			productNum = products.size();
		
		//步骤3：计算总页数
		if(productNum != 0) {
			pageNum = (productNum - 1)/pageSize +1;
		}
		
		return pageNum;
	}
	
	/**
	 * 产品删除
	 * 
	 * @param fProduct		产品数据
	 * @return					返回是否删除成功
	 */
	public boolean deleteProduct(Product fProduct,HttpServletRequest fRequest) {
		
		ProductDal pDal = null;
		ProductParamDal ppDal = null;
		ProductPictureDal ppicDal = null;
		PictureDeal picDeal = null;
		
		try {
			
			//步骤1：实例化DAL
			pDal = new ProductDal();
			ppDal = new ProductParamDal();
			ppicDal = new ProductPictureDal();
			picDeal = new PictureDeal();
			
			//步骤2：删除图片
			
			//获取所有图片信息
			ArrayList<ProductPicture> pictures = null;
			ProductPicture picture = new ProductPicture();
			picture.setProductID(fProduct.getProdcuctID());
			pictures = ppicDal.getPicture(picture);
			
			//删除产品图片信息
			ppicDal.deleteProPictures(picture);
			
			//删除图片文件
			ArrayList<String> picPaths = new ArrayList<String>();
			for(ProductPicture aPicture : pictures) {
				
				picPaths.add(aPicture.getPictureAddr());
				picPaths.add(aPicture.getPictureBreAddr());
			}
			//调用图片处理类进行删除
			if(!picDeal.deleteFiles(picPaths, fRequest)) return false;
			
			//步骤3：删除参数
			ProductParam param = new ProductParam();
			param.setProductID(fProduct.getProdcuctID());
			if(!ppDal.deleteParam(param)) return false;
			
			//步骤4：删除产品介绍图片
			//获取产品介绍
			fProduct = pDal.getProduct(fProduct);
			if(fProduct == null) return false;
			
			ArrayList<String> picPaths2 = new ArrayList<String>();
			Pattern p = Pattern.compile("<img.*src=['\"](../[^'\"]+)['\"].*/>");
			Matcher m = p.matcher(fProduct.getIntroduct());
			while(m.find()) {
				picPaths2.add(m.group(1));
			}	
			if(!picDeal.deleteFiles(picPaths2, fRequest)) return false;
			
			//步骤5：删除产品信息本身
			if(!pDal.deleteProduct(fProduct)) return false;
			
		} catch (Exception e) {
			
			System.out.println("业务逻辑层：产品删除失败");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 加载产品基本信息
	 * 
	 * @param fProductID		产品ID
	 * @param fOut				JSP输出对象
	 */
	public void loadProductBaseInfo(int fProductID,JspWriter fOut) {
		
		ProductDal pDal = null;
		ProductTypeDal ptDal = null;
		Product product = null;
		ArrayList<ProductType> types = null;
		
		try {
			
			//步骤1：实例化DAL并获取产品数据
			pDal = new ProductDal();
			product = new Product();
			product.setProdcuctID(fProductID);
			product = pDal.getProduct(product);
			if(product == null) throw new Exception("产品不存在！");
			
			//步骤2：输出产品名称
			fOut.println("<div class='nameAndType'><div class='productNameDiv'><span>产品名称：</span>");
			fOut.println(String.format("<input type='text' name='productName' value='%s'></div>"
					, product.getProductName()));
			
			//步骤3：输出产品类别（下拉框）
			ptDal = new ProductTypeDal();
			types = ptDal.getAllTypes();
			if(types == null) throw new Exception("类别加载出错，类别不存在");
			
			fOut.println("<div class='productType'><span>产品类别：</span>");
			fOut.println("<select name='typeID'>");
			for(ProductType aType : types) {
				
				fOut.println(String.format("<option value=%d %s>%s</option>",
						aType.getTypeID(),
						aType.getTypeID() == product.getProductTypeID()? "selected='selected'":"",
						aType.getTypeName()));
			}
			fOut.println("</select></div></div>");
			//步骤4：输出产品发布时间
			//设置时间格式
			DateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
			
			fOut.println(String.format("<p>产品发布时间：%s</p>", 
					dfs.format(product.getPublishTime())));
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品基本信息异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载产品参数
	 * 
	 * @param fProductID		产品ID
	 * @param fOut				JSP输出对象
	 * @return						返回参数个数
	 */
	public int loadProductParams(int fProductID,JspWriter fOut) {
		
		ProductParamDal ppDal = null;
		ArrayList<ProductParam> params = null;
		
		try {
			
			//步骤1：实例化DAL并获取数据
			ppDal = new ProductParamDal();
			ProductParam param = new ProductParam();
			param.setProductID(fProductID);
			params = ppDal.getParam(param);
			if(params == null) throw new Exception("参数获取失败");
			
			//步骤2：遍历参数集合输出参数
			for(ProductParam aParam : params) {
				
				fOut.println("<tr>");
				fOut.println(String.format("<td><input type='text' name='names' value='%s'  /></td>"
						, aParam.getParamName()));
				fOut.println(String.format("<td><input type='text' name='values' value='%s'  /></td>"
						, aParam.getParamValue()));
				fOut.println("<td><input class='deletebtn' type='button' value='删除' onclick='deleteParam(this)' /></td>");
				fOut.println("</tr>");
			}
			
		} catch (Exception e) {
			
			System.out.println("业务逻辑层：加载产品参数异常");
			e.printStackTrace();
			return 0;
		}

		return params.size();
	}
	
	/**
	 * 加载产品图片列表
	 * 
	 * @param fProductID		产品ID
	 * @param fOut				JSP输出对象
	 */
	public void loadProductPicList(int fProductID,JspWriter fOut) {
		
		ProductPictureDal ppDal = null;
		ArrayList<ProductPicture> pictures = null;
		
		try {
			
			//步骤1：调用DAL并获取图片数据
			ppDal = new ProductPictureDal();
			ProductPicture picture = new ProductPicture();
			picture.setProductID(fProductID);
			pictures = ppDal.getPicture(picture);
			if(pictures == null)  {
				
				fOut.println("<p class='nosmartpic'>产品当前暂时没有预览图</p>");
			}
			
			//步骤2：遍历图片信息集合，输出图片
			for(ProductPicture aPicture : pictures) {
				fOut.print(String.format("<a href='DeleteProPic?productID=%d&picID=%d'><img src='%s' width=140 height=90 /></a>"
						,aPicture.getProductID(), aPicture.getPictureID(),aPicture.getPictureBreAddr()));
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品图片异常");
			e.printStackTrace();
			return;
		}

	}
	
	/**
	 * 加载产品介绍
	 * 
	 * @param fProductID		产品ID
	 * @param fOut				JSP输出对象
	 */
	public void loadProductIntro(int fProductID,JspWriter fOut) {
		
		ProductDal pDal = null;
		Product product = null;
		
		try {
			
			//步骤1：获调用DAL获取介绍数据
			pDal = new ProductDal();
			product = new Product();
			product.setProdcuctID(fProductID);
			product = pDal.getProduct(product);
			if(product == null) throw new Exception("无法获取产品信息,产品不存在");
			
			//步骤2：输出介绍
			if(product.getIntroduct() != null) {
				
				fOut.println(product.getIntroduct());
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品介绍异常");
			e.printStackTrace();
			return;
		}
	}
	
	public boolean deleteProPic(int fPicID,HttpServletRequest fRequest) {
		
		ProductPictureDal ppDal = null;
		PictureDeal picDeal = null;
		ProductPicture picture = null;
		
		try {
			
			//步骤1：实例化DAL并获取图片数据
			ppDal = new ProductPictureDal();
			picture = new ProductPicture();
			picture.setPictureID(fPicID);
			picture = ppDal.getAPicture(picture);
			if(picture == null) return false;
			
			//步骤2：从数据库中删除此图片记录
			if(!ppDal.deletePicture(picture)) return false;
			
			//步骤3：调用图片处理类，实际删除此图片
			picDeal = new PictureDeal();
			ArrayList<String> picPaths = new ArrayList<String>();
			picPaths.add(picture.getPictureAddr());
			picPaths.add(picture.getPictureBreAddr());
			if(!picDeal.deleteFiles(picPaths, fRequest)) return false;
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品图片删除异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 更新产品基本信息
	 * 
	 * @param fProduct		产品数据
	 * @param fParams		参数集合数据
	 * @return					返回是否更新成功
	 */
	public boolean updateProductBaseInfo(Product fProduct,ArrayList<ProductParam> fParams) {
		
		ProductDal pDal = null;
		ProductParamDal ppDal = null;
		
		try {
			
			//步骤1：实例化DAL
			pDal = new ProductDal();
			ppDal = new ProductParamDal();
			
			//步骤2：更新产品类别以及产品名称
			if(!pDal.updateProduct(fProduct)) return false;
			
			//步骤3：更新产品参数
			
			//删除原有产品参数
			ProductParam param = new ProductParam();
			param.setProductID(fProduct.getProdcuctID());
			if(!ppDal.deleteParam(param)) return false;
			
			//添加新的参数
			for (ProductParam aParam : fParams) {

				aParam.setProductID(fProduct.getProdcuctID());

				if (!ppDal.addParam(aParam)) return false;
			}
			
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品基本信息更新异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 更新产品介绍
	 * 
	 * @param fProIntroduce		产品介绍数据
	 * @return							返回是否成功工薪
	 */
	public boolean updateProIntro(Product fProIntroduce,HttpServletRequest fRequest) {
		
		PictureDeal picDeal = null;
		ProductDal pDal = null;
		
		
		try {
			
			//步骤1：实例化DAL
			picDeal = new PictureDeal();
			pDal = new ProductDal();
			
			//步骤2：获取修改前的介绍数据
			Product preProIntro = new Product();
			preProIntro.setProdcuctID(fProIntroduce.getProdcuctID());
			preProIntro = pDal.getProduct(preProIntro);
			
			//步骤3：获取修改前的介绍数据中的图片地址,并判断是否删除图片
			ArrayList<String> picPaths1 = new ArrayList<String>();
			ArrayList<String> picPaths2 = new ArrayList<String>();
			//获取修改前的图片地址集合
			Pattern p = Pattern.compile("<img.*?src=['\"](../ProductIntroPic/[^'\"]+?)['\"][^/>]+?/>");
			Matcher m = p.matcher(preProIntro.getIntroduct());
			while(m.find()) {
				
				picPaths1.add(m.group(1));
			}
			
			//获取修改后的图片地址集合
			Pattern p1 = Pattern.compile("<img.*?src=['\"](../ProductIntroPic/[^'\"]+?)['\"][^/>]+?/>");
			Matcher m1 = p1.matcher(fProIntroduce.getIntroduct());
			while(m1.find()) {
				
				picPaths2.add(m1.group(1));
			}
			//移除待删除路径数据中不满足删除条件的路径
			for(String aPath2 : picPaths2) {
				
				picPaths1.remove(aPath2);
			}
			//执行删除
			if(picPaths1.size() != 0) {
				
				if(!picDeal.deleteFiles(picPaths1, fRequest)) return false;
			}
			
			//步骤4：更新产品介绍数据
			//复制介绍中的图片地址到正式目录下
			HttpSession session = fRequest.getSession(true);
			if(session.getAttribute("UserID") == null) return false;
			int userID = Integer.valueOf(session.getAttribute("UserID").toString());
			
			boolean isHasPic = false;
			
			Pattern p2 = Pattern.compile("<img.*?src=['\"](../PicCache/" + userID +"/[^'\"]+?)['\"][^/>]+?/>");
			Matcher m2 = p2.matcher(fProIntroduce.getIntroduct());
			while(m2.find()) {
				
				isHasPic = true;
				//调用图片Deal进行实际复制
				if(!picDeal.fileCopy(fRequest, m2.group(1), "ProductIntroPic"))
					return false;
			}	
			//检测以上步骤是否成功进行
			if(isHasPic) {
				
				//替换原路径为目标路径
				fProIntroduce.setIntroduct(
						fProIntroduce.getIntroduct().replaceAll(
								"../PicCache/" + userID +"/" , "../ProductIntroPic/")); 
			}
			
			//步骤5：调用DAL更新介绍信息
			if(!pDal.updateIntroduce(fProIntroduce)) return false;
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：产品介绍更新异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
