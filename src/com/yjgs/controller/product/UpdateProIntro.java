package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.Product;

/**
 * Servlet implementation class UpdateProIntro
 */
public class UpdateProIntro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProIntro() {
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

		ProductManageBll pmBll = null;
		Product proIntroduce = null;
		int productID = 0;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取产品ID
		try {

			productID = Integer.valueOf(request.getParameter("productID"));

		} catch (Exception e) {

			System.out.println("获取产品ID异常");
			e.printStackTrace();

			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：数据封装
		proIntroduce = packInroduce(request);
		if(proIntroduce == null) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：调用BLL处理实际更新
		pmBll = new ProductManageBll();
		if(pmBll.updateProIntro(proIntroduce,request)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "保存成功！");
			request.setAttribute("URL", "../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败！");
			request.setAttribute("URL", "../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 包装产品介绍数据
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回产品介绍数据
	 */
	private Product packInroduce(HttpServletRequest fRequest) {
		
		Product proIntroduce = null;
		
		try {
			
			proIntroduce = new Product();
			proIntroduce.setProdcuctID(Integer.valueOf(fRequest.getParameter("productID")));
			proIntroduce.setIntroduct(fRequest.getParameter("introduce"));
			
		} catch (Exception e) {

			System.out.println("包装产品介绍数据异常");
			e.printStackTrace();
			return null;
		}
		
		return proIntroduce;
	}

}
