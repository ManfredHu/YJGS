<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.CompanyInfoManagerBll"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改招聘信息</title>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="../Css/CompanyInfoManage.css" />
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="企业信息管理-修改企业信息" name="now" />
</jsp:include>
<div id="main">
	<%
		CompanyInfoManagerBll cIMBll = new CompanyInfoManagerBll();

		cIMBll.UpdateRecruitment(out);
	%>
	<script type="text/javascript">
		var editor = CKEDITOR.replace('text');
	</script>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>