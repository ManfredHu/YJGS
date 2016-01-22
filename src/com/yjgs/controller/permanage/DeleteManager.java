package com.yjgs.controller.permanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.PermissionManageBll;
import com.yjgs.dcl.Manager;

/**
 * Servlet implementation class DeleteManager
 */
public class DeleteManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManager() {
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

		PermissionManageBll pBll = null;
		Manager manager = null;
		
		// 步骤1：设置请求与相应的编码及文档格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：将请求数据（所要删除的用户ID）封装到实体类
		try {
			
			manager = new Manager();
			manager.setManagerID(Integer.valueOf(request.getParameter("ID")));
			
		} catch (Exception e) {
			
			System.out.println("数据包装异常");
			e.printStackTrace();
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		
		//步骤3：执行删除逻辑，并处理跳转
		pBll = new PermissionManageBll();
		if(pBll.DeleteManager(manager)) {
			
			response.sendRedirect("ManagerList.jsp");
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "用户删除失败");
			request.setAttribute("URL", "../PermissionManage/ManagerList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
	}

}
