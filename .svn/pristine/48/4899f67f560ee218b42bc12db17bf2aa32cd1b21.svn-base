package com.yjgs.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import com.yjgs.bll.ibll.IPermissionViewAndApplyBll;
import com.yjgs.dal.ManagerDal;
import com.yjgs.dal.Manager_PermissionDal;
import com.yjgs.dal.PermissionApplyDal;
import com.yjgs.dal.Permission_ApplyDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Manager_Permission;
import com.yjgs.dcl.Mapping_Permission_Apply;
import com.yjgs.dcl.PermissionApply;
import com.yjgs.enumdata.ManagerLevel;

public class PermissionViewAndApplyBll implements IPermissionViewAndApplyBll {

	@Override
	public void loadPermissionStatus(JspWriter fOut, HttpServletRequest fRequest) {

		ManagerDal mDal = null;
		Manager_PermissionDal mpDal = null;
		Manager manager = null;
		ArrayList<Mapping_Manager_Permission> permissions = null;
		
		//步骤1：实例化
		mDal = new ManagerDal();
		mpDal = new Manager_PermissionDal();
		manager = new Manager();
		
		try {
			
			//步骤2：获取管理员ID并据此获取管理员数据
			HttpSession session =  fRequest.getSession(true);
			manager.setManagerID(Integer.valueOf(
					session.getAttribute("UserID").toString()));
			manager = mDal.getAManager(manager);
			if(manager == null) throw new Exception("获取管理员数据时异常");
			
			//步骤3：判断管理员是否为超级管理员,并作超级管理员处理
			if(manager.getManagerLevel() == ManagerLevel.SUPER) {
				
				fOut.print("<td>超级管理员</td>");
				for(int i = 0; i<6; i++) {
					fOut.print("<td><img src='../Image/dui.png' /></td>");
				}
				return;
			}
			
			//步骤4：获取管理员权限数据(一般管理员的情况)
			Mapping_Manager_Permission aManager 
			= new Mapping_Manager_Permission();
			aManager.setManagerID(manager.getManagerID());
			permissions = mpDal.getAllPermission(aManager);
			if(permissions == null) throw new Exception("获取管理员权限数据时异常");
			
			
			
			//步骤5：绑定各权限状态
			//----------------------------
			
			//绑定管理员类别
			fOut.println("<td>一般管理员</td>");
			
			//绑定产品管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("产品管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
			
			//绑定新闻管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("新闻管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
			
			//绑定首页管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("首页管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
			
			//绑定反馈管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("反馈管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
			
			//绑定企业信息管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("企业信息管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
			
			//绑定功能管理情况
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("功能管理")) {
						isHas = true;
						break;
					}
				}
				fOut.println(String.format("<td><img src='%s' /></td>"
						, isHas? "../Image/dui.png":"../Image/cuo.png"));
			}
		}
		catch (Exception e) {

			System.out.println("业务逻辑层：权限状态加载异常");
			e.printStackTrace();
		}
	}

	@Override
	public void loadApplyPermissions(JspWriter fOut, HttpServletRequest fRequest) {
		
		ManagerDal mDal = null;
		Manager_PermissionDal mpDal = null;
		Manager manager = null;
		ArrayList<Mapping_Manager_Permission> permissions = null;
		
		// 步骤1：实例化
		mDal = new ManagerDal();
		mpDal = new Manager_PermissionDal();
		manager = new Manager();
		
		try {
			
			//步骤2：获取管理员ID并据此获取管理员数据
			HttpSession session =  fRequest.getSession(true);
			manager.setManagerID(Integer.valueOf(
					session.getAttribute("UserID").toString()));
			manager = mDal.getAManager(manager);
			if(manager == null) throw new Exception("获取管理员数据时异常");
			
			//步骤3：判断管理员是否为超级管理员
			if(manager.getManagerLevel() == ManagerLevel.SUPER) {
				
				fOut.print("<p>您是超级管理员，无需申请权限</p>");
				return;
			}
			
			//步骤4：获取管理员权限数据(一般管理员的情况)
			Mapping_Manager_Permission aManager 
			= new Mapping_Manager_Permission();
			aManager.setManagerID(manager.getManagerID());
			permissions = mpDal.getAllPermission(aManager);
			if(permissions == null) throw new Exception("获取管理员权限数据时异常");
			
			//步骤5：判断当前管理员是否拥有全部权限并作相应处理
			if(permissions.size() == 6) {
				
				fOut.print("<p>您拥有全部权限，无需申请权限</p>");
				return;
			}
			
			//步骤6：输出可申请的权限复选框
			
			//判断是否可以申请产品管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("产品管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='产品管理'"
							+ " name='applyPermission' />产品管理</div>");
				}
			}
			
			//判断是否可以申请新闻管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("新闻管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='新闻管理'"
							+ " name='applyPermission' />新闻管理</div>");
				}
			}
			
			//判断是否可以申请首页管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("首页管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='首页管理'"
							+ " name='applyPermission' />首页管理</div>");
				}
			}
			
			//判断是否可以申请反馈管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("反馈管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='反馈管理'"
							+ " name='applyPermission' />反馈管理</div>");
				}
			}
			
			//判断是否可以申请企业信息管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("企业信息管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='企业信息管理'"
							+ " name='applyPermission' />企业信息管理</div>");
				}
			}
			
			//判断是否可以申请功能管理权限
			{
				boolean isHas = false;
				for(Mapping_Manager_Permission aPermission : permissions) {
					
					if(aPermission.getPermission().equals("功能管理")) {
						
						isHas = true;
						break;
					}
				}
				if(!isHas) {
					fOut.println("<div><input type='checkbox' value='功能管理'"
							+ " name='applyPermission' />功能管理</div>");
				}
			}
			
			//输出提交按钮
			fOut.println("<input class='submitButton' type='submit' value='提交申请' />");
		} 
		catch (Exception e) {
			System.out.println("业务逻辑层：加载可申请权限异常");
			e.printStackTrace();
		}
	}

	@Override
	public boolean submitNewApply(ArrayList<Mapping_Permission_Apply> fPermissions,
			Manager fManager){
		
		PermissionApplyDal paDal = null;
		Permission_ApplyDal appliesDal = null;
		PermissionApply apply = null;
		
		paDal = new PermissionApplyDal();
		appliesDal = new Permission_ApplyDal();
		
		try {
			
			//步骤1：构建新的权限申请数据，并添加此申请
			apply = new PermissionApply();
			apply.setManagerID(fManager.getManagerID());
			if(!paDal.addNewApply(apply)) return false;
			
			//步骤2：获取添加后的申请ID
			apply = paDal.getApplyID(apply);
			if(apply == null) return false;
			
			//步骤3：对权限映射数据绑定申请的ID
			for(int i = 0; i < fPermissions.size(); i++) {
				
				fPermissions.get(i).setPerApplyID(apply.getPerApplyID());
			}
			
			//步骤4：调用权限映射Dal添加权限
			if(!appliesDal.addPermissions(fPermissions)) {
				return false;
			}
		}
		catch(Exception e) {
			
			System.out.println("业务逻辑层：权限申请添加出错");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 加载管理员未回复的权限
	 * 
	 * @param fOut				JSP输出对象
	 * @param fRequest			Servlet请求对象
	 */
	public void loadNoReadApplies(JspWriter fOut, HttpServletRequest fRequest) {
		
		PermissionApplyDal applyDal = null;
		Permission_ApplyDal permissionDal = null;
		ArrayList<PermissionApply> applies = null;
		
		//步骤1：实例化DAL
		applyDal = new PermissionApplyDal();
		permissionDal = new Permission_ApplyDal();
		
		try {
			
			//步骤2：调用DAL，获取未回复申请
			HttpSession session = fRequest.getSession(true);
			PermissionApply apply = new PermissionApply();
			apply.setManagerID(Integer.valueOf(session.getAttribute("UserID").toString()));
			applies = applyDal.getNoReadApplies(apply);
			
			if(applies == null) return;
			
			//步骤3：遍历未回复申请，获取申请的权限情况并输出
			
			//实例化日期格式
			DateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
			
			for(PermissionApply aApply : applies) {
				
				ArrayList<Mapping_Permission_Apply> permissions = null;
				
				//输出行头
				fOut.println("<tr>");
				
				//步骤3.1：输出申请的日期
				fOut.println(String.format("<td>%s</td>"
						,dfs.format(aApply.getApplyTime())));
				
				//步骤3.2：获取申请的权限情况（权限映射数据）
				Mapping_Permission_Apply applyID
				= new Mapping_Permission_Apply();
				applyID.setPerApplyID(aApply.getPerApplyID());
				permissions = permissionDal.getAllPermissions(applyID);
				
				if(permissions == null) continue;
				
				//步骤3.3：输出权限情况
				fOut.println("<td>");
				for(Mapping_Permission_Apply aPermission : permissions) {
					
					fOut.write(String.format("<span>%s </span>", aPermission.getPermission()));
				}
				fOut.println("</td>");
				
				//步骤3.4：输出状态
				fOut.println("<td>未回复</td>");
			}
		}
		catch (Exception e) {
			
			System.out.println("业务逻辑层：未回复申请加载出错");
			e.printStackTrace();
		}
	}
	
	/**
	 * 加载管理员已回复的权限
	 * 
	 * @param fOut				JSP输出对象
	 * @param fRequest			Servlet请求对象
	 */
	public void loadReadedApplies(JspWriter fOut, HttpServletRequest fRequest) {
		
		PermissionApplyDal applyDal = null;
		Permission_ApplyDal permissionDal = null;
		ArrayList<PermissionApply> applies = null;
		
		//步骤1：实例化DAL
		applyDal = new PermissionApplyDal();
		permissionDal = new Permission_ApplyDal();
		
		try {
			
			//步骤2：调用DAL，获取未回复申请
			HttpSession session = fRequest.getSession(true);
			PermissionApply apply = new PermissionApply();
			apply.setManagerID(Integer.valueOf(session.getAttribute("UserID").toString()));
			applies = applyDal.getReadedApplies(apply);
			
			//步骤3：遍历未回复申请，获取申请的权限情况并输出
			
			//实例化日期格式
			DateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
			
			if(applies == null) return;
			
			for(PermissionApply aApply : applies) {
				
				ArrayList<Mapping_Permission_Apply> permissions = null;
				
				//输出行头
				fOut.println("<tr>");
				
				//步骤3.1：输出申请的日期
				fOut.println(String.format("<td>%s</td>"
						,dfs.format(aApply.getApplyTime())));
				
				//步骤3.2：获取申请的权限情况（权限映射数据）
				Mapping_Permission_Apply applyID
				= new Mapping_Permission_Apply();
				applyID.setPerApplyID(aApply.getPerApplyID());
				permissions = permissionDal.getAllPermissions(applyID);
				
				if(permissions == null) continue;
				
				//步骤3.3：输出权限情况
				fOut.println("<td>");
				for(Mapping_Permission_Apply aPermission : permissions) {
					
					fOut.write(String.format("<span>%s </span>", aPermission.getPermission()));
				}
				fOut.println("</td>");
				
				//步骤3.4：输出状态
				fOut.println(String.format("<td>%s</td>", aApply.isPass()? "已通过":"未通过"));
			}
		}
		catch (Exception e) {
			
			System.out.println("业务逻辑层：已回复申请加载出错");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<PermissionApply> loadApplies(Manager fManager) {

		return null;
	}

}
