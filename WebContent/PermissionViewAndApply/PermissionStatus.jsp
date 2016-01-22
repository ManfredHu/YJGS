<%@page import="com.yjgs.bll.PermissionViewAndApplyBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>查看与申请权限-网站后台管理</title>
<link rel="stylesheet" href="../Css/PermissionViewAndApply.css" />
<script type="text/javascript" src="../JS/ManagerList.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="查看与申请权限" name="now"/>
</jsp:include>
<div id="main">
	<h2>我的权限情况</h2>
	<table>
		<thead>
			<tr>
				<th class="type">管理员类型</th>
				<th class="product">产品管理</th>
				<th class="news">新闻管理</th>
				<th class="firstpage">首页管理</th>
				<th class="advise">反馈管理</th>
				<th class="info">企业信息管理</th>
				<th class="function">功能管理</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
					//调用业务逻辑层，直接加载权限情况
					PermissionViewAndApplyBll pvBll = new PermissionViewAndApplyBll();
					pvBll.loadPermissionStatus(out, request);
				%>
			</tr>
		</tbody>
	</table>
	<h2 class="canApply">可申请的权限</h2>
	<form method="post" action="SubmitApply" id="PermissionApply">
		
		<%
			//调用业务逻辑层，直接加载可申请权限
			pvBll.loadApplyPermissions(out, request);
		%>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>