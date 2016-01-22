<%@page import="com.yjgs.bll.NewsTypeBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>新闻类型管理</title>
<link rel="stylesheet" href="../Css/UpdateNewsType.css" />
<script type="text/javascript" src="../JS/UpdateNewsType.js">
</script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="添加新产品" name="now" />
</jsp:include>
<div id="main">
<%
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	//调用新闻类别数据逻辑层，加载动态数据
	NewsTypeBll ntbll = new NewsTypeBll();
	ntbll.onloadNewsType(out);
%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>