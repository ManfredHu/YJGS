package com.yjgs.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class NewsSPictureSel
 */
public class NewsSPictureSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsSPictureSel() {
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
		String imgPath = null;
		PrintWriter out = null;
		String callback = null;
		
		HttpSession session = request.getSession(true);
		int userID = (int)session.getAttribute("UserID");
		
		try {
			
			callback = request.getParameter("CKEditorFuncNum");
			response.setContentType("text/html; charset=UTF-8");
			
			pDeal = new PictureDeal();
			imgPath = pDeal.uploadPicture(this, request, response, "PicCache/" + userID);
			
			if(imgPath == null) {
				
				out.println("<script type=\"text/javascript\">");
				out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
						+ ",'','上传错误，请检查文件格式是否正确（必须为.jpg/.gif/.bmp/.png文件）');");
				out.println("</script>");
				return;
			}
			
			//获取图片长宽,设置长宽
			int[] lengths = pDeal.getImgWandH(imgPath,request);
			
			if(lengths[0]>=600){
				
				lengths[1]=(600/lengths[0])*lengths[1];
				
				lengths[0]=600;
				
			}

			//压缩图片
			imgPath = pDeal.compressPicture(request, imgPath, "PicCache/" + userID, lengths[0], lengths[1]);
			
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
