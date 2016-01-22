package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductType;

public interface IProductDal {
	
	/**
	 * 查询产品信息
	 * @param fProduct				要查询的产品信息实体类
	 * @return							所查询产品的数据数组
	 */
	public Product SearchProduct(Product fProduct);

	/**
	 * 查询所有产品信息
	 * @return							所有产品的数据数组
	 */
	public ArrayList<Product> SearchProduct();
	
	/**
	 * 根据产品类别查询该类别的所有产品信息
	 * @param fproProductType						要查询的产品类别
	 * @return												该类别的所有产品数据数组
	 */	
	public ArrayList<Product> SearchProduct(ProductType fproProductType);
	
	/**
	 * 修改产品信息
	 * @param fProduct				待修改的产品信息实体类
	 * @return							修改操作是否成功
	 */
	public boolean UpdateProduct(Product fProduct);
	
	/**
	 * 删除产品信息
	 * @param fProduct				要删除的产品信息实体类
	 * @return							删除操作是否成功
	 */
	public boolean DeleteProduct(Product fProduct);
	
	/**
	 * 增加产品信息
	 * @param fProduct				要增加的产品信息实体类
	 * @return							增加操作是否成功
	 */
	public boolean AddProduct(Product fProduct);
	
	/**
	 * 查询含有对应关键字
	 * 
	 * @param fKeyWord		查询关键字
	 * @return						返回产品信息集合
	 */
	public ArrayList<Product> SearchProduct(String fKeyWord);

}

