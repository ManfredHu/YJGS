package com.yjgs.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ProductManageBll;
import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductParam;

/**
 * Servlet implementation class AddProduct1
 */
public class AddProduct1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct1() {
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

		ProductManageBll pmBll = null;
		Product product = null;
		ArrayList<ProductParam>  params = null;
		int ProductID = 0;
		
		// 步骤1：设置请求响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 步骤2：进行数据的后台验证
		if (!validate(request)) {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据输入有误，请重新输入");
			request.setAttribute("URL", "../ProductManage/ProductAdd1.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		// 步骤3：数据的封装
		product = packProduct(request);
		params = packParams(request);
		if (product == null || params == null) {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "内部错误");
			request.setAttribute("URL", "../ProductManage/ProductAdd1.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		// 步骤4：调用BLL执行添加逻辑
		pmBll = new ProductManageBll();
		ProductID = pmBll.addProduvtAndParams(product, params);
		if (ProductID != 0) {

			//将新的产品ID传递给下一步的页面
			response.sendRedirect("ProductAdd2.jsp?productID=" + ProductID);
			
//			request.setAttribute("productID", ProductID);
//			request.getRequestDispatcher("ProductAdd2.jsp").forward(
//					request, response);
			return;
		} else {

			request.setAttribute("judge", "false");
			request.setAttribute("text", "添加错误，请重新添加");
			request.setAttribute("URL", "../ProductManage/ProductAdd1.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
	}
	
	/**
	 * 数据的后台验证
	 * 
	 * @param fRequest		Servlet请求		
	 * @return
	 */
	private boolean  validate(HttpServletRequest fRequest) {
		
		int maxParamNum = 10;
		
		int type = 0;
		String productName = null;
		String[] names = null;
		String[] values = null;
		
		try {
			
			//步骤1：获取数据
			type = Integer.valueOf(fRequest.getParameter("type"));
			productName = fRequest.getParameter("productName");
			names = fRequest.getParameterValues("names");
			values = fRequest.getParameterValues("values");
			
			//步骤2：判断是否选择了类别
			if(type == 0) return false;
			
			//步骤3：判断参数个数是否超过最大值
			if(names.length > maxParamNum) return false;
			
			//步骤4：非空验证判断数据长度是否合法
			if(productName.length() > 50 || productName.length() == 0) return false;
			
			for(String name : names) {
				
				if(name.length() > 10 || name.length() == 0) return false;
			}
			
			for (String value : values) {
				
				if (value.length() > 100 || value.length() == 0) return false; 
			}
			
		} catch (Exception e) {

			System.out.println("数据验证异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 包装产品数据
	 * 
	 * @param fRequest		Servlet请求数据
	 * @return					返回产品实体类
	 */
	private Product packProduct(HttpServletRequest fRequest) {
		
		Product product = null;
		
		try {
			
			product = new Product();
			product.setProductName(fRequest.getParameter("productName"));
			product.setProductTypeID(Integer.valueOf(fRequest.getParameter("type")));
			
		} catch (Exception e) {

			System.out.println("产品数据包装异常");
			e.printStackTrace();
			return null;
		}

		return product;
	}
	
	/**
	 * 包装产品参数集合
	 * 
	 * @param fRequest		Servlet请求数据
	 * @return					返回产品参数集合
	 */
	private ArrayList<ProductParam> packParams(HttpServletRequest fRequest) {
		
		ArrayList<ProductParam> params = null;
		String[] names = null;
		String[] values = null;
		
		
		try {
			
			//步骤1：获取数据
			names = fRequest.getParameterValues("names");
			values = fRequest.getParameterValues("values");
			if(names.length != values.length) return null;
			
			//步骤2：实际包装
			params = new ArrayList<ProductParam>();
			for(int i=0; i<names.length; i++) {
				
				ProductParam aParam = new ProductParam();
				
				aParam.setParamName(names[i]);
				aParam.setParamValue(values[i]);
				
				params.add(aParam);
			}
			
		} catch (Exception e) {

			System.out.println("产品数据包装异常");
			e.printStackTrace();
			return null;
		}

		return params;
	}
	
}
