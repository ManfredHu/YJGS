<%@page import="sun.security.util.PropertyExpander.ExpandException"%>
<%@page import="com.yjgs.bll.NewsBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>新闻详情</title>
<link rel="stylesheet" href="../Css/News.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="新闻中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="ProductList.jsp">新闻中心</a></span>
	</div>
	<jsp:include page="ShowNewsType.jsp"></jsp:include>
	<div id="productList">
		<h2>
			<span class="newsList">新闻详情</span> <span class="en">News</span>
		</h2>
		<div class="productPicList detail">
			<%
				NewsBll nBll = new NewsBll();

				try {
					int NewsID = Integer.parseInt(request.getParameter("newsID"));
					nBll.LoadNewsInfo(NewsID, out);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("judge", "false");
					request.setAttribute("text", "错误的操作");
					request.setAttribute("URL", "../FirstPage/FirstPage.jsp");
					request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
							request, response);
					return;
				}
			%>
		</div>
	</div>

</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	goTopEx();
</script>