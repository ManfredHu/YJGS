<%@page import="java.util.ArrayList"%>
<%@page import="com.yjgs.bll.PasswordProtectProblemBll"%>
<%@page import="com.yjgs.dcl.PasswordProtectProblem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改密保问题-网站后台管理</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/writeProblem.css" />
<script type="text/javascript" src="../JS/login.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="修改密保问题" name="now" />
</jsp:include>
<div id="main">
	<%
	PasswordProtectProblemBll pppBll = new PasswordProtectProblemBll();
	try{
		int userID = (Integer)session.getAttribute("UserID");
		pppBll.UpdateProblem(userID,out,request,response);
	}
	 catch(Exception e){
		e.printStackTrace();
		request.setAttribute("judge", "false");
		request.setAttribute("text", "错误的操作");
		request.setAttribute("URL", "../ManagerLogin/ManagerLogin.jsp");
		request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
				request, response);
		
		return;
	} 
	%>
	<%
	if(request.getParameter("errorInfo")!=null){
		out.println(request.getParameter("errorInfo"));
	}
%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>