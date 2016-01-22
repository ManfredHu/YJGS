package com.yjgs.dpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.yjgs.dbcl.PoolManager;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;
import com.yjgs.dcl.Permission;

public class PermissionDpl {

	public PermissionDpl() {

	}

	/**
	 * 执行数据库查询，并将ResultSet数据包装为权限数据容器
	 * 

	 * @param fSqlString	相应SQL语句
	 * @return					权限数据集合
	 */
	public ArrayList<Permission> excuteQuery(String fSqlString) {

		PooledConnection pConn = null;
		ResultSet rSet = null;
		ArrayList<Permission> permissions = null;

		//步骤1：获取数据库连接池连接
		pConn = PoolManager.getConnection();

		//步骤2：执行SQL查询语句并调用私有方法包装结果集数据
		try {
			
			rSet = pConn.executeQuery(fSqlString);

			permissions = rsetToContainer(rSet);

			//关闭数据库连接池连接（其实就是返回连接回到连接池）
			pConn.close();	

		} catch (Exception e) {

			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}

		//步骤3：返回实体类集合数据

		return permissions;
	}

	
	/**
	 * 内部方法、进行结果集包装的具体过程
	 * 
	 * @param fRSet			数据库查询结果集
	 * @return					返回包装完成的实体类集合
	 * @throws Exception	抛出ResultSet读取时的异常
	 */
	private ArrayList<Permission> rsetToContainer(ResultSet  fRSet) throws Exception {
		

		ArrayList<Permission> permissions = new ArrayList<Permission>();

		//循环遍历结果集获取数据
		while (fRSet.next()) {

			Permission aPermission = new Permission();

			aPermission.setPermissionID(fRSet.getInt("PermissionID"));
			aPermission.setContent(fRSet.getString("Content"));

			permissions.add(aPermission);
		}

		return permissions;
	}

}
