package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class CropTest
 */
public class CropTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropTest() {
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
		String outImgPath = null;
		int x;
		int y;
		int w;
		int h;
		int tarWidth;
		int tarHeight;
		
		response.setContentType("text/html; charset=UTF-8");
		x = (int)Math.round(Double.valueOf(request.getParameter("image.x").toString()));
		y = (int)Math.round(Double.valueOf(request.getParameter("image.y").toString()));
		w = (int)Math.round(Double.valueOf(request.getParameter("image.width").toString())); 
		h = (int)Math.round(Double.valueOf(request.getParameter("image.height").toString())); 
		tarWidth = (int)Math.round(Double.valueOf(request.getParameter("tarWidth").toString())); 
		tarHeight = (int)Math.round(Double.valueOf(request.getParameter("tarHeight").toString())); 
		imgPath = request.getParameter("image.Path").toString(); 
		
//		imgPath = "../ProductPicture/o_20141212003050274.JPG";
		pDeal = new PictureDeal();
		outImgPath= pDeal.cropPicture(request, imgPath, x, y, w, h,tarWidth,tarHeight,"ProductPicture/Test");
		if(outImgPath != null) {
			
			String comPath = pDeal.compressPicture(request, outImgPath, "ProductPicture", 285, 180);
			
			
			response.getWriter().println(String.format("<img src='%s' />", outImgPath));
			response.getWriter().println(String.format("<br /><img src='%s' />", comPath));
			response.getWriter().close();
		}
		
		
		
		
		
	}

}
