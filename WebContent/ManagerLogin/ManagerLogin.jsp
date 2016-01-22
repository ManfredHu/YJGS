<%@page import="com.yjgs.dal.ManagerDal"%>
<%@page import="com.yjgs.bll.ManagerBll"%>
<%@page import="com.yjgs.dcl.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站后台登陆</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/login.css" />
<script type="text/javascript" src="../JS/login.js"></script>
</head>
<body>
	<form action="ManagerLoginSel" method="post" id="loginForm">
		<h1>管理员登录</h1>
		<div class="loginDiv">
			<input type="text" maxlength="15" placeholder="请输入用户名..."
				name="userNum" id="userNum" onfocus="blue(this);"
				onblur="checkUsername(this);" /> <input type="password"
				maxlength="15" name="userPwd" id="userPwd" placeholder="请输入密码..."
				onfocus="blue(this);" onblur="checkPassword(this);" /> <input
				type="text" name="yanzhengma" id="yanzhengma"
				placeholder="请输入验证码..." maxlength="4" onfocus="blue(this);"
				onblur="checkNum(this)"  /> <a id="checkNum"
				href="javascript:changeImage();"> <img alt="验证码 "
				src="yanzhengma" width="100" height="40" id="imgRandom" />
			</a>
			<div class="autoDiv">
				<input type="checkbox" id="checkbox" name="checkbox" value="1" /> <label
					for="checkbox">自动登陆</label>
			</div>
			<input type="submit" value="登陆" id="login" name="login"
				onclick="return checkAll();" /> <a class="forget"
				href="../FindPwdComplaint/FindPwd.jsp">忘记密码</a>
			<%
				//显示错误信息
				if (request.getParameter("errorInfo") != null) {
					out.print("<p id='error'>" + request.getParameter("errorInfo")
							+ "</p>");
				}

				//检查session，若session已存在则直接进入系统
				if (session.getAttribute("UserID") != null) {

					response.sendRedirect("../welcome/adminIndex.jsp");
					return;
				}

				//获取所有cookie，并遍历cookie，查找到“UserNum”时，页面转向管理员页面
				Cookie cookies[] = request.getCookies();
				Cookie scookie = null;
				if (cookies != null) {
					
					for(Cookie aCookie : cookies) {
						
						if(aCookie.getName().equals("MaxAge")) {
							
							if(Integer.valueOf(aCookie.getValue())<= 0) {
								return;
							}
						}
					}
					
					for (int n = 0; n <= cookies.length - 1; n++) {
						scookie = cookies[n];
						if (scookie.getName().equals("UserID")) {

							Manager manager = new Manager();
							ManagerDal mDal = new ManagerDal();
							ManagerBll mBll = new ManagerBll();
							manager.setManagerID(Integer.valueOf(scookie.getValue()));
							manager = mDal.getAManager(manager);

							session.setAttribute("UserID", manager.getManagerID());
							session.setAttribute("UserName",
									manager.getManagerName());
							session.setAttribute("UserLevel",
									manager.getManagerLevel());
							session.setAttribute("Permission",
									mBll.getPermissionStatus(manager));
							session.setMaxInactiveInterval(30 * 60);

							response.sendRedirect("../welcome/adminIndex.jsp"); //跳转到管理员页面
							return;

						}
					}
				}
			%>
		</div>
	</form>
</body>
</html>