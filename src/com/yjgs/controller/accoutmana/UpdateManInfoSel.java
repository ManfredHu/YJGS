package com.yjgs.controller.accoutmana;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.ManagerBll;
import com.yjgs.dcl.Manager;

/**
 * Servlet implementation class UpdateManInfoSel
 */
public class UpdateManInfoSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManInfoSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userID = 0;
		HttpSession session = null;
		String userName = request.getParameter("userName");
		
		if(userName=="" || userName.length()>25){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入出错!");
			request.setAttribute("URL", "../AccountManage/UpdateManaInfo.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		try{
			
			session = request.getSession(true);
			userID = (int)session.getAttribute("UserID");
			
			Manager manager = new Manager();
			manager.setManagerID(userID);
			manager.setManagerName(userName);
			
			ManagerBll mBll = new ManagerBll();
			
			if(mBll.updateInfo(manager)){
				session.setAttribute("UserName", userName);
				request.setAttribute("judge", "true");
				request.setAttribute("text", "修改个人信息成功！");
				request.setAttribute("URL", "../welcome/adminIndex.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
		}
		else{
			request.setAttribute("judge", "false");
			request.setAttribute("text", "修改个人信息失败！");
			request.setAttribute("URL", "../AccountManage/UpdateManaInfo.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.print("业务逻辑层调用失败！");
		}
	}

}
