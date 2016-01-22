package com.yjgs.controller.advice;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.dal.AdviceDal;
import com.yjgs.dcl.Advice;

/**
 * Servlet implementation class AdviceDealSel
 */
public class AdviceDealSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdviceDealSel() {
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

		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String text = request.getParameter("text");
		String yanzhengma = request.getParameter("yanzhengma");
		String sessionstring = (String) session.getAttribute("strEnsure");
		
		if(text==""){
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "建议反馈内容不能为空！");
			request.setAttribute("URL", "../Advice/LoadAdvice.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(request, response);
			return;
		}
		
		if(!sessionstring.equals(yanzhengma)){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "验证码不能为空！");
			request.setAttribute("URL", "../Advice/LoadAdvice.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(request, response);
			return;
		}
		
		if(!testEmail(email)){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "邮箱格式错误！");
			request.setAttribute("URL", "../Advice/LoadAdvice.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(request, response);
			return;
		}
		
		AdviceDal adviceDal = new AdviceDal();
		Advice advice = new Advice();
		advice.setContent(text);
		advice.setUserMail(email);
		try {
			
			if(adviceDal.addAdvice(advice)){
//				request.setAttribute("judge", "true");
//				request.setAttribute("text", "建议反馈提交成功！");
//				request.setAttribute("URL", "../Advice/LoadAdvice.jsp");
//				request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(request, response);
				response.sendRedirect("../Advice/LoadAdvice.jsp");
				return;
			}
		} catch (Exception e) {
			System.out.println("建议反馈提交失败！");
			e.printStackTrace();
		}
	}
	
	//检测邮箱正确与否
	public boolean testEmail(String Email){
		String regEx = "\\w+@\\w+\\.\\w+";
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(Email);
		boolean result=m.find();
		return result;
	}

}
