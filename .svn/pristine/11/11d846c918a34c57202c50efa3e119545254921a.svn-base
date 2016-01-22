<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申诉页面</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/Complaint.css" />
</head>
<body>
	<form id="findPwd" action="ComplaintSel" method="post">
		<h1>账号申诉</h1>
		<div class="div1">
			<div class="accountDiv">
				<span>账号:</span>
				<input class="textinput" type="text" name="ComplaintNum" />
			</div>
			<%
				if(request.getParameter("errorInfo")!=null){
					out.print("<p style='position:absolute; bottom:76px;left:100px;color:#EB4F38'>"+request.getParameter("errorInfo")+"</p>");
				}
			%>
			<div class="applyReasonDiv">
			<span>申述原因:</span>
			<textarea rows="3" cols="60" name= "ComplaintReason" ></textarea>
			</div>
			<div class="emailDiv">
				<span>邮箱:</span>
				<input class="textinput" type="text" name="email" />
			</div>
			<%
				if(request.getParameter("nullInfo")!=null){
					out.print("<p style='position:absolute; bottom:76px;left:100px;color:#EB4F38'>"+request.getParameter("nullInfo")+"</p>");
				}
			%>
			<input class="sure" type="submit" value="提交" />
		</div>
</form>
</body>
</html>