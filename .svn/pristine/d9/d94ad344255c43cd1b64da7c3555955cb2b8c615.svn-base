package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IPermissionApplyDal;
import com.yjgs.dcl.PermissionApply;
import com.yjgs.dpl.PermissionApplyDpl;

public class PermissionApplyDal implements IPermissionApplyDal {

	@Override
	public boolean addNewApply(PermissionApply fApply) {
		
		PermissionApplyDpl paDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("INSERT INTO tb_permission_apply "
				+ "(ManagerID,IsRead,IsPass,ApplyTime)"
				+ "VALUES (%d,%d,%d,now())",
				fApply.getManagerID(),fApply.isRead()? 1 : 0,fApply.isPass()? 1 : 0);
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = paDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean deleteApplies(PermissionApply fApply){
		
		PermissionApplyDpl paDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		paDpl = new PermissionApplyDpl();
		
		//步骤2：编写sql语句并注入相应数据、执行并判断是否成功
		sqlString = String.format("DELETE FROM tb_permission_apply "
				+ "WHERE PerApplyID = %d", fApply.getPerApplyID());
			
		reCount = paDpl.excuteUpdate(sqlString);
			
		if(reCount <= 0 ) return false;
		
		//若遍历成功，则返回True
		return true;
		
	}

	@Override
	public boolean updateApply(PermissionApply fApply) {
		
		PermissionApplyDpl paDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("UPDATE tb_permission_apply "
				+ "SET IsRead = %d,IsPass = %d WHERE PerApplyID =%d ",
				fApply.isRead()? 1 : 0,fApply.isPass()? 1 : 0,fApply.getPerApplyID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = paDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public PermissionApply getApply(PermissionApply fApply) {
		
		ArrayList<PermissionApply> apply = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("SELECT * FROM tb_permission_apply "
				+ "WHERE PerApplyID = %d ", fApply.getPerApplyID());
		
		//步骤2：执行SQL语句并接收权限数据集合
		apply = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回第一项、否则返回null
		if(apply.size() == 0) return null;
		return apply.get(0);
	}
	
	public PermissionApply getApplyID(PermissionApply fApply) {
		
		ArrayList<PermissionApply> apply = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("SELECT MAX(PerApplyID) AS PerApplyID,ManagerID,IsRead,IsPass,ApplyTime"
				+ " FROM tb_permission_apply"
				+ " WHERE ManagerID=%d AND IsRead=%d AND IsPass = %d"
				, fApply.getManagerID(),fApply.isPass()? 1:0,fApply.isPass()? 1:0);
		
		//步骤2：执行SQL语句并接收权限数据集合
		apply = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回第一项、否则返回null
		if(apply.size() == 0) return null;
		return apply.get(0);
		
	}
	
	
	/**
	 * 获取管理员所有未读申请
	 * 
	 * @param fManager			管理员数据
	 * @return							所有未读申请
	 */
	public ArrayList<PermissionApply> getNoReadApplies(PermissionApply fManager) {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("SELECT * FROM tb_permission_apply "
				+ "WHERE ManagerID = %d AND IsRead = 0 ORDER BY ApplyTime DESC"
				, fManager.getManagerID());
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
		
	}
	
	/**
	 * 获取所有未读申请
	 * 
	 * @return	返回未读申请的集合
	 */
	public ArrayList<PermissionApply> getNoReadApplies() {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = "SELECT * FROM tb_permission_apply "
				+ "WHERE  IsRead = 0 ORDER BY ApplyTime DESC";
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
	}
	
	/**
	 * 获取管理员所有已读申请
	 * 
	 * @param fManager			管理员数据
	 * @return							所有未读申请
	 */
	public ArrayList<PermissionApply> getReadedApplies(PermissionApply fManager) {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("SELECT * FROM tb_permission_apply "
				+ "WHERE ManagerID = %d AND IsRead = 1 ORDER BY ApplyTime DESC"
				, fManager.getManagerID());
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
		
	}
	
	/**
	 * 获取所有已读申请
	 * 
	 * @return	返回已读申请的集合
	 */
	public ArrayList<PermissionApply> getReadedApplies() {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = "SELECT * FROM tb_permission_apply "
				+ "WHERE  IsRead = 1 ORDER BY ApplyTime DESC";
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
	}
	
	

	@Override
	public ArrayList<PermissionApply> getAllApplies(PermissionApply fManager) {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = String.format("SELECT * FROM tb_permission_apply "
				+ "WHERE PerApplyID = %d ", fManager.getManagerID());
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
	}

	@Override
	public ArrayList<PermissionApply> getAllApplies() {
		
		ArrayList<PermissionApply> applies = null;
		PermissionApplyDpl paDpl = null; 
		String sqlString = null;
		
		//步骤1：实例化包装类并编写查询SQL语句
		paDpl = new PermissionApplyDpl();
		sqlString = "SELECT * FROM tb_permission_apply";
		
		//步骤2：执行SQL语句并接收权限数据集合
		applies = paDpl.excuteQuery(sqlString);

		//步骤3：根据返回的数据集合判断查询是否成功
		//成功返回数据集合、否则返回null
		if(applies.size() == 0) return null;
		return applies;
	}

}
