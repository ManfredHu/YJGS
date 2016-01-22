package com.yjgs.dpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.yjgs.dbcl.PoolManager;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;
import com.yjgs.dcl.Product;

public class ProductDpl {
	
   public ArrayList<Product> excuteQuery(String fsql){
		
		PooledConnection pConn = null;			//数据库连接connection
		ResultSet rSet = null;					//返回的数据库结果集
		ArrayList<Product> product = new ArrayList<Product>();		
		
		//获取连接
		pConn = PoolManager.getConnection();
		
		try {
			
			rSet = pConn.executeQuery(fsql);
			
			if(!rSet.wasNull())
			{
				product = rsetToContainer(rSet);
			}
	
			pConn.close();
				
		} catch (Exception e) {
			
			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}
		return product;
		
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
	 * 执行数据库记录的插入
	 * 
	 * @param fSqlString	SQL语句
	 * @return					返回新添加的ID
	 */
	public int excuteInsert(String fSqlString) {
		
		PooledConnection 	pConn 		= null;
		int 							reCount 	= 0;
		ResultSet					reID			= null;
		
		// 步骤1：获取数据库连接池连接
		pConn = PoolManager.getConnection();

		// 步骤2：执行SQL更新
		try {

			reCount  = pConn.executeUpdate(fSqlString);
			if(reCount != 0) {
				
				//获取最新添加的ID，当前维护的连接有效
				reID = pConn.executeQuery("SELECT LAST_INSERT_ID()");
				if(!reID.next()) return 0;
				reCount = reID.getInt(1);
			}

			// 关闭数据库连接池连接（其实就是返回连接回到连接池）
			pConn.close();

		} catch (Exception e) {

			System.out.println("执行数据库更新出错!");
			e.printStackTrace();
			return 0;
		}
		
		//步骤3：返回新记录ID
		return reCount;
		
	}

   /**
    * 内部方法、进行结果集包装的具体过程
    * 
    * @param frSet		数据库查询结果集
    * @return			返回包装完成的实体类
    */
   private ArrayList<Product> rsetToContainer(ResultSet frSet) {
	
	 ArrayList<Product> product = new ArrayList<Product>();
	
	try {
		while(frSet.next()){
			
			Product products=new Product();
			products.setProdcuctID(frSet.getInt("ProductID"));
			products.setProductTypeID(frSet.getInt("ProductTypeID"));
			products.setProductName(frSet.getString("ProductName"));
			products.setIntroduct(frSet.getString("Introduce"));
			products.setPublishTime(frSet.getDate("PublishTime"));
			
			product.add(products);
		}
		
		
	} catch (SQLException e) {
		
		System.out.println("执行数据库查询出错!");
		e.printStackTrace();
	}
	
	return product;
}


}
