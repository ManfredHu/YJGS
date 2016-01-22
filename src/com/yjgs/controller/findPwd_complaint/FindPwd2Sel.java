package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yjgs.bll.PasswordProtectProblemBll;
import com.yjgs.dcl.PasswordProtectProblem;

/**
 * Servlet implementation class FindPwd2Sel
 */
public class FindPwd2Sel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwd2Sel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String answer = request.getParameter("answer");
		String select = request.getParameter("select");
		int userNum = Integer.parseInt(select);
		
		//数据验证，判断答案不为零
		
		if(answer==""){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("errorInfo", "答案不能为空！");
			
			response.sendRedirect("FindPwd2.jsp");
			return;
		}
		
		PasswordProtectProblem ppp = new PasswordProtectProblem();
		ppp.setProblemID(userNum);
		ppp.setAnswer(answer);
		
		PasswordProtectProblemBll mBll = new PasswordProtectProblemBll();
		
		try{
			
		boolean isAnswer = false;
			
		isAnswer=mBll.IsAnswer(ppp);
		
		if(isAnswer==true){
			response.sendRedirect("FindPwd3.jsp");
			
		}
		else {
			HttpSession session = request.getSession();
			
			session.setAttribute("errorInfo", "答案错误，请重新输入！");
			
			response.sendRedirect("FindPwd2.jsp");
			return;
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.print("数据显示错误");
		}
		
	}

}
