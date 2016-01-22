package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.ManagerBll;
import com.yjgs.dcl.Manager;

/**
 * Servlet implementation class FindPwd1
 */
public class FindPwd1Sel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPwd1Sel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");

		// 步骤1，获取账号
		String userNum = request.getParameter("UserNum");

		// 验证账号不为空
		if (userNum.length()==0 ||userNum.length()>50) {

			String errorInfo = String.format("FindPwd.jsp?errorInfo= %s",
					"账号信息错误！");
			request.getRequestDispatcher(errorInfo).forward(request, response);
			return;
		}

		// 步骤2，封装数据，将数据封装到实体类中
		Manager fmanager = new Manager();
		fmanager.setManagerAccount(userNum);

		// 步骤3，实例化相应类，并执行getManager（）方法，获取数据结果
		ManagerBll mDal = new ManagerBll();
		Manager manager = new Manager();

		manager = mDal.getManager(fmanager);

		// 步骤4，当数据集不为空，即账号存在时，跳转到找回密码2页面，否则返回上一级，并显示错误信息
		if (manager != null) {
			HttpSession ppHttpSession = request.getSession();
			ppHttpSession.setAttribute("UserID", manager.getManagerID());
			response.sendRedirect("FindPwd2.jsp");
			return;
		} else {
			String errorText2 = String.format("FindPwd.jsp?errorInfo= %s",
					"账号不存在！");
			request.getRequestDispatcher(errorText2).forward(request, response);
			return;
		}
	}

}
