package com.yjgs.dcl;

import com.yjgs.enumdata.ManagerLevel;

public class Manager {

	//管理员ID
	private int 			managerID 					= 0;
	
	//管理员名称	
	private String 			managerName 				= null;
	
	//管理员密码
	private String 			password 					= null;
	
	//管理员账号
	private String 			managerAccount 				= null;
	
	//管理员级别
	private ManagerLevel 	managerLevel 				= null;

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getManagerAccount() {
		return managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	public ManagerLevel getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(ManagerLevel managerLevel) {
		this.managerLevel = managerLevel;
	}
	
	
}
