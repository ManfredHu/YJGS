<%@page import="com.yjgs.bll.NewsBll"%>
<%@page import="com.yjgs.bll.NewsTypeBll" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>管理新闻-网站后台管理</title>
<link rel="stylesheet" href="../Css/ManagerNews.css" />
<script type="text/javascript" src="../JS/ManagerNews.js"></script>
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="新闻管理-管理全部新闻" name="now" />
</jsp:include>
<div id="main">
<%
		int typeID = 0;
		int curPage = 1;
		int pageNum = 1;
		if(request.getParameter("typeID")!= null) {
			
			typeID = Integer.valueOf(request.getParameter("typeID"));
		}
		if(request.getParameter("page")!= null) {
			
			curPage = Integer.valueOf(request.getParameter("page"));
		}
		
		//ProductBll pBll = new ProductBll();
		NewsBll pBll = new NewsBll();
		pageNum = pBll.getPageNum(typeID);
		if(curPage > pageNum) {
			
			response.sendRedirect("../NewsManage/ManagerNews.jsp?typeID="
			+ typeID + "&page=" + (curPage-1));
			return;
		}
	%>
	<div>
		<form id="typeOptions" action="chooseTypeSel" method="post">
			<span>选择类别：</span>
			<select name="typeID" onchange="typeChange(this)">
					<%
					pBll.NewsTypeLoad(out,request);
					%>
			</select>
		</form>
		<%
			//加载新闻列表
			pBll.loadProductList(out, typeID, curPage);
		%>
	</div>
	<div id="PageList">
		<%
			//加载页码选项
			pBll.loadPageLinks(out, typeID, curPage);
		%>
	</div>

	<form class='changePageForm' method="post" action="GoToNewsPage">
		<span>当前第<span id="pageNow"><%=curPage%></span>页,</span>
		<span>共<%= pageNum %>页,</span>
		<span>跳转到</span>
		<select class='changePage' name="page" >
			<%
				pBll.loadPageOption(out, pageNum);
			%>
		</select>
		<input type="hidden" name="typeID" value=<%= typeID %> />
		<span>页</span>
		<input class='sure' type="submit" value="确定" />
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>