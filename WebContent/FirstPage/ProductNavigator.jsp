<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul id="proNav">
	<%
		FirstPageManageBll fpBll = new FirstPageManageBll();
		fpBll.loadProductNvigator(out);
	%>
</ul>
