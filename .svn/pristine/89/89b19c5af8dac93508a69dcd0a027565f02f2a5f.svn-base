package com.yjgs.dpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.yjgs.dbcl.PoolManager;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;
import com.yjgs.dcl.NewsType;

public class NewsTypeDpl {
	
	/**
	 * 执行查询的数据库查询
	 * @param fSqlString		要执行的sql语句
	 * @return					封装好了的数据集合
	 */
public ArrayList<NewsType> excuteQuery(String fSqlString) {
		
		PooledConnection 		pConn 				= null;
		ResultSet 				  		rSet					= null;
		
		ArrayList<NewsType>  	newTypes		= null;
		
		//步骤1：获取数据库连接池连接
		pConn = PoolManager.getConnection();
		
		//步骤2：执行SQL查询语句并调用私有方法包装结果集数据
		try {
			
			rSet = pConn.executeQuery(fSqlString);
			
			newTypes = RsetToContainer(rSet);
			
			//关闭数据库连接池连接（其实就是返回连接回到连接池）
			pConn.close();	
			
		} catch (Exception e) {
			
			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}
		
		//步骤3：返回实体类集合数据
		return newTypes;
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
	
	/**
	 * 内部方法、进行结果集包装的具体过程
	 * 
	 * @param fRSet			数据库查询结果集
	 * @return					返回包装完成的实体类集合
	 * @throws Exception	抛出ResultSet读取时的异常
	 */
	private ArrayList<NewsType> RsetToContainer(
			ResultSet  fRSet) throws Exception {
		
		ArrayList<NewsType> newsTypes =
				new ArrayList<NewsType>();
		
		//循环遍历结果集获取数据
		while (fRSet.next()) {
			
			NewsType aNewsType = 
					new NewsType();
			
			aNewsType.setTypeID(fRSet.getInt("TypeID"));
			aNewsType.setTypeName(fRSet.getString("TypeName"));
			
			newsTypes.add(aNewsType);
		}
		
		return newsTypes;
	}

}
