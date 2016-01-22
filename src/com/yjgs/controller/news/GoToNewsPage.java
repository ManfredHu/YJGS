package com.yjgs.controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoToPage
 */
public class GoToNewsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToNewsPage() {
        super();
        // TODO Auto-generated constructor stub
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
		
		int typeID = 0;
		int page = 1;
		
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取类别ID以及页码
		if (request.getParameter("typeID") != null) {

			typeID = Integer.valueOf(request.getParameter("typeID"));
		}
		if(request.getParameter("page") != null) {
			
			page = Integer.valueOf(request.getParameter("page"));
		}
		
		//步骤3：跳转
		response.sendRedirect("../NewsManage/ManagerNews.jsp?typeID=" + typeID + "&page=" + page);
		return;
	}
	

}
