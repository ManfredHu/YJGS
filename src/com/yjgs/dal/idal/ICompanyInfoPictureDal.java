package com.yjgs.dal.idal;


import com.yjgs.dcl.CompanyInfoPicture;

public interface ICompanyInfoPictureDal {

	/**
	 * 添加新的图片信息
	 * 
	 * @param fPicture	所要添加的图片信息数据
	 * @return				返回是否添加成功
	 */
	public boolean addPicture(CompanyInfoPicture fPicture);
	
	/**
	 * 删除一个首页图片信息
	 * 
	 * @param fPicture	所要删除的图片信息
	 * @return				返回是否删除成功
	 */
	public boolean deletePicture(CompanyInfoPicture fPicture);
	
}
