package com.yjgs.fittler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yjgs.publ.PictureDeal;

/**
 * Servlet Filter implementation class CacheClear
 */
public class CacheClear implements Filter {

    /**
     * Default constructor. 
     */
    public CacheClear() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//步骤1：将Servlet请求转化为HttpServlet
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		//步骤2：先放行，进行登陆
		chain.doFilter(request, response);
		
		//步骤3：登陆完成后，进行用户缓存目录文件的删除
		HttpSession session = httpRequest.getSession(true);
		String userID = null;
		if(session.getAttribute("UserID") != null) {
			
			userID = session.getAttribute("UserID").toString();
		}
		else {
			
			System.out.println("用户临时文件删除错误：用户ID获取失败");
			return;
		}
		
		PictureDeal picDeal = new PictureDeal();
		if(picDeal.deleteDirectory("../PicCache/" + userID , httpRequest)) {
			
			System.out.println("用户临时文件删除成功");
			return;
		}
		else {
			
			System.out.println("用户临时文件删除失败");
			return;
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
