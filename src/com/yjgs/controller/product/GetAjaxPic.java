package com.yjgs.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductBll;
import com.yjgs.dcl.Product;

/**
 * Servlet implementation class GetAjaxPic
 */
public class GetAjaxPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAjaxPic() {
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
		
		ProductBll pBll = null;
		int picID = 0;
		String picPath = null;
		PrintWriter out = null;
		
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取图片ID
		try {
			
			picID = Integer.valueOf(request.getParameter("picID"));
			
		} catch (Exception e) {
			
			System.out.println("错误的操作");
			e.printStackTrace();
	
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../FirstPage/FirstPage.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
					request, response);
			return;
		}
		
		
		
		//步骤3:调用BLL并返回
		pBll = new ProductBll();
		out = response.getWriter();
		out.write(pBll.getOPicPath(picID));
		return;
	}

}
