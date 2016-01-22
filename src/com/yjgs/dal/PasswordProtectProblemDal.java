package com.yjgs.dal;


import java.util.ArrayList;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.PasswordProtectProblem;
import com.yjgs.dpl.NewsDpl;
import com.yjgs.dpl.PasswordProtectProblemDpl;

public class PasswordProtectProblemDal {

public ArrayList<PasswordProtectProblem> getProblem(Manager fManager){
		
		//第一步，获取密保ID
		
		int pPPID = fManager.getManagerID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_password_protect_problem where ManagerID="+pPPID+" "; 
		
		//第三步，执行数据包装类，获得具体信息的数据集合
		
		ArrayList<PasswordProtectProblem> problems = new ArrayList<PasswordProtectProblem>();
		PasswordProtectProblemDpl pDl = new PasswordProtectProblemDpl();
		problems = pDl.excuteQuery(strSql);
		
		//第四步，返回该具体信息数据集合
		
		return problems;
	}

	//验证问题答案是否正确
	public boolean IsAnswer(PasswordProtectProblem fPasswordProtectProblem){
	
	//第一步，获取密保ID
	
	int problemID = fPasswordProtectProblem.getProblemID();
	String answer = fPasswordProtectProblem.getAnswer();
	
	//第二步，编写sql语句，
	
	String strSql = "select * from tb_password_protect_problem where ProblemID="+problemID+" and Answer='"+answer+"' "; 
	
	//第三步，执行数据包装类，获得具体信息的数据集合
	
	ArrayList<PasswordProtectProblem> problems = new ArrayList<PasswordProtectProblem>();
	PasswordProtectProblemDpl pDl = new PasswordProtectProblemDpl();
	problems = pDl.excuteQuery(strSql);
	
	//第四步，返回该具体信息数据集合
	if(problems.isEmpty())
		 return false;
	else return true;
}

	/**
	 * 删除问题
	 * @param fProduct				封装有新闻ID的新闻实体类
	 * @return						是否删除成功。
	 */
	public boolean deleteProblem(PasswordProtectProblem fPasswordProtectProblem){
		
		//第一步，获取问题信息
		int problemID = fPasswordProtectProblem.getManagerID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_password_protect_problem where ManagerID="+problemID+""; 
		
		//第三步，实例化数据操作类，声明、定义返回值
		int reCount = 0;
		NewsDpl pDl = new NewsDpl();
		
		//第四步，执行数据操作层方法，获取返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回值是否为1，是则返回true，不是则返回false
		if(reCount==3) return true;
		else return false;
	}
	
	//增加问题
	public boolean addProblem(PasswordProtectProblem fPasswordProtectProblem){
		
		//第一步，获取问题信息
		int 	managerID 		= fPasswordProtectProblem.getManagerID();
		String 	problem			= fPasswordProtectProblem.getProblem();
		String 	answer 			= fPasswordProtectProblem.getAnswer();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_password_protect_problem (ManagerID,Problem,Answer) value ("
				+ managerID
				+ ",'"
				+ problem
				+ "','"
				+ answer
			    +"')";

		//第三步，实例化包装类和返回值类型
		PasswordProtectProblemDpl pDl = new PasswordProtectProblemDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
	
	public boolean updatePasswordProtectProblem(PasswordProtectProblem fPasswordProtectProblem){
		
		//第一步，获取所有问题信息
		int 	problemID		= fPasswordProtectProblem.getProblemID();
//		int 	managerID 		= fPasswordProtectProblem.getManagerID();
		String 	problem			= fPasswordProtectProblem.getProblem();
		String 	answer 			= fPasswordProtectProblem.getAnswer();
		
		//第二步，编写sql语句
		String strSql = "update tb_password_protect_problem set Answer='" + answer
				+ "', Problem = '"+problem+"' where ProblemID="+problemID+""  ;

		//第三步，实例化包装类和返回值类型
		NewsDpl pDl = new NewsDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
}
