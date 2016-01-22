package com.yjgs.controller.accoutmana;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.PasswordProtectProblemBll;
import com.yjgs.dal.PasswordProtectProblemDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.PasswordProtectProblem;
/**
 * Servlet implementation class UpdatePPPAnswerSel
 */
public class UpdatePPPAnswerSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePPPAnswerSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//步骤1：获取修改后的答案，并将其变成字符串数组
		String answer1 = request.getParameter("No1Answer");
		String answer2 = request.getParameter("No2Answer");
		String answer3 = request.getParameter("No3Answer");
		String[] answers = {answer1,answer2,answer3};
		
		String problem1 = request.getParameter("No1Problem");
		String problem2 = request.getParameter("No2Problem");
		String problem3 = request.getParameter("No3Problem");
		String[] allProblems = {problem1,problem2,problem3};
		
		//步骤二：实例化相应类，得到相应管理员的密保问题
		ArrayList<PasswordProtectProblem> problems = new ArrayList<PasswordProtectProblem>();
		PasswordProtectProblemBll pppBll = new PasswordProtectProblemBll();
		Manager manager = new Manager();
		HttpSession session = request.getSession();
		manager.setManagerID((Integer)session.getAttribute("UserID"));		//修改成用户ID
		problems = this.getProblems(manager);
		
		PasswordProtectProblem problem = new PasswordProtectProblem();
		
		if(answer1==""||answer2==""||answer3==""){
			if(answer1==""){
				String errorInfo = String.format("UpdateProAnswer.jsp?errorInfo=%s", "答案1不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response);
				return ;
			}
			
			if(answer2==""){
				String errorInfo = String.format("UpdateProAnswer.jsp?errorInfo=%s", "答案2不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response);
				return ;
			}
			
			if(answer3==""){
				String errorInfo = String.format("UpdateProAnswer.jsp?errorInfo=%s", "答案3不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response);
				return ;
			}
		}
		
		//步骤3：通过一个循环，执行三次答案更新操作
		for(int t=0;t<3;t++){
			
			//problem.setManagerID(1);
			problem.setProblemID(problems.get(t).getProblemID());
			problem.setAnswer(answers[t]);
			problem.setProblem(allProblems[t]);
			
			try{
				
				boolean issuccess = pppBll.UpdateAnswer(problem);
				if(issuccess==true){
					
					System.out.print("第"+t+"次修改成功！");
					if(t==2){
						request.setAttribute("judge", "true");
						request.setAttribute("text", "修改密保问题和密保答案成功！");
						request.setAttribute("URL", "../welcome/adminIndex.jsp");		//返回的为管理员主页
						request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
						return;
					}
				}
				else {
					System.out.print("第"+t+"次修改失败！");
					request.setAttribute("judge", "false");
					request.setAttribute("text", "很抱歉，修改密保问题和密保答案失败！");
					request.setAttribute("URL", "../AccountManage/UpdateProAnswer.jsp");		//返回的为管理员主页
					request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
					return;
				}
			}
			catch(Exception e){
				
				e.printStackTrace();
				System.out.print("数据操作层调用失败！");
			}
		}
	}

	//调用数据操作层，得到相应管理员的所有密码问题
	public ArrayList<PasswordProtectProblem> getProblems(Manager fManager) {

		PasswordProtectProblemDal pPPDal = new PasswordProtectProblemDal();
		ArrayList<PasswordProtectProblem> pPPs = null;

		try {
			pPPs = pPPDal.getProblem(fManager);
		} catch (Exception e) {
			System.out.print("数据操作层，查询账号时发生错误！");
			e.printStackTrace();
		}

		if (pPPs.size()!=0) {
			return pPPs;
		} else
			return null;
	}
	
}
