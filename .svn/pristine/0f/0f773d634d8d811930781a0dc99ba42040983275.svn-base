<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>其他信息管理-首页管理</title>
<link rel="stylesheet" href="../Css/FirstPageManage.css" />
<script type="text/javascript" src="../JS/ProductAdd2.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="产品管理-产品查看与修改" name="now" />
</jsp:include>
<div id="main">
	<h2>LOGO图片：</h2>
	<form id="LogoUpload" action="LogoUpload" method="post" enctype="multipart/form-data">
		<div  class="uploadDiv">
			<input onchange="uploading2(this);" class="file" type="file" name="Picturefile"/>
		</div>
		<input id="upload2" type="submit" value="更换" />
	</form>
	<div class="marginDiv">
		<%
			//加载LOGO图片
			FirstPageManageBll fpBll = new FirstPageManageBll();
			fpBll.loadLogoPic(out);
		%>
	</div>
	
	<h2>企业简介图片：</h2>
	<form id="IntroPicUpload" action="IntroPicUpload" method="post" enctype="multipart/form-data">
		<div  class="uploadDiv">
			<input onchange="uploading3(this);" class="file" type="file" name="Picturefile"/>
		</div>
		<input id="upload3" type="submit" value="更换" />
	</form>
	<div class="marginDiv">
		<%
			//加载企业简介图片
			fpBll.loadCompanyIntroPic(out);
		%>
	</div>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>