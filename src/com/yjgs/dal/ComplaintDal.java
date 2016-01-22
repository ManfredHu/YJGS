package com.yjgs.dal;

import java.util.ArrayList;

import jdk.nashorn.internal.objects.annotations.Where;

import com.yjgs.dcl.Complaint;
import com.yjgs.dpl.ComplaintDpl;

public class ComplaintDal {
	
	public boolean addComplaint(Complaint fComplaint) {
		
		ComplaintDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new ComplaintDpl();
		sqlString = String.format("INSERT INTO tb_complaint "
				+ "(ComplaintAccount,ComplaintReason,Email,IsPass) "
				+ "VALUES ('%s','%s','%s',0)",fComplaint.getConplaintAccount()
				,fComplaint.getConplaintReason(),fComplaint.getEmail(),fComplaint.getIsPass());
		
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

	public boolean deleteComplaint(ArrayList<Complaint> fComplaint) {
		
		ComplaintDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		aDpl = new ComplaintDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(Complaint complaint : fComplaint) {
			
			sqlString = String.format("DELETE FROM tb_complaint "
					+ "WHERE ComplaintID = %d",complaint.getComplaintID());
			
			reCount = aDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
				
		//若遍历成功，则返回True
		return true;
		
	}


	public boolean updateComplaint(Complaint fComplaint) {

		ComplaintDpl aDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new ComplaintDpl();
		sqlString = String.format("UPDATE tb_complaint "
				+ "SET IsPass =1"+" where ComplaintID = %d",fComplaint.getComplaintID());
		
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


	public Complaint getComplaint(Complaint fComplaint) {

		ComplaintDpl aDpl = null;
		String sqlString = null;
		ArrayList<Complaint> reCount = null;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new ComplaintDpl();
		sqlString = String.format("SELECT * from tb_complaint "
				+ "where ComplaintID = %d",fComplaint.getComplaintID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = aDpl.excuteQuery(sqlString);
		
		//步骤3：返回数据
		if(reCount.size()!=0)
		return reCount.get(0);
		else return null;
	}

	public ArrayList<Complaint> getNoPassComplaint() {

		ComplaintDpl aDpl = null;
		String sqlString = null;
		ArrayList<Complaint> reCount = null;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new ComplaintDpl();
		sqlString = String.format("SELECT * from tb_complaint "
				+ "where IsPass=0");
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = aDpl.excuteQuery(sqlString);
		
		//步骤3：返回数据
		return reCount;
	}
	
	/**
	 * 获取所有未读申诉
	 * 
	 * @return		返回未读申诉数据
	 */
	public ArrayList<Complaint> getAllNoPassComplaints() {
		
		ComplaintDpl aDpl = null;
		String sqlString = null;
		ArrayList<Complaint> complaints = null;
		
		//步骤1：实例化包装类并编写SQL语句
		aDpl = new ComplaintDpl();
		sqlString = String.format("SELECT * FROM tb_complaint "
				+ "WHERE IsPass = 0");
		
		//步骤2：执行SQL语句并接收受影响行数
		complaints = aDpl.excuteQuery(sqlString);
		
		//步骤3：返回数据
		if(complaints.size() == 0) {
			return null;
		}
		return complaints;
	}

}
