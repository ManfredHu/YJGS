package com.yjgs.bll.ibll;

import com.yjgs.dcl.Manager;

public interface IManaLoginBll {
	
	/**
	 * 验证是否为管理员
	 * @param fManager			管理员等陆的账号和密码等	
	 * @return					是否登陆成功
	 */
	public boolean IsManager(Manager fManager);
	
	/**
	 * 获取管理员登陆成功后的权限信息
	 * @param fManager			登陆成功的管理员信息
	 * @return					相应权限的拥有与否
	 */
	public boolean[] GetPermission(Manager fManager);

}
