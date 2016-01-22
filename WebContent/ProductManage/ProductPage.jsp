<%@page import="com.yjgs.bll.ProductManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>产品管理-产品查看与修改</title>
<link rel="stylesheet" href="../Css/ProductPage.css" />
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../JS/ProductPage.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="产品管理-产品查看与修改" name="now" />
</jsp:include>
<div id="main">
	<%
		int productID = 0;
		ProductManageBll pmBll = null;
		try {

			productID = Integer.valueOf(request.getParameter("productID"));
		} catch (Exception e) {

			System.out.println("错误的操作");
			e.printStackTrace();

			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp")
					.forward(request, response);
			return;
		}
		pmBll = new ProductManageBll();
	%>
	<h2>产品基本信息：</h2>
	<form id="baseInfoForm" method="post" action="UpdateBaseInfo">
		<%
			//加载基本信息
			pmBll.loadProductBaseInfo(productID, out);
		%>
		<table id="paramsTable">
			<thead>
				<tr>
					<th>参数名</th>
					<th>参数值</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody id="paramTableBody">
				<%
					//加载产品参数
					int curParamNum = pmBll.loadProductParams(productID, out);
				%>
			</tbody>
		</table>
		<input type="hidden" name="productID" value=<%=productID%> /> <input
			type="button" onclick="addParam()" value="添加参数" id="addParamBtn" /> <input
			type="submit" value="保存基本信息" class="saveBtn" />
		<script type="text/javascript">
			curParamNum =
		<%=curParamNum%>
			;
		</script>
	</form>
	<h2 class="h2-smartPic">产品预览图片：</h2>
	<h4>图片上传</h4>
	<form id="PicUpload" action="ProPicUpload_fd" method="post"
		enctype="multipart/form-data">
		<div class="uploadDiv">
			<input class="file" type="file" name="brePicturefile" onchange="uploading(this);" /> 
		</div>
		<input type="hidden" name="productID" value=<%=productID%> /> 
		<input id="upload" type="submit" value="上传" />
	</form>
	<h4>图片列表(点击删除图片)</h4>
	<div id="picList">
		<%
			//加载图片列表
			pmBll.loadProductPicList(productID, out);
		%>
	</div>
	<h2 class="proIntroduce">产品介绍：</h2>
	<form id="introForm" action="UpdateProIntro" method="post">
		<textarea rows="10" cols="10" id="introduce" name="introduce">
		<%
			//加载产品介绍
			pmBll.loadProductIntro(productID, out);
		%>
		</textarea>
		<input type="hidden" name="productID" value=<%=productID%> /> <input
			type="submit" value="保存产品介绍" class="saveIntroduce" />
		<script type="text/javascript">
			var editor = CKEDITOR.replace('introduce');
		</script>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>