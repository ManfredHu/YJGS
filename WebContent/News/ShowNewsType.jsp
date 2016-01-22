<%@page import="com.yjgs.bll.NewsTypeBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="proNav">
	<h2>
		<span class="allPro">全部新闻分类</span>
	</h2>
	<ul>
		<%
			//实例化数据逻辑层，加载所有新闻列表
			//展示所有新闻列表
			NewsTypeBll newsTypeBll = new NewsTypeBll();
			newsTypeBll.loadAllNewsType(out);
		%>
	</ul>
</div>