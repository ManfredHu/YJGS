<%@page import="com.yjgs.bll.LoadMasterPageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
</head>
<body>
	<div id="header">
		<div id="mycenter">
			<div class="logo">
				<a href="../FirstPage/FirstPage.jsp" name="top">
					<jsp:include page="../FirstPage/Logo.jsp"></jsp:include>
					<!-- <img src="../Image/logoword.gif" alt="渔具网站" /> -->
				</a>
			</div>
			<div class="topright">
				<a href="#" id="setHome" onclick="SetHome(this,window.location)">设为首页</a>
				<a href="#" id="collect" onclick="AddFavorite(window.location,document.title)">收藏本站</a>
			</div>
			<jsp:include page="../Product/SearchBox.jsp"></jsp:include>
			<%
				new LoadMasterPageBll().loadFunctionStatus(out);
			%>
		</div>
	</div>