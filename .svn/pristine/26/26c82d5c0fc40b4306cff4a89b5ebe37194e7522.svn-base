package com.yjgs.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class TestCK
 */
public class TestCK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PictureDeal pDeal = null;
		String imgPath = null;
		PrintWriter out = null;
		String callback = null;
		
		try {
			
			callback = request.getParameter("CKEditorFuncNum");
			response.setContentType("text/html; charset=UTF-8");
			
			pDeal = new PictureDeal();
			imgPath = pDeal.uploadPicture(this, request, response, "ProductPicture");
			
			if(imgPath != null) {
				
				out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");  
				out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
				        + ",'" + imgPath + "','')"); // 相对路径用于显示图片  
				out.println("</script>"); 
			}
			
		} catch (Exception e) {
			
			System.out.print("试验出错！");
			e.printStackTrace();
		}
		
	}

}
