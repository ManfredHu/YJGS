package com.yjgs.dpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.yjgs.dbcl.ConnectionPool.PooledConnection;
import com.yjgs.dbcl.PoolManager;
import com.yjgs.dcl.Function;

public class FunctionDpl {
	public FunctionDpl(){
		
	}
	
	/**功能查询查找
	 * 执行数据库查询，并将ResultSet数据包装为实体类
	 * 
	 * @param fSqlString	相应SQL语句
	 */
	public ArrayList<Function> excuteQuery(String fSqlString) {
		
		// 数据库连接池类
		PooledConnection pConn = null;
		// 结果集
		ResultSet rSet = null;
		// 要返回的查询结果
		ArrayList<Function> functions = null;
		
		//得到连接
		pConn = PoolManager.getConnection();
		
		try{
			//执行语句得到结果集
			rSet = pConn.executeQuery(fSqlString);
			//调用私有方法将结果集解包

			functions = rsetToContainer(rSet);

			pConn.close();

		}catch(Exception e){
			System.out.println("执行数据库更新出错!");
			e.printStackTrace();
		}
		
		return functions;
		
	}
	
	/**
	 * 内部方法，将得到的结果集打包成链表
	 * @param fRset
	 * @return
	 * @throws Exception
	 */
	private ArrayList<Function> rsetToContainer(ResultSet fRset) throws	Exception{
		
		//初始化结果集
		ArrayList<Function> functions = new ArrayList<Function>();
		//查询结果集
		while (fRset.next()) {
			
			// 初始化一个
			Function aFunction = new Function();
			aFunction.setFunctionID(fRset.getInt("FunctionID"));
			aFunction.setName(fRset.getString("Name"));

			if (fRset.getInt("IsShow") == 0) {
				aFunction.setShow(false);
			} else {
				aFunction.setShow(true);
			}

			functions.add(aFunction);
		}
		return functions;

	}
	
	/**
	 * 功能管理修改
	 * 执行数据库更新
	 * 
	 * @param fSqlString		SQL语句
	 * @return					受影响行数
	 */
	public int excuteUpdate(String fSqlString){
		
		PooledConnection pConn = null;
		int reCount = 0;
		
		// 步骤1：获取数据库连接池连接
		pConn = PoolManager.getConnection();

		// 步骤2：执行SQL更新
		try {

			reCount  = pConn.executeUpdate(fSqlString);

			// 关闭数据库连接池连接（其实就是返回连接回到连接池）
			pConn.close();

		} catch (Exception e) {

			System.out.println("执行数据库查询出错!");
			e.printStackTrace();
		}
				
			//步骤3：返回受影响行数
			return reCount;
		
	}

}
