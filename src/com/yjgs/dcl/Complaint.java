package com.yjgs.dcl;

public class Complaint {
	
	//申诉ID
	private int 	complaintID 		= 0 ;
	
	//申诉账号
	private String 	conplaintAccount 	= null;
	
	//申诉原因
	private String 	conplaintReason 	= null;
	
	//申诉者邮箱
	private String 	email 				= null;
	
	//是否回复
	private int 	isPass 				= 2;

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public String getConplaintAccount() {
		return conplaintAccount;
	}

	public void setConplaintAccount(String conplaintAccount) {
		this.conplaintAccount = conplaintAccount;
	}

	public String getConplaintReason() {
		return conplaintReason;
	}

	public void setConplaintReason(String conplaintReason) {
		this.conplaintReason = conplaintReason;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	
	

}
