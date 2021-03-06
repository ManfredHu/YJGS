package com.yjgs.bll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import com.yjgs.dal.FirstPagePictureDal;
import com.yjgs.dal.OtherPictureDal;
import com.yjgs.dal.PageBottomInfoDal;
import com.yjgs.dal.ProductDal;
import com.yjgs.dal.ProductListDal;
import com.yjgs.dal.ProductParamDal;
import com.yjgs.dal.ProductTypeDal;
import com.yjgs.dcl.FirstPagePicture;
import com.yjgs.dcl.OtherPicture;
import com.yjgs.dcl.PageBottomInfo;
import com.yjgs.dcl.ProductList;
import com.yjgs.dcl.ProductParam;
import com.yjgs.dcl.ProductType;
import com.yjgs.publ.PictureDeal;

public class FirstPageManageBll {

	
	/**
	 * 添加首页图片
	 * 
	 * @param fRequest		Servlet请求
	 * @return					是否添加成功
	 */
	public boolean addNewPic(HttpServletRequest fRequest) {
		
		FirstPagePictureDal fpDal = null;
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
			outImgPath= pDeal.cropPicture(fRequest, imgPath, x, y, w, h,tarWidth,tarHeight,"FirstPagePicture");
			if(outImgPath == null) return false;
			
		} catch (Exception e) {

			System.out.println("图片裁减异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤2：图片压缩
		try {
			
			//压缩为288*104大小
			comPath = pDeal.compressPicture(fRequest, outImgPath, "FirstPagePicture", 288, 104);
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
			
			FirstPagePicture picture = new FirstPagePicture();
			picture.setFileName(fileName);
			picture.setPictureAddr(outImgPath);
			picture.setPictureBreAddr(comPath);

			//步骤2：获取图片当前的序号
			fpDal = new FirstPagePictureDal();
			FirstPagePicture maxSortPic = fpDal.getTheEndPic();
			if(maxSortPic != null) {
				
				picture.setSortingNum(maxSortPic.getSortingNum() + 1);
			}
			else {
				picture.setSortingNum(1);
			}
			
			
			//步骤3：调用DAL并添加新的图片
			if(!fpDal.addPicture(picture)) return false;
			
			
		} catch (Exception e) {

			System.out.println("图片添加异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 管理员界面的首页图片加载
	 *
	 * @param fOut		JSP输出对象
	 */
	public void loadFirstPagePic_fm(JspWriter fOut) {
		
		FirstPagePictureDal fpDal = null;
		ArrayList<FirstPagePicture> pictures = null;
		
		try {
			
			//步骤1：实例化DAL并获取数据
			fpDal = new FirstPagePictureDal();
			pictures = fpDal.getAllPictures();
			if(pictures == null) {
				
				fOut.println("<tr><td>首页图片暂无</td></tr>");
			}
			
			//步骤2：输出
			
			//输出第一行
			fOut.println("<tr>");
			fOut.println(String.format("<td><a class='down' href='ChangeSort?upDown=down&picID=%d '><span>下移</span></a></td>"
					, pictures.get(0).getPictureID()));
			fOut.println(String.format("<td><a href='%s' target='_blank'><img src='%s' width=288 height=104 /></a></td>"
					, pictures.get(0).getPictureAddr(),pictures.get(0).getPictureBreAddr()));
			fOut.println(String.format("<td><a class='delete' href='DeletePic?picID=%d'>删除</a></td>"
					, pictures.get(0).getPictureID()));
			fOut.println("</tr>");
			
			if(pictures.size() == 1) return;
			
			//输出中间行
			for(int i = 1; i< pictures.size() -1; i++) {
				
				fOut.println("<tr>");
				fOut.println(String.format("<td><a class='up' href='ChangeSort?upDown=up&picID=%d'><span>上移</span></a>"
						+ " <a class='down' href='ChangeSort?upDown=down&picID=%d'><span>下移</span></a></td>"
						, pictures.get(i).getPictureID(),pictures.get(i).getPictureID()));
				fOut.println(String.format("<td><a href='%s' target='_blank'><img src='%s' width=288 height=104 /></a></td>"
						, pictures.get(i).getPictureAddr(),pictures.get(i).getPictureBreAddr()));
				fOut.println(String.format("<td><a class='delete' href='DeletePic?picID=%d'>删除</a></td>"
						, pictures.get(i).getPictureID()));
				fOut.println("</tr>");
			}
			
			//输出最后一行
			int lastIndex = pictures.size() - 1;
			
			fOut.println("<tr>");
			fOut.println(String.format("<td><a class='up' href='ChangeSort?upDown=up&picID=%d'><span>上移</span></a></td>"
					, pictures.get(lastIndex).getPictureID()));
			fOut.println(String.format("<td><a href='%s' target='_blank'><img src='%s' width=288 height=104 /></a></td>"
					, pictures.get(lastIndex).getPictureAddr(),pictures.get(lastIndex).getPictureBreAddr()));
			fOut.println(String.format("<td><a class='delete' href='DeletePic?picID=%d'>删除</a></td>"
					, pictures.get(lastIndex).getPictureID()));
			fOut.println("</tr>");
			
		} catch (Exception e) {
			
			System.out.println("图片列表加载异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 删除首页图片
	 * 
	 * @param fPicID		首页图片ID
	 * @return				返回是否成功删除
	 */
	public boolean deletePic(int fPicID,HttpServletRequest fRequest ) {
		
		PictureDeal picDeal = null;
		FirstPagePictureDal fpDal = null;
		
		try {
			
			//步骤1：删除图片数据
			FirstPagePicture picture = new FirstPagePicture();
			picture.setPictureID(fPicID);
			
			fpDal = new FirstPagePictureDal();
			picture = fpDal.getAPicture(picture);
			
			if(!fpDal.deletePicture(picture)) return false;
			
			//实际删除图片文件
			ArrayList<String> picPaths = new ArrayList<String>();
			picPaths.add(picture.getPictureAddr());
			picPaths.add(picture.getPictureBreAddr());
			
			picDeal = new PictureDeal();
			if(!picDeal.deleteFiles(picPaths, fRequest)) return false;
			
			
			//步骤2：重置图片序号
			ArrayList<FirstPagePicture> pictures = null;
			pictures = fpDal.getAllPictures();
			if(pictures == null) return false;
			
			//重置编号
			for(int i=0; i<pictures.size(); i++) {
				
				pictures.get(i).setSortingNum(i + 1); 
			}
			
			//更新数据库
			if(!fpDal.updatePictures(pictures)) return false;
			
		} catch (Exception e) {
			
			System.out.println("图片删除异常");
			e.printStackTrace();
			return false;
		} 
		
		return true;
	}
	
	/**
	 * 对图片进行排序（实质是两张图片序号替换）
	 * 
	 * @param picID			图片ID
	 * @param upDown		上移还是下移
	 * @return					返回排序（移动是否成功）
	 */
	public boolean picSorting(int picID,String upDown) {
		
		FirstPagePictureDal fpDal = null;
		int curSortNum = 0;
		FirstPagePicture curPic = null;
		FirstPagePicture tarPic = null;
		
		
		try {
			
			//步骤1：获取当前图片以及当前序号
			fpDal = new FirstPagePictureDal();
			curPic = new FirstPagePicture();
			curPic.setPictureID(picID);
			
			curPic = fpDal.getAPicture(curPic);
			if(curPic == null) return false;
			
			//获取当前序号
			curSortNum = curPic.getSortingNum();
			
			//步骤2：获取需要替换的目标图片信息
			tarPic = new FirstPagePicture();
			if(upDown.equals("up")) {
				
				tarPic.setSortingNum(curSortNum - 1);
			}
			else if(upDown.equals("down")) {
				
				tarPic.setSortingNum(curSortNum + 1);
			}
			else {
				return false;
			}
			
			tarPic = fpDal.getPicBySort(tarPic);
			if(tarPic == null) return false;
			
			//步骤3：替换序号
			curPic.setSortingNum(tarPic.getSortingNum());
			tarPic.setSortingNum(curSortNum);
			
			//步骤4：更新数据库
			ArrayList<FirstPagePicture> pictures = new ArrayList<FirstPagePicture>();
			pictures.add(curPic);
			pictures.add(tarPic);
			if(!fpDal.updatePictures(pictures)) return false;
			
		} catch (Exception e) {

			System.out.println("图片排序异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 加载首页图片
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadFirstPagePic(JspWriter fOut) {
		
		FirstPagePictureDal fpDal = null;
		ArrayList<FirstPagePicture> pictures = null;
		
		try {
			
			//步骤1：获取所有首页图片
			fpDal = new  FirstPagePictureDal();
			pictures = fpDal.getAllPictures();
			
			//步骤2：输出第一张大图
			/*fOut.println("<div class='imageDiv'>");
			fOut.println(String.format("<img id='bigPic' src='%s' width=900 height=325 />"
					, pictures.get(0).getPictureAddr()));
			fOut.println("</div>");*/
			
			//步骤3：输出其他图片的选择列表
			fOut.println("<ul>");
			for(int i = 0; i < pictures.size(); i++) {
				
				fOut.println("<li>");
				fOut.println(String.format("<a href='%s' target='_blank'><img src='%s' alt='轮转照片' width=900 height=325 /></a> "
						, pictures.get(i).getPictureAddr(),pictures.get(i).getPictureAddr()));
				fOut.println("</li>");
			}
			fOut.println("</ul>");
			
		} catch (Exception e) {
			
			System.out.println("加载首页图片异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载首页产品信息
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadProductInfo(JspWriter fOut) {
		
		ProductListDal pListDal = null;
		ArrayList<ProductList> products = null;
		
		try {
			
			//步骤1：实例化DAL并获取相应数据
			pListDal = new ProductListDal();
			products = pListDal.getNewestSixProduct();
			
			//步骤2：遍历产品数据集合并输出
			for(ProductList aProduct : products) {
				
				fOut.println("<div>");
				fOut.println(String.format("<a href='../Product/ProductPage.jsp?productID=%d'>", aProduct.getProductID()));
				fOut.println(String.format("<img src='%s' width=285 height=180 />",  
						aProduct.getProductBreAddr()==null? "../Image/NoBrePic.jpg":aProduct.getProductBreAddr()));
				fOut.println(String.format("<span>%s</span>", aProduct.getProductName()));
				fOut.println("</a>");
				fOut.println("</div>");
			}
			
		} catch (Exception e) {
			
			System.out.println("加载产品列表异常");
			e.printStackTrace();
			return;
		}
	}
	
	
	
	/**
	 * 加载底部参数
	 * 
	 * @param fOut		JSP输出对象
	 * @return				返回参数个数（没有参数时返回1）
	 */
	public int loadParams(JspWriter fOut) {
		
		PageBottomInfoDal pbiDal = null;
		ArrayList<PageBottomInfo> params = null;
		
		try {
			
			//步骤1：实例化DAL并获取数据
			pbiDal = new PageBottomInfoDal();
			params = pbiDal.getAllInfos();
			if(params == null) {
				
				fOut.println("<tr>");
				fOut.println(String.format("<td><input type='text' name='names'  /></td>"));
				fOut.println(String.format("<td><input type='text' name='values'  /></td>"));
				fOut.println("<td><input type='button'  class='deletebtn' value='删除' onclick='deleteParam(this)' /></td>");
				fOut.println("</tr>");
				return 1;
			}
			
			//步骤2：遍历参数集合输出参数
			for(PageBottomInfo aParam : params) {
				
				fOut.println("<tr>");
				fOut.println(String.format("<td><input type='text' name='names' value='%s'  /></td>"
						, aParam.getInfoName()));
				fOut.println(String.format("<td><input type='text' name='values' value='%s'  /></td>"
						, aParam.getInfoValue()));
				fOut.println("<td><input type='button' class='deletebtn' value='删除' onclick='deleteParam(this)' /></td>");
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
	 * 更新网页底部参数
	 * 
	 * @param fParams		参数集合
	 * @return					返回是否更新成功
	 */
	public boolean updatePageBottomInfo(ArrayList<PageBottomInfo> fParams) {
		
		PageBottomInfoDal pbiDal = null;
		
		try {
			
			//步骤1：实例化DAL
			pbiDal = new PageBottomInfoDal();
			
			//步骤3：更新参数
			
			//删除原有的所有参数
			pbiDal.deleteAllInfo();
			
			//添加新的参数
			if(!pbiDal.addInfos(fParams)) return false;
			
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：网页底部信息更新异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 加载网页底部参数
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadPageBottomInfos(JspWriter fOut) {
		
		PageBottomInfoDal pbiDal = null;
		ArrayList<PageBottomInfo> params = null;
		
		try {
			
			//步骤1：获取数据
			pbiDal = new PageBottomInfoDal();
			params = pbiDal.getAllInfos();
			if(params == null) return;
			
			//步骤2：输出
			for (PageBottomInfo aParam : params) {
				
				fOut.println(String.format("<p>%s：", aParam.getInfoName()));
				fOut.println(String.format("%s</p>", aParam.getInfoValue()));
			}
			
		} catch (Exception e) {
			
			System.out.println("业务逻辑层：加载底部参数异常");
			e.printStackTrace();
			return;
		}
		
	}
	
	/**
	 * 加载产品导航
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadProductNvigator(JspWriter fOut) {
		
		ProductTypeDal ptDal = null;
		ProductListDal plDal = null;
		ArrayList<ProductType> types = null;
		
		try {
			
			//步骤1：实例化DAL并获取所有类别
			ptDal = new ProductTypeDal();
			plDal = new ProductListDal();
			types = ptDal.getAllTypes();
			if(types == null) return;
			
			//步骤2：遍历类别输出导航
			for(ProductType aType : types) {
				
				ArrayList<ProductList> aList = null;
				ProductList aProduct = new ProductList();
				aProduct.setProductTypeID(aType.getTypeID());
				aList = plDal.getListByType(aProduct);
				if(aList == null) continue;
				
				//输出导航子列表项
				fOut.println("<li><dl>");
				
				//输出产品名
				fOut.println(String.format("<dt><a href='../Product/ProductList.jsp?typeID=%d' >%s</dt>"
						,aType.getTypeID(),aType.getTypeName()));
				for(int i = 0; i<5 && i< aList.size(); i++) {
					
					fOut.println(String.format("<dd><a href='../Product/ProductPage.jsp?productID=%d'>%s</a></dd>"
							,aList.get(i).getProductID() ,aList.get(i).getProductName()));
				}
				fOut.println("</dl>");
				fOut.println(String.format("<a class='allPro' href='../Product/ProductList.jsp?typeID=%d' >所有%s商品</a>"
						, aType.getTypeID(),aType.getTypeName()));
				fOut.println("</li>");
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：加载产品导航异常");
			e.printStackTrace();
			return;
		}
		
	}
	
	/**
	 * 加载Logo图片
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadLogoPic(JspWriter fOut) {
		
		OtherPictureDal opDal = null;
		OtherPicture logoPic = null;
		
		try {
			
			//步骤1：实例化DAL并获取数据
			opDal = new OtherPictureDal();
			logoPic = opDal.getLogoPic();
			if(logoPic == null) {
				
				//没有Logo时加载默认Logo
				fOut.println("<img src='../Image/DefaultLogo.jpg' width=240 height=60 />");
				return;
			}
			
			//步骤2：加载Logo图片
			fOut.println(String.format("<img src='%s' width=240 height=60 />", logoPic.getPictureBreAddr()));
			
		} catch (Exception e) {
			
			System.out.println("加载Logo图片异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载公司简介图片
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadCompanyIntroPic(JspWriter fOut) {
		
		OtherPictureDal opDal = null;
		OtherPicture logoPic = null;
		
		try {
			
			//步骤1：实例化DAL并获取数据
			opDal = new OtherPictureDal();
			logoPic = opDal.getIntroPic();
			if(logoPic == null) {
				
				//没有Logo时加载默认Logo
				fOut.println("<img src='../Image/DefaultIntroPic.jpg' width=285 height=285 />");
				return;
			}
			
			//步骤2：加载Logo图片
			fOut.println(String.format("<img src='%s' width=285 height=285 />", logoPic.getPictureBreAddr()));
			
		} catch (Exception e) {
			
			System.out.println("加载Logo图片异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 更新LOGO图片
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否更新成功
	 */
	public boolean updateLogo(HttpServletRequest fRequest) {
		
		OtherPictureDal opDal = null;
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
			outImgPath= pDeal.cropPicture(fRequest, imgPath, x, y, w, h,tarWidth,tarHeight,"OtherPicture");
			if(outImgPath == null) return false;
			
		} catch (Exception e) {

			System.out.println("图片裁减异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤2：图片压缩
		try {
			
			//压缩为240*60大小
			comPath = pDeal.compressPicture(fRequest, outImgPath, "OtherPicture", 240, 60);
			if(comPath == null) return false;
			
		} catch (Exception e) {
			
			System.out.println("图片压缩异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤3：更新LOGO图片记录
		try {
			
			//步骤1：删除原来的LOGO
			OtherPicture picture = null;
			opDal = new OtherPictureDal();
			picture = opDal.getLogoPic();
			if(picture != null) {
				ArrayList<String> picPaths = new ArrayList<String>();
				picPaths.add(picture.getPictureAddr());
				picPaths.add(picture.getPictureBreAddr());
				if(!pDeal.deleteFiles(picPaths, fRequest)) return false;
			}
			
			//步骤2：构造LOGO图片数据
			String[] temp = outImgPath.split("/");
			String fileName = temp[temp.length - 1];
			
			picture = new OtherPicture();
			picture.setFileName(fileName);
			picture.setPictureAddr(outImgPath);
			picture.setPictureBreAddr(comPath);
			picture.setPitureType(0);
				
			//步骤3：调用DAL并更新
			if(!opDal.updatePic(picture)) return false;
			
			
		} catch (Exception e) {

			System.out.println("图片更新异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * 更新企业简介图片
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否更新成功
	 */
	public boolean updateComIntroPic(HttpServletRequest fRequest) {
		
		OtherPictureDal opDal = null;
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
			outImgPath= pDeal.cropPicture(fRequest, imgPath, x, y, w, h,tarWidth,tarHeight,"OtherPicture");
			if(outImgPath == null) return false;
			
		} catch (Exception e) {

			System.out.println("图片裁减异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤2：图片压缩
		try {
			
			//压缩为285*285大小
			comPath = pDeal.compressPicture(fRequest, outImgPath, "OtherPicture", 285,285);
			if(comPath == null) return false;
			
		} catch (Exception e) {
			
			System.out.println("图片压缩异常");
			e.printStackTrace();
			return false;
		}
		
		//步骤3：更新企业简介图片记录
		try {
			
			//步骤1：删除原来的企业简介图片
			OtherPicture picture = null;
			opDal = new OtherPictureDal();
			picture = opDal.getIntroPic();
			
			if(picture != null) {
				
				ArrayList<String> picPaths = new ArrayList<String>();
				picPaths.add(picture.getPictureAddr());
				picPaths.add(picture.getPictureBreAddr());
				if(!pDeal.deleteFiles(picPaths, fRequest)) return false;
			}
			
			//步骤1：构造企业简介图片数据
			String[] temp = outImgPath.split("/");
			String fileName = temp[temp.length - 1];
			
			picture = new OtherPicture();
			picture.setFileName(fileName);
			picture.setPictureAddr(outImgPath);
			picture.setPictureBreAddr(comPath);
			picture.setPitureType(1);	//类型为1
				
			//步骤2：调用DAL并更新
			if(!opDal.updatePic(picture)) return false;
			
			
		} catch (Exception e) {

			System.out.println("图片更新异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
