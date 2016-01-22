package com.yjgs.controller.managerLogin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.ManagerBll;
import com.yjgs.bll.PasswordProtectProblemBll;
import com.yjgs.dcl.Manager;
import com.yjgs.publ.MD5;

/**
 * Servlet implementation class ManagerLgoinSel
 */
public class ManagerLoginSel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerLoginSel() {
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

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 第一步，获取jsp传递管理员登陆数据
		String userNum = request.getParameter("userNum");
		String userPwd = MD5.GetMD5Code(request.getParameter("userPwd"));
		String yanzhengma = request.getParameter("yanzhengma");
		String sessionstring = (String) session.getAttribute("strEnsure");

		if (userNum == "" || userPwd == "") {
			String errorInfo = String.format("ManagerLogin.jsp?errorInfo= %s",
					"账号或密码不能为空!");
			request.getRequestDispatcher(errorInfo).forward(request, response);
			return;
		}
		
		if(yanzhengma== ""){
			String errorInfo = String.format("ManagerLogin.jsp?errorInfo= %s",
					"验证码不能为空!");
			request.getRequestDispatcher(errorInfo).forward(request, response);
			return;
		}
		
		if(!yanzhengma.equals(sessionstring)){
			String errorInfo = String.format("ManagerLogin.jsp?errorInfo= %s",
					"验证码错误!");
			request.getRequestDispatcher(errorInfo).forward(request, response);
			return;
		}

					// 第二步，将数据封装到Manager中
					ArrayList<Manager> managers = new ArrayList<Manager>();
					Manager manager = new Manager();
					manager.setManagerAccount(userNum);
					manager.setPassword(userPwd);
					managers.add(manager);

					// 第三步，调用相应的业务逻辑层，返回查询结果
					ManagerBll mBll = new ManagerBll();
					Manager ismanager = mBll.getManagers(manager);

					// 第四步，若返回结果为空，即没有验证成功，重新返回登陆页面，若有数据，则将管理员ID和管理员名字存储到session中，并跳转到管理员页面Manager.jsp

						if (ismanager != null) {

							// HttpSession session = request.getSession();
							// //创建session

							session.setAttribute("UserID",
									ismanager.getManagerID());
							session.setAttribute("UserName",
									ismanager.getManagerName());
							session.setAttribute("UserLevel", 
									ismanager.getManagerLevel());
							session.setAttribute("Permission",mBll.getPermissionStatus(ismanager));
							session.setMaxInactiveInterval(30 * 60); // session的过期时间设为30分钟
							
							String[] isCookies = (String[]) request
									.getParameterValues("checkbox");
							// 若点了“记住我”，则保存cookie
							if (isCookies != null) {
								for (String iscookie : isCookies) {
									if (iscookie.equals("1")) {
										Cookie ManaNum = new Cookie("UserID",
												String.valueOf(ismanager.getManagerID()));
										Cookie maxAge = new Cookie("MaxAge", "30");
										ManaNum.setMaxAge(30*24*60*60);
										ManaNum.setPath("/");	
										maxAge.setMaxAge(30*24*60*60);
										maxAge.setPath("/");
										response.addCookie(ManaNum);
										response.addCookie(maxAge);
									}
								}
							}
							
							//若还没设置密保问题，前往设置
							Manager man = new Manager();
							man.setManagerID(ismanager.getManagerID());
							if(!this.HasProblem(man)){
								response.sendRedirect("../AccountManage/WritePPProblem.jsp");
								return;
							}
							
							response.sendRedirect("../welcome/adminIndex.jsp");
							return;// 登陆成功后跳转到管理员页面

						} 
						else {
							
							String errorInfo = String.format("ManagerLogin.jsp?errorInfo=%s",
									"账号或密码错误！");
							request.getRequestDispatcher(errorInfo).forward(request, response);
							return;
						}


	}
	
	public boolean HasProblem(Manager fManager){
		
		PasswordProtectProblemBll pppBll = new PasswordProtectProblemBll();
		
		return pppBll.HasProblem(fManager);
	}
	}
	


