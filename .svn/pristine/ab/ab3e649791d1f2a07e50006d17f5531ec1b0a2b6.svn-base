<%@page import="com.yjgs.bll.CompanyInfoManagerBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>联系我们</title>
<link rel="stylesheet" href="../Css/ContactUs.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="loadCompanyRelation.jsp">联系我们</a></span>
	</div>
	<%
		CompanyInfoManagerBll cIMBll = new CompanyInfoManagerBll();

		cIMBll.loadRelationContent(out);
	%>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	goTopEx();
</script>