<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码--3、更改密码</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/FindPwd.css" />
</head>
<body>
	<%
		try{
			//HttpSession session = request.getSession();
			int userID = (Integer)session.getAttribute("UserID");
			
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
	<form action="FindPwd3Sel" method="post">
		<h1>更改密码</h1>
		<div class="findpwd3">
			<div>
				<span> 请输入新密码：</span>
				<input type="password" name="userPwd" />
			</div>
			<div class="martop">
				<span>请再输入密码：</span>
				<input type="password" name="againPwd" /> 
			</div>
			<input id="findpwd3Btn" class="nextbtn" type="submit" value="提交">
			<%
				if (request.getParameter("errorInfo") != null) {
					out.print("<p class='errortext' id='error2'>"+request.getParameter("errorInfo")+"</p>");
				}
			%>

		</div>
	</form>
</body>
</html>