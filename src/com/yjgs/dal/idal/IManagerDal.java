package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Manager;
import com.yjgs.dcl.PasswordProtectProblem;
import com.yjgs.dcl.Permission;

public interface IManagerDal {
	
	/**
	 * 添加管理员
	 * @param fManager			待添加的管理员数据
	 * @return					是否添加成功
	 */
	public boolean addManager(Manager fManager);
	
	/**
	 * 删除管理员
	 * @param fManager			待删除的管理员数据
	 * @return					是否删除成功
	 */
	public boolean deleteManager(Manager fManager);
	
	/**
	 * 修改管理员信息
	 * @param fManager			待修改的管理员数据
	 * @return					是否修改成功
	 */
	public boolean updateManager(Manager fManager);
	
	/**
	 * 查询所有管理员的信息
	 * @return					所有管理员的数据数组
	 */
	public ArrayList<Manager> searchManager();

	/**
	 * 查询单个管理员的信息
	 * @param fManager			要查询单个管理员的数据信息
	 * @return					单个管理员的详细信息
	 */
	public Manager getManager(Manager fManager);
	
	/**
	 * 管理员登陆验证
	 * @param fManager			登陆时管理员账号、密码
	 * @return					是否登陆成功
	 */
	public boolean IsManager(Manager fManager);
	
	/**
	 * 获取管理员权限
	 * @param fManager			管理员信息
	 * @return					管理员所有权限
	 */
	public ArrayList<Permission> GetPermission(Manager fManager);
	
	
	public ArrayList<PasswordProtectProblem> getProblems(Manager fManager);

}
