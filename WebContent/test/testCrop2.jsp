<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>剪裁</title>
<script src="../Jcrop/js/jquery.min.js" type="text/javascript" ></script>
<script src="../Jcrop/js/jquery.Jcrop.js" type="text/javascript" ></script>
<script type="text/javascript">
  jQuery(function($){

    // Create variables (in this scope) to hold the API and image size
    var jcrop_api,
        boundx,
        boundy,

        // Grab some information about the preview pane
        $preview = $('#preview-pane'),
        $pimg = $('#preview-pane .preview-container img'),
        
        xsize = 200,
        ysize = 200;
    
    $('#target').Jcrop({
      onChange: updatePreview,
      onSelect: updatePreview,
      aspectRatio: xsize / ysize
    },function(){
      // Use the API to get the real image size
      var bounds = this.getBounds();
      boundx = bounds[0];
      boundy = bounds[1];
      // Store the API in the jcrop_api variable
      jcrop_api = this;

      // Move the preview into the jcrop container for css positioning
      $preview.appendTo(jcrop_api.ui.holder);
    });

    function updatePreview(c)
    {
      if (parseInt(c.w) > 0)
      {
        var rx = 200 / c.w;
        var ry = 200 / c.h;

        $pimg.css({
          width: Math.round(rx * boundx) + 'px',
          height: Math.round(ry * boundy) + 'px',
          marginLeft: '-' + Math.round(rx * c.x) + 'px',
          marginTop: '-' + Math.round(ry * c.y) + 'px'
        });
        
        $('#width').val(c.w);  //c.w 裁剪区域的宽
		$('#height').val(c.h); //c.h 裁剪区域的高
		$('#x').val(c.x);  //c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标
		$('#y').val(c.y);  //c.y 裁剪区域顶点的y坐标
      }
    };

  });


</script>
<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css" type="text/css" />
<style type="text/css">
	#preview-pane .preview-container {
		width: 200px;
		height: 200px;
		overflow: hidden;
	}
	
	#preview-pane {
		position: absolute;
		top:500px;
		left:0px;
		
	}
	
	#body {
		position: relative;
	}
	
</style>
</head>
<body>
<div  id="body">

	<%
		String imgPath = request.getAttribute("imgPath").toString();
	%>
	<img src="<%=imgPath  %>" id="target" alt="[Jcrop Example]" />

	<div id="preview-pane">
		<div class="preview-container">
			<img src="<%=imgPath  %>" class="jcrop-preview" alt="Preview" />
		</div>
	</div>
	
	<form action="CropTest" method="post">
		 <input type="hidden" name="image.x" id="x" /> 
		 <input type="hidden"name="image.y" id="y" /> 
		 <input type="hidden" name="image.width"id="width" />
		 <input type="hidden" name="image.height" id="height" />
		 <input type="hidden" name="image.Path" id="Path" value="<%=imgPath  %>" >
		<input type="submit" value="确定" /> 
	</form>
</div>

</body>
</html>