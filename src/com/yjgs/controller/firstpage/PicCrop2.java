package com.yjgs.controller.firstpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.FirstPageManageBll;

/**
 * Servlet implementation class PicCrop2
 */
public class PicCrop2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicCrop2() {
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

		FirstPageManageBll fpBll = null;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤3：对请求数据进行验证
		if(!validate(request)) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败，请选择正确的区域进行裁减");
			request.setAttribute("URL", "../FirstPageManage/OtherPageManage.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤4：调用BLL进行图片的裁减、压缩以及添加
		fpBll = new FirstPageManageBll();
		if(fpBll.updateLogo(request)) {
			
			response.sendRedirect("../FirstPageManage/OtherPageManage.jsp");
			return;
		} 
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败，请重试");
			request.setAttribute("URL", "../FirstPageManage/OtherPageManage.jsp");
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
