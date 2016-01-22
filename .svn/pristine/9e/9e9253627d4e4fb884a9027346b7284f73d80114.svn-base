<%@page import="com.yjgs.bll.NewsBll"%>
<%@page import="com.yjgs.bll.NewsTypeBll"%>
<%@page import="com.yjgs.dcl.*"%>
<%@page import="com.yjgs.dal.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改新闻内容</title>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="../Css/NewsUpdate.css" />
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="新闻管理-修改新闻内容" name="now" />
</jsp:include>
<div id="main">
	<%
		NewsBll newsbll = new NewsBll();
		try {
			String News = request.getParameter("newsID");
			int id = Integer.parseInt(News);

			newsbll.LoadUpdateNews(out, id);
		} catch (Exception e) {
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据传递出错！");
			request.setAttribute("URL", "../NewsManage/ManagerNews.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp")
					.forward(request, response);
			return;
		}
	%>
	<script type="text/javascript">
		var editor = CKEDITOR.replace('Text');
	</script>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>