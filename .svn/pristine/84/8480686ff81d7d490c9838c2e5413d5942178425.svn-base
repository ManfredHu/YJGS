package com.yjgs.dpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.yjgs.dbcl.PoolManager;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;
import com.yjgs.dcl.Manager;
import com.yjgs.enumdata.ManagerLevel;

public class ManagerDpl {

	public ManagerDpl(){
		
	}
	
	public ArrayList<Manager> excuteQuery(String fsql){
		
		PooledConnection pConn = null;			//数据库连接connection
		ResultSet rSet = null;					//返回的数据库结果集
		ArrayList<Manager> managers= new ArrayList<Manager>();		//用于判断管理员账号、密码是否正确
		
		//获取连接
		pConn = PoolManager.getConnection();
		
		try {
			
			rSet = pConn.executeQuery(fsql);
			
			if(!rSet.wasNull())
			{
				managers = rsetToContainer(rSet);
			}
	
			pConn.close();
				
		} catch (Exception e) {
			
			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}
		return managers;
		
	}
	
	/**
	 * 执行数据库更新
	 * 
	 * @param fSqlString	SQL语句
	 * @return					受影响行数
	 */
	public int excuteUpdate(String fSqlString) {
		
		PooledConnection 	pConn 		= null;
		int 							reCount 	= 0;
		
		// 步骤1：获取数据库连接池连接
		pConn = PoolManager.getConnection();

		// 步骤2：执行SQL更新
		try {

			reCount  = pConn.executeUpdate(fSqlString);

			// 关闭数据库连接池连接（其实就是返回连接回到连接池）
			pConn.close();

		} catch (Exception e) {

			System.out.println("执行数据库更新出错!");
			e.printStackTrace();
		}
		
		//步骤3：返回受影响行数
		return reCount;
		
	}
	

	private ArrayList<Manager> rsetToContainer(ResultSet rSet) {
		
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		try {
			while(rSet.next()){
				
				Manager manager = new Manager();
				manager.setManagerID(rSet.getInt("ManagerID"));
				manager.setManagerName(rSet.getString("ManagerName"));
				manager.setPassword(rSet.getString("Password"));
				manager.setManagerAccount(rSet.getString("ManagerAccount"));
				if(rSet.getInt("ManagerLevel")==0)
					manager.setManagerLevel(ManagerLevel.SUPER);
				if(rSet.getInt("ManagerLevel")==1)
					manager.setManagerLevel(ManagerLevel.COMMON);
				
				managers.add(manager);
			}
			
			
		} catch (SQLException e) {
			
			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}
		
		return managers;
	}
	
	
}
