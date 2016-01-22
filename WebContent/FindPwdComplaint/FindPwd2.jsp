<%@page import="com.yjgs.bll.PasswordProtectProblemBll"%>
<%@page import="com.yjgs.dcl.PasswordProtectProblem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.yjgs.bll.ManagerBll"%>
<%@page import="com.yjgs.dcl.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码--2、回答密保问题</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/FindPwd.css" />
</head>
<body>


	<%
	try{
		PasswordProtectProblemBll newproblem = new PasswordProtectProblemBll();
		newproblem.LoadProblem((Integer) session.getAttribute("UserID"),
				out, session);
	}
	catch(Exception e){
		e.printStackTrace();
		request.setAttribute("judge", "false");
		request.setAttribute("text", "错误的操作");
		request.setAttribute("URL", "../FindPwdComplaint/FindPwd.jsp");
		request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
				request, response);
		return;
	}
	%>
</body>
</html>