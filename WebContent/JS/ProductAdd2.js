/**
 * 添加产品页面2
 */
$(function() {
	var jcrop_api, boundx, boundy;
	// 使原图具有裁剪功能
	$('#target').Jcrop({
		onChange : updatePreview,
		onSelect : updatePreview,
		aspectRatio : 14 / 9
	}, function() {
		// Use the API to get the real image size
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		// Store the API in the jcrop_api variable
		jcrop_api = this;
	});
	// 裁剪过程中，每改变裁剪大小执行该函数
	function updatePreview(c) {
		if (parseInt(c.w) > 0) {
			$('#preview').css({
				width : Math.round(210 / c.w * boundx) + 'px',
				height : Math.round(135 / c.h * boundy) + 'px',
				marginLeft : '-' + Math.round(210 / c.w * c.x) + 'px',
				marginTop : '-' + Math.round(135 / c.h * c.y) + 'px'
			});
			$('#width').val(c.w); // c.w 裁剪区域的宽
			$('#height').val(c.h); // c.h 裁剪区域的高
			$('#x').val(c.x); // c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标
			$('#y').val(c.y); // c.y 裁剪区域顶点的y坐标

		}
	}
	;
});
function uploading3(one) {
	var allowExt = ".jpg,.jpeg,.png,.bmp,.gif"; // 支持的扩展名
	var fileExt = one.value.substr(one.value.lastIndexOf('.')).toLowerCase();
	if (allowExt.indexOf(fileExt) == -1) {
		alert("上传图片的类型错误！仅支持jpg,gif,png,bmp,png格式图片");
		return;
	} else {
		var ff = document.getElementById('IntroPicUpload');
		if(ff!=null){
			ff.submit();
		}
	}

}
function uploading2(one) {
	var allowExt = ".jpg,.jpeg,.png,.bmp,.gif"; // 支持的扩展名
	var fileExt = one.value.substr(one.value.lastIndexOf('.')).toLowerCase();
	if (allowExt.indexOf(fileExt) == -1) {
		alert("上传图片的类型错误！仅支持jpg,gif,png,bmp,png格式图片");
		return;
	} else {
		var ff = document.getElementById('LogoUpload');
		if(ff!=null){
			ff.submit();
		}
	}

}
function uploading(one) {
	var allowExt = ".jpg,.jpeg,.png,.bmp,.gif"; // 支持的扩展名
	var fileExt = one.value.substr(one.value.lastIndexOf('.')).toLowerCase();
	if (allowExt.indexOf(fileExt) == -1) {
		alert("上传图片的类型错误！仅支持jpg,gif,png,bmp,png格式图片");
		return;
	} else {
		var ff = document.getElementById('PicUpload');
		if(ff!=null){
			ff.submit();
		}
	}

}