package com.yjgs.fittler;

import java.io.IOException;
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

/**
 * Servlet Filter implementation class DefaultPageRedirct
 */
public class DefaultPageRedirct implements Filter {

    /**
     * Default constructor. 
     */
    public DefaultPageRedirct() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


	    HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		String requestURL = null;
		String defaultPage = null;
		
		// 步骤1：将request对象转化为HttpRequest对象
		httpRequest = (HttpServletRequest) request;
		httpResponse = (HttpServletResponse)response;
		
		//步骤2：设置默认页面
		defaultPage = "ManagerLogin/ManagerLogin.jsp";
		
		//步骤3：获取判断路径是否为项目根路径
		requestURL = httpRequest.getRequestURL().toString();
		String contextPath = httpRequest.getContextPath();
		
		Pattern p = Pattern.compile("http://.+" + contextPath + "/(.+)");
		Matcher m = p.matcher(requestURL);
		if(!m.find()) {
		
				//步骤4：重定向
				System.out.println("重定向到默认页面：" + defaultPage );
				httpResponse.sendRedirect(defaultPage );
				return;
		}
		
		//步骤5：其他情况则放行
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
