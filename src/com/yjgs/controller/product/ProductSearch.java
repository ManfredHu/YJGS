package com.yjgs.controller.product;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.fastinfoset.Encoder;

/**
 * Servlet implementation class ProductSearch
 */
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearch() {
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

		String keyWords = null;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取关键字
		try {
			
			keyWords = request.getParameter("keyWords");
		} catch (Exception e) {

			System.out.println("获取关键字异常");
			e.printStackTrace();
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../FirstPage/FirstPage.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：跳转到搜索页面并传递搜索关键字
		keyWords = URLEncoder.encode(keyWords, "UTF-8");
		response.sendRedirect("../Product/ProductSearch.jsp?keyWords=" + keyWords);
		return;
	}

}
