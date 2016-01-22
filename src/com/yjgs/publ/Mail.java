package com.yjgs.publ;

/**
 * 邮箱实体类
 * @author yuqin
 *
 */
public class Mail {
	
	String title 			= null;		//邮件标题
	String content 			= null;		//邮件内容
	String mailPassword 	= null;		//邮箱密码
	String myMail 			= null;		//我的邮箱账号
	String sendToMail 		= null;		//发送去的邮箱账号
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMailPassword() {
		return mailPassword;
	}
	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	public String getMyMail() {
		return myMail;
	}
	public void setMyMail(String myMail) {
		this.myMail = myMail;
	}
	public String getSendToMail() {
		return sendToMail;
	}
	public void setSendToMail(String sendToMail) {
		this.sendToMail = sendToMail;
	}
	
	

}
