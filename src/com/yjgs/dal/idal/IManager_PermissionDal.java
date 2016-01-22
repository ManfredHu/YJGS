package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Mapping_Manager_Permission;

public interface IManager_PermissionDal {

	/**
	 * 对指定管理员添加个新的权限
	 * 
	 * @param fPermissions		权限映射集合
	 * @return							返回是否添加成功
	 */
	public boolean addNewPermissions(ArrayList<Mapping_Manager_Permission> fPermissions);
	
	
	/**
	 * 删除指定管理员的所有权限
	 * 
	 * @param fManager	指定的管理员
	 * @return					返回是否删除成功
	 */
	public boolean deleteAllPermission(Mapping_Manager_Permission fManager);
	
	/**
	 * 获取管理员的所有权限
	 * 
	 * @param fManager	指定的管理员（权限映射）
	 * @return					返回权限映射的集合
	 */
	public ArrayList<Mapping_Manager_Permission> getAllPermission(Mapping_Manager_Permission fManager);
}
