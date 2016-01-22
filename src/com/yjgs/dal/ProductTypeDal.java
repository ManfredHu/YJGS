package com.yjgs.dal;

import java.util.ArrayList;
import com.yjgs.dcl.ProductType;
import com.yjgs.dpl.ProductTypeDpl;

public class ProductTypeDal {
	
	/**
	 * 查询具体产品类别信息
	 * @param fProduct			对应产品类别实体类
	 * @return					具有产品类别具体信息的数据集合
	 */
	public ArrayList<ProductType> getType(ProductType fProductType){
		
		//第一步，获取产品ID
		
		int typeID = fProductType.getTypeID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_product_type where TypeID="+typeID+" "; 
		
		//第三步，执行数据包装类ProductTypeDpl，获得产品系列具体信息的数据集合
		
		ArrayList<ProductType> productTypes = new ArrayList<ProductType>();
		ProductTypeDpl pDl = new ProductTypeDpl();
		productTypes = pDl.excuteQuery(strSql);
		
		//第四步，返回该产品系列具体信息数据集合
		
		return productTypes;
	}
	
	public ArrayList<ProductType> getAllTypes() {

		// 第二步，编写sql语句，

		String strSql = "select * from tb_product_type";

		// 第三步，执行数据包装类ProductTypeDpl，获得产品系列具体信息的数据集合

		ArrayList<ProductType> productTypes = new ArrayList<ProductType>();
		ProductTypeDpl pDl = new ProductTypeDpl();
		productTypes = pDl.excuteQuery(strSql);

		// 第四步，返回该产品系列具体信息数据集合
		if(productTypes.size() == 0) {
			return null;
		}
		return productTypes;
	}
	

	/**
	 * 删除产品系列信息
	 * @param fProduct				封装有产品ID的产品实体类
	 * @return						是否删除成功。
	 */
	public boolean deleteType(ProductType fProductType){
		
		//第一步，获取信息
		int typeID = fProductType.getTypeID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_product_type where TypeID="+typeID+""; 
		
		//第三步，实例化数据操作类，声明、定义返回值
		int reCount = 0;
		ProductTypeDpl pDl = new ProductTypeDpl();
		
		//第四步，执行数据操作层方法，获取返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回值是否为1，是则返回true，不是则返回false
		if(reCount==1) return true;
		else return false;
	}
	
	/**
	 * 增加产品系列信息
	 * @param fProductType				产品系列具体信息
	 * @return							是否修改成功
	 */
	public boolean addType(ProductType fProductType){
		
		//第一步，获取信息
		String 	typeName 	= fProductType.getTypeName();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_product_type (TypeName) value ('"+typeName+"') ";
		//第三步，实例化包装类和返回值类型
		ProductTypeDpl pDl = new ProductTypeDpl();
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
	 * 修改产品系列信息
	 * @param fProductType				待修改的产品系列信息
	 * @return							是否修改成功
	 */
	public boolean updateType(ProductType fProductType){
		
		//第一步，获取信息
		int typeID        = fProductType.getTypeID();
		String typeName		= fProductType.getTypeName();
		
		//第二步，编写sql语句
		String strSql = "update tb_product_type set TypeName='" + typeName
				+ "' where TypeID=" + typeID + "";

		//第三步，实例化包装类和返回值类型
		ProductTypeDpl pDl = new ProductTypeDpl();
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
	 * 类型搜索
	 * 
	 * @param fKeyWords		关键字
	 * @return						返回类型数据列表
	 */
	public ArrayList<ProductType> typeSearch(String fKeyWords) {
		
		ProductTypeDpl ptDpl = null;
		ArrayList<ProductType> types = null;
		String sqlString = null;
		
		sqlString = "SELECT * FROM tb_product_type WHERE typeName LIKE '%" + fKeyWords + "%'";
		
		ptDpl = new ProductTypeDpl();
		types = ptDpl.excuteQuery(sqlString);
		
		if(types.size() == 0) return null;
		return types;
		
	}
	
	

}
