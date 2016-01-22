<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.FunctionManageBll"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>功能管理-网站后台管理</title>
<link rel="stylesheet" href="../Css/FunctionManage.css" />
<script type="text/javascript" src="../JS/FunctionManage.js"></script>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="功能管理" name="now"/>
</jsp:include>
<div id="main">
	<h2>一级功能设置</h2>
	<% 
		FunctionManageBll fb = new FunctionManageBll();
		fb.loadStatus(out);
	%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>