package com.yjgs.controller.advice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.publ.AdviceYanzhengma;

/**
 * Servlet implementation class Yanzhengma
 */
public class Yanzhengma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Yanzhengma() {
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

		// TODO Auto-generated method stub
				//禁用缓存，每次访问此页面，都重新生成  
			       response.setHeader("Pragma","No-cache");   
			       response.setHeader("Cache-Control","no-cache");   
			       response.setDateHeader("Expires", 0);   
			  
			       //生成验证码的实例对象  
			       AdviceYanzhengma ie = new AdviceYanzhengma();  
			  
			       //调用里面的方法，返回的是生成的验证码中的字符串  
			       String str = ie.getEnsure(0,0,response.getOutputStream());  
			  
			       //获得session，并把字符串保存在session中
			       HttpSession session = request.getSession(true);
			       session.setAttribute("strEnsure", null);
			       session.setMaxInactiveInterval(30); 
			       session.setAttribute("strEnsure", str); 
			      
			}
	

}
