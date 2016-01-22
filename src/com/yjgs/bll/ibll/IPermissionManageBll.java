package com.yjgs.bll.ibll;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Manager_Permission;
import com.yjgs.dcl.Permission;
import com.yjgs.dcl.PermissionApply;

public interface IPermissionManageBll {

	/**
	 * 注册新的管理员账号
	 * 
	 * @param fManager		管理员账号信息
	 * @param fPermissions	管理员权限信息
	 * @return						返回是否注册成功
	 */
	public boolean registerNewManager(Manager fManager
			,ArrayList<Permission> fPermissions);
	
	/**
	 * 加载管理员列表
	 * 
	 * @param fOut	JSP的输出对象
	 */
	public void loadAllManager(JspWriter fOut);
	
	/**
	 * 加载所有权限
	 * 
	 * @param fOut	JSP输出对象
	 */
	public void loadAllPermission(JspWriter fOut);
	
	/**
	 * 修改管理员权限
	 * 
	 * @param fMapManagers		管理员与权限映射集合
	 * @return								是否修改成功
	 */
	public boolean modifyPermission(Map<Manager, 
			ArrayList<Mapping_Manager_Permission>> fMapManagers);
	
	/**
	 * 加载所有未读申请
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadNoReadApplies(JspWriter fOut);
	
	/**
	 * 加载所有已读申请
	 * 
	 * @param fOut	JSP输出对象
	 */
	public void loadReadedApplies(JspWriter fOut);
	
	/**
	 * 解决申请（通过或不通过）
	 * 
	 * @param fApply	解决后的权限申请信息
	 * @return				返回是否更新成功
	 */
	public boolean dealApply(PermissionApply fApply);
	
	/**
	 *删除指定的申请信息
	 * 
	 * @param fApply	需要删除的申请信息
	 * @return				返回是否删除成功
	 */
	public boolean deleteApply(PermissionApply fApply);
}
