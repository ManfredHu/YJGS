<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../ckeditor/contents.css">  
    <script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
</head>
<body>
	<form action="" method="post">
		<textarea rows="10" cols="10" id="introduce" name="introduce">
			<h2>你好！！</h2><h3>你们好！</h3>
		</textarea> 
		<input type="submit" value="提交" /> 
		<script type="text/javascript">
		//<![CDATA[
			// Replace the <textarea id="editor1"> with an CKEditor instance.
			var editor = CKEDITOR.replace('introduce');
		//]]>
		</script>
	</form>
</body>
</html>