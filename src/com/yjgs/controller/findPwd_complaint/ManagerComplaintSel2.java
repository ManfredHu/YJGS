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

/**
 * Servlet implementation class ManagerComplaintSel2
 */
public class ManagerComplaintSel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerComplaintSel2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String myEmail = request.getParameter("myEmail");
		String Password = request.getParameter("password");
		String text = request.getParameter("text");
		//建立邮件会话
		  Properties pro = new Properties();
		  pro.put("mail.smtp.host","smtp.qq.com");//存储发送邮件的服务器
		  pro.put("mail.smtp.auth","true");  //通过服务器验证
		  
		  Session s =Session.getInstance(pro); //根据属性新建一个邮件会话
		  //s.setDebug(true);
		  
		  //由邮件会话新建一个消息对象
		  MimeMessage message = new MimeMessage(s);
		  
		  //设置邮件
		  InternetAddress fromAddr = null;
		  InternetAddress toAddr = null;
		  
		  try 
		  {
		   fromAddr = new InternetAddress(870004292+"@qq.com");   //邮件发送地址
		   message.setFrom(fromAddr);         //设置发送地址
		   
		   toAddr = new InternetAddress("917925411@qq.com");       //邮件接收地址
		   message.setRecipient(Message.RecipientType.TO, toAddr);  //设置接收地址
		   
		   message.setSubject("测试");   //设置邮件标题
		   message.setText(text);   //设置邮件正文
		   message.setSentDate(new Date()); //设置邮件日期
		   
		   message.saveChanges();    //保存邮件更改信息

		   Transport transport = s.getTransport("smtp");
		   transport.connect("smtp.qq.com", "870004292", "cpxyhmchzl152537"); //服务器地址，邮箱账号，邮箱密码
		   transport.sendMessage(message, message.getAllRecipients());   //发送邮件
		   transport.close();//关闭
		 
		   System.out.print("成功！");
		  } 
		  catch (Exception e) 
		  {
		   e.printStackTrace();
		   System.out.print("失败！");
		  }

		 
	}
	

}
