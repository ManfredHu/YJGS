<%@ page import="com.yjgs.bll.PermissionManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>添加新管理员-网站后台管理</title>
<link rel="stylesheet" href="../Css/PermissionManager.css" />
<script type="text/javascript" src="../JS/addNewManager.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="添加新管理员" name="now" />
</jsp:include>
<div id="main">
	<form id="addNewManager" method="post" action="AddNewManager">
		<ul>
			<li><span>用户名：</span> <input type="text" name="userName"
				id="userName" maxlength="20" onfocus="blue(this);"
				onblur="checkUsername(this);" /></li>
			<li><span>账号：</span> <input type="text" name="userAccount"
				id="userAccount" maxlength="20" onfocus="blue(this);"
				onblur="checkAccount(this);" /></li>
			<li><span>请选择权限：</span>
				<dl>
					<%
						PermissionManageBll pmBll = new PermissionManageBll();
						pmBll.loadAllPermission(out);
					%>
				</dl></li>
			<li><input id="submit" class="submitButton"
				onclick="return checkAll();" type="submit" value="提交" name="submit" />
			</li>
		</ul>
	</form>

</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>
