package com.yjgs.dbcl;

public class DBConfig {

	private static String mysqlHost 			= "localhost"; 			//mysql数据库服务器ip
	
	private static int 		mysqlPort 			= 3306; 		//mysql数据服务器端口
	
	private static String mysqlDB 				= "db_yjgs"; //mysql数据库实例
	
	private static String mysqlUser 			= "root"; 		//mysql数据库用户名
	
	private static String mysqlPassword 	= "123456"; 	//mysql数据库密码

//	private static String mysqlHost 			= "hf"; 			//mysql数据库服务器ip
//	
//	private static int 		mysqlPort 			= 3306; 		//mysql数据服务器端口
//	
//	private static String mysqlDB 				= "db_yjwz"; //mysql数据库实例
//	
//	private static String mysqlUser 			= "root"; 		//mysql数据库用户名
//	
//	private static String mysqlPassword 	= "123456"; 	//mysql数据库密码

//	private static String mysqlHost 			= "localhost"; 			//mysql数据库服务器ip
//	
//	private static int 		mysqlPort 			= 3306; 		//mysql数据服务器端口
//	
//	private static String mysqlDB 				= "db_yjwz"; //mysql数据库实例
//	
//	private static String mysqlUser 			= "root"; 		//mysql数据库用户名
//	
//	private static String mysqlPassword 	= "birthday625@"; 	//mysql数据库密码

	
	/**
	 * 设置mysql服务器名
	 * 
	 * @mysqlHost 要设置的mysql服务器名
	 */
	
	
	public static String getMysqlHost() { 
		return mysqlHost;
	}
	
	
	
	public static int getMysqlPort() { 
		return mysqlPort;
	}
	
	
	
	public static String getMysqlDB() { 
		return mysqlDB;
	}
	
	
	
	public static String getMysqlUser() { 
		return mysqlUser;
	}
	
	
	
	public static String getMysqlPassword() { 
		return mysqlPassword;
	}
}
