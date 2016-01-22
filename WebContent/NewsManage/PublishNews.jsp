<%@page import="com.yjgs.bll.NewsTypeBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>发布新闻-新闻管理</title>
<link rel="stylesheet" href="../Css/PublishNews.css" />
<link rel="stylesheet" type="text/css" href="../ckeditor/contents.css">  
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script> 
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="新闻管理-发布新闻" name="now" />
</jsp:include>
<div id="main">
	<form action="PublishNewsSel" method="Post">
		<div class="newsTitle">
			<span>新闻题目:</span>
			<input type="text" name="NewsTitle" />
		</div>
		<div class="newsType">
			<span>新闻系列:</span>
			<%
				NewsTypeBll ntBll = new NewsTypeBll();
				ntBll.loadNewsType(out);
			%>
		</div>
		<span class="newsContent">新闻正文:</span>
		<textarea name="Text"></textarea>
		<input class="typeAddBtn" type="submit" value="提交" />
		<script type="text/javascript">
			var editor = CKEDITOR.replace('Text');
		</script>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>