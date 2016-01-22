<%@page import="com.yjgs.bll.ProductManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>产品管理-产品列表</title>
<script type="text/javascript" src="../JS/ProductList.js"></script>
<link rel="stylesheet" href="../Css/ProductList.css" />
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="产品管理-产品列表" name="now" />
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
		ProductManageBll pmBll = new ProductManageBll();
		pageNum = pmBll.getPageNum(typeID);
		if(curPage > pageNum) {
			response.sendRedirect("../ProductManage/ProductList.jsp?typeID="
			+ typeID + "&page=" + (curPage-1));
			return;
		}
	%>
	<form id="typeOptions" action="TypeChangeForList" method="post" >
		<span>选择类别：</span>
		<select name='typeID' onchange="typeChange(this)">
		<%
			//加载类别选项
			pmBll.loadTypeOption_B(out,request);
		%>
		</select>
	</form>
	<table class="tb">
		<thead>
			<tr>
				<th class="productName">产品名称</th>
				<th class="publishTime">发布时间</th>
				<th class="smartPic">预览图</th>
				<th class="detail">详细信息</th>
				<th class="delete">删除</th>
			</tr>
		</thead>
		<tbody>
			<%
				//加载产品列表数据
				pmBll.loadProductList(out, request);
			%>
		</tbody>
	</table>
	<p class="nowPage">当前页：<span id="curPage"><%= curPage %></span></p>
	<div class="PageList">
		<%
			//加载页码选项
			pmBll.loadPageLinks(out, request);
		%>
	</div>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>