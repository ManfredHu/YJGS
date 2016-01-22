package com.yjgs.controller.perview;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.PermissionViewAndApplyBll;
import com.yjgs.dal.PermissionApplyDal;
import com.yjgs.dal.Permission_ApplyDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Permission_Apply;
import com.yjgs.dcl.PermissionApply;

/**
 * Servlet implementation class SubmitApply
 */
public class SubmitApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitApply() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PermissionViewAndApplyBll pvBll = null;
		Manager manager = null;
		ArrayList<Mapping_Permission_Apply> permissions = null;
		
		// 步骤1：设置请求与相应的编码及文档格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：对请求数据进行验证（验证是否申请了已申请的权限）
		if(!validate(request)) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "申请提交失败，请检查是否提交了已申请的权限");
			request.setAttribute("URL", "../PermissionViewAndApply/PermissionStatus.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		
		//步骤3：将请求数据封装到实体类中
		manager = packManager(request);
		permissions = packApplies(request);
		
		//步骤4：调用业务逻辑，执行添加管理员业务，并根据结果处理跳转
		pvBll = new PermissionViewAndApplyBll();
		if(pvBll.submitNewApply(permissions,manager)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "成功提交申请，请等待管理员回复");
			request.setAttribute("URL", "../PermissionViewAndApply/PermissionStatus.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "申请提交失败，请重试");
			request.setAttribute("URL", "../PermissionViewAndApply/PermissionStatus.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 验证是否有重复申请的权限
	 * 
	 * @param fRequest			请求数据
	 * @return						返回是否通过验证
	 */
	private boolean validate(HttpServletRequest fRequest) {
		
		PermissionApplyDal paDal = null;
		Permission_ApplyDal appliesDal = null;
		int managerID = 0;
		String[] permissions = null;
		HttpSession session = null;
		
		
		paDal = new PermissionApplyDal();
		appliesDal = new Permission_ApplyDal();
		
		
		//步骤1：判断是否有已申请的权限
		try {
			
			//获取管理员ID和申请的权限
			session = fRequest.getSession(true);
			managerID = Integer.valueOf(session.getAttribute("UserID").toString());
			permissions = fRequest.getParameterValues("applyPermission");
			
			//步骤1.1：获取管理员已申请的权限
			ArrayList<Mapping_Permission_Apply> appliedPermissions = null;
			ArrayList<PermissionApply> applies  = null;
			
			//--实例化实体类（已申请的权限集合）
			appliedPermissions =new ArrayList<Mapping_Permission_Apply>();

			//--获取管理员的所有未读申请
			PermissionApply manager = new PermissionApply();
			manager.setManagerID(managerID);
			applies = paDal.getNoReadApplies(manager);
			
			//--如果有未读申请，则进行以各申请的判断
			if( applies == null)  return true;
				
			//遍历未读申请，将申请的权限加进已申请的权限集合
			for(PermissionApply aApply : applies) {
					
				Mapping_Permission_Apply applyID
				= new Mapping_Permission_Apply();
					
				applyID.setPerApplyID(aApply.getPerApplyID());
					
				ArrayList<Mapping_Permission_Apply> applyPermissions
				=appliesDal.getAllPermissions(applyID);
					
				if(applyPermissions == null) continue;
				
				//获取对应申请中的所有权限，加进已申请权限
				appliedPermissions.addAll(applyPermissions);
			}

			//嵌套循环，判断当前申请的权限是否已经被申请过
			for(Mapping_Permission_Apply aAppliedPermission : appliedPermissions) {
					
				for(String aPermission : permissions) {
						
					if(aAppliedPermission.getPermission().equals(aPermission)) {
							return false;
					}
				}
			}
		}
		catch(Exception e) {
			
			System.out.println("重复申请的验证出错");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * 包装管理员数据
	 * 
	 * @param fRequest			Servlet请求数据
	 * @return						返回管理员实体类
	 */
	private Manager packManager(HttpServletRequest fRequest) {
		
		Manager manager = new Manager();
		
		try {
			
			HttpSession session = fRequest.getSession(true);
			manager.setManagerID(Integer.valueOf
					(session.getAttribute("UserID").toString())); 
			
		} 
		catch (Exception e) {

			System.out.println("管理员数据包装出错");
			e.printStackTrace();
			return null;
		}
		
		return manager;
	}
	
	/**
	 * 包装权限申请数据
	 * 
	 * @param request		Servlet请求
	 * @return					申请映射集合
	 */
	private ArrayList<Mapping_Permission_Apply> packApplies(HttpServletRequest fRequest) {
		
		String[] values = null;
		ArrayList<Mapping_Permission_Apply> permissions 
		= new ArrayList<Mapping_Permission_Apply>();
		
		try {
			
			values =  fRequest.getParameterValues("applyPermission");
			for(String aValue : values) {
				
				Mapping_Permission_Apply aPermission 
				= new Mapping_Permission_Apply();
				aPermission .setPermission(aValue);
				permissions.add(aPermission);
			}
			
		} catch (Exception e) {
			
			System.out.println("权限申请数据包装错误");
			e.printStackTrace();
			return null;
		}
		
		return permissions;
		
	}

}
