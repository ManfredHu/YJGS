package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductParam;
import com.yjgs.dcl.ProductPicture;

/**
 * 产品具体信息展示业务逻辑层
 * 
 * @author 周宇钦
 *
 */
public interface ILoadProductInfoBll {
	
	/**
	 * 获取对应产品图片
	 * 
	 * @param fProduct			所要查询的产品信息
	 * @return					含有要查询产品的图片数据数组
	 */
	public ArrayList<ProductPicture> LoadProPic(Product fProduct);
	
	/**
	 * 获取相应产品的产品参数
	 * 
	 * @param fProduct			所要查询的产品信息
	 * @return					含有要查询产品的参数数据数组
	 */
	public ArrayList<ProductParam> LoadProParam(Product fProduct);

	/**
	 * 获取相应产品的具体信息
	 * 
	 * @param fProduct			所要查询的产品信息
	 * @return					要查询的产品具体信息
	 */
	public Product LoadProInfo(Product fProduct);
}
