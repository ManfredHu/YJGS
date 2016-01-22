package com.yjgs.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class PicUploadForCK
 */
public class PicUploadForCK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicUploadForCK() {
        super();//调用父级的构造函数覆盖自己的构造函数

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
		PrintWriter out = null;
		String callback = null;
		int userID = 0;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取CKeditor的参数以及Out输出对象
		try {
			
			callback = request.getParameter("CKEditorFuncNum");
			out = response.getWriter();
			
		} catch (Exception e) {
			
			System.out.print("获取editor参数出错");
			e.printStackTrace();
			return;
		}
		
		//步骤3：调用图片处理类上传图片
		userID = Integer.valueOf(request.getSession(true).getAttribute("UserID").toString());
		
		pDeal = new PictureDeal();
		imgPath = pDeal.uploadPicture(this, request, response, "PicCache/" + userID);
		if(imgPath == null) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'','上传错误，请检查文件格式是否正确（必须为.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return;
		}
		
		//步骤4：进行图片大小的检查，若太大则进行压缩
		outImgPath = pDeal.picDealForCK(request, imgPath,"PicCache/" + userID);
		if(outImgPath != null) {
			
			out.println("<script type=\"text/javascript\">");  
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
			        + ",'" + outImgPath + "','')"); // 相对路径用于显示图片  
			out.println("</script>"); 
		}
		else {
		
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'','上传失败，内部错误');");
			out.println("</script>");
			return;
		}
		
		
	}

}
