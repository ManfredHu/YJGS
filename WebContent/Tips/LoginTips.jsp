<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您还没有登陆！</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/login.css" />
<script type="text/javascript" src="../JS/login.js"></script>
</head>
<body>
	<%
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("refresh",
				"3;url=../ManagerLogin/ManagerLogin.jsp");
	%>
	<div class="noLoignPage">
		<p class="noLoginTips">对不起，您还没有登陆</p>
		<p class="noLoginTipsLink">
			请等待<span id="ds">3</span>秒后跳转或者点击<a
				href="../ManagerLogin/ManagerLogin.jsp">立即跳转</a>
		</p>
	</div>
	<script type="text/javascript">
		function addLoadEvent(func) {
			var oldfunc = window.onload;
			if (typeof window.onload != 'function') {
				window.onload = func;
			} else {
				window.onload = function() {
					oldfunc();
					func();
				}
			}
		}
		var num = 3;
		function daoshu() {
			if (num > 0) {
				document.getElementById("ds").innerHTML = num;
				setTimeout("daoshu()", 1000);
				num--;
			}
		}
		addLoadEvent(daoshu);
	</script>
</body>
</html>
