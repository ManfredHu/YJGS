<%@page import="com.yjgs.bll.ProductBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>产品搜索</title>
<link rel="stylesheet" href="../Css/ProductSearch.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="ProductList.jsp">产品搜索</a></span>
	</div>
	<form id="searchBox" action="ProductSearch" method="post">
		<span>产品搜索：</span>
		<input class="textBox" type="text" name="keyWords" maxlength="100"
			value="请输入关键字..." onfocus="if(this.value=='请输入关键字...')this.value=''"
			onblur="if(this.value=='')this.value='请输入关键字...'"/>
		<input class="button" type="submit" value="搜索" />
	</form>
	
	<%
		String keyWords = null;
		int curPage = 1;
		
		//获取当前页码
		if(request.getParameter("page") != null) {
			
			curPage = Integer.valueOf(request.getParameter("page"));
		}
		
		//获取关键字
		try {
			
			keyWords = new String(request.getParameter("keyWords").getBytes("ISO-8859-1"),"UTF-8") ;
		}catch(Exception e) {
			
			System.out.println("错误的操作");
			e.printStackTrace();
	
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../FirstPage/FirstPage.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
					request, response);
			return;
		}
	
		//加载结果
		ProductBll pBll = new ProductBll();
		int pageNum =  pBll.productSearch(keyWords, curPage, out);
		
		//加载页码列表
		pBll.loadSearchPageList(out, keyWords,pageNum,curPage);
	%>
	<span id='pagenow' style="display:none;"><%= curPage %></span>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script>
	DeleteProductPage();
</script>