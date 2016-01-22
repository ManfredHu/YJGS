package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ComplaintBll;
import com.yjgs.dcl.Complaint;
import com.yjgs.publ.Mail;
import com.yjgs.publ.SendMail;

/**
 * Servlet implementation class ManagerComplaintSel
 */
public class ManagerComplaintSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerComplaintSel() {
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

		String email = request.getParameter("email");
		String myEmail = request.getParameter("myEmail");
		String Password = request.getParameter("password");
		String text = request.getParameter("text");
		String title = request.getParameter("title");
		int ID = Integer.parseInt(request.getParameter("cid"));
		
		if(myEmail==""||Password==""||text==""||title==""){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "邮件数据不能为空！");
			request.setAttribute("URL", "../ManagerComplaint/ManagerComplaint.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
		
		Mail mail = new Mail();
		Complaint complaint = new Complaint();
		ComplaintBll complaintBll =new ComplaintBll();
		complaint.setComplaintID(ID);
		mail.setContent(text);
		mail.setMailPassword(Password);
		mail.setMyMail(myEmail);
		mail.setSendToMail(email);
		mail.setTitle(title);
		
		SendMail sendMail = new SendMail();
		
		try {
			
			if(sendMail.sendMail(mail)){
				System.out.print("发送邮箱成功！");
				if(complaintBll.UpdatePass(complaint)){
					System.out.println("申述状态改变成功！");
				
					request.setAttribute("judge", "true");
					request.setAttribute("text", "邮件回复成功！");
					request.setAttribute("URL", "NewsRemind.jsp");
					request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
					return;
				}
				else{
					System.out.println("申述状态改变失败！");
				}
			}
			
		} catch (Exception e) {
		
			System.out.print("发送邮箱失败！");
			request.setAttribute("judge", "flase");
			request.setAttribute("text", "邮件回复失败！");
			request.setAttribute("URL", "NewsRemind.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			e.printStackTrace();
		}
		

		 
	}

}
