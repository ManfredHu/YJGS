package com.yjgs.dal.idal;

import java.util.ArrayList;
import com.yjgs.dcl.ProductType;

public interface IProductTypeDal {
	
	/**
	 * 批量增加新类别
	 * @param fProductTypes
	 * 					新类别数据数组
	 * 
	 * @return	返回是否操作成功
	 */
	public Boolean AddType(ArrayList<ProductType> fProductTypes[]);
	
	/**
	 * 增加一个新类别
	 * @param fProductType
	 * 					新类别
	 * @return	返回是否操作成功
	 */
	public Boolean AddType(ProductType fProductType);
	
	/**
	 * 批量删除类别
	 * @param fProductTypes		删除的类别数组
	 * @return								返回是否操作成功
	 */
	public Boolean DeleteType(ArrayList<ProductType> fProductTypes[]);
	
	/**
	 * 删除一个类别
	 * @param fProductType		删除类别信息
	 * @return							返回是否操作成功
	 */
	public Boolean DeleteType(ProductType fProductType);
	
	/**
	 * 批量修改类别名称
	 * @param fProductTypes	修改的类别名称数组
	 * @return							返回是否操作成功
	 */
	public Boolean UpdateType(ArrayList<ProductType> fProductTypes[]);
	
	/**
	 * 修改类别名称
	 * @param fProductType		修改的类别信息
	 * @return							返回是否操作成功
	 */
	public Boolean UpdateType(ProductType fProductType);
	
	/**
	 * 查看所有的类别名称
	 * @return				所有类别数据数组
	 */
	public ArrayList<ProductType> SearchType();
}
