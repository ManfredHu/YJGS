package com.yjgs.bll.ibll;

import com.yjgs.dcl.ProductType;

/**
 * 产品类别管理业务逻辑层接口
 * @author 周宇钦
 *
 */
public interface IManaProTypeBll {
	
	/**
	 * 添加新类别
	 * 
	 * @param fProductType				要添加的新类别信息
	 * @return							是否添加成功
	 */
	public boolean AddType(ProductType fProductType);
	
	/**
	 * 删除类别
	 * 
	 * @param fProductType				要删除的类别信息
	 * @return							是否删除成功
	 */
	public boolean DaleteType(ProductType fProductType);
	
	/**
	 * 修改产品类别
	 * 
	 * @param fProductType				修改后的类别信息
	 * @return							是否修改成功
	 */
	public boolean UpdateType(ProductType fProductType);

}
