package com.yjgs.controller.news;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.NewsBll;
import com.yjgs.dcl.News;

/**
 * Servlet implementation class PublishNewsSel
 */
public class PublishNewsSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishNewsSel() {
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

		String NewsTitle = request.getParameter("NewsTitle");
		String Text = request.getParameter("Text");
		String type=request.getParameter("NewsType");
		int Type = Integer.parseInt(type);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String str = sdf.format(new Date());
		
		if(NewsTitle==""||Text==""||type=="0"){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "新闻信息不能为空！");
			request.setAttribute("URL", "../NewsManage/PublishNews.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
	
		String newTextString=ChangeText(Text,request);
		News fNews = new News();
		fNews.setTitle(NewsTitle);
		fNews.setContent(newTextString);
		fNews.setTypeID(Type);
		//fNews.setPublishTime(str);
		
		NewsBll nBll = new NewsBll();
		try {
			
			if(nBll.addNews(fNews)){
				System.out.print("成功！");
				matchPath(Text,request);
				deleteSPicture(Text,request);
				
				request.setAttribute("judge", "true");
				request.setAttribute("text", "添加新闻成功！");
				request.setAttribute("URL", "../NewsManage/ManagerNews.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.print("失败！");
		}
 	}

	//复制图片
	public void matchPath(String Text,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userID = (int)session.getAttribute("UserID");
		//String path = "PicCache/" + userID;
		
		String str = "src=\".*?.[a-z]{3}\"";

        String newPath = null;
        String oldPath = null;
  
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(Text);
       while(m.find()){
        System.out.println(m.group(0));
        String[] strs = m.group(0).split("\"");
        String pathstr[] = strs[1].split("/");
        newPath="../NewsPicture/"+pathstr[3];
        oldPath="../"+pathstr[1]+"/"+pathstr[2]+"/"+pathstr[3];
        System.out.println(newPath);
        System.out.println(pathstr[3]);
        NewsBll newsBll = new NewsBll();
        newsBll.Copy(oldPath,newPath,request.getSession().getServletContext().getRealPath("/"));
		}
      
	}
	
	//改变图片地址
	public String ChangeText(String Text,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userID = (int)session.getAttribute("UserID");
		
		//String str = "src=\".*?.[a-z]{3}\"";
		
		String regex = "PicCache/" + userID;
		Pattern pat = Pattern.compile(regex);  
		Matcher matcher = pat.matcher(Text);     
		 if (matcher.find()) { 
//			   String[] strs = matcher.group(0).split("\"");
//			   String pathstr[] = strs[1].split("/");
//			   String regex = pathstr[1]+"/"+pathstr[2];
			   String temp = Text.substring(matcher.start(),matcher.end());
			   Text = Text.replaceAll(temp, temp.substring(0,temp.lastIndexOf(regex))+"NewsPicture");
	}
		 return Text;
	}
	
	//删除缓存文件夹的图片
	public void deleteSPicture(String Text,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userID = (int)session.getAttribute("UserID");
		String spath = "PicCache/" + userID;
		
        //String str ="../"+spath+"/\\w+\\.jpg";
        String str = "src=\".*?.[a-z]{3}\"";
        
	    Pattern p = Pattern.compile(str);
	    Matcher m = p.matcher(Text);
	    while(m.find()){
		    System.out.println(m.group(0));
		    
		    String[] strs = m.group(0).split("\"");
			//String pathstr[] = strs[1].split("/");
		    //String[] pathStrings = m.group(0).split("/");
		    //String path="../"+spath+"/"+pathStrings[3];
		    System.out.println(strs[1]);
		    NewsBll newsBll = new NewsBll();
		    newsBll.DeletePic(strs[1],request.getSession().getServletContext().getRealPath("/"));
		}
}
}
