<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>添加新产品-添加产品介绍</title>
<link rel="stylesheet" href="../Css/ProductAdd.css" />
<link rel="stylesheet" type="text/css" href="../ckeditor/contents.css">  
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="添加新产品-添加产品介绍" name="now" />
</jsp:include>
<div id="main">
	<%
		int productID = 0;
		try {
			productID = Integer.valueOf(request.getParameter("productID"));
		}catch(Exception e) {
			System.out.println("获取产品ID失败，错误的操作");
			e.printStackTrace();
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(
					request, response);
			return;
		}
	%>
	<h2>第二步：编辑产品介绍</h2>
	<form action="Addproduct3" method="post" id="ckeditor">
		<textarea rows="10" cols="10" id="introduce" name="introduce"></textarea> 
		<input type="hidden" name="productID" value=<%=productID %> />
		<input id="nextBtn2" type="submit" value="提交" /> 
		<script type="text/javascript">
		//<![CDATA[
			// Replace the <textarea id="editor1"> with an CKEditor instance.
			var editor = CKEDITOR.replace('introduce');
		//]]>
		</script>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>