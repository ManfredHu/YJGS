package com.yjgs.controller.accoutmana;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.ManagerBll;
import com.yjgs.dcl.Manager;
import com.yjgs.publ.MD5;

/**
 * Servlet implementation class UpdatePwdSel
 */
public class UpdatePwdSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		int userID = (Integer)session.getAttribute("UserID");
		//int userID = 1;
		
		if(password1==""||password2==""||password3==""){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据不能为空，请重新填写！");
			request.setAttribute("URL", "UpdatePwd.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		if(!password2.equals(password3)){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "新密码两次输入不相符，请重新填写！");
			request.setAttribute("URL", "UpdatePwd.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		if(!passwordIsTrue(password1,userID)){
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "旧密码输入不正确，请重新填写！");
			request.setAttribute("URL", "UpdatePwd.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		ManagerBll mBll = new ManagerBll();
		
		Manager fManager = new Manager();
		fManager.setManagerID(userID);
		fManager.setPassword(MD5.GetMD5Code(password2));		//MD5加密密码
		
		
		
		try{
			
			boolean isTrue = mBll.UpdatePwd(fManager);
			
			if(isTrue == true){
				
				Cookie cookies[]=request.getCookies();
				Cookie scookie = null;
				if(cookies!=null){
					for(int n=0;n<=cookies.length-1;n++){
					    
						scookie=cookies[n];
						if(scookie.getName().equals("UserID") || scookie.getName().equals("MaxAge"))
						{
							if(scookie.getName().equals("MaxAge")) {
								
								scookie.setValue("0"); //标志cookies过期
							}
							response.addCookie(scookie);
							scookie.setPath("/");
						}
					}
				
				}
				
				session.invalidate();
				
				response.sendRedirect("../ManagerLogin/ManagerLogin.jsp");
				return;
			}
			else {
				request.setAttribute("judge", "false");
				request.setAttribute("text", "很抱歉，密码修改失败！");
				request.setAttribute("URL", "UpdatePwd.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			System.out.print("业务逻辑层查询失败");
			request.setAttribute("judge", "false");
			request.setAttribute("text", "很抱歉，密码修改失败！");
			request.setAttribute("URL", "UpdatePwd.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
	}
	
	public boolean passwordIsTrue(String fpassword,int userID){
		
		ManagerBll mBll = new ManagerBll();
		
		Manager manager =new Manager();
		Manager reManager = new Manager();
		manager.setManagerID(userID);
		reManager=mBll.getmanager(manager);
		
		if(reManager.getPassword().equals(MD5.GetMD5Code(fpassword))){
			return true;
		}
		else return false;
	}

}
