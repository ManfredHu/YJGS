package com.yjgs.dpl;

import java.util.ArrayList;

import javax.servlet.ServletRequest;

public interface IDataPackLayer {

	/**
	 * 执行数据库查询，并将ResultSet数据包装为实体类
	 * 
	 * @param fSqlString	相应SQL语句
	 * @return					返回对应的实体类集合
	 */
	public ArrayList<Object> excuteQuery(String fSqlString);
	
	/**
	 * 执行数据库更新
	 * 
	 * @param fSqlString	相应SQL语句
	 * @return					返回受影响行数
	 */
	public int excuteUpdate(String fSqlString);
	
	/**
	 * 将相应的表单数据包装到实体类中
	 * 
	 * @param fRequest		Servlet请求
	 * @return					相应的实体类集合
	 */
	public ArrayList<Object> packTheData(ServletRequest fRequest);
	
	/**
	 * 后台数据验证（对表单数据进行进一步验证）
	 * 
	 * @param fRequest		Servlet请求
	 * @return					是否通过验证
	 */
	public boolean dataVlidate(ServletRequest fRequest);
}
