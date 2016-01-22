package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductParam;

/**
 * 产品参数的数据操作层接口
 * @author yuqin
 *
 */
public interface IProductParamDal {
	
	/**
	 * 增加产品参数
	 * @param fProductParam				欲增加的产品参数信息
	 * @return										是否添加产品参数成功
	 */
	public boolean AddParam(ProductParam fProductParam);
	
	/**
	 * 批量增加产品参数
	 * @param fProductParams				欲增加的产品参数信息数组
	 * @return								是否添加产品参数成功
	 */
	public boolean AddParam(ArrayList<ProductParam> fProductParams);
	
	/**
	 * 删除产品参数(可一个或者多个)
	 * @param fProductParams		欲删除的产品参数信息
	 * @return						是否删除产品参数成功
	 */
	public boolean DeleteParam(ArrayList<ProductParam> fProductParams);

	/**
	 * 批量修改产品参数（可一个）
	 * @param fProductParams				欲修改的产品参数数据数组（一个或多个）
	 * @return								是否修改产品参数成功
	 */
	public boolean UpdateParam(ArrayList<ProductParam> fProductParams);
	
	/**
	 * 查询相应的产品的产品参数
	 * @param fProduct					欲查询的产品信息
	 * @return							查询的产品参数数组
	 */
	public ArrayList<ProductParam> SearchParam(Product fProduct);
	
	/**
	 * 模糊查询含有对应关键字的参数
	 * 
	 * @param fKeyWord		关键字
	 * @return						参数集合
	 */
	public ArrayList<ProductParam> SearchParam(String fKeyWord);
}
