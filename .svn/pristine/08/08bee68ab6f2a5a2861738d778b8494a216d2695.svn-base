package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.ProductType;

/**
 * Servlet implementation class DeleteType
 */
public class DeleteType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteType() {
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

		ProductManageBll pBll = null;
		ProductType type = null;
		
		//步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//步骤3：数据的封装
		type = packType(request);
		if(type == null) {		//数据获取失败时，也进行相应提示的跳转
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;	
		}
		
		//步骤4：调用BLL执行添加逻辑
		pBll = new ProductManageBll();
		if(pBll.deleteAType(type)) {
			
			response.sendRedirect("../ProductManage/ProductTypeList.jsp");
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除失败，请重新删除");
			request.setAttribute("URL", "../ProductManage/ProductTypeList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;	
		}
	}
	
	/**
	 * 将请求数据封装到实体类
	 * 
	 * @param fRequest
	 *            Servlet请求数据
	 * @return Type实体类
	 */
	private ProductType packType(HttpServletRequest fRequest) {

		ProductType type = null;

		try {

			type = new ProductType();

			type.setTypeID(Integer.valueOf(fRequest.getParameter("typeID")));

		} catch (Exception e) {

			System.out.println("数据包装异常");
			e.printStackTrace();
			return null;
		}

		return type;
	}

}
