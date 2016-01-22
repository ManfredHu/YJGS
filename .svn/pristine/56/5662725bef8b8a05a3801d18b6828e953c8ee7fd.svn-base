<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.yjgs.bll.ManagerBll"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改用户名-网站后台管理</title>
<link rel="stylesheet" href="../Css/AccountManage.css" />
<script type="text/javascript" src="../JS/login.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="修改用户名" name="now" />
</jsp:include>
<div id="main">
	<%
		ManagerBll mBll = new ManagerBll();
		try{
			int userID = (Integer) session.getAttribute("UserID"); 
			mBll.loadInfo(userID, out);
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("judge", "false");
			request.setAttribute("text", "错误的操作");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Tips/ErrorTips.jsp").forward(
					request, response);
			return;
		}
		
	%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>