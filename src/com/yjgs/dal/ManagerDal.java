package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Manager;
import com.yjgs.dpl.ManagerDpl;
import com.yjgs.enumdata.ManagerLevel;

public class ManagerDal {

	/**
	 * 登陆的时候检查账号、密码是否正确
	 * @param fManager				封装了登陆数据的Manager实体类
	 * @return						具有所有管理员的信息几个
	 */
	public ArrayList<Manager> IsManager(Manager fManager){
		
		//第一步，获取登陆管理员的账号和密码。
		
		String userNum=fManager.getManagerAccount();
		String userPwd=fManager.getPassword();
		
		if(userPwd!=null){
		
		//第二步，编写sql语句
		
		ArrayList<Manager> isManager = new ArrayList<Manager>();
		ManagerDpl mDal =null;
		
		String strSQL = "select * from tb_manager where ManagerAccount = '"
				+ userNum + "' and Password ='" + userPwd + "'";
		
		//第三步，将sql语句作为参数，实例化数据连接类，将sql代进数据库连接类
	
		mDal = new ManagerDpl();
		isManager=mDal.excuteQuery(strSQL);
		
		//第四步，返回结果
		
		if(isManager.size() == 0){
			return null;
		}
		return isManager;
		}
		
		else {
			ArrayList<Manager> isManager = new ArrayList<Manager>();
			ManagerDpl mDal =null;
			
			String strSQL = "select * from tb_manager where ManagerAccount = '"
					+ userNum + "'";
			
			//第三步，将sql语句作为参数，实例化数据连接类，将sql代进数据库连接类
		
			mDal = new ManagerDpl();
			isManager=mDal.excuteQuery(strSQL);
			
			//第四步，返回结果
			
			if(isManager.size() == 0){
				return null;
			}
			return isManager;
			
		}
		
	}
	
	/**
	 * 查询所有管理员信息
	 * @return				具有所有管理员信息的数据集合
	 */
	public ArrayList<Manager> selectAllManager(){
		
		//第一步，声明所需变量类型
		
		ArrayList<Manager> allManagers = new ArrayList<Manager>();
		ManagerDpl mDal = null;
		
		//第二步，编写sql语句
		
		String strSql = "select * from tb_manager WHERE ManagerLevel = 1";
		
		//第三步，创建数据包装层mDal,执行查询操作，返回具有所有管理员信息的数据集合
		
		mDal = new ManagerDpl();
		allManagers = mDal.excuteQuery(strSql);
		
		//第四步，返回具有所有管理员信息的数据集合
		if(allManagers.size() == 0) return null;
		else return allManagers;
	}
	
	//增加管理员操作
	public boolean addManager(Manager fManager){
		
		String managerName = fManager.getManagerName();
		String password = fManager.getPassword();
		String managerAccount = fManager.getManagerAccount();
		int managerLevel = 1;
		
		//SUPER是枚举类型常量 不是字符串
		if(fManager.getManagerLevel() == ManagerLevel.SUPER){
			managerLevel = 0;
		}
		
		ManagerDpl mdl = new ManagerDpl();
		
		String strSql = String.format(" insert into tb_manager "
				+ "(ManagerName,Password,ManagerAccount,ManagerLevel) "
				+ "value ('%s','%s','%s',%d)",
				managerName, password, managerAccount, managerLevel);
		
		int recount = mdl.excuteUpdate(strSql);
		
		if(recount==1)
			return true;
		else return false;
		
	}
	
	//获取管理员ID
	public Manager getManagerID(Manager fManager){
		
		String managerName = fManager.getManagerName();
		String password = fManager.getPassword();
		String managerAccount = fManager.getManagerAccount();
		int managerLevel = 1;
		
		if(fManager.getManagerLevel().equals("SUPER")){
			managerLevel = 0;
		}
		
		ManagerDpl mdl = new ManagerDpl();
		ArrayList<Manager> managerList =new ArrayList<Manager>();
		
		String strSql = String.format("select * from tb_manager "
				+ "where ManagerName = '%s' and Password = '%s' and ManagerAccount= '%s' and ManagerLevel =%d",
				managerName,password,managerAccount,managerLevel );
		
		managerList= mdl.excuteQuery(strSql);
		
		return managerList.get(0);	//缺少出错验证
		
	}
	
	//修改密码操作
	public boolean UpdatePwd(Manager fManager){
		
		//步骤1，获取管理员ID和密码
		int userID = fManager.getManagerID();
		String userPwd = fManager.getPassword();
		
		//步骤2，编写sql语句
		String strSql = "Update tb_manager set Password = '"+userPwd+"' where ManagerID = "+userID+"";
		
		//步骤3，实例化管理员包装层，执行修改操作
		ManagerDpl mdl = new ManagerDpl();
		int recount = mdl.excuteUpdate(strSql);
		
		//步骤4，通过判断返回数值的大小，返回相应值
		if(recount==1){
			return true;
		}
		else return false;
	}
	
	//删除管理员操作
	public boolean deleteManager(Manager fManager){
		
		//步骤1，获取管理员ID
		int managerID = fManager.getManagerID();
		
		//步骤2，编写sql语句
		String strSql = String.format("delete from tb_manager where ManagerID=%d", managerID);
		
		//步骤3，实例化管理员包装层，执行删除操作
		ManagerDpl mDpl = new ManagerDpl();
		int result = mDpl.excuteUpdate(strSql);
		
		//步骤4，判断返回值的大小，根据大小返回相应的结果
		if(result!=0){
			return true;
		}
		else return false;
	}
	
	//根据管理员ID查询管理员信息
	public ArrayList<Manager> selectManager(Manager fManager){
		
		//第一步，声明所需变量类型
		
		int managerID = fManager.getManagerID();
		ArrayList<Manager> allManagers = new ArrayList<Manager>();
		ManagerDpl mDal = null;
		
		//第二步，编写sql语句
		
		String strSql = "select * from tb_manager where ManagerID = "+managerID+"";
		
		//第三步，创建数据包装层mDal,执行查询操作，返回具有所有管理员信息的数据集合
		
		mDal = new ManagerDpl();
		allManagers = mDal.excuteQuery(strSql);
		
		//第四步，返回具有所有管理员信息的数据集合
		
		return allManagers;
	}
	
	public Manager getAManager(Manager fManager) {
		
		ArrayList<Manager> manager = null;
		ManagerDpl mDpl = null;
		String sqlString = null;
		
		//步骤1：实例化包装类
		mDpl = new ManagerDpl();
		
		//步骤2：编写Sql语句
		sqlString = String.format("SELECT * FROM tb_manager "
				+ "WHERE ManagerID = %d"
				, fManager.getManagerID());
		
		//步骤3：执行SQL语句并判断查询是否成功
		manager = mDpl.excuteQuery(sqlString);
		if(manager.size() == 0) {
			return null;
		}
		else {
			return manager.get(0);
		}
	}
	
	public boolean UpdateInfo(Manager fManager){
		
		ManagerDpl mDpl = new ManagerDpl();
		
		String strSql = String.format("update tb_manager set ManagerName='%s' where ManagerID=%d",fManager.getManagerName(),fManager.getManagerID());
		
		int recount = mDpl.excuteUpdate(strSql);
		
		//步骤4，通过判断返回数值的大小，返回相应值
		if(recount==1){
			return true;
		}
		else return false;
	}
	
	///通过管理员账号获取管理员名字
	public Manager getManagerbyAcco(Complaint fComplaint){
		
		ArrayList<Manager> manager = null;
		ManagerDpl mDpl = null;
		String sqlString = null;
		
		//步骤1：实例化包装类
		mDpl = new ManagerDpl();
		
		//步骤2：编写Sql语句
		sqlString = String.format("SELECT * FROM tb_manager "
				+ "WHERE ManagerAccount = '%s'"
				, fComplaint.getConplaintAccount());
		
		//步骤3：执行SQL语句并判断查询是否成功
		manager = mDpl.excuteQuery(sqlString);
		if(manager.size() == 0) {
			return null;
		}
		else {
			return manager.get(0);
		}
	}
}
