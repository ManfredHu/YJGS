package com.yjgs.controller.firstpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.yjgs.dal.FirstPagePictureDal;
import com.yjgs.dcl.FirstPagePicture;
import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class PicUpload
 */
public class PicUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicUpload() {
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
		String imgPath = null;
		int[] wh = null;

		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：检查是否已达最大上传数量
		if(!validate()) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "上传错误，图片已经到达最大数量，请删除旧图后重试");
			request.setAttribute("URL", "../FirstPageManage/FirstPagePicList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}

		// 步骤3：获取SmartUpload对象
		pDeal = new PictureDeal();
		sU = pDeal.getUpload(this, request, response);

		// 步骤4：调用图片处理类上传图片
		userID = Integer.valueOf(request.getSession(true)
				.getAttribute("UserID").toString());

		imgPath = pDeal.uploadPicture(request, sU, "PicCache/" + userID); // 先保存到cache缓存目录下
		if (imgPath != null) {

			// 获取图片长宽
			wh = pDeal.getImgWandH(imgPath, request);
			if(wh[0] < 900 || wh[1] < 325) {		//图片大小需大于900*325
				
				request.setAttribute("judge", "false");
				request.setAttribute("text", "上传错误，图片尺寸过小");
				request.setAttribute("URL", "../FirstPageManage/FirstPagePicList.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(
						request, response);
				return;
				
			}

			response.sendRedirect("../FirstPageManage/PicCrop.jsp?imgPath="
			+ imgPath + "&Width=" + wh[0] + "&Height=" + wh[1]);
			return;
		} else {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "上传错误，请检查图片格式是否正确并重新添加");
			request.setAttribute("URL", "../FirstPageManage/FirstPagePicList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 验证图片数量是否已经达到最大
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否通过验证
	 */
	private boolean validate() {
		
		int maxPicNum = 5;
		FirstPagePictureDal fpDal = null;
		ArrayList<FirstPagePicture> pictures = null;
		
		try {
			
			//步骤1：获取图片数据
			fpDal = new FirstPagePictureDal();
			pictures = fpDal.getAllPictures();
			if(pictures == null) return true;
			
			//步骤2：判断是否已达最大数量
			if(pictures.size() == maxPicNum) {
				return false;
			}
			
			
		} catch (Exception e) {

			System.out.println("首页图片数量验证异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
