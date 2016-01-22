package com.yjgs.fittler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheck
 */
public class LoginCheck implements Filter {

	//用户访问Filter配置信息
	@SuppressWarnings("unused")
	private FilterConfig config;
	
    /**
     * Default constructor. 
     */
    public LoginCheck() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		this.config = fConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String servletPath = null;
		HttpSession session = null;
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		ArrayList<String> noLoginFolders = null;		//此处的URL都指服务器端的绝对地址（Servlet路径）
		boolean isPass = false;
		
		//步骤1：将request对象转化为HttpRequest对象
		httpRequest = (HttpServletRequest)request;
		httpResponse = (HttpServletResponse)response;
		
		//输出过滤的URL
		String URL = httpRequest.getRequestURL().toString();
		System.out.println("URL：" + URL);
		
		//步骤2：设置统一的请求和相应数据的编码
		httpRequest.setCharacterEncoding("UTF-8");
		httpResponse.setContentType("text/html; charset=UTF-8");
		
		//步骤3：获取session并判断是否已经登陆，已经登陆则放行
		session = httpRequest.getSession(true);
		if(session.getAttribute("UserID") != null) {
			
			chain.doFilter(request, response);
			return;
		}
		
		//步骤4：获取请求的URL
		servletPath = httpRequest.getServletPath();
		if(servletPath == null) {
			
			chain.doFilter(request, response);
			return;
		}
		
		//步骤5：不检查css以及js文件
		if(servletPath.indexOf(".") != -1) {
			
			String fileType = "";
			Pattern p = Pattern.compile("/.+[.](.+)");
			Matcher m = p.matcher(servletPath);
			
			if(m.find()) {
				
				fileType = m.group(1).toLowerCase();
				System.out.println("文件后缀：" + fileType);
				if(!fileType.equals("jsp")) {
					
					chain.doFilter(request, response);
					return;
				}
			}
		}
		
		//步骤6：设置无需登录的请求URL集合
		String folderName = "";
		Pattern p = Pattern.compile("/(\\S+?)/\\S+");
		Matcher m = p.matcher(servletPath);
		if(m.find()) {
			
			folderName = m.group(1);
			
			noLoginFolders = getNoLoginFolders();
			
			//步骤7：判断当前请求的URL是否为无需登录页面
			for(String aFolder : noLoginFolders) {
				
				if(folderName.equals(aFolder))  isPass = true;
			}
		}
		
		//步骤8：根据是否通过检测选择放行或跳转到错误页面
		if(isPass) {
			chain.doFilter(request, response);
			return;
		}
		else {
			
//			httpResponse.sendRedirect("../welcome/LoginTips.jsp");
			httpRequest.getRequestDispatcher("../Tips/LoginTips.jsp").forward(
					request, response);
			return;
		}
		
	}
	
	/**
	 * 设置并返回所有无需登录检测的页面的URL集合
	 * 
	 * @return		返回URL集合
	 */
	private ArrayList<String> getNoLoginFolders() {
		
		ArrayList<String> folderNames = new ArrayList<String>();
		
		
		// 找回密码以及申诉
		{
			String aFolder = "FindPwdComplaint";
			folderNames.add(aFolder);
		}
		
		
		// 提示页面
		{
			String aFolder = "Tips";
			folderNames.add(aFolder);
		}
		
		//登陆页面
		{
			String aFolder = "ManagerLogin";
			folderNames.add(aFolder);
		}
		
		// 产品展示页
		{
			String aFolder = "Product";
			folderNames.add(aFolder);
		}
		
		// 首页
		{
			String aFolder = "FirstPage";
			folderNames.add(aFolder);
		}
		
		
		//新闻
		{
			String aFolder = "News";
			folderNames.add(aFolder);
		}
		
		//建议反馈
		{
			String aFolder = "Advice";
			folderNames.add(aFolder);
		}
		
		//企业信息
		{
			String aFolder = "CompanyInfo";
			folderNames.add(aFolder);
		}
		
		// 其他无需登录页面
		// -------------------------------（待补充）
		return folderNames;
	}

}
