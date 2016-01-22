package com.yjgs.controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.NewsTypeBll;

/**
 * Servlet implementation class ManagerNewsSel
 */
public class ManagerNewsSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerNewsSel() {
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

		String typeID = request.getParameter("NewsType");
		int TypeID = Integer.parseInt(typeID);
		
		response.sendRedirect(String.format("ManagerNews.jsp?newsID=%d", TypeID));
	}

}
