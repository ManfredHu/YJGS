<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../Master/adminMaster_header.jsp"></jsp:include>
<title>回复申诉</title>
<link rel="stylesheet" href="../Css/NewRemind.css" />
<jsp:include page="../Master/adminMaster_header2.jsp" flush="true">
	<jsp:param value="查看普通管理员忘记密码申述" name="now" />
</jsp:include>
<div id="main">
<%
	String email = null;
	try{
		 email =request.getParameter("email");
		if(email==null){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "数据传递出错！");
			request.setAttribute("URL", "../ManagerComplaint/NewsRemind.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
	}
	catch(Exception e){
		e.printStackTrace();
		request.setAttribute("judge", "false");
		request.setAttribute("text", "数据传递出错！");
		request.setAttribute("URL", "../ManagerComplaint/NewsRemind.jsp");
		request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
		return;
	}
	email =request.getParameter("email");
	//int id=Integer.parseInt(request.getParameter("id"));
%>
<form action="ManagerComplaintSel" method="post">

		<h3 style="text-align: center;">申述回复</h3>
		<div class="rEmail">回复邮箱：<span><%=email %></span></div>
		<input type="hidden" name="email" value=<%=email %>>
		<div class="lp">我的邮箱：<input class="inp" type="text" name="myEmail" /></div>
		<div class="lp">邮箱密码：<input class="inp" type="password" name="password" /></div>
		<div class="lp">邮箱标题：<input class="inp" type="text" name="title" value="yjgs邮件申述回复"/></div>
		<input type="hidden" name="cid" value=<%=request.getParameter("Id") %> />
		<div class="lp">回复内容：<textarea class="tx" name="text">【管理员回复】你好</textarea></div>
		<div class="lp tip">友情提醒：在发送邮箱前，请检查你的邮箱是否开启SMTP和POP服务，如无，邮件发送将失败！</div>
		<input class="btnp" style="margin-top:50px;margin-left:450px;" type="submit" value="提交" />
</form>
</div>
<jsp:include page="../Master/adminMaster_footer.jsp"></jsp:include>