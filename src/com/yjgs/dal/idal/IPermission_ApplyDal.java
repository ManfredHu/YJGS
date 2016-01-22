package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Mapping_Permission_Apply;

/**
 *	处理权限申请映射数据
 * 
 * @author 少波
 *
 */
public interface IPermission_ApplyDal {
	
	/**
	 * 向指定申请添加多个权限
	 * 
	 * @param fPermissions	所要添加的权限集合
	 * @param fApply			所要添加权限的申请
	 * @return						返回是否添加成功
	 */
	public boolean addPermissions(ArrayList<Mapping_Permission_Apply> fPermissions);
	
	/**
	 * 删除对应权限申请的所有权限内容
	 * 
	 * @param fApply	要删除权限内容的申请
	 * @return				返回是否删除成功
	 */	
	public boolean deleteAllPermission(Mapping_Permission_Apply fApply);
	
	/**
	 * 获取指定权限申请的所有权限内容
	 * 
	 * @param fApply	要获取申请内容的权限
	 * @return				返回权限映射的集合
	 */
	public ArrayList<Mapping_Permission_Apply> getAllPermissions(Mapping_Permission_Apply fApply);
	
	
}
