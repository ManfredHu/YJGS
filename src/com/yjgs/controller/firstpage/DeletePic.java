package com.yjgs.controller.firstpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.FirstPageManageBll;
import com.yjgs.dal.FirstPagePictureDal;
import com.yjgs.dcl.FirstPagePicture;

/**
 * Servlet implementation class DeletePic
 */
public class DeletePic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePic() {
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
		int picID = 0;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：获取图片ID
		try {
			
			picID = Integer.valueOf(request.getParameter("picID"));
					
		} catch (Exception e) {

			System.out.println("获取图片ID异常");
			e.printStackTrace();
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：进行数据验证
		if(!validate()) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除失败，首页图片至少留下一张");
			request.setAttribute("URL", "../FirstPageManage/FirstPagePicList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤4：调用BLL实际执行删除
		fpBll = new FirstPageManageBll();
		if(fpBll.deletePic(picID,request)) {
			
			response.sendRedirect("../FirstPageManage/FirstPagePicList.jsp");
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除失败");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../FirstPageManage/FirstPagePicList.jsp").forward(
					request, response);
			return;
		}
					
	}
	
	/**
	 * 验证图片数量是否已经达到最小
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否通过验证
	 */
	private boolean validate() {
		
		int minPicNum = 1;
		FirstPagePictureDal fpDal = null;
		ArrayList<FirstPagePicture> pictures = null;
		
		try {
			
			//步骤1：获取图片数据
			fpDal = new FirstPagePictureDal();
			pictures = fpDal.getAllPictures();
			
			//步骤2：判断是否已达最大数量
			if(pictures.size() == minPicNum) {
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
