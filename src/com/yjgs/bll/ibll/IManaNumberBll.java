package com.yjgs.bll.ibll;

import com.yjgs.dcl.Manager;

public interface IManaNumberBll {
	
	/**
	 * 删除管理员账号
	 * 
	 * @param fManager			待删除的管理员信息
	 * @return					是否删除成功
	 */
	public boolean DeleteNum(Manager fManager);

	/**
	 * 添加管理员账号
	 * 
	 * @param fManager			要添加的管理员信息
	 * @return					是否添加成功
	 */
	public boolean AddNum(Manager fManager);
	
	/**
	 * 修改管理员信息
	 * @param fManager			要修改的管理员信息
	 * @return					是否修改成功
	 */
	public boolean UpdateNum(Manager fManager);
}
