package com.yjgs.dbcl;

import java.sql.SQLException;
import com.yjgs.dbcl.DBConfig;
import com.yjgs.dbcl.ConnectionPool;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;

public class PoolManager {

	//静态的数据库连接池连接对象
	private static PooledConnection conn;
	
	//静态的数据库连接池
	private static ConnectionPool connectionPool;
	
	//本类
	private static PoolManager inst;

	//关闭连接池
	public void close() {
		try {
			connectionPool.closeConnectionPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//返回连接
	public static void returnConnection(PooledConnection curConn) {
		try {
			connectionPool.returnConnection(curConn.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PoolManager() {
		if (inst != null)
			return;


		String connStr = String.format("jdbc:mysql://%s:%d/%s", 
				DBConfig.getMysqlHost(), DBConfig.getMysqlPort(),
				DBConfig.getMysqlDB());
		connectionPool = new ConnectionPool("com.mysql.jdbc.Driver", 
				connStr, DBConfig.getMysqlUser(), DBConfig.getMysqlPassword());
		try {
			connectionPool.createPool();
			inst = this;
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//获取连接
	public static PooledConnection getConnection() {
		if (inst == null)
			new PoolManager();

		try {
			
			conn = connectionPool.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
