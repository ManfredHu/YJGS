<%@page import="com.yjgs.bll.ComplaintBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>消息提醒页面</title>
<link rel="stylesheet" href="../Css/NewRemind.css" />
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="查看普通管理员忘记密码申述" name="now" />
</jsp:include>
<div id="main">
<%
	//加载未处理申述
	ComplaintBll complaint = new ComplaintBll();
	complaint.loadComplaint(out);
%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>