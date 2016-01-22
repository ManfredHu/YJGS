<%@page import="com.yjgs.bll.ProductBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>产品中心</title>
<link rel="stylesheet" href="../Css/Product.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="ProductList.jsp">产品中心</a></span>
	</div>
	
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
		
		ProductBll pBll = new ProductBll();
		pageNum = pBll.getPageNum(typeID);
		if(curPage > pageNum) {
			
			response.sendRedirect("../Product/ProductList.jsp?typeID="
			+ typeID + "&page=" + (curPage-1));
			return;
		}
	%>
	<jsp:include page="TypeList.jsp">
		<jsp:param value="<%=typeID %>" name="typeID" />
	</jsp:include>
	<div id="productList">
		<h2>
			<span class="proDisplay">产品展示</span>
			<span class="en">Product</span>
		</h2>
		<div class="productPicList">
		<div class="checkdiv2">
			<jsp:include page="../Product/SearchBox2.jsp"></jsp:include>
			<div class="downAndUp">
				<span><span id="pagenow"><%=curPage%></span>/<%= pageNum %></span>
				<a class="uppage" href="ProductList.jsp?typeID=<%=typeID %>&page=<%=curPage -1 %>" 
				 <%=curPage == 1? "style='display: none'":"" %>>上一页</a>
				<a class="downpage" href="ProductList.jsp?typeID=<%=typeID %>&page=<%=curPage +1 %>" 
				 <%=curPage == pageNum? "style='display: none'":"" %>>下一页</a>
			</div>
			
		</div>
			<%
				//加载产品列表
				pBll.loadProductList(out, typeID, curPage);
			%>
			<div id="pageNum">
				<%
					//加载页码选项
					pBll.loadPageLinks(out, typeID, curPage);
				%>
				<form class="productForm" method="post" action="GoToPage">
					<span>到</span>
					<select name="page" >
						<%
							pBll.loadPageOption(out, pageNum);
						%>
					</select>
					<span>页</span>
					<input type="submit" value="确定" />
					<input type="hidden" name="typeID" value=<%= typeID %> />
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/DeleteNowPage.js"></script>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	DeleteProductPage();
	goTopEx();
	addLoadEvent(changeLiHover);
</script>