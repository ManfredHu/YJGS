<%@page import="com.yjgs.bll.ProductManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>类别管理-网站后台管理</title>
<link rel="stylesheet" href="../Css/ProductType.css" />
<script type="text/javascript" src="../JS/ProductType.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="类别管理" name="now" />
</jsp:include>
<div id="main">
	<form id="TypeManage" method='post' action='ModifyType'>
		<table>
			<caption>产品类别管理</caption>
			<thead>
				<tr>
					<th class="number">编号</th>
					<th class="typeName">类别名称</th>
					<th class="productNum">产品数量</th>
					<th class="modify">修改</th>
					<th class="delete">删除</th>
				</tr>
			</thead>
			<tbody>
				<%
					ProductManageBll proBll = new ProductManageBll();
					proBll.loadProductTypeList(out);
				%>
			</tbody>
		</table>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>