package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.PermissionApply;

public interface IPermissionApplyDal {

	/**
	 * 添加新的申请
	 * 
	 * @param fApply	新的申请数据
	 * @return				返回是否添加成功
	 */
	public boolean addNewApply(PermissionApply fApply);
	
	/**
	 * 删除一个申请
	 * 
	 * @param fApply	指定的要删除的申请数据
	 * @return				返回是否成功删除
	 */
	public boolean deleteApplies(PermissionApply fApply);
	
	/**
	 * 修改一个申请
	 * 
	 * @param fApply	指定要修改的申请数据
	 * @return				返回是否成功修改
	 */
	public boolean updateApply(PermissionApply fApply);
	
	/**
	 * 获得一个申请数据
	 * 
	 * @param fApply	指定要获取申请的数据的局部信息
	 * @return				返回此申请数据的全部信息
	 */
	public PermissionApply getApply(PermissionApply fApply);
	
	/**
	 * 获取指定管理员的所有申请数据
	 * 
	 * @param fApply	指定要获取的管理员数据
	 * @return				返回此管理员的所有申请数据集合
	 */
	public	ArrayList<PermissionApply> getAllApplies(PermissionApply fManager);
	
	/**
	 * 获取的所有申请数据
	 * 
	 * @return	返回所有申请数据的集合
	 */
	public	ArrayList<PermissionApply> getAllApplies();
	
	
}
