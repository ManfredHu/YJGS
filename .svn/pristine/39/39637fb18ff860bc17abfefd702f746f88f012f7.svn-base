<%@page import="com.yjgs.bll.NewsTypeBll"%>
<%@page import="com.yjgs.bll.NewsBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>新闻中心</title>
<link rel="stylesheet" href="../Css/News.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="新闻中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="ShowTypeNews.jsp">新闻中心</a></span>
	</div>
	<jsp:include page="ShowNewsType.jsp"></jsp:include>
	<%
		int typeID = 0;
		int curPage = 1;
		int pageNum = 1;
		if (request.getParameter("typeID") != null) {

			typeID = Integer.valueOf(request.getParameter("typeID"));
		}
		if (request.getParameter("page") != null) {

			curPage = Integer.valueOf(request.getParameter("page"));
		}

		//ProductBll pBll = new ProductBll();
		NewsBll pBll = new NewsBll();
		pageNum = pBll.getPageNum(typeID);
		if (curPage > pageNum) {

			response.sendRedirect("../NewsManage/ManagerNews.jsp?typeID="
					+ typeID + "&page=" + (curPage - 1));
			return;
		}
	%>
	<div id="productList">
		<h2>
			<span class="newsList">新闻列表</span> <span class="en">News</span>
		</h2>
		<div class="productPicList">
			<%
				//实例化数据逻辑层，加载所有新闻列表

				NewsTypeBll newsTypeBll = new NewsTypeBll();

				/* newsTypeBll.loadAllNewsType(out);  */
			%>
			<%
				//int TypeID = Integer.parseInt(request.getParameter("id"));

				//NewsTypeBll newsTypeBll = new NewsTypeBll();

				newsTypeBll.LoadAllNews(typeID, out, curPage);
			%>

			<div id="pageNum">
				<div id="aList">
					<%
						//加载页码选项
						pBll.loadPageLink(out, typeID, curPage);
					%>
				</div>
				<form method="post" action="GoToNewsPage2" class="toOtherPage">
					<span>当前第<span id="curPage"><%=curPage%></span>页,
					</span> <span>共<%=pageNum%>页,
					</span> <span>跳转到</span> <select name="page">
						<%
							pBll.loadPageOption(out, pageNum);
						%>
					</select> <input type="hidden" name="typeID" value=<%=typeID%> /> <span>页</span>
					<input type="submit" value="确定" />
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/DeleteNowPage.js"></script>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	goTopEx();
</script>