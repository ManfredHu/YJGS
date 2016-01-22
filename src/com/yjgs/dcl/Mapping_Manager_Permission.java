package com.yjgs.dcl;

public class Mapping_Manager_Permission {

	private int 		mappingID = 0;	//映射ID
	
	private int 		managerID = 0;	//管理员ID
	
	private String 	permission = null;	//权限内容

	public int getMappingID() {
		return mappingID;
	}

	public void setMappingID(int mappingID) {
		this.mappingID = mappingID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
