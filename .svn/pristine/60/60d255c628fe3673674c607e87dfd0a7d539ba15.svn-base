package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.FirstPageProductList;
import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductType;

public interface IFirstPageProductManageBll {

	/**
	 * 加载首页产品列表
	 * 
	 * @return	返回首页产品列信息集合
	 */
	public ArrayList<FirstPageProductList> loadProductList();
	
	/**
	 * 加载产品类别
	 * 
	 * @return	返回产品类别信息集合
	 */
	public ArrayList<ProductType> loadProductTypes();
	
	/**
	 * 加载具体类别的所有产品信息
	 * 
	 * @param fType	产品类别
	 * @return			返回产品信息集合
	 */
	public ArrayList<Product> loadProducts(ProductType fType);
	
	/**、
	 * 添加新的首页展示产品
	 * 
	 * @param fItem	首页产品列表项
	 * @return			返回是否添加成功
	 */
	public boolean addNewItem(FirstPageProductList fItem);
	
	/**
	 * 批量删除首页产品列表项
	 * 
	 * @param fItems		首页产品列表项
	 * @return				返回是否删除成功
	 */
	public boolean deleteItems(ArrayList<FirstPageProductList> fItems);
	
	/**
	 * 重新排列产品列表项
	 * 
	 * @param fItems		需要重新排列的首页产品列表项集合
	 * @return				返回是否成功重排
	 */
	public boolean sortItems(ArrayList<FirstPageProductList> fItems);
}
