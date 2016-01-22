<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加 公司联系方式</title>
<script type="text/javascript">
		function addRelation(){
			var area = document.getElementById("textArea");
			
			//增加文本框1
			var input=document.createElement("input");	
			input.type="text";
			input.name="content1";
			area.appendChild(input);
			
			//增加：
			var ss = document.createElement("span");
			ss.innerHTML=":";
			area.appendChild(ss);
			
			//增加文本框2
			var input=document.createElement("input");	
			input.type="text";
			input.name="content2";
			area.appendChild(input);
		}
</script>
</head>
<body>
<form action="AddRelationSel" method="post">
		新增联系方式：<input type="text" name="content1" />:<input type="text" name="content2" />
		<span id="textArea"></span>
		<input type="submit" value="提交" />
</form>
		<a href="" onclick="addRelation();return false;">新增联系方式</a>
</body>
</html>