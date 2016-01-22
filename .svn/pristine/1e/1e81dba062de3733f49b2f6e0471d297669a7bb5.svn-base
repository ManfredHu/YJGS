package com.yjgs.controller.firstpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.FirstPageManageBll;
import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.PageBottomInfo;
import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductParam;

/**
 * Servlet implementation class UpdatePageBottomInfo
 */
public class UpdatePageBottomInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePageBottomInfo() {
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
		ArrayList<PageBottomInfo> params = null;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤3：数据验证
		if(!validate(request)) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入有误，请重新输入");
			request.setAttribute("URL", "../FirstPageManage/BottomParams.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：数据封装
		params = packParams(request);
		if(params == null) {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入有误，请重新输入");
			request.setAttribute("URL", "../FirstPageManage/BottomParams.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤4：调用BLL处理更新逻辑
		fpBll = new FirstPageManageBll();
		if(fpBll.updatePageBottomInfo(params)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "保存成功！");
			request.setAttribute("URL", "../FirstPageManage/BottomParams.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "保存失败！");
			request.setAttribute("URL", "../FirstPageManage/BottomParams.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	}
	
	/**
	 * 数据验证
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否通过验证
	 */
	private boolean validate(HttpServletRequest fRequest) {
		
		int maxParamNum = 5;
		
		String productName = null;
		String[] paramNames = null;
		String[] paramValues = null;
		
		try {
			
			//步骤1：获取数据
			paramNames = fRequest.getParameterValues("names");
			paramValues = fRequest.getParameterValues("values");
			
			//步骤2：判断参数个数是否超过最大值
			if(paramNames.length > maxParamNum) return false;
			
			//步骤3：长度以及非空验证
			for (String name : paramNames) {

				if (name.length() > 10 || name.length() == 0)
					return false;
			}

			for (String value : paramValues) {

				if (value.length() > 100 || value.length() == 0)
					return false;
			}
			
		} catch (Exception e) {

			System.out.println("数据验证异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 包装参数集合
	 * 
	 * @param fRequest		Servlet请求
	 * @return					产品参数集合
	 */
	public ArrayList<PageBottomInfo> packParams(HttpServletRequest fRequest) {
		
		ArrayList<PageBottomInfo> params = null;
		
		try {
			
			params = new ArrayList<PageBottomInfo>();
			
			String[] names = fRequest.getParameterValues("names");
			String[] values = fRequest.getParameterValues("values");
			for(int i = 0; i< names.length; i++) {
				
				PageBottomInfo param = new PageBottomInfo();
				param.setInfoName(names[i]);
				param.setInfoValue(values[i]);
				
				params.add(param);
			}
			
			
		} catch (Exception e) {

			System.out.println("产品参数数据包装异常");
			e.printStackTrace();
			return null;
		}
		
		return params;
	}

}
