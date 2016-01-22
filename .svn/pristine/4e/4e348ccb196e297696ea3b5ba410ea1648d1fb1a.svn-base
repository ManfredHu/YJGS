package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IPermission_ApplyDal;
import com.yjgs.dcl.Mapping_Permission_Apply;
import com.yjgs.dpl.MappingPermissionApplyDpl;

public class Permission_ApplyDal implements IPermission_ApplyDal {

	@Override
	public boolean addPermissions(
			ArrayList<Mapping_Permission_Apply> fPermissions) {
		
		MappingPermissionApplyDpl mDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		// 步骤1：实例化包装类
		mDpl = new MappingPermissionApplyDpl();

		// 步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for (Mapping_Permission_Apply aPermission : fPermissions) {

			sqlString = String.format("INSERT INTO tb_mapping_permission_apply "
					+ "(PerApplyID,Permission) "
					+ "VALUES (%d,'%s')",
					aPermission.getPerApplyID(),aPermission.getPermission());

			reCount = mDpl.excuteUpdate(sqlString);

			if (reCount <= 0)
				return false;
		}

		// 若遍历成功，则返回True
		return true;
	}

	@Override
	public boolean deleteAllPermission(Mapping_Permission_Apply fApply) {
		
		MappingPermissionApplyDpl mDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		// 步骤1：实例化包装类并编写SQL语句
		mDpl = new MappingPermissionApplyDpl();
		sqlString = String.format("DELETE FROM tb_mapping_permission_apply "
				+ "WHERE PerApplyID = %d",fApply.getPerApplyID());

		// 步骤2：执行SQL语句并接收受影响行数
		reCount = mDpl.excuteUpdate(sqlString);

		// 步骤3：根据受影响行数判断添加是否成功
		if (reCount <= 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ArrayList<Mapping_Permission_Apply> getAllPermissions(
			Mapping_Permission_Apply fApply) {
		
		ArrayList<Mapping_Permission_Apply> permissions = null;
		MappingPermissionApplyDpl mDpl = null;
		String sqlString = null;
		
		//步骤1：实例化包装类并编写相应SQL语句
		mDpl = new MappingPermissionApplyDpl();
		sqlString = String.format("SELECT * FROM tb_mapping_permission_apply "
				+ "WHERE PerApplyID = %d", fApply.getPerApplyID());
		
		//步骤2：执行SQL语句并接收数据集合
		permissions = mDpl.excuteQuery(sqlString);
		
		////步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(permissions.size() == 0) return null;
		return permissions;

	}

}
