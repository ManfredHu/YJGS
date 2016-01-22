package com.yjgs.controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.NewsTypeBll;
import com.yjgs.dcl.NewsType;

/**
 * Servlet implementation class DeleteNewsTypeSel
 */
public class DeleteNewsTypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsTypeSel() {
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
		
		//步骤1：获取jsp页面数据信息
		int typeID = Integer.parseInt(request.getParameter("id"));
		
		//步骤2：封装实体类
		NewsType newsType = new NewsType();
		newsType.setTypeID(typeID);
		
		//步骤3：实现删除操作，并响应页面跳转
		NewsTypeBll ntBll = new NewsTypeBll();
		
		try {
			
			if(ntBll.DeleteTypeName(newsType)){
				request.setAttribute("judge", "true");
				request.setAttribute("text", "删除新闻类别成功！");
				request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
	
			request.setAttribute("judge", "false");
			request.setAttribute("text", "删除新闻类别失败！");
			request.setAttribute("URL", "../NewsManage/UpdateNewsType.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
  		
	}

}
