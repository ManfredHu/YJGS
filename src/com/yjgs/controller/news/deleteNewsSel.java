package com.yjgs.controller.news;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.NewsBll;
import com.yjgs.dcl.News;

/**
 * Servlet implementation class deleteNewsSel
 */
public class deleteNewsSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNewsSel() {
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

		int id = Integer.parseInt(request.getParameter("deleteNewsID"));
		
		News news = new News();
		news.setNewsID(id);
		News snews = new News();
		snews.setNewsID(id);
		NewsBll nBll = new NewsBll();
		snews = nBll.loadNewsInfo(snews);
		String content= snews.getContent();
		
		NewsBll newsBll = new NewsBll();
		try {
			
			if(newsBll.DeleteNews(news)){
				deleteSPicture(content,request);
				response.sendRedirect("ManagerNews.jsp?typeID="+snews.getTypeID()+"");
			}
			
			
		} catch (Exception e) {
			
			System.out.print("删除数据失败!");
			e.printStackTrace();
		}
		
	}
	
	//删除文件夹的图片
		public void deleteSPicture(String Text,HttpServletRequest request){
			
		String str ="../NewsPicture/\\w+\\.jpg";
	    Pattern p = Pattern.compile(str);
	    Matcher m = p.matcher(Text);
	    while(m.find()){
		    System.out.println(m.group(0));
		    NewsBll newsBll = new NewsBll();
		    newsBll.DeletePic(m.group(0),request.getSession().getServletContext().getRealPath("/"));
		}
	}

}
