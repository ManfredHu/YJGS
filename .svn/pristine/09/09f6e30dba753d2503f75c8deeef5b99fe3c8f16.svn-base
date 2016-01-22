<%@page import="com.yjgs.bll.ComplaintBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>具体申诉查询</title>
<link rel="stylesheet" href="../Css/NewRemind.css" />
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="申述详情" name="now" />
</jsp:include>
<div id="main">
<%
	int ComplaintID=0;
	String ManagerName = null;
	int userId = 0;
	try{
		ComplaintID = Integer.parseInt(request.getParameter("Id"));
		ManagerName = request.getParameter("ManaName");
		ManagerName = new String(ManagerName.getBytes("iso-8859-1"),"UTF-8");
		userId = Integer.parseInt(request.getParameter("UserID"));
		
		if(ComplaintID==0||ManagerName==null||userId==0){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据传递出错！");
			request.setAttribute("URL", "../ManagerComplaint/NewsRemind.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ComplaintBll cBll = new ComplaintBll();
		cBll.loadComplaint(userId,ComplaintID,ManagerName,out,request,response);
	}
	catch(Exception e){
		e.printStackTrace();
		request.setAttribute("judge", "false");
		request.setAttribute("text", "数据传递出错！");
		request.setAttribute("URL", "../ManagerComplaint/NewsRemind.jsp");
		request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
		return;
	}
	//int userId = (int)session.getAttribute("UserID");
	
%>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>