<%@page import="com.yjgs.bll.ProductBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="proNav">
	<h2><span class="allPro">全部产品分类</span></h2>
	<ul>
	<%
		int typeID = 0;
		String sTypeID = request.getParameter("typeID");
		//获取当前选中类别
		if(sTypeID != null) {
			typeID = Integer.valueOf(sTypeID);
		}
		
		
		ProductBll pBll = new ProductBll();
		pBll.loadTypeList(typeID,out);
	%>
	</ul>
</div>
