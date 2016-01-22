package com.yjgs.bll.ibll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Permission_Apply;
import com.yjgs.dcl.PermissionApply;

public interface IPermissionViewAndApplyBll {

	/**
	 * 加载当前管理员的权限状态
	 * 
	 * @param fOut				JSP输出对象
	 * @param fRequest			Servlet请求对象
	 */
	public void loadPermissionStatus(JspWriter fOut,HttpServletRequest fRequest);
	
	/**
	 * 加载当前管理员可申请的权限
	 * 
	 * @param fOut				JSP输出对象
	 * @param fRequest			Servlet请求对象
	 */
	public void loadApplyPermissions(JspWriter fOut,HttpServletRequest fRequest);
	
	/**
	 * 提交新的权限申请
	 * 
	 * @param fPermissions	申请的权限信息集合
	 * @return						返回是否成功提交
	 */
	public boolean submitNewApply(ArrayList<Mapping_Permission_Apply> fPermissions,
			Manager fManager);
	
	/**
	 * 查看权限申请状态(查看管理员所有权限申请)
	 * 
	 * @param fManager	需要查看状态的管理员信息
	 * @return					返回权限申请信息集合
	 */
	public ArrayList<PermissionApply> loadApplies(Manager fManager);
}
