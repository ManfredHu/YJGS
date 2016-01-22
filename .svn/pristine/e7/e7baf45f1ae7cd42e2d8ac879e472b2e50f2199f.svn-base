package com.yjgs.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadAvator
 */
public class UploadAvator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAvator() {
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

		/**
		    * 获取一个pageContext实例
		    */
		   PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		  
		   /**
		    * 获取一个TimeStamp实例
		    */
		   TimeStamp st=new TimeStamp();
		  
		   /**
		    * 获取一个SmartUpload实例
		    */
		   SmartUpload su=new SmartUpload();
		  
		   /**
		    * 初始化SmartUpload
		    */
		   su.initialize(pageContext);    
		  
		   /**
		    * 准备上传
		    */
		   try {                   
		   su.upload();               
		  } catch (SmartUploadException e) {
		   e.printStackTrace();
		  }
		  
		  /**
		   * 获取上传图片的文件名
		   */
		  String photoName=st.getStimeStamp()+"."+su.getFiles().getFile(0).getFileExt();
		  request.setAttribute("photoName", photoName);  //保存图片的文件名
		  
		  /**
		   * 上传的地址
		   */
//		  String fileAddress=getServletContext().getRealPath("/")+"/ProductPicture/"+photoName;
//		//保存上传的地址
//		  request.setAttribute("fileAddress",request.getContextPath() + "/ProductPicture/" + photoName); 
		  //获取上传地址的处理
		  String rootFolder = null; //项目根路径文件夹名（项目名称）
		  String phyPath = null;		//项目物理路径
		  String imgFolder = null;
		  String imgFileName = null;
		  String imgPhyPath = null;	//图片物理路径
		  String imgPath = null; //图片相对路径
		  
		  //步骤1：获取项目名、物理路径
		  rootFolder = request.getContextPath().substring(1);
		  phyPath = request.getSession(true).getServletContext().getRealPath("/");
		  
		  //步骤2：对项目物理路径进行检测，判断其是否为使用Eclipse时的默认目录
		  Pattern p = Pattern.compile("(.+\\\\).metadata\\\\.+\\\\" + rootFolder + "\\\\");
		  Matcher m = p.matcher(phyPath);
		  
		  if(m.find()) {
			  
			  //Eclipse的工作空间目录
			  String eclipseWorkspace = m.group(1);
			  phyPath = eclipseWorkspace + rootFolder + "\\WebContent\\";
		  }
		  
		  //步骤3：获取图片存放的文件夹名，设置图片物理路径以及相对地址
		  
		  //根据实际情况可能不同
		  imgFolder = "ProductPicture";		
		  imgFileName = photoName;		
		  
		  imgPhyPath = phyPath + imgFolder + "\\" + imgFileName;
		  imgPath = "../" + imgFolder + "/" +imgFileName;
		  
		  //步骤4：保存图片相对路径到request
		  request.setAttribute("imgPath", imgPath);
		  
		  
		  /**;
		   * 开始上传
		   */
		  try {
		   su.getFiles().getFile(0).saveAs(imgPhyPath);
		  } catch (SmartUploadException e) {
		   e.printStackTrace();
		  }

		  HttpSession session =  request.getSession(true);
		  session.setAttribute("imgPhyPath", imgPhyPath);
		  session.setAttribute("imgPath", imgPath);
		  
		  //response.getWriter().println(String.format("<a href='%s'></a>", imgPath));
		  
		  response.setContentType("text/html;charset=utf-8");  
		  PrintWriter out = response.getWriter();  
		  out.println(imgPath); 
	}

}
