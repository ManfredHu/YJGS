package com.yjgs.controller.permanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.PermissionManageBll;
import com.yjgs.dcl.PermissionApply;

/**
 * Servlet implementation class DeleteApply
 */
public class DeleteApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteApply() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PermissionManageBll pBll = null;
		PermissionApply apply = null;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 步骤2：包装请求数据
		apply = packApply(request);
		if(apply == null) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;	
			
		}
		// 步骤3：调用BLL处理相应逻辑并处理跳转
		pBll = new PermissionManageBll();
		if (pBll.deleteApply(apply)) {

			request.getRequestDispatcher("ApplyDeal.jsp").forward(request, response);
			return;
		} 
		else {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除出错，请重试");
			request.setAttribute("URL", "../PermissionManage/ApplyDeal.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 包装请求数据到申请实体类
	 * 
	 * @return		返回要处理的申请数据
	 */
	private PermissionApply packApply(HttpServletRequest fRequest) {
		
		PermissionApply apply = new PermissionApply();
		
		try {
			
			//获取请求数据并设置申请参数
			apply.setPerApplyID(Integer.valueOf(fRequest.getParameter("ID")));
			
		} catch (Exception e) {
			
			System.out.println("申请数据包装出错");
			e.printStackTrace();
			return null;
		}
		
		return apply;
	}

}
