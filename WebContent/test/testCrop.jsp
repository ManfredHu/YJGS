<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>裁减</title>
	<script src="../Jcrop/js/jquery.min.js" type="text/javascript"></script>
	<script src="../Jcrop/js/jquery.Jcrop.js" type="text/javascript"></script>
	<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css" type="text/css" />
	
	<script type="text/javascript">
	$(function(){
		var jcrop_api, boundx, boundy;
		//使原图具有裁剪功能
		$('#target').Jcrop({
			onChange: updatePreview,
			onSelect: updatePreview,
			aspectRatio: 285/180
		},function(){
			// Use the API to get the real image size
			var bounds = this.getBounds();
			boundx = bounds[0];
			boundy = bounds[1];
			// Store the API in the jcrop_api variable
			jcrop_api = this;
		});
		//裁剪过程中，每改变裁剪大小执行该函数
		function updatePreview(c){
			if (parseInt(c.w) > 0){	
				$('#preview').css({
					width: Math.round(285/ c.w * boundx) + 'px',  	//200 为预览div的宽和高
					height: Math.round(180/ c.h * boundy) + 'px',
					marginLeft: '-' + Math.round(285 / c.w * c.x) + 'px',
					marginTop: '-' + Math.round(180 / c.h * c.y) + 'px'
				});
				$('#width').val(c.w);  //c.w 裁剪区域的宽
				$('#height').val(c.h); //c.h 裁剪区域的高
				$('#x').val(c.x);  //c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标
				$('#y').val(c.y);  //c.y 裁剪区域顶点的y坐标
				
			}
		  };
	});
  </script>
</head>
<body>
	<%
		String imgPath = request.getAttribute("imgPath").toString();
		int srcWidth = Integer.valueOf(request.getAttribute("Width").toString()); 
		int srcHeight = Integer.valueOf(request.getAttribute("Height").toString()); 
		int tarWidth = 0;
		int tarHeight = 0;
		
		if(srcWidth > 600 || srcHeight > 600) {
			
			if(srcWidth >= srcHeight) {
				
				tarWidth = 600;
				tarHeight = (int)Math.round((((double)600) * ((double)srcHeight)/((double)srcWidth)));
			}
			else {
				
				tarHeight = 600;
				tarWidth = (int)Math.round((((double)600) * ((double)srcWidth)/((double)srcHeight)));
			}
		}
		else {
			
			tarWidth = srcWidth;
			tarHeight = srcHeight;
		}
		
		
	%>
	原图：
	<div style="width: 600px; height: 600px;">
		<img src="<%=imgPath %>" id="target" alt="" width="<%=tarWidth %>px" height="<%=tarHeight %>px" />
	</div>
	
	预览：
	<!-- <div style="width: 200px; height: 200px; overflow: hidden; border: 1px solid gray;"
	 id="preview-pane">
		<div class="preview-container">
			<img id="preview" src="demo_files/sago.jpg" class="jcrop-preview" alt="Preview" />
		</div>
	</div> -->
	<div
		style="width: 285px; height: 180px; overflow: hidden; border: 1px solid gray;">
		<img id="preview" src="<%=imgPath  %>"  width="285px" height="180px" />
	</div>
	
	
	<form action="CropTest" method="post">
		 <input type="hidden" name="image.x" id="x" /> 
		 <input type="hidden"name="image.y" id="y" /> 
		 <input type="hidden" name="image.width"id="width" />
		 <input type="hidden" name="image.height" id="height" />
		 <input type="hidden" name="image.Path" id="Path" value="<%=imgPath  %>" >
		 <input type="hidden" name="tarWidth" id="tarWidth" value="<%=tarWidth  %>" >
		 <input type="hidden" name="tarHeight" id="tarHeight" value="<%=tarHeight  %>" >
		<input type="submit" value="确定" /> 
	</form>
</body>
</html>