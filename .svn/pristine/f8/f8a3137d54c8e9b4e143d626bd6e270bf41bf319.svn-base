package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dpl.PermissionDpl;
import com.yjgs.dal.idal.IPermissionDal;
import com.yjgs.dcl.Permission;

public class PermissionDal implements IPermissionDal {

	public PermissionDal() {

	}

	@Override
	public ArrayList<Permission> getAllPermission() {

		String sqlString = null;
		ArrayList<Permission> permissions = null;
		PermissionDpl pDpl = null;

		//步骤1：编写SQL语句，获取所有权限
		sqlString = "SELECT * FROM tb_permission ORDER BY PermissionID ASC";

		
		//步骤2：实例化包装类并执行SQL语句获取返回的权限实体类集合
		pDpl 		= new PermissionDpl();

		permissions = pDpl.excuteQuery(sqlString);

		//步骤3：返回获取的权限数据集合
		return permissions;
	}

}
