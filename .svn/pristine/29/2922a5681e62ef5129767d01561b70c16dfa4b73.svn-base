package com.yjgs.controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chooseTypeSel
 */
public class chooseTypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chooseTypeSel() {
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

		
		int typeID = 0;
		
		//步骤1：获取类别ID
		try {
			
			typeID = Integer.valueOf(request.getParameter("typeID"));
			
		} catch (Exception e) {
			
			System.out.println("获取类别ID异常");
			e.printStackTrace();
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤2：跳转到相应类别的产品列表页面
		response.sendRedirect("../NewsManage/ManagerNews.jsp?typeID=" + typeID);
		return;
	}
	

}
