<%@page import="com.yjgs.bll.PermissionManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>查看申诉-网站后台管理</title>
<link rel="stylesheet" href="../Css/PermissionManager.css" />
<script type="text/javascript" src="../JS/ManagerList.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="查看申诉" name="now"/>
</jsp:include>
<div id="main">
	<table class="atable">
		<caption class="nopass">未处理的申请</caption>
		<thead>
			<tr>
				<th class="applier">申请人</th>
				<th class="aAccount">申请人账号</th>
				<th class="aDate">申请日期</th>
				<th class="aPermission">申请的权限</th>
				<th class="aPass">是否通过</th>
			</tr>
		</thead>
		<tbody>
			<%
				//调用业务逻辑层输出未读申请
				PermissionManageBll pBll = new PermissionManageBll();
				pBll.loadNoReadApplies(out);
			%>
		</tbody>
	</table>
	<table class="btable">
		<caption class="pass">已处理的申请</caption>
		<thead>
			<tr>
				<th class="applier">申请人</th>
				<th class="aAccount">申请人账号</th>
				<th class="aDate">申请日期</th>
				<th class="aPermission">申请的权限</th>
				<th class="aPass">是否通过</th>
				<th class="aDelete">删除</th>
			</tr>
		</thead>
		<tbody>
		<%
			//调用业务逻辑层输出已读申请
			pBll.loadReadedApplies(out);
		%>
		</tbody>
	</table>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>