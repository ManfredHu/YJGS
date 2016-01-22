package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jspsmart.upload.SmartUpload;
import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class ProductPicUpload
 */
public class ProductPicUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPicUpload() {
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

		PictureDeal pDeal = null;
		SmartUpload sU = null;
		int userID = 0;
		int productID = 0;
		String imgPath = null;
		int[] wh = null;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取SmartUpload对象
		pDeal = new PictureDeal();
		sU = pDeal.getUpload(this, request, response);
		
		//步骤3：获取产品ID
		try {
			
			productID = Integer.valueOf(sU.getRequest().getParameter("productID"));
		} catch (Exception e) {
			
			System.out.println("获取图片ID异常");
			e.printStackTrace();
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp")
					.forward(request, response);
			return;
		}
		
		//步骤4：调用图片处理类上传图片
		userID = Integer.valueOf(request.getSession(true).getAttribute("UserID").toString());
		
		imgPath = pDeal.uploadPicture(request,sU,"PicCache/" + userID); //先保存到cache缓存目录下
		if(imgPath != null) {
			
			//获取图片长宽
			wh = pDeal.getImgWandH(imgPath, request);
			
			response.sendRedirect("../ProductManage/ProductAdd2.jsp?productID=" + productID +"&imgPath="
					+imgPath + "&Width=" + wh[0] + "&Height=" + wh[1] );
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "上传错误，请检查图片格式是否正确并重新添加");
			request.setAttribute("URL", "../ProductManage/ProductAdd2.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}

}
