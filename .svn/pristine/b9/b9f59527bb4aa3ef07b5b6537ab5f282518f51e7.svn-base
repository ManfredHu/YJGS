package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.Product;

/**
 * Servlet implementation class DeleteProduct
 */
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
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
		Product product = null;
		int typeID = 0;
		int page = 1;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取typeID以及page
		try {
			
			typeID = Integer.valueOf(request.getParameter("typeID"));
			page = Integer.valueOf(request.getParameter("page"));
			
		} catch (Exception e) {
			
			System.out.println("获取类型以及页码失败，重定向到默认产品页");
			e.printStackTrace();
		}
		
		//步骤3：数据的封装
		product = packProduct(request);
		if (product == null) { // 数据获取失败时，也进行相应提示的跳转

			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤4：调用BLL进行删除
		pmBll = new ProductManageBll();
		if(pmBll.deleteProduct(product,request)) {
			
			response.sendRedirect("../ProductManage/ProductList.jsp?typeID=" + typeID + "&page=" + page);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除失败，请重新删除");
			request.setAttribute("URL", "../ProductManage/ProductList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;	
		}
		
	}
	
	/**
	 * 产品数据的封装
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回产品数据
	 */
	private Product packProduct(HttpServletRequest fRequest) {
		
		Product product = new Product();
		
		try {
			
			product.setProdcuctID(Integer.valueOf(fRequest.getParameter("productID")));
			
		} catch (Exception e) {
			
			System.out.println("数据封装异常");
			e.printStackTrace();
			return null;
		}
		
		return product;
	}

}
