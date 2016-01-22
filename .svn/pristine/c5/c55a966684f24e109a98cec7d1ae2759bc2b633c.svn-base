<%@page import="com.yjgs.bll.ProductManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>添加新产品-上传产品图片</title>
<link rel="stylesheet" href="../Css/ProductAdd.css" />
<script src="../Jcrop/js/jquery.min.js" type="text/javascript"></script>
<script src="../Jcrop/js/jquery.Jcrop.js" type="text/javascript"></script>
<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css" type="text/css" />
<script type="text/javascript" src="../JS/ProductAdd2.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="添加新产品-产品预览图" name="now" />
</jsp:include>
<div id="main">
	<%
		ProductManageBll pmBll = null;
		int productID = 0;
		boolean isUpload = false; //是否开启上传
		boolean isCrop = false; //是否开启裁减
		int picNum = 0; //当前预览图个数
		int maxPicNum = 5; //最大预览图数
		//获取产品ID，并处理无ID时的错误操作异常
		try {
			productID = Integer.valueOf(request.getAttribute("productID")
					.toString());
		} catch (Exception e) {
			try {
				productID = Integer.valueOf(request.getParameter(
						"productID").toString());
			} catch (Exception e2) {
				System.out.println("错误的操作");
				e.printStackTrace();
				request.setAttribute("judge", "false");
				request.setAttribute("text", "错误的操作");
				request.setAttribute("URL", "../welcome/adminIndex.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp")
						.forward(request, response);
				return;
			}
		}
		//获取产品预览图数量，并决定是否开启上传
		pmBll = new ProductManageBll();
		picNum = pmBll.getProPicNum(productID);
		if (picNum < maxPicNum) {
			isUpload = true;
		}
		//选择是否开启裁减并关闭上传
		if (request.getParameter("imgPath") != null) {
			isCrop = true;
			isUpload = false;
		}
	%>
	<div <%=!isUpload ? "style='display: none;'" : ""%>>
		<h2>第一步：预览图上传<span>(可上传1-5张)</span></h2>
		<form id="PicUpload" action="ProductPicUpload" method="post"
			enctype="multipart/form-data">
			<div class="uploadDiv">
				<div class="bgImage"></div>
				<input onchange="uploading(this);" class="file" type="file" name="brePicturefile" />
			</div> 
			<input type="hidden"name="productID" value=<%=productID%> />
			<input id="upload" type="submit" value="上传" />
		</form>
	</div>


	<%
		//
		String imgPath = "";
		int srcWidth = 0;
		int srcHeight = 0;
		int tarWidth = 0;
		int tarHeight = 0;
		int srcImgWidth = 350; //原图展示边长
		int viewImgWidth = 210; //缩略图展示宽		//实际比例 14：9
		int viewImgHeight = 135;//缩略图展示的长
		//存在原图地址属性则展示此模块
		if (isCrop) {

			try {
				
				imgPath = request.getParameter("imgPath").toString();
				srcWidth = Integer
						.valueOf(request.getParameter("Width").toString());
				srcHeight = Integer.valueOf(request.getParameter("Height")
						.toString());
			}catch(Exception e) {
				
				request.setAttribute("judge", "false");
				request.setAttribute("text", "错误的操作");
				request.setAttribute("URL", "../welcome/adminIndex.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp")
						.forward(request, response);
				return;
			}

			if (srcWidth > srcImgWidth || srcHeight > srcImgWidth) {

				if (srcWidth >= srcHeight) {

					tarWidth = srcImgWidth;
					tarHeight = (int) Math.round((((double) srcImgWidth)
							* ((double) srcHeight) / ((double) srcWidth)));
				} else {

					tarHeight = srcImgWidth;
					tarWidth = (int) Math.round((((double) srcImgWidth)
							* ((double) srcWidth) / ((double) srcHeight)));
				}
			} else {

				tarWidth = srcWidth;
				tarHeight = srcHeight;
			}

		}
	%>
	<div <%=!isCrop ? "style='display: none;'" : ""%> class="secondDiv">
		<h2>第二步：预览图剪裁</h2>
		<div class="bigPic">
			<span>原图：</span>
			<div style="width: <%=srcImgWidth%>px; height: <%=srcImgWidth%>px;">
				<img src="<%=imgPath%>" id="target" alt="原图" width="<%=tarWidth%>px"
					height="<%=tarHeight%>px" />
			</div>
		</div>
		<div class="smartPic">
			<span>预览：</span>
			<div style="width: <%=viewImgWidth%>px; height: <%=viewImgHeight%>px; overflow: hidden;">
				<img id="preview" src="<%=imgPath%>" width="<%=viewImgWidth%>px"
					height="<%=viewImgHeight%>px" />
			</div>
		</div>
		<form action="ProductPicCrop" method="post">
			<input type="hidden" name="image.x" id="x" /> <input type="hidden"
				name="image.y" id="y" /> <input type="hidden" name="image.width"
				id="width" /> <input type="hidden" name="image.height" id="height" />
			<input type="hidden" name="image.Path" id="Path"
				value="<%=imgPath%>"> <input type="hidden"
				name="tarWidth" id="tarWidth" value="<%=tarWidth%>"> <input
				type="hidden" name="tarHeight" id="tarHeight"
				value="<%=tarHeight%>"> <input type="hidden"
				name="productID" id="productID" value="<%=productID%>"> <input
				type="submit" value="确定并保存" class="sureAndSave" />
		</form>
	</div>
	<div>
		<h2>已保存的预览图：</h2>
		<div id="breDiv">
			<%
				//调用业务逻辑加载产品预览图
				pmBll.loadExistBrePic(productID, out);
			%>
		</div>
		<a class="nextBtn" href="ProductAdd3.jsp?productID=<%=productID%>">下一步</a>
	</div>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>