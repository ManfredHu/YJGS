package com.yjgs.dcl;

import java.util.Date;

public class PermissionApply {

	private int 			perApplyID 	= 0;			//权限申请ID
	
	private int 			managerID 	= 0;			//管理员ID
	
	private boolean 	isRead 			= false;		//是否已读
	
	private boolean 	isPass 			= false;		//是否通过
	
	private Date			applyTime		= null;		//申请时间

	public int getPerApplyID() {
		return perApplyID;
	}

	public void setPerApplyID(int perApplyID) {
		this.perApplyID = perApplyID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	
	
	
}
