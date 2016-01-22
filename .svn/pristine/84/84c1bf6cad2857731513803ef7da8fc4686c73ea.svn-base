<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改密码-网站后台管理</title>
<link rel="stylesheet" href="../Css/AccountManage.css" />
<script type="text/javascript" src="../JS/login.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="修改密码" name="now" />
</jsp:include>
<div id="main">
	<form id="changePwd" action="UpdatePwdSel" method="post">
		<ul>
			<li><span>请输入原密码：</span> <input placeholder="请输入原密码..." onblur="checkPassword(this);" onfocus="blue(this);" type="password" name="password1" />
			</li>
			<li><span>修改后的密码：</span> <input placeholder="请输入新密码..." onblur="checkPassword(this);" onfocus="blue(this);" type="password" name="password2" />
			</li>
			<li><span>请再输入一遍：</span> <input placeholder="请再输一次..." onblur="checkPassword(this);" onfocus="blue(this);" type="password" name="password3" />
			</li>
			<li><input onclick="return pwdCheckAll();" id="pwdBtn" class="submitButton2" type="submit"
				value="修改" /></li>
		</ul>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>