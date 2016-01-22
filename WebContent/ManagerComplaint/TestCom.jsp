<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*,javax.mail.*,javax.activation.*"%>
<%@ page import="javax.mail.internet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String qm ="cpxyhmchzl152537"; //您的QQ密码
	String tu = "qq.com"; //你邮箱的后缀域名
	String tto="917925411@qq.com"; //接收邮件的邮箱
	String ttitle="试验！";
	String tcontent="你好！ ";
	Properties props=new Properties();
	props.put("mail.smtp.host","smtp.qq.com.cn");//发信的主机，这里我填写的是我们公司的主机！可以不用修改！
	props.put("mail.smtp.auth","true");
	Session s=Session.getInstance(props);
	s.setDebug(false);
	MimeMessage message=new MimeMessage(s);
	//给消息对象设置发件人/收件人/主题/发信时间
	InternetAddress from=new InternetAddress("870004292@"+tu); //这里的115798090 改为您发信的QQ号
	message.setFrom(from);
	InternetAddress to=new InternetAddress(tto);
	message.setRecipient(Message.RecipientType.TO,to);
	message.setSubject(ttitle);
	message.setSentDate(new Date());
	//给消息对象设置内容
	BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
	mdp.setContent(tcontent,"text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
	Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
	//象(事实上可以存放多个)
	mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
	message.setContent(mm);//把mm作为消息对象的内容
	message.saveChanges();
	Transport transport=s.getTransport("smtp");
	transport.connect("smtp.qq.com","870004292",qm); //这里的115798090也要修改为您的QQ号码
	transport.sendMessage(message,message.getAllRecipients());
	transport.close();
	out.print("成功！");
	%>
</body>
</html>