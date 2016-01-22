package com.yjgs.controller.news;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.NewsTypeBll;
import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsType;

/**
 * Servlet implementation class UpdateNewsTypeSel
 */
public class UpdateNewsTypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsTypeSel() {
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

		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//步骤1：获取jsp页面信息
		String firstName = null;
		NewsType type = new NewsType();
		Enumeration<String> names = null;
		names = request.getParameterNames();
		firstName = names.nextElement();
		type.setTypeID(Integer.valueOf(firstName));
		type.setTypeName(request.getParameter(firstName));
		
		//数据非空判断
		if(request.getParameter(firstName).length() == 0||request.getParameter(firstName).length() > 10){
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "更新新闻类别失败，新闻类别数据不能为空！");
			request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		//步骤2：封装数据到实体类
//		NewsType newsType = new NewsType();
//		newsType.setTypeID(num);
//		newsType.setTypeName(newName);
		
		//步骤3：实现更新操作，并响应页面跳转
		NewsTypeBll ntbll = new NewsTypeBll();
		try{
		if(ntbll.UpdateTypeName(type)){
			System.out.print("修改成功！");
			request.setAttribute("judge", "true");
			request.setAttribute("text", "更改新闻类别成功！");
			request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		else{
			request.setAttribute("judge", "false");
			request.setAttribute("text", "更改新闻类别失败！");
			request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		}
		catch(Exception e){
			System.out.print("修改失败！");
			request.setAttribute("judge", "false");
			request.setAttribute("text", "更改新闻类别失败！");
			request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
 	}

}
