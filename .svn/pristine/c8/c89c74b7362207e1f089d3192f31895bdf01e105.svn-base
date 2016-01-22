<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>图片裁减</title>
<script src="../Jcrop/js/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="../Css/PicCropForUpdate.css" />
<script src="../Jcrop/js/jquery.Jcrop.js" type="text/javascript"></script>
<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css"
	type="text/css" />
<script type="text/javascript">
	$(function() {
		var jcrop_api, boundx, boundy;
		//使原图具有裁剪功能
		$('#target').Jcrop({
			onChange : updatePreview,
			onSelect : updatePreview,
			aspectRatio : 36 / 13
		}, function() {
			// Use the API to get the real image size
			var bounds = this.getBounds();
			boundx = bounds[0];
			boundy = bounds[1];
			// Store the API in the jcrop_api variable
			jcrop_api = this;
		});
		//裁剪过程中，每改变裁剪大小执行该函数
		function updatePreview(c) {
			if (parseInt(c.w) > 0) {
				$('#preview').css({
					width : Math.round(216 / c.w * boundx) + 'px',
					height : Math.round(78 / c.h * boundy) + 'px',
					marginLeft : '-' + Math.round(216 / c.w * c.x) + 'px',
					marginTop : '-' + Math.round(78 / c.h * c.y) + 'px'
				});
				$('#width').val(c.w); //c.w 裁剪区域的宽
				$('#height').val(c.h); //c.h 裁剪区域的高
				$('#x').val(c.x); //c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标
				$('#y').val(c.y); //c.y 裁剪区域顶点的y坐标

			}
		}
		;
	});
</script>
<style>
#breDiv img {
	display: inline-block;
	width: 216px;
	height: 78px;
}
</style>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="产品管理-产品查看与修改" name="now" />
</jsp:include>
<div id="main">
	<%
		//获取裁减的图片参数
		String imgPath = "";
		int srcWidth = 0;
		int srcHeight = 0;
		int tarWidth = 0;
		int tarHeight = 0;
		int srcImgWidth = 350; //原图展示边长
		int viewImgWidth = 216; //缩略图展示宽		//实际比例 36:13
		int viewImgHeight = 78;//缩略图展示的长
		//存在原图地址属性则展示此模块

		try {

			imgPath = request.getParameter("imgPath").toString();
			srcWidth = Integer.valueOf(request.getParameter("Width")
					.toString());
			srcHeight = Integer.valueOf(request.getParameter("Height")
					.toString());
		} catch (Exception e) {

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
	%>
	<div class="secondDiv">
		<h2>预览图剪裁：<span>（如大小不合适可先用图像处理软件处理，最佳尺寸为900像素*325像素）</span></h2>
		<div class="bigPic">
			<span>原图：</span>
			<div style="width: <%=srcImgWidth%>px; height: <%=srcImgWidth%>px;">
				<img src="<%=imgPath%>" id="target" alt="" width="<%=tarWidth%>px"
					height="<%=tarHeight%>px" />
			</div>
		</div>
		<div class="smartPic">
			<span>预览：</span>
			<div
				style="width: <%=viewImgWidth%>px; height: <%=viewImgHeight%>px; overflow: hidden;">
				<img id="preview" src="<%=imgPath%>" width="<%=viewImgWidth%>px"
					height="<%=viewImgHeight%>px" />
			</div>
		</div>
		<form action="PicCrop" method="post">
			<input type="hidden" name="image.x" id="x" /> <input type="hidden"
				name="image.y" id="y" /> <input type="hidden" name="image.width"
				id="width" /> <input type="hidden" name="image.height" id="height" />
			<input type="hidden" name="image.Path" id="Path"
				value="<%=imgPath%>"> <input type="hidden" name="tarWidth"
				id="tarWidth" value="<%=tarWidth%>"> <input type="hidden"
				name="tarHeight" id="tarHeight" value="<%=tarHeight%>"> <input
				type="submit" value="确定并保存" class="sureAndSave" />
		</form>
	</div>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>