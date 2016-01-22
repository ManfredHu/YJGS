package com.yjgs.dcl;

public class Permission {
	
	private 	int 		permissionID 	= 0;			//权限ID
	
	private 	String 	content 			= 	null;		//权限内容

	public int getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
