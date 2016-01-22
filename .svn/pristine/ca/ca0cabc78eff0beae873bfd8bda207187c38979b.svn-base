<%@page import="com.yjgs.bll.ProductManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>添加新产品-网站后台管理</title>
<link rel="stylesheet" href="../Css/ProductAdd.css" />
<script type="text/javascript" src="../JS/AddProduct.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="添加新产品" name="now" />
</jsp:include>
<div id="main">
	<form id="AddProduct" action="AddProduct1" method="post">
		<div class="chooType">
			<span>选择类别：</span>
			<select name="type" class="chooType">
			<%
				ProductManageBll pmBll = new ProductManageBll();
				pmBll.loadTypeOption(out);
			%>
			</select>
		</div>
		<div class="inputname">
			<span>产品名称：</span> <input id="proName" type="text" name="productName" />
		</div>
		<div class="paramAdd">
			<span>参数编辑：</span>
			<table id="paramsTable">
				<thead>
					<tr>
						<th class="paramName">参数名</th>
						<th class="paramValue">参数值</th>
						<th class="deleteBtn">删除</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="names" /></td>
						<td><input type="text" name="values" /></td>
						<td><input class="deletebtn" type="button" value="删除"
							onclick="deleteParam(this)"></td>
					</tr>
				</tbody>
			</table>
			<input id="addParamBtn" type="button" onclick="addParam()" value="添加新参数" />
		</div>
		<input id="nextBtn" onclick="return checkAll();" type="submit" name="submit" value="下一步" />
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>