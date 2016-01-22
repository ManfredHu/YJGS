<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>添加新闻类别</title>
<link rel="stylesheet" href="../Css/AddNewsType.css" />
<script type="text/javascript">
		var sum = 0;
		function addType(){
			var area = document.getElementById("TypeArea");
			if(sum==3){
				alert("一次最多新增四个类别！");
				return;
			}
			//增加文本框
			var input=document.createElement("input");	
			input.type="text";
			input.name="NewsType";
			area.appendChild(input);
			sum++;
		}
</script>
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="添加新类别" name="now" />
</jsp:include>
<div id="main">
	<form id="ProductTypeAdd" action="AddNewsTypeSel" method="post">
		<div class="spanAndTypeArea">
			<span>新闻新类别:</span>
			<div id="TypeArea">
				<input type="text" name="NewsType" />
			</div>
		</div>
		<a href="#" onclick="addType();return false;">新增类别</a>
		<input class="typeAddBtn" type="submit" value="添加" />
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>