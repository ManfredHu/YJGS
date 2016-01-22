package com.yjgs.publ;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	public boolean sendMail(Mail fMail){
		
		String qm =fMail.getMailPassword(); //您的QQ密码
		String tto=fMail.getSendToMail(); //接收邮件的邮箱
		String ttitle=fMail.getContent();
		String tcontent=fMail.getTitle();
		
		String[] tu = fMail.getMyMail().split("@"); 
		String maillast = tu[1];			//获取邮箱后缀
		
		Properties props=new Properties();
		props.put("mail.smtp.host",String.format("smtp.%s.cn", maillast));//发信的主机，这里我填写的是我们公司的主机！可以不用修改！
		props.put("mail.smtp.auth","true");
		Session s=Session.getInstance(props);
		s.setDebug(false);
		MimeMessage message=new MimeMessage(s);
		try{
		//给消息对象设置发件人/收件人/主题/发信时间
		InternetAddress from=new InternetAddress(fMail.getMyMail()); //发信的QQ号
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
		transport.connect(String.format("smtp.%s", maillast),tu[0],qm); //这里的115798090也要修改为您的QQ号码
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();
		return true;
		}
		catch(Exception e){
			System.out.print("发送邮箱失败！");
			e.printStackTrace();
		}
		return false;
	}

}
