<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.CompanyInfoManagerBll"%>
<%
	///加载首页企业信息
	CompanyInfoManagerBll CIMBll = new CompanyInfoManagerBll();
	CIMBll.loadCompanyInfo(out);
%>
