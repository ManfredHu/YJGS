package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.ProductList;
import com.yjgs.dpl.ProductListDpl;

public class ProductListDal {
	
	/**
	 * 获取指定类别指定页码的产品列表项集合（从产品列表视图获取）
	 * 
	 * @param fProduct				产品数据（类别）
	 * @param fPage					页码
	 * @return
	 */
	public ArrayList<ProductList> getList(ProductList fProduct,int fPage) {
		
		ProductListDpl pDpl = null;
		ArrayList<ProductList> products = null;
		String sqlString = null;
		int startPage = 0;
		int pageSize = 5;	//一页5记录
		
		//步骤1：实例化包装类
		pDpl = new ProductListDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM v_product_list"
				+ " %s ORDER BY PublishTime DESC LIMIT %d,%d", 
				fProduct.getProductTypeID()==0? "":"WHERE ProductTypeID =" + fProduct.getProductTypeID()
				,startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		products = pDpl.excuteQuery(sqlString);
		if(products.size() == 0) {
			return null;
		}
		return products;
	}
	
	/**
	 * 获取指定类别指定页码的产品列表项集合（从产品列表视图获取）
	 * 
	 * @param fProduct				产品数据（类别）
	 * @param fPage					页码
	 * @return
	 */
	public ArrayList<ProductList> getList_fs(ProductList fProduct,int fPage) {
		
		ProductListDpl pDpl = null;
		ArrayList<ProductList> products = null;
		String sqlString = null;
		int startPage = 0;
		int pageSize = 8;	//一页8记录
		
		//步骤1：实例化包装类
		pDpl = new ProductListDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM v_product_list"
				+ " %s ORDER BY PublishTime DESC LIMIT %d,%d", 
				fProduct.getProductTypeID()==0? "":"WHERE ProductTypeID =" + fProduct.getProductTypeID()
				,startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		products = pDpl.excuteQuery(sqlString);
		if(products.size() == 0) {
			return null;
		}
		return products;
	}
	
	/**
	 * 获取指定类别的所有产品
	 * 
	 * @param fProduct		产品数据
	 * @return					返回指定类别产品集合
	 */
	public ArrayList<ProductList> getListByType(ProductList fProduct) {
		
		ProductListDpl pDpl = null;
		ArrayList<ProductList> products = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		pDpl = new ProductListDpl();
		
		// 步骤2：编写SQL语句注入该数据
		sqlString = String.format("SELECT * FROM v_product_list"
				+ " %s ",fProduct.getProductTypeID() == 0 ? "" : "WHERE ProductTypeID ="
						+ fProduct.getProductTypeID());
		
		// 步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		products = pDpl.excuteQuery(sqlString);
		if (products.size() == 0) {
			return null;
		}
		return products;
		
	}
	
	/**
	 *加载最新的6个产品信息 
	 * 
	 * @return		返回产品信息集合
	 */
	public ArrayList<ProductList> getNewestSixProduct() {
		
		ProductListDpl pDpl = null;
		ArrayList<ProductList> products = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		pDpl = new ProductListDpl();
		
		// 步骤2：编写SQL语句注入该数据
		sqlString = String.format("SELECT * FROM v_product_list ORDER BY PublishTime DESC LIMIT 6");
		
		// 步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		products = pDpl.excuteQuery(sqlString);
		if (products.size() == 0) {
			return null;
		}
		return products;
	}
	
	/**
	 * 根据ID集合获取产品集合
	 * 
	 * @param fList		产品ID集合
	 * @return				产品数据集合
	 */
	public ArrayList<ProductList> getListByID(ArrayList<ProductList> fList) {
		
		ProductListDpl pDpl = null;
		ArrayList<ProductList> products = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类以及数据集合
		pDpl = new ProductListDpl();
		products = new ArrayList<ProductList>();

		//步骤2：循环遍历ID集合，构造结果集
		for(ProductList aItem : fList) {
			
			// 编写SQL语句注入该数据
			ArrayList<ProductList> aProduct = null;
			sqlString = String
					.format("SELECT * FROM v_product_list WHERE ProductID = %d",aItem.getProductID());
			aProduct = pDpl.excuteQuery(sqlString);
			if(aProduct.size() == 0) continue;
			products.add(aProduct.get(0));
		}
		
		// 步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		if (products.size() == 0) {
			return null;
		}
		return products;
	}

}
