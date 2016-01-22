package com.yjgs.controller.product;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.ProductType;

/**
 * Servlet implementation class ModifyTyep
 */
public class ModifyType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyType() {
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

		ProductManageBll pBll = null;
		ProductType type = null;
		
		//步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//步骤2：进行数据的后台验证
		if (!validate(request)) {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入有误，请重新输入");
			request.setAttribute("URL", "../ProductManage/ProductTypeList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		//步骤3：数据的封装
		type = packType(request);
		
		//步骤4：调用BLL执行添加逻辑
		pBll = new ProductManageBll();
		if(pBll.modifyType(type)) {
			
			response.sendRedirect("../ProductManage/ProductTypeList.jsp");
			return;	
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "修改失败，请重新修改");
			request.setAttribute("URL", "../ProductManage/ProductTypeAdd.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;	
		}
	}
	
	/**
	 * 对请求数据进行验证
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回是否通过验证
	 */
	@SuppressWarnings("unchecked")
	private boolean validate(HttpServletRequest fRequest) {
		
		Enumeration<String> names = null;
		String type = null;

		try {

			names = fRequest.getParameterNames();
			type = fRequest.getParameter(names.nextElement());
		
			Pattern p = Pattern.compile("^[\u4E00-\u9FA5A-Za-z0-9]+$");
			Matcher m = p.matcher(type);

			if (m.find())
				return true;

		} catch (Exception e) {

			System.out.println("数据验证异常");
			e.printStackTrace();
			return false;
		}

		return false;
	}
	
	/**
	 * 将请求数据封装到实体类
	 * 
	 * @param fRequest		Servlet请求数据
	 * @return					Type实体类
	 */
	@SuppressWarnings("unchecked")
	private ProductType packType(HttpServletRequest fRequest) {
		
		Enumeration<String> names = null;
		ProductType type = null;
		String firstName = null;
		
		try {
			
			type = new ProductType();
			
			names = fRequest.getParameterNames();
			firstName = names.nextElement();
			type.setTypeID(Integer.valueOf(firstName));
			type.setTypeName(fRequest.getParameter(firstName));
			
			
		} catch (Exception e) {

			System.out.println("数据包装异常");
			e.printStackTrace();
			return null;
		}
		
		return type;
	}

}
