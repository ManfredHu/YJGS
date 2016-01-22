<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title><%= application.getServerInfo() %></title>
<body>
上传文件程序应用示例
<form action='doUpload.jsp' method='post' enctype='multipart/form-data'>
<%-- 类型enctype用multipart/form-data，这样可以把文件中的数据作为流式数据上传，不管是什么文件类型，均可上传。--%>
请选择要上传的文件<input type='file' name='upfile' size='50'>
<input type='submit' value='提交'>
</form>
</body>
</html>