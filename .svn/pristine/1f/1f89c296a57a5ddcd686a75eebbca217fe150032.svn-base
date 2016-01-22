<%@page import="com.yjgs.bll.MessageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>消息提醒-网站后台管理</title>
<link rel="stylesheet" href="../Css/MessageReminding.css" />
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="消息提醒" name="now" />
</jsp:include>
<div id="main">
	<%
		//加载管理员消息以及建议消息
		MessageBll mBll = new MessageBll();
		mBll.loadSuperManagerMess(out, request);
		mBll.loadAdviceMess(out);
	%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>