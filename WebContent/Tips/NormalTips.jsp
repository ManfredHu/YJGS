<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>您还没有登陆！</title>
	<link rel="shortcut icon" href="../Image/adminLogo.ico" />
	<link rel="stylesheet" href="../Css/login.css" />
	<link rel="stylesheet" href="../Css/ErrorTips.css" />
	<script type="text/javascript" src="../JS/login.js"></script>
	<style type="text/css">
		p.words{
			text-align: center;
		}
		p.s{
			padding-left: 70px;
			background: url(../Image/iconfont-keyi.png) no-repeat;
			font-size: 20px;
			font-color: #888;
			height: 64px;
			line-height: 64px;
		}
		p.f{
			padding-left: 70px;
			background: url(../Image/iconfont-jinzhi.png) no-repeat;
			font-size: 20px;
			font-color: #888;
			height: 64px;
			line-height: 64px;
		}
	</style>
</head>
<body>
	<div class="noLoignPage">
	<%
		//取得参数正确或错误显示图片
		String judge = "";
		String text = "";
		String URL = "";

		//是否操作成功
		if (request.getAttribute("judge") != null)
			judge = request.getAttribute("judge").toString();
		if (judge != "") {
			if (judge == "true")
				out.write("<p class='words s'>操作成功</p>");
			else
				out.write("<p class='words f'>操作失败</p>");
		}

		//传递要显示的页面文本text
		if (request.getAttribute("text") != null)
			text = request.getAttribute("text").toString();
		if (text != "")
			out.write("<p class='textCenter pmargin' >" + text + "</p>");

		//设置3秒后跳转
		if (request.getAttribute("URL") != null)
			URL = request.getAttribute("URL").toString();
		if (URL != "") {

			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("refresh", "3;url = " + URL);

		}
	%>
	<p class='textCenter'>页面将在<span id="ds">3</span>秒后跳转,<a href="<%= URL %>" >立即跳转</a></p>
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
