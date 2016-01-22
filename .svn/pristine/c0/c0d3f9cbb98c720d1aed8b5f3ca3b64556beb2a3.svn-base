<%@page import="com.yjgs.bll.PermissionViewAndApplyBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>查看申请状态-网站后台管理</title>
<link rel="stylesheet" href="../Css/PermissionViewAndApply.css" />
<script type="text/javascript" src="../JS/ManagerList.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="查看申请状态" name="now"/>
</jsp:include>
<div id="main">
	<table class="appliesStatus">
		<caption class="nopass">未回复的申请</caption>
		<thead>
			<tr>
				<th class="applyDate">申请日期</th>
				<th class="applyPermission">申请权限</th>
				<th class="isPass">状态</th>
			</tr>
		</thead>
		<tbody>
		<%
				
			//调用业务逻辑层，加载未回复的申请状况
			PermissionViewAndApplyBll pvBll = new PermissionViewAndApplyBll();
			pvBll.loadNoReadApplies(out,request);
		%>
		</tbody>
	</table>
	<table class="appliesStatus secondTable">
		<caption class="pass">已回复的申请</caption>
		<thead>
			<tr>
				<th class="applyDate">申请日期</th>
				<th class="applyPermission">申请权限</th>
				<th class="isPass">是否通过</th>
			</tr>
		</thead>
		<tbody>
		<%
			//调用业务逻辑，加载已回复的申请状况
			pvBll.loadReadedApplies(out,request);
		%>
		</tbody>
	</table>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>