<%@page import="com.yjgs.bll.AdviceBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>修改建议反馈内容</title>
<link rel="stylesheet" href="../Css/advise.css" />
<jsp:include page="../Master/adminMaster_header2.jsp">
	<jsp:param value="反馈管理-查看发聩详情" name="now" />
</jsp:include>
<div id="main">
<%
		int AdviceID = 0;
		try{
		 AdviceID = Integer.parseInt(request.getParameter("id"));
		}
		catch(Exception e){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据传递出错！");
			request.setAttribute("URL", "ManageAdvice.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		AdviceBll Advice = new AdviceBll();
		
		Advice.loadManAdvice(AdviceID,out);
%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>