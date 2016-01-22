package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.Product;

/**
 * Servlet implementation class Addproduct3
 */
public class Addproduct3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addproduct3() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductManageBll pmBll = null;
		Product product = null;
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
			request.setAttribute("URL", "../welcom/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		// 步骤3：数据的封装
		product = packProduct(request);
		if (product == null) {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "内部错误");
			request.setAttribute("URL", "../ProductManage/ProductAdd3.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		pmBll = new ProductManageBll();
		if(pmBll.addNewProductIntroduce(product,request)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "添加成功");
			request.setAttribute("URL", "../ProductManage/ProductList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "flase");
			request.setAttribute("text", "添加失败");
			request.setAttribute("URL", "../ProductManage/ProductList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 包装产品数据
	 * 
	 * @param fRequest		Servlet请求数据
	 * @return					返回产品数据
	 */
	public Product packProduct(HttpServletRequest fRequest) {
		
		Product product = null;
		
		try {
			
			product = new Product();
			product.setProdcuctID(Integer.valueOf(fRequest.getParameter("productID")));
			product.setIntroduct(fRequest.getParameter("introduce"));
			
		} catch (Exception e) {
			
			System.out.println("产品数据包装异常");
			e.printStackTrace();
			return null;
		}
		
		return product;
	}

}
