package com.yjgs.dal;

import java.sql.Date;
import java.util.ArrayList;
import com.yjgs.dcl.Product;
import com.yjgs.dpl.ProductDpl;

public class ProductDal {
	
	/**
	 * 查询具体产品信息
	 * @param fProduct			对应产品实体类
	 * @return					具有产品具体信息的数据集合
	 */
	public Product getProduct(Product fProduct){
		
		//第一步，获取产品ID
		
		int productID = fProduct.getProdcuctID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_product where ProductID="+productID+" "; 
		
		//第三步，执行数据包装类ProductDpl，获得产品具体信息的数据集合
		
		ArrayList<Product> products = new ArrayList<Product>();
		ProductDpl pDl = new ProductDpl();
		products = pDl.excuteQuery(strSql);
		
		//第四步，返回该产品具体信息数据集合
		if (products.size() == 0) {
			return null;
		}
		else return products.get(0);
	}
	
	/**
	 * 获取指定类型的所有产品
	 * 
	 * 
	 * @param fProduct		含类别ID的产品实体类
	 * @return					产品数据集合
	 */
	public ArrayList<Product> getProductsByType(Product fProductType){
		
		//第一步，获取产品ID
		
		int typeID = fProductType.getProductTypeID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_product where ProductTypeID="+typeID;
		
		//第三步，执行数据包装类ProductDpl，获得产品具体信息的数据集合
		
		ArrayList<Product> products = new ArrayList<Product>();
		ProductDpl pDl = new ProductDpl();
		products = pDl.excuteQuery(strSql);
		
		//第四步，返回该产品具体信息数据集合
		if(products.size() == 0) {
			
			return null;
		}
		return products;
	}
	

	/**
	 * 删除产品信息
	 * @param fProduct				封装有产品ID的产品实体类
	 * @return							是否成功删除
	 */
	public boolean deleteProduct(Product fProduct){
		
		//第一步，获取产品信息
		int productID = fProduct.getProdcuctID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_product where ProductID="+productID+""; 
		
		//第三步，实例化数据操作类，声明、定义返回值
		int reCount = 0;
		ProductDpl pDl = new ProductDpl();
		
		//第四步，执行数据操作层方法，获取返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步：判断影响行数，返回是否成功执行
		if(reCount == 0) return false;
		return true;
	}
	
	/**
	 * 添加产品
	 * 
	 * @param fProduct		产品数据
	 * @return					返回新产品ID
	 */
	public int addProduct(Product fProduct){
		
		//第一步，获取所有产品信息
		int productTypeID = fProduct.getProductTypeID();
		String productName= fProduct.getProductName();
		String introduct  = fProduct.getIntroduct();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_product (ProductTypeID,ProductName,Introduce,PublishTime) value ("
				+ productTypeID
				+ ",'"
				+ productName
				+ "','"
				+ introduct
				+ "',now()) ";

		//第三步，实例化包装类和返回值类型
		ProductDpl pDl = new ProductDpl();
		int newID = 0;
		
		//第四步，执行数据包装层，方法获得新纪录ID
		newID = pDl.excuteInsert(strSql);
		
		//第五步，返回新产品ID
		return newID;
	}
	
	/**
	 * 更新产品名称以及类别
	 * 
	 * @param fProduct		产品数据
	 * @return					返回是否更新成功
	 */
	public boolean updateProduct(Product fProduct) {
		
		// 第一步：编辑SQL语句并注入数据
		String sqlString = String.format("UPDATE tb_product SET ProductTypeID=%d"
				+ ",ProductName='%s'"
				+ " WHERE ProductID=%d"
				,fProduct.getProductTypeID()
				,fProduct.getProductName(),
				fProduct.getProdcuctID());

		// 第三步，实例化包装类和返回值类型
		ProductDpl pDl = new ProductDpl();
		int addResult = 0;

		// 第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(sqlString);

		// 第五步，判断返回结果，输出返回值
		if (addResult == 1) {
			return true;
		} else
			return false;
	}
	
	
	/**
	 * 更新产品介绍
	 * 
	 * @param fProduct		产品数据（包含产品介绍）
	 * @return					是否成功更新
	 */
	public boolean updateIntroduce(Product fProduct) {
		
		//第一步：编辑SQL语句并注入数据
		String sqlString = String.format("UPDATE tb_product SET Introduce='%s'"
				+ " WHERE ProductID=%d", fProduct.getIntroduct(),fProduct.getProdcuctID());

		// 第三步，实例化包装类和返回值类型
		ProductDpl pDl = new ProductDpl();
		int addResult = 0;

		// 第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(sqlString);

		// 第五步，判断返回结果，输出返回值
		if (addResult == 1) {
			return true;
		} else
			return false;
	}
	
	/**
	 * 当产品类别被删除时，更新对应产品信息（类别ID设置为0）
	 * 
	 * @param fProduct		产品类别ID信息
	 * @return					返回是否更新成功
	 */
	public boolean updateWTypeD(Product fProduct) {

		// 第二步，编写sql语句
		String strSql = String.format("update tb_product set ProductTypeID=0 WHERE "
				+ "ProductTypeID = %d  ", fProduct.getProductTypeID()); 

		// 第三步，实例化包装类和返回值类型
		ProductDpl pDl = new ProductDpl();

		// 第四步，执行数据包装层excuteUpdate（）方法获得返回值
		pDl.excuteUpdate(strSql);

		// 第五步，判断返回结果，输出返回值
		return true;
	}
	
	public ArrayList<Product> productSearch(String fKeyWords) {
		
		ProductDpl pDpl = null;
		ArrayList<Product> products = null;
		String sqlString = null;
		
		sqlString = "SELECT * FROM tb_product WHERE ProductName LIKE '%" + fKeyWords + "%'";
		
		pDpl = new ProductDpl();
		products = pDpl.excuteQuery(sqlString);
		
		if(products.size() == 0) {
			
			return null;
		}
		return products;
	}
	
}
