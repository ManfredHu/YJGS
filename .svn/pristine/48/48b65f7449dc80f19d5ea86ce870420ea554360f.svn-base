<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jcrop测试</title>
<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css" type="text/css" />
<script type="text/javascript" src="../JS/jquery-2.1.1.js"></script>
<script type="text/javascript" src="../Jcrop/js/jquery.Jcrop.js"></script>
<script type="text/javascript">

	
	/* $('#upload-form').submit(function(e) {
		$('#upload_target').one('load', function() {
			var ret = $('body', frames['upload_target'].document).html();
			var data = eval("(" + ret + ")");
			if (data.Status == 'OK') {
				var imageUrl = data.ImageUrl;
				
				$('#cropbox').attr('src', imageUrl);
				$('#preview').attr('src', imageUrl);
				$("#cropbox").Jcrop({
					onChange: showPreview,
					onSelect: showPreview,
					aspectRatio: 1
				});
				$('#crop-area').show();
			} else {
				alert("Upload Failed!");
			}
		});
	});
	
	
    function showPreview(coords) {
        var rx = 150 / coords.w;
        var ry = 150 / coords.h;

        $('#preview').css({
            width: Math.round(rx * 500) + 'px',
            height: Math.round(ry * 370) + 'px',
            marginLeft: '-' + Math.round(rx * coords.x) + 'px',
            marginTop: '-' + Math.round(ry * coords.y) + 'px'
        });
        $('#x').val(coords.x);
        $('#y').val(coords.y);
        $('#w').val(coords.w);
        $('#h').val(coords.h);
    };
    
    $('#submit-avatar').click(function(e) {
    	e.preventDefault();
    	var form = $(this).closest('form');
    	$.ajax({
    		type: 'POST',
    		url: form.attr('action'),
    		dataType: 'json',
    		data: form.serialize(),
    		success: function(data) {
    			if (data.Status == 'OK') {
    				$('#avatar-image').attr('src', data.ImageUrl);
    			} else {
    				alert("Server Error!");
    			}
    		}
    	});
    });

    $('#submit-avatar').click(function(e) {
    	e.preventDefault();
    	var form = $(this).closest('form');
    	$.ajax({
    		type: 'POST',
    		url: form.attr('action'),
    		dataType: 'text',
    		data: form.serialize(),
    		success: function(data) {
    			if (data.Status == 'OK') {
    				$('#avatar-image').attr('src', data);
    			} else {
    				alert("Server Error!");
    			}
    		}
    	});
    }); */
</script>
</head>
<body>
	<div id="avator-croper">
    <div>
		<!-- upload form -->
        <form id="upload-form" target="upload_target" method="post" action="UploadAvator" enctype="multipart/form-data">
            <input type="file" name="file" /> <input type="submit" id='upload-avator' value="Upload" />
        </form>
        <iframe id="upload_target" name="upload_target" src="" style="display:none"></iframe>
    </div>

    <div id="crop-area" style="display:none">
        <div>
            <img id="cropbox" src="" />		<!-- original image -->
        </div>
        <div style="width: 150px; height: 150px; overflow: hidden; margin-left: 5px; margin-top: 10px">
            <img id="preview" src="">		<!-- preview image -->
        </div>
    </div>
    
    <div>
        <form action="CropAvator" method="post">
            <input type="hidden" id="x" name="x" />
            <input type="hidden" id="y" name="y" />
            <input type="hidden" id="w" name="w" />
            <input type="hidden" id="h" name="h" />
            <button type="submit" id="submit-avatar">Crop Image</button>
        </form>
    </div>
</div>
</body>
</html>