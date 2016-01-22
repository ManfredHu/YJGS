<%@page import="com.yjgs.bll.PermissionManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>查看所有账号权限-网站后台管理</title>
<link rel="stylesheet" href="../Css/PermissionManager.css" />
<script type="text/javascript" src="../JS/ManagerList.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="查看所有账号权限" name="now"/>
</jsp:include>
<div id="main">
	<form method="post" action="ModifyPermission" id="PermissionList">
		<table>
			<caption>用户账号与对应权限列表</caption>
			<thead>
				<tr>
					<th class="userNameList">用户名</th>
					<th class="accountList">账号</th>
					<th class="permissionList">对应的权限</th>
					<th class="deleteList">删除</th>
				</tr>
			</thead>
			<%
				//调用业务逻辑层，加载管理员列表
				PermissionManageBll pBll = new PermissionManageBll();
				pBll.loadAllManager(out);
			%>
				
		</table>
		<input id="ManagerListSubmit" class="submitButton" type="submit" value="提交修改"  />
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>