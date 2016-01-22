<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>首页</title>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script type="text/javascript" src="../JS/FristPage.js"></script>
<link rel="stylesheet" href="../Css/FirstPage.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品管理-产品查看与修改" name="now" />
</jsp:include>
<div id="content">
	<div class="slider">
		<%
			//加载首页图片
			FirstPageManageBll fpBll = new FirstPageManageBll();
			fpBll.loadFirstPagePic(out);
		%>
	</div>
	<div class="divForIntroduce">
		<h2>公司简介</h2>
		<a href="../Product/ProductList.jsp">查看更多</a>
	</div>
	<div class="comcony">
		<jsp:include page="../FirstPage/IntroPic.jsp"></jsp:include>
		<jsp:include page="../CompanyInfo/loadCompanyInfo.jsp"></jsp:include>
	</div>
	<div class="divForPic">
		<h2>产品展示</h2>
		<a href="../CompanyInfo/AboutUs.jsp">查看更多</a>
	</div>
	<div class='productPicList'>
		<%
			//加载首页产品
			fpBll.loadProductInfo(out);
		%>
	</div>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script>
	$(".slider").MobileSlider();
</script>