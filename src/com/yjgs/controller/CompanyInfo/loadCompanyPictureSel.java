package com.yjgs.controller.CompanyInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class loadCompanyPictureSel
 */
public class loadCompanyPictureSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadCompanyPictureSel() {
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

		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PictureDeal pictureDeal = new PictureDeal();
		SmartUpload su = pictureDeal.getUpload(this, request, response);;
		
		try {
			
			String imgpath = pictureDeal.uploadPicture(request,su,"CompanyPicture");
			
			System.out.println("上传企业图片成功！");
			System.out.println(imgpath);
		} catch (Exception e) {

			System.out.println("上传企业图片失败！");
			e.printStackTrace();
		}

	}

}
