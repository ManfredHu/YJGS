<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.AdviceBll"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>反馈管理-网站后台管理</title>
<link rel="stylesheet" href="../Css/advise.css" />
<script type="text/javascript" src="../JS/ManagerNews.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="反馈管理" name="now" />
</jsp:include>
<div id="main">
	<%
		int typeID = 0;
		int curPage = 1;
		int pageNum = 1;
		if(request.getParameter("page")!= null) {
			
			curPage = Integer.valueOf(request.getParameter("page"));
		}
		
		AdviceBll pBll = new AdviceBll();
		pageNum = pBll.getPageNum();
		if(curPage > pageNum) {
			
			response.sendRedirect("../AdviceManage/ManageAdvice.jsp?page=" + (curPage-1));
			return;
		}
%>
<%
		//加载先前的建议反馈
		AdviceBll adviceBll = new AdviceBll();

		pBll.loadProductList(out, curPage);
		
%>
	<div id="PageList">
		<%
			//加载页码选项
			pBll.loadManPageLinks(out,request);
		%>
	</div>
	<form class="changePageForm" method="post" action="GoToAdvicesPage">
		<span>当前第<span id="pageNow"><%= curPage %></span>页,</span>
		<span>共<%= pageNum %> 页,</span>
		<span>跳转到</span>
		<select class="changePage" name="page" >
			<%
				pBll.loadPageOption(out,pageNum);
			%>
		</select>
		<input type="hidden" name="typeID" value=<%= typeID %> />
		<span>页</span>
		<input class="sure" type="submit" value="确定" />
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>
