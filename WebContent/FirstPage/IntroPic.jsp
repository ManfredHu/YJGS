<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//加载企业简介图片
	FirstPageManageBll fpBll = new FirstPageManageBll();
	fpBll.loadCompanyIntroPic(out);
%>
