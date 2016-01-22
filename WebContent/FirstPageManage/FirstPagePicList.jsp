<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>轮转照片管理-网站后台管理</title>
<link rel="stylesheet" href="../Css/FirstPageManage.css" />
<script type="text/javascript" src="../JS/ProductAdd2.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="首页轮转照片管理" name="now" />
</jsp:include>
<div id="main">
	<h2>上传新的图片<span class="sm-advise">照片尺寸应大于900*325像素</span></h2>
	<form id="PicUpload" action="PicUpload" method="post" enctype="multipart/form-data">
		<div class="uploadDiv">
			<input class="file" type="file" name="Picturefile" onchange="uploading(this);"/>
		</div> 
			<input id="upload" type="submit"value="上传" />
	</form>
	<h2>首页图片列表<span class="sm-advise">点击图片查看大图</span></h2>
	<table>
		<tbody>
			<%
				//加载首页图片列表
				FirstPageManageBll fpBll = new FirstPageManageBll();
				fpBll.loadFirstPagePic_fm(out);
			%>
		</tbody>
	</table>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>