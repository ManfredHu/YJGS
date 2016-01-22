package com.yjgs.bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import com.yjgs.dal.ManagerDal;
import com.yjgs.dal.Manager_PermissionDal;
import com.yjgs.dal.PermissionDal;
import com.yjgs.dal.idal.IManagerDal;
import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Manager_Permission;
import com.yjgs.dcl.PasswordProtectProblem;
import com.yjgs.dcl.Permission;

public class ManagerBll implements IManagerDal {

	@Override
	public boolean addManager(Manager fManager) {
		return false;
	}

	@Override
	public boolean deleteManager(Manager fManager) {
		return false;
	}

	@Override
	public boolean updateManager(Manager fManager) {
		return false;
	}

	@Override
	public ArrayList<Manager> searchManager() {
		return null;
	}

	@Override
	public Manager getManager(Manager fManager) {

		// 步骤1，实例化管理员数据操作层
		ManagerDal mdpl = new ManagerDal();
		ArrayList<Manager> pManager = null;

		// 步骤2，执行查询操作
		try {
			pManager = mdpl.IsManager(fManager);
		} catch (Exception e) {
			System.out.print("数据操作层，查询账号时发生错误！");
			e.printStackTrace();
		}

		// 步骤3，若查询有结果，则返回第一个结果，不然返回空
		if (pManager!= null) {
			return pManager.get(0);
		} else
			return null;

	}

	public boolean HasManager(Manager fManager) {

		// 步骤1，实例化管理员数据操作层

		ManagerDal mdpl = new ManagerDal();
		ArrayList<Manager> pManager = null;

		// 步骤2，执行查询操作
		try {
			pManager = mdpl.IsManager(fManager);
		} catch (Exception e) {
			System.out.print("数据操作层，查询账号时发生错误！");
			e.printStackTrace();
		}

		// 步骤3，若查询有结果，则返回第一个结果，不然返回空
		if (pManager.size() != 0) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean IsManager(Manager fManager) {
		return false;
	}

	@Override
	public ArrayList<Permission> GetPermission(Manager fManager) {
		return null;
	}

	// 修改管理员密码
	public boolean UpdatePwd(Manager fManager) {

		ManagerDal mDal = new ManagerDal();
		boolean UpdatePwd = false;

		UpdatePwd = mDal.UpdatePwd(fManager);

		return UpdatePwd;
	}

	@Override
	public ArrayList<PasswordProtectProblem> getProblems(Manager fManager) {
		return null;
	}

	public void loadInfo(int userID, JspWriter fOut) {

		Manager manager = new Manager();

		manager.setManagerID(userID);

		ManagerDal managerDal = new ManagerDal();
		ArrayList<Manager> managers = new ArrayList<Manager>();

		managers = managerDal.selectManager(manager);

		try {
			fOut.write("<form id='changeUserName' action='UpdateManInfoSel' method='post'>");
			if (managers != null) {
				fOut.write(String.format(
						"<span>用户名：</span><input type='text' value=%s name='userName'/>",
						managers.get(0).getManagerName()));
			}
			fOut.write("<input class='submitButton2' id='changeUserNameBtn' type='submit' value='提交'>");
			fOut.write("</form >");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据加载发生错误！");
		}

	}

	// 登陆时验证账号和密码是否正确
	public Manager getManagers(Manager fManager) {

		// 步骤1，实例化管理员数据操作层
		ManagerDal mdpl = new ManagerDal();
		ArrayList<Manager> pManager = null;

		// 步骤2，执行查询操作
		try {
			pManager = mdpl.IsManager(fManager);
		} catch (Exception e) {
			System.out.print("数据操作层，查询账号时发生错误！");
			e.printStackTrace();
		}

		// 步骤3，若查询有结果，则返回第一个结果，不然返回空
		if (pManager != null) {
			return pManager.get(0);
		} else
			return null;
	}
	
	/**
	 * 获取指定管理员的所有权限情况
	 * 
	 * @param fManager		管理员数据
	 * @return						返回权限-布尔型的Map类型
	 */
	public Map<Permission, Boolean> getPermissionStatus(
			Manager fManager) {
		
		PermissionDal pDal = null;
		Manager_PermissionDal mapPDal = null;
		ArrayList<Permission> sysPermissions = null;
		ArrayList<Mapping_Manager_Permission> manaPermissions = null;
		Map<Permission, Boolean> permissionStatus = null;
		
		//步骤1：实例化DAL类
		pDal = new PermissionDal();
		mapPDal = new Manager_PermissionDal();
		
		
		try {
			
			//步骤2：获取系统所有权限
			sysPermissions = pDal.getAllPermission();
			
			//步骤3：获取管理员所有权限
			Mapping_Manager_Permission managerID
			= new Mapping_Manager_Permission(); 
			managerID.setManagerID(fManager.getManagerID());
			manaPermissions = mapPDal.getAllPermission(managerID);
			
			//步骤4：遍历系统权限和管理员权限，构造状态MAP类型
			permissionStatus = new HashMap<Permission, Boolean>();
			for(Permission aSysPermission : sysPermissions) {
				
				boolean isHas = false;				
				if(manaPermissions != null) {
					for(Mapping_Manager_Permission aManaPermission : manaPermissions) {
						
						if(aSysPermission.getContent().equals(aManaPermission.getPermission())) {
							
							isHas = true;
							break;
						}
					}
				}
				permissionStatus.put(aSysPermission, isHas);
			}
		}
		catch (Exception e) {

			System.out.println("获取管理员权限状态出错");
			e.printStackTrace();
			return null;
		}
		
		return permissionStatus;
	}
	
	public Manager getmanager(Manager fManager){
		
		ManagerDal mDal = new  ManagerDal();
		Manager manager = mDal.getAManager(fManager);
		
		return manager;
	}
	
	public boolean updateInfo(Manager fManager){
		ManagerDal mDal = new  ManagerDal();
		return mDal.UpdateInfo(fManager);

	}
	
	//通过账号获得管理员信息
	public Manager getManagerByAcco(Complaint fComplaint){
		
		ManagerDal mDal = new ManagerDal();
		
		return mDal.getManagerbyAcco(fComplaint);
	}
	
	//获取所有管理员信息
	public ArrayList<Manager> getAllManager(){
		
		ManagerDal mDal = new ManagerDal();
		
		return mDal.selectAllManager();
	}
}
