package com.yjgs.dal.idal;

import com.yjgs.dcl.CompanyInfo;

public interface ICompanyInfoDal {

	/**
	 * 修改信息
	 * 
	 * @param fInfo	需要修改的信息数据
	 * @return			返回是否成功修改
	 */
	public boolean updateInfo(CompanyInfo fInfo);
	
	/**
	 * 获取一种企业信息
	 * 
	 * @param fInfo	需要获取的信息的数据
	 * @return			返回获取的信息数据
	 */
	public CompanyInfo getAInfo(CompanyInfo fInfo);
}
