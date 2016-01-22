package com.yjgs.controller.permanage;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yjgs.bll.PermissionManageBll;
import com.yjgs.dal.ManagerDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Permission;
import com.yjgs.enumdata.ManagerLevel;
import com.yjgs.publ.MD5;

/**
 * Servlet implementation class AddNewManager
 */
public class AddNewManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewManager() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PermissionManageBll pBll = null;
		Manager newManager = null;
		ArrayList<Permission> permissions = null;
		
		//步骤1：设置请求与相应的编码及文档格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//步骤2：对请求数据进行后台验证
		if(!validate(request)) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入有误，请重新输入");
			request.setAttribute("URL", "../PermissionManage/AddNewManager.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		//步骤3：将请求数据封装到实体类中
		newManager = packNewManager(request);
		permissions = packPermissions(request);
		
		
		//步骤4：调用业务逻辑，执行添加管理员业务，并根据结果处理跳转
		pBll = new PermissionManageBll();
		if(pBll.registerNewManager(newManager, permissions)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "成功添加管理员");
			request.setAttribute("URL", "../PermissionManage/AddNewManager.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;

		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "添加管理员失败");
			request.setAttribute("URL", "../PermissionManage/AddNewManager.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}

	}
	
	/**
	 * 对请求数据进行后台验证
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否通过验证
	 */
	private boolean validate(HttpServletRequest fRequest) {
		
		ManagerDal mDal = null;
		ArrayList<Manager> managers = null;
		String userAccount = null;
		
		try {
		
			//步骤1：验证用户名及账号（长度验证）
			if(fRequest.getParameter("userName").length() > 15) return false;
			if(fRequest.getParameter("userAccount").length() > 15) return false;
		
			//步骤2：验证账号（不重复验证）
			mDal = new ManagerDal();
			managers = mDal.selectAllManager();
			userAccount = fRequest.getParameter("userAccount");
			if(managers != null) {
				for(Manager aManager : managers) {
					
					if(aManager.getManagerAccount().equals(userAccount))
						return false;
				}
			}
		}
		catch(Exception e) {
			
			System.out.println("数据验证异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	//包装Manager数据到实体类
	private Manager packNewManager(HttpServletRequest fRequest) {
		
		Manager newManager = new Manager();
		
		try {
			
			//读取请求数据，封装到实体类中
			newManager.setManagerName(fRequest.getParameter("userName"));
			newManager.setPassword(MD5.GetMD5Code("8888"));
			newManager.setManagerAccount(fRequest.getParameter("userAccount"));
			newManager.setManagerLevel(ManagerLevel.COMMON);
			
		} catch (Exception e) {
			
			System.out.println("从请求数据到Manager的封装过程出现异常！");
			e.printStackTrace();
			return null;
		}
		
		return newManager;
	}
	
	//包装Permission数据到实体类
	private ArrayList<Permission> packPermissions(
			HttpServletRequest fRequest) {

		String[] rParams = null;
		ArrayList<Permission> permissions = null;
		
		try {
			
			//步骤1：获取请求数据中的权限ID数据
			rParams = fRequest.getParameterValues("permissions");
			
			//步骤2：遍历请求数据，并封装到权限实体类中
			permissions = new ArrayList<Permission>();		
			for(String param : rParams) {
				
				Permission aPermission = new Permission();
				aPermission.setContent(param);
		
				permissions.add(aPermission);
			}
			
		} catch (Exception e) {

			System.out.println("从请求数据到Permission的封装过程出现异常！");
			e.printStackTrace();
			return null;
		}
		
		//步骤3：返回权限实体类集合
		return permissions;
	}

}
