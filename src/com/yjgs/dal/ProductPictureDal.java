package com.yjgs.dal;

import java.util.ArrayList;
import com.yjgs.dcl.ProductPicture;
import com.yjgs.dpl.ProductPictureDpl;
import com.yjgs.enumdata.ProductPictureType;

public class ProductPictureDal {
	
	/**
	 * 查询对应产品的所有图片信息
	 * @param fProductPicture				待查询的产品信息
	 * @return								具有产品图片的数据集合
	 */
	public ArrayList<ProductPicture> getPicture(ProductPicture fProductPicture){
		
		//第一步，获取信息
		
		int productID = fProductPicture.getProductID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_product_picture where ProductID="+productID+" "; 
		
		//第三步，执行数据包装类ProductPictureDpl，获得产品参数具体信息的数据集合
		
		ArrayList<ProductPicture> productPictures = new ArrayList<ProductPicture>();
		ProductPictureDpl pDl = new ProductPictureDpl();
		productPictures = pDl.excuteQuery(strSql);
		
		//第四步，返回该产品系列具体信息数据集合
		if(productPictures.size() == 0) return null;
		return productPictures;
	}
	
	
	/**
	 * 获取产品所有预览图片
	 * 
	 * @param fProductPicture	产品ID信息
	 * @return							返回预览图片集合
	 */
	public ArrayList<ProductPicture> getProBrePics(ProductPicture fProductPicture) {

		// 第二步，编写sql语句，

		String strSql =String.format("select * from tb_product_picture where "
				+ "Display=0 AND ProductID=%d ORDER BY PictureID ASC ", fProductPicture.getProductID());

		// 第三步，执行数据包装类ProductPictureDpl，获得产品参数具体信息的数据集合

		ArrayList<ProductPicture> productPictures = new ArrayList<ProductPicture>();
		ProductPictureDpl pDl = new ProductPictureDpl();
		productPictures = pDl.excuteQuery(strSql);

		// 第四步，返回该产品系列具体信息数据集合
		if(productPictures.size() ==0) {
			return null;
		}
		return productPictures;
		
	}
	
	public ProductPicture getAPicture(ProductPicture fPicture) {
		
		ProductPictureDpl pDpl = null;
		ArrayList<ProductPicture> pictures = null;
		String sqlString = null;
		
		//步骤1：编写SQL语句
		sqlString = String.format("SELECT * FROM tb_product_picture WHERE PictureID=%d"
				, fPicture.getPictureID());
		
		//步骤2：调用DPL执行SQL语句
		pDpl = new ProductPictureDpl();
		pictures = pDpl.excuteQuery(sqlString);
		
		//步骤3：判断并返回
		if(pictures.size() == 0) return null;
		return pictures.get(0);
	}

	/**
	 * 删除产品图片
	 * @param fProductPicture			相应产品图片信息
	 * @return							是否删除成功
	 */
	public boolean deletePicture(ProductPicture fProductPicture){
		
		//第一步，获取信息
		int		pictureID		= 	fProductPicture.getPictureID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_product_picture where PictureID=" + pictureID + "";

		//第三步，实例化包装类和返回值类型
		ProductPictureDpl pDl = new ProductPictureDpl();
		int reCount = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(reCount==1){
			return true;
		}
		else return false;
	}
	
	/**
	 * 删除对应产品的所有图片信息
	 * 
	 * @param fProductPicture		产品数据
	 * @return								返回是否删除成功
	 */
	public boolean deleteProPictures(ProductPicture fProductPicture) {
		
		ProductPictureDpl pDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		
		//步骤1：编写SQL语句
		sqlString = String.format("DELETE FROM tb_product_picture WHERE ProductID= %d"
				, fProductPicture.getProductID());
		
		//步骤2：调用DPL执行SQL语句
		pDpl = new ProductPictureDpl();
		reCount = pDpl.excuteUpdate(sqlString);
		
		//步骤3：判断并返回
		if(reCount == 0) return false;
		return true;
		
	}
	
	/**
	 * 增加产品图片
	 * @param fProductPicture				待增加的产品图片信息
	 * @return								是否增加成功
	 */
	public boolean addPicture(ProductPicture fProductPicture){
		
		//第一步，获取信息
		String fileName = fProductPicture.getFileName();

		int productID = fProductPicture.getProductID();
		int display = 0;
		if (fProductPicture.getDisplay() == ProductPictureType.InfoPictrue)
			display = 1;

		String pictureAddr = fProductPicture.getPictureAddr();
		String pictureBreAddr = fProductPicture.getPictureBreAddr();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_product_picture (ProductID,FileName,Display,PictureAddr,PictureBreAddr) "
				+ "value ('"+productID+"','"+fileName+"',"+display+",'"+pictureAddr+"','"+pictureBreAddr+"') ";

		//第三步，实例化包装类和返回值类型
		ProductPictureDpl pDl = new ProductPictureDpl();
		int reCount = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(reCount==1){
			return true;
		}
		else return false;
	}
}
