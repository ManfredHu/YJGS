package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IManager_PermissionDal;
import com.yjgs.dcl.Mapping_Manager_Permission;
import com.yjgs.dpl.MappingManagerPermissionDpl;

public class Manager_PermissionDal implements IManager_PermissionDal {

	@Override
	public boolean addNewPermissions(ArrayList<Mapping_Manager_Permission> fPermissions) {
		
		MappingManagerPermissionDpl mDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化权限映射数据包装类
		mDpl = new MappingManagerPermissionDpl();
		
		//步骤2：循环遍历权限映射集合数据，同时编写SQL语句、注入数据并调用包装类执行
		for(Mapping_Manager_Permission aPermission : fPermissions) {
			
			sqlString = String.format("INSERT INTO tb_mapping_manager_permission "
					+ "(ManagerID,Permission) VALUES (%d,'%s')",
					aPermission.getManagerID(),aPermission.getPermission());
			
			reCount = mDpl.excuteUpdate(sqlString);
			
			//受影响行数若不大于0，则返回False
			if(reCount <= 0 ) return false;
			
		}
		
		return true;
	}


	@Override
	public boolean deleteAllPermission(Mapping_Manager_Permission fManager) {
		
		MappingManagerPermissionDpl mDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化权限映射数据包装类
		mDpl = new MappingManagerPermissionDpl();
		
		sqlString = String.format("DELETE FROM tb_mapping_manager_permission "
				+ "WHERE ManagerID = %d", fManager.getManagerID());
		
		reCount = mDpl.excuteUpdate(sqlString);

		if (reCount < 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public ArrayList<Mapping_Manager_Permission> getAllPermission(
			Mapping_Manager_Permission fManager) {

		ArrayList<Mapping_Manager_Permission> permissions = null;
		MappingManagerPermissionDpl mDpl = null;
		String sqlString = null;
		
		mDpl = new MappingManagerPermissionDpl();
		
		sqlString = String.format("SELECT * FROM tb_mapping_manager_permission "
				+ "WHERE ManagerID=%d ", fManager.getManagerID());
		
		permissions = mDpl.excuteQuery(sqlString);
		
		return permissions;
	}

}
