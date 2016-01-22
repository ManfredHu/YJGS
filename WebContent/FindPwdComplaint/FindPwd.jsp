<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码--1、验证账号</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/FindPwd.css" />
</head>
<body>
	<form id="findPwd" action="FindPwd1Sel" method="post">
		<h1>找回密码</h1>
		<div>
			<span> 请输入账号：</span>
			<input class="textField" type="text" name="UserNum" /> 
			<input class="nextbtn" type="submit" value="下一步" />
			<%
				if (request.getParameter("errorInfo") != null) {
					out.print("<p class='errortext' id='error1'>"+request.getParameter("errorInfo")+"</p>");
				}
			%>
		</div>
	</form>
</body>
</html>