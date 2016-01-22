package com.yjgs.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.NewsTypeBll;
import com.yjgs.dcl.NewsType;

/**
 * Servlet implementation class AddNewsTypeSel
 */
public class AddNewsTypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsTypeSel() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int t=0;
		
		//步骤1：获取新闻类别
		String NewsType = request.getParameter("NewsType");
		
		String[] type = request.getParameterValues("NewsType");
		
		for(t=0;t<type.length;t++){
		
		//非空验证
		if(NewsType ==""){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "新闻类别不能为空！");
			request.setAttribute("URL", "../NewsManage/AddNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		}
		for(t=0;t<type.length;t++){
		//步骤2：实例化业务逻辑层，进行添加操作
		NewsTypeBll ntbll = null;
		NewsType newtype = null;
		
		newtype = new NewsType();
		newtype.setTypeName(type[t]);
		
		ntbll = new NewsTypeBll();
		
		try{
		//步骤3：判断是否添加成功。并进行页面的跳转
		if(ntbll.AddNewsType(newtype)){
			System.out.print("添加成功！");
			
		}
		}
		catch(Exception e){
			
			System.out.print("添加失败！");
			e.printStackTrace();
		}
		
		}
		if(t==type.length){
			request.setAttribute("judge", "true");
			request.setAttribute("text", "新闻类别添加成功！");
			request.setAttribute("URL", "../NewsManage/AddNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		else{
			request.setAttribute("judge", "false");
			request.setAttribute("text", "新闻类别添加失败！");
			request.setAttribute("URL", "../NewsManage/AddNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
	}

}
