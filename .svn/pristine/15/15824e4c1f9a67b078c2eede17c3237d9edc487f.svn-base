package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.ProductList;
import com.yjgs.dcl.ProductType;

public interface ILoadProductListBll {
	
	/**
	 * 加载产品类别列表
	 * 
	 * @return	产品类别数据数组
	 */
	public ArrayList<ProductType> loadTypeList();
	
	/**
	 * 加载产品列表
	 * 
	 * @param fpage		请求页数
	 * @param fType		产品类型
	 * @return				产品列表数据数组
	 */
	public ArrayList<ProductList> loadProductList(int fpage,ProductType fType);
	
	/**
	 * 获取产品列表总页数
	 * 
	 * @param fTyge		产品类别
	 * @return			对应产品列表总页数
	 */
	public int getPageSum(ProductType fTyge);

}
