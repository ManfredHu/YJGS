<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.CompanyInfoManagerBll"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>人才招聘</title>
<link rel="stylesheet" href="../Css/recruitment.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="loadRecruitment.jsp">人才招聘</a></span>
	</div>
	<div class="centerfor">
		<%
			CompanyInfoManagerBll cIMBll = new CompanyInfoManagerBll();

			cIMBll.loadRecruitment(out);
		%>
	</div>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	goTopEx();
</script>