package com.yjgs.controller.managerLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class goBack
 */
public class goBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
		//找到相应的cookie
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
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("ManagerLogin.jsp");
		}
		catch(Exception e){
			System.out.print("页面跳转失败!");//返回之前页面
			e.printStackTrace();
		}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("ManagerLogin.jsp");
		return;


}

	}
	
