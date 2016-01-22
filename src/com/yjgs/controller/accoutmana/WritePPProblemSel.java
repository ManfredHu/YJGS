package com.yjgs.controller.accoutmana;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.PasswordProtectProblemBll;
import com.yjgs.dcl.PasswordProtectProblem;

/**
 * Servlet implementation class WritePPProblemSel
 */
public class WritePPProblemSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WritePPProblemSel() {
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
		
		String problem1 = request.getParameter("problem1");
		String problem2 = request.getParameter("problem2");
		String problem3 = request.getParameter("problem3");
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String[] answers = {answer1,answer2,answer3};
		
		String[] problems = {problem1,problem2,problem3};
		
		if(answer1==""||answer2==""||answer3==""){
			
			String errorInfo = String.format("WritePPProblem.jsp?errorInfo=%s", "问题和答案不能为空！");
			request.getRequestDispatcher(errorInfo).forward(request, response);
			return ;
		}
		
		PasswordProtectProblemBll pppBll = new PasswordProtectProblemBll();
		PasswordProtectProblem ppp = new PasswordProtectProblem();
		
		HttpSession session =request.getSession();
		int userID = (Integer)session.getAttribute("UserID");
		ppp.setManagerID(userID);
		
		for(int t=0;t<3;t++){
			
			ppp.setAnswer(answers[t]);
			ppp.setProblem(problems[t]);
			
			try{
				
				boolean issuccess = pppBll.InsertProblem(ppp);
				if(issuccess==true){
					System.out.print("插入数据成功！");
					
				}
				else{
					System.out.print("插入数据失败！");
					request.setAttribute("judge", "false");
					request.setAttribute("text", "添加密保问题失败！");
					request.setAttribute("URL", "WritePPProblem.jsp");
					request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
					return;
				}
				
				if(t==2){
					request.setAttribute("judge", "true");
					request.setAttribute("text", "添加密保问题成功！");
					request.setAttribute("URL", "../welcome/adminIndex.jsp");
					request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
					return;
				}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.print("数据逻辑层调用失败！");
			}
		}
		
	}

}
