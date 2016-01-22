package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.ProductList;
import com.yjgs.dcl.ProductType;

/**
 * 展示产品图片的数据操作层接口
 * @author yuqin
 *
 */
public interface IShowPicListDal {
	
	/**
	 * 展示产品列表（含缩略图、产品信息等）
	 * @return				含有产品信息的数据数组
	 */
	public ProductList ShowList(ProductList fList);
	
	/**
	 * 展示对应系列的产品列表（含缩略图、产品信息等）
	 * @param fpage					对应页数
	 * @param fpProductList			对应产品类型
	 * @return						含有产品数据的数据数组
	 */
	public ArrayList<ProductList> ShowList(int fpage,ProductType fProductType);

	/**
	 * 获取产品列表总页数
	 * 
	 * @param fTyge		产品类别
	 * @return			对应产品列表总页数
	 */
	public int getPageSum(ProductType fTyge);
}
