package com.yjgs.bll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import sun.misc.FpUtils;

import com.yjgs.dal.PasswordProtectProblemDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.PasswordProtectProblem;

public class PasswordProtectProblemBll {

	// 验证密保问题答案是否正确
	public boolean IsAnswer(PasswordProtectProblem fPasswordProtectProblem) {

		PasswordProtectProblemDal pppDal = new PasswordProtectProblemDal();
		boolean isAnswer = false;

		isAnswer = pppDal.IsAnswer(fPasswordProtectProblem);

		return isAnswer;
	}

	// 获取相应管理员的问题
	public ArrayList<PasswordProtectProblem> getProblems(Manager fManager) {

		PasswordProtectProblemDal pPPDal = new PasswordProtectProblemDal();
		ArrayList<PasswordProtectProblem> pPPs = null;

		try {
			pPPs = pPPDal.getProblem(fManager);
		} catch (Exception e) {
			System.out.print("数据操作层，查询账号时发生错误！");
			e.printStackTrace();
		}

		if (pPPs != null) {
			return pPPs;
		} else
			return null;
	}

	// 加载相应管理员问题
	public void LoadProblem(int UserNum, JspWriter fOut, HttpSession sess) {

		ArrayList<PasswordProtectProblem> problems = new ArrayList<PasswordProtectProblem>();
		Manager manager = new Manager();
		manager.setManagerID(UserNum);
		problems = this.getProblems(manager);
		try {
			fOut.write("<form id='findPwd2' action='FindPwd2Sel' method='post'>");
			fOut.write("<h1>请回答密保问题</h1><div class='findpwd2'>");
			fOut.write("<div><span>请选择问题：</span><select name = 'select'>");
			if (problems != null) {
				fOut.write(String.format("<option value=%d> %s </option>",
						problems.get(0).getProblemID(), problems.get(0)
								.getProblem()));
				fOut.write(String.format("<option value=%d> %s </option>",
						problems.get(0).getProblemID(), problems.get(1)
								.getProblem()));
				fOut.write(String.format("<option value=%d> %s </option>",
						problems.get(0).getProblemID(), problems.get(2)
								.getProblem()));
			}
			fOut.write("</select ></div>");
			fOut.write("<div class='findpwd2-div2'><span>请输入问题答案：</span><input type='text' name='answer' /></div>");
			String errorInfo = (String) sess.getAttribute("errorInfo");
			if (errorInfo != null) {
				fOut.write("<p class='errortext' id='error2'>" + errorInfo + "</p>");
			}
			fOut.write("<input id='findpwd2Btn' class='nextbtn' type='submit' value='提交' >");
			fOut.write("<a class='forgetProblem' href='Complaint.jsp'>忘记问题</a></div>");
			fOut.write("</form >");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据加载发生错误！");
		}

	}

	// 加载修改密保问题

	public void UpdateProblem(int userID, JspWriter fOut,HttpServletRequest request,HttpServletResponse response) {

		ArrayList<PasswordProtectProblem> problems = new ArrayList<PasswordProtectProblem>();
		Manager manager = new Manager();
		// manager.setManagerID(1); //修改成用户ID
		manager.setManagerID(userID);
		problems = this.getProblems(manager);
		try {
//<<<<<<< .mine
			if (problems.size()!=0) {
//			fOut.write("<form action='UpdatePPPAnswerSel' method='post'>");
//			// fOut.write("<select name = 'select'>");
//=======
			fOut.write("<form id='writeProblem' action='UpdatePPPAnswerSel' method='post'>");
			fOut.write("<ul>");
//>>>>>>> .r259
				fOut.write(String
						.format("<li><span>第一个密保问题：</span><input type='text' value='%s' name='No1Problem' "
								+"onblur='checkProblem(this);' onfocus='blue(this);' placeholder='请输入第一个问题...' /></li>"
								+ "<li class='answer'><span>答案：</span><input type='text' value='%s' name='No1Answer' "
								+"onblur='checkAnswer(this);' onfocus='blue(this);' placeholder='请输入第一个问题答案...' /></li>",
								problems.get(0).getProblem(), problems.get(0)
										.getAnswer()));
				fOut.write(String
						.format("<li><span>第二个问题：</span><input type='text' value='%s' name='No2Problem' "
								+"onblur='checkProblem(this);' onfocus='blue(this);' placeholder='请输入第二个问题...' /></li>"
								+"<li class='answer'><span>答案：</span><input type='text' value='%s' name='No2Answer' "
								+"onblur='checkAnswer(this);' onfocus='blue(this);' placeholder='请输入第二个问题答案...' /></li>",
								problems.get(1).getProblem(), problems.get(1)
										.getAnswer()));
				fOut.write(String
						.format("<li><span>第三个问题：</span><input type='text' value='%s' name='No3Problem' "
								+"onblur='checkProblem(this);' onfocus='blue(this);' placeholder='请输入第三个问题...' /></li>" 
								+"<li class='answer'><span>答案：</span><input type='text' value='%s' name='No3Answer' "
								+"onblur='checkAnswer(this);' onfocus='blue(this);' placeholder='请输入第三个问题答案...' /></li>",
								problems.get(2).getProblem(), problems.get(2)
										.getAnswer()));
				fOut.write("<li><input onclick='return checkProblemAndAnswer(this);' id='login' type='submit' value='提交' /></li>");
				fOut.write("</form >");
			}

			else{
				fOut.println("暂无密保问题！");
				request.setAttribute("judge", "false");
				request.setAttribute("text", "暂无密保问题，请前往添加!");
				request.setAttribute("URL", "../AccountManage/WritePPProblem.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(
						request, response);
				return;
			}

			fOut.write("<li><input onclick='return checkProblemAndAnswer(this);' id='login' type='submit' value='提交' /></li>");
			fOut.write("</form >");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据加载发生错误！");
		}

	}

	// 修改密保问题答案
	public boolean UpdateAnswer(PasswordProtectProblem fPasswordProtectProblem) {

		PasswordProtectProblemDal pppDal = new PasswordProtectProblemDal();
		boolean isAnswer = false;

		isAnswer = pppDal.updatePasswordProtectProblem(fPasswordProtectProblem);

		return isAnswer;
	}

	// 插入密保问题
	public boolean InsertProblem(PasswordProtectProblem fPasswordProtectProblem) {

		PasswordProtectProblemDal pppDal = new PasswordProtectProblemDal();
		boolean isAnswer = false;

		isAnswer = pppDal.addProblem(fPasswordProtectProblem);

		return isAnswer;
	}

	public boolean HasProblem(Manager fManager) {

		PasswordProtectProblemDal pppDal = new PasswordProtectProblemDal();
		ArrayList<PasswordProtectProblem> problems = pppDal
				.getProblem(fManager);

		if (problems.size() == 0) {
			return false;
		} else
			return true;
	}
	
	//加载重置密码的管理员页面
	public void loadUpdateRePassword(JspWriter fout){
		
		ManagerBll managerBll = new ManagerBll();
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		try {
			
			managers=managerBll.getAllManager();
			
			fout.println("<h3>所有管理员信息</h3>");
			fout.println("<table>");
			fout.println("<tr><td>管理员名字</td><td>管理员账号</td><td>密码重置</td></tr>");
			//fout.println("<form action='UpdateRePasswordSel' method='post'>");
			for(int t=0;t<managers.size();t++){
				
				fout.print(String.format("<tr><td>%s</td><td>%s</td><td><input type='button' value='提交' onclick='UpdatePwd(%d);'></td></tr>", managers.get(t).getManagerName(), managers.get(t).getManagerAccount(),managers.get(t).getManagerID()));
				System.out.print(managers.get(t).getManagerID());
			}
			//fout.println("</form>");
			fout.println("</table>");
		} catch (Exception e) {
			
			System.out.println("输出管理员信息出错！");
			e.printStackTrace();
		}
	}
	
	//删除密码问题
	public boolean deletePPP(PasswordProtectProblem fPasswordProtectProblem){
		PasswordProtectProblemDal pppDal = new PasswordProtectProblemDal();
		
		return pppDal.deleteProblem(fPasswordProtectProblem);
	}
}
