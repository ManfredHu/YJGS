package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IAdviceDal;
import com.yjgs.dcl.Advice;
import com.yjgs.dpl.AdviceDpl;

public class AdviceDal implements IAdviceDal {

	@Override
	public boolean addAdvice(Advice fAdvice) {
		
		AdviceDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new AdviceDpl();
		sqlString = String.format("INSERT INTO tb_advice "
				+ "(Content,UserMail,AdviceTime,Reply,IsReply) "
				+ "VALUES ('%s','%s',now(),'暂无',0)",fAdvice.getContent(),fAdvice.getUserMail());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = aDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}

	}

	@Override
	public boolean deleteAdvice(Advice fAdvices) {
		
		AdviceDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		//for(Advice advice : fAdvices) {
			
			sqlString = String.format("DELETE FROM tb_advice "
					+ "WHERE AdviceID = %d",fAdvices.getAdviceID());
			
			reCount = aDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		//}
				
		//若遍历成功，则返回True
		return true;
		
	}

	@Override
	public boolean updateAdvice(Advice fAdvice) {

		AdviceDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new AdviceDpl();
		sqlString = String.format("UPDATE tb_advice "
				+ "SET Reply = '%s', IsReply = 1 where AdviceID=%d",fAdvice.getReply(),fAdvice.getAdviceID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = aDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public Advice getAdvice(Advice fAdvice) {

		return null;
	}

	@Override
	public ArrayList<Advice> getAdvices(int fPage,boolean isReply) {

		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		int pageSize = 5;		//一页5个记录
		int startPage = 0;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM tb_advice "
				+ "WHERE IsReply = %d LIMIT %d,%d", isReply? 1 : 0,startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		advices = aDpl.excuteQuery(sqlString);
		if(advices.size() == 0) return null;
		return advices;
	}
	
	public ArrayList<Advice> getAllAdvices(int fPage) {

		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		int pageSize = 5;		//一页5个记录
		int startPage = 0;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM tb_advice order by AdviceTime desc"
				+ " LIMIT %d,%d ", startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		advices = aDpl.excuteQuery(sqlString);
		if(advices.size() == 0) return null;
		return advices;
	}
	
	public ArrayList<Advice> getManAdvices(int fPage) {

		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		int pageSize = 5;		//一页5个记录
		int startPage = 0;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM tb_advice  "
				+ "where IsReply=0 order by AdviceTime desc LIMIT %d,%d ", startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		advices = aDpl.excuteQuery(sqlString);
		if(advices.size() == 0) return null;
		return advices;
	}


	public ArrayList<Advice> getPageSum() {

		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：编写SQL语句注入数据
		sqlString = String.format("SELECT * FROM tb_advice ");
		
		//步骤3：执行SQ语句
		advices = aDpl.excuteQuery(sqlString);
		
		//步骤4：返回集合大小
		return advices;

	}

	
	public Advice getAdvices(Advice fAdvice) {
		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：编写SQL语句注入数据
		sqlString = String.format("SELECT * FROM tb_advice where AdviceID=%d",fAdvice.getAdviceID());
		
		//步骤3：执行SQ语句
		advices = aDpl.excuteQuery(sqlString);
		
		//步骤4：返回集合大小
		if(advices.size()!=0)
		return advices.get(0);
		else return null;

}
	
	/**
	 * 获取建议反馈数量
	 * 
	 * @param isReply			是否回复
	 * @return						返回建议反馈数量
	 */
	public int getNum(boolean isReply) {
		ArrayList<Advice> advices = null;
		AdviceDpl aDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：编写SQL语句注入数据
		sqlString = String.format("SELECT * FROM tb_advice "
				+ "WHERE IsReply = %d ", isReply? 1 : 0);
		
		//步骤3：执行SQ语句
		advices = aDpl.excuteQuery(sqlString);
		
		//步骤4：返回集合大小
		return advices.size();

	}
		
	
	public int getManagePageSum() {

		ArrayList<Advice> advices = new ArrayList<Advice>();
		AdviceDpl aDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		aDpl = new AdviceDpl();
		
		//步骤2：编写SQL语句注入数据
		sqlString = String.format("SELECT * FROM tb_advice where IsRead = 0");
		
		//步骤3：执行SQ语句
		advices = aDpl.excuteQuery(sqlString);
		
		//步骤4：返回集合大小
		if(advices==null) return 0;
		else return advices.size();

	}

	@Override
	public int getPageSum(boolean isReply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAdvices(ArrayList<Advice> fAdvices) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
