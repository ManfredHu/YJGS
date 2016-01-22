<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布新产品</title>
</head>
<body>
<form action="UploadProductSel" method="post" enctype="multipart/form-data">
	产品图片：<input type="file" name="photo" />
	<input type="submit" value="提交" />
	<%
		String realPath =  request.getSession().getServletContext().getRealPath("/");
		out.println("<h2>"+ realPath +"</h2>");
		String projectPath =  System.getProperty("user.dir");
		out.println("<h2>"+ projectPath +"</h2>");
		String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
		out.println("<h2>"+ t +"</h2>");
	%>
</form>
</body>
</html>