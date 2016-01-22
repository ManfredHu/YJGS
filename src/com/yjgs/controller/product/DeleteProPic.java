package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;

/**
 * Servlet implementation class DeleteProPic
 */
public class DeleteProPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProPic() {
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
		int productID = 0;
		int picID = 0;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取产品以及图片ID
		try {
			
			productID = Integer.valueOf(request.getParameter("productID"));
			picID = Integer.valueOf(request.getParameter("picID"));
			
		} catch (Exception e) {
			
			System.out.println("获取ID异常");
			e.printStackTrace();

			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：调用BLL处理实际删除
		pmBll = new  ProductManageBll();
		if(pmBll.deleteProPic(picID,request)) {
			
			response.sendRedirect("../ProductManage/ProductPage.jsp?productID=" + productID);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除失败");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../ProductManage/ProductPage.jsp?productID=" + productID).forward(
					request, response);
			return;
		}
	}

}
