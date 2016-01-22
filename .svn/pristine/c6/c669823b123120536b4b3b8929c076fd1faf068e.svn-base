package com.yjgs.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.yjgs.dal.ProductPictureDal;
import com.yjgs.dcl.ProductPicture;
import com.yjgs.publ.PictureDeal;

/**
 * Servlet implementation class ProPicUpload_fd
 */
public class ProPicUpload_fd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProPicUpload_fd() {
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

		// 步骤2：获取SmartUpload对象
		pDeal = new PictureDeal();
		sU = pDeal.getUpload(this, request, response);

		// 步骤3：获取产品ID
		try {

			productID = Integer.valueOf(sU.getRequest().getParameter(
					"productID"));
		} catch (Exception e) {

			System.out.println("获取图片ID异常");
			e.printStackTrace();
			return;
		}
		
		// 步骤4：检查是否已达最大上传数量
		if (!validate(productID)) {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "上传错误，图片数量已达到最大，无法继续添加");
			request.setAttribute("URL",
						"../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
						request, response);
			return;
		}

		// 步骤5：调用图片处理类上传图片
		userID = Integer.valueOf(request.getSession(true)
				.getAttribute("UserID").toString());

		imgPath = pDeal.uploadPicture(request, sU, "PicCache/" + userID); // 先保存到cache缓存目录下
		if (imgPath != null) {

			// 获取图片长宽
			wh = pDeal.getImgWandH(imgPath, request);

			response.sendRedirect("../ProductManage/PicCropForUpdate.jsp?productID="
					+ productID + "&imgPath=" + imgPath + "&Width=" + wh[0]
					+ "&Height=" + wh[1]);
			return;
		} else {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "上传错误，请检查图片格式是否正确并重新添加");
			request.setAttribute("URL",
					"../ProductManage/ProductPage.jsp?productID=" + productID);
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 对图片数量进行验证
	 * 
	 * @param fProductID
	 * @return
	 */
	private boolean validate(int fProductID) {
		
		int maxImgNum = 5;
		ProductPictureDal ppicDal = null;
		ArrayList<ProductPicture> pictures = null;
		
		try {
			
			//获取当前图片数据
			ppicDal = new ProductPictureDal();
			ProductPicture picture = new ProductPicture();
			picture.setProductID(fProductID);
			pictures = ppicDal.getProBrePics(picture);
			
			if(pictures == null) return true;
			
			if(pictures.size() == maxImgNum) return false;
			
		} catch (Exception e) {
			
			System.out.println("图片数量严重异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
