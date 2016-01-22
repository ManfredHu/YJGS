<%@page import="com.yjgs.bll.FirstPageManageBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>底部信息修改-网站后台管理</title>
<script type="text/javascript" src="../JS/BottomParam.js"></script>
<link rel="stylesheet" href="../Css/ProductAdd.css" />
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="底部信息修改" name="now" />
</jsp:include>
<div id="main">
	<span class="paramSet">参数信息：</span>
	<form method="post" action="UpdatePageBottomInfo">
		<table id="paramsTable">
			<thead>
				<tr>
					<th>参数名</th>
					<th>参数值</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody id="paramTableBody">
				<%
					//加载产品参数
					FirstPageManageBll fpBll = new FirstPageManageBll();
					int curParamNum = fpBll.loadParams(out);
				%>
			</tbody>
		</table>
		<input type="button" onclick="addParam()" value="添加信息" id="addParamBtn" /> <input
			type="submit" value="更新信息" id="nextBtn" />
		<script type="text/javascript">
			curParamNum =<%=curParamNum%>;
		</script>
	</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>