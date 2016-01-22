<%@page import="com.yjgs.bll.ProductBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<link rel="stylesheet" href="../Css/Product.css" />
<%
	int typeID = 0;	
	int productID = 0;
	String productName = null;
	ProductBll pBll = null;
	
	if(request.getParameter("typeID")!= null) {
		
		typeID = Integer.valueOf(request.getParameter("typeID"));
	}
	
	try {
		productID = Integer.valueOf(request.getParameter("productID"));
	} catch (Exception e) {
		System.out.println("错误的操作");
		e.printStackTrace();
		request.setAttribute("judge", "false");
		request.setAttribute("text", "错误的操作");
		request.setAttribute("URL", "../FirstPage/FirstPage.jsp");
		request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
				request, response);
		return;
	}
	pBll = new ProductBll();
	//获取产品名称
	productName = pBll.getProductName(productID);
%>
<title><%=productName%></title>
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品管理-产品查看与修改" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="ProductList.jsp">产品中心</a>><a href="#">产品基本信息</a></span>
	</div>
	<jsp:include page="TypeList.jsp">
		<jsp:param value="<%=typeID %>" name="typeID" />
	</jsp:include>
	<div id="productList">
		<h2>
			<span class="proDisplay">产品基本信息</span>
		</h2>
		<div class="productPicList pad">
			<h3>
				<span class="je">产品名称</span><span class="eng">Products Name：</span><span class="productTi"><%=productName%></span>
			</h3>
			<div class="productPic">
				<h4><span class="je">产品展示</span><span class="eng">Products Exhibition：</span></h4>
				<%
					pBll.loadPreviewPic(out, productID);
				%>
			</div>
			<div class="productParam">
				<%
					pBll.loadProductParam(out, productID);
				%>
			</div>

			<div class="productIntroduce">
				<div>
					<%
						pBll.loadProIntroduce(out, productID);
					%>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../JS/UserProduct.js"></script>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>