package com.yjgs.controller.product;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class UploadTest
 */
public class UploadTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadTest() {
        super();
        // TODO Auto-generated constructor stub
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
		String imgPath = null;
		int[] wh = null;
		
		response.setContentType("text/html; charset=UTF-8");
		
		pDeal = new PictureDeal();
		imgPath = pDeal.uploadPicture(this, request, response, "ProductPicture/Test");
		
		if(imgPath != null) {
			
			//获取图片长宽
			wh = pDeal.getImgWandH(imgPath, request);
			
			request.setAttribute("imgPath", imgPath);
			request.setAttribute("Width", wh[0]);
			request.setAttribute("Height", wh[1]);
			request.getRequestDispatcher("testCrop.jsp").forward(request, response);
			return;
		}
		
		
		
	}

}
