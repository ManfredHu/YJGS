package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;

/**
 * Servlet implementation class ProPicCrop_fd
 */
public class ProPicCrop_fd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProPicCrop_fd() {
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
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取产品ID
		try {
			
			productID = Integer.valueOf(request.getParameter("productID"));
		} catch (Exception e) {

			System.out.println("获取图片ID异常");
			e.printStackTrace();
			return;
		}
		
		//步骤3：对请求数据进行验证
		if(!validate(request)) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败，请选择正确的区域进行裁减");
			request.setAttribute("URL", "../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤4：调用BLL进行图片的裁减、压缩以及添加
		pmBll = new ProductManageBll();
		if(pmBll.addNewProductPic(request)) {
			
			//刷新页面
			response.sendRedirect("../ProductManage/ProductPage.jsp?productID=" + productID);
			return;
		} 
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败，请重试");
			request.setAttribute("URL", "../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 验证是否已经选择了图片的裁减区域
	 * 
	 * @param fRequest		Servlet请求
	 * @return					是否通过验证
	 */
	private boolean validate(HttpServletRequest fRequest) {
		
		String x;
		String y;
		String w;
		String h;
		
		try {
			
			x = fRequest.getParameter("image.x");
			y = fRequest.getParameter("image.y");
			w = fRequest.getParameter("image.width");
			h = fRequest.getParameter("image.height");
			
			if(x.equals("")  ) {
				return false;
			}
			if(y.equals("")  ) {
				return false;
			}
			if(w.equals("")  ) {
				return false;
			}
			if(h.equals("") ) {
				return false;
			}
			if(x.equals("0") && y.equals("0") && w.equals("0") && h.equals("0") ) {
				return false;
			}
			
		} catch (Exception e) {

			System.out.println("图片裁减验证异常");
			e.printStackTrace();
			return false;
		}
	
		return true;
	}

}
