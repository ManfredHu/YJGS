package com.yjgs.controller.advice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.AdviceBll;
import com.yjgs.dcl.Advice;
import com.yjgs.publ.Mail;
import com.yjgs.publ.SendMail;

/**
 * Servlet implementation class UpdateAdviceSel
 */
public class UpdateAdviceSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdviceSel() {
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

		String text = request.getParameter("text");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("Adviceid"));
		AdviceBll adviceBll = new AdviceBll();
		Advice advice = new Advice();
		Advice advice2 =new Advice();
		
		Mail mail = new Mail();
		mail.setContent(text);
		mail.setMyMail("18826425711@163.com");
		mail.setMailPassword("cpxyhmchzl152537");
		mail.setTitle("yjgs的建议反馈回复");
		mail.setSendToMail(email);
		
		advice.setAdviceID(id);
		advice.setReply(text);
		
		advice2.setAdviceID(id);
		
		SendMail sendMail = new SendMail();
		try {
			if(sendMail.sendMail(mail)){
				try {
					advice2 = adviceBll.getAdvices(advice2);
					adviceBll.changeRead(advice);
					request.setAttribute("judge", "true");
					request.setAttribute("text", "成功回复建议反馈！");
					request.setAttribute("URL", "../AdviceManage/ManageAdvice.jsp");
					request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
					return;
				} catch (Exception e) {
					System.out.println("更改阅读状态出错！");
					e.printStackTrace();
				}
		
			}
		} catch (Exception e) {
			System.out.println("回复建议反馈失败！");
			e.printStackTrace();
		}
	}

}
