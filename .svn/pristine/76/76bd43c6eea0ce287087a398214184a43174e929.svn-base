<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<jsp:include page="adminMaster_header.jsp"></jsp:include>
<title>操作提示页面-网站后台管理</title>
<jsp:include page="adminMaster_header2.jsp">
	<jsp:param value="操作提示页面" name="now"/>
</jsp:include>
<div id="main">
	<%
		//取得参数正确或错误显示图片
		String judge = "";
		String text = "";
		String URL = "";
		
		//是否操作成功
		if (request.getAttribute("judge") != null)
			judge = request.getAttribute("judge").toString();
		if (judge != "") {
			if (judge == "true")
				out.write("<p class='succeed'>操作成功</p>");
			else
				out.write("<p class='fail'>操作失败</p>");
		}
		
		//传递要显示的页面文本text
		if (request.getAttribute("text") != null)
			text = request.getAttribute("text").toString();
		if (text != "")
			out.write("<p class='textCenter pmargin' >" + text + "</p>");
		
		//设置3秒后跳转
		if (request.getAttribute("URL") != null)
			URL = request.getAttribute("URL").toString();
		if (URL != "") {
			
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("refresh","3;url = " + URL);
			
		}
	%>
	<p class='textCenter'>页面将在3秒后跳转,<a href="<%= URL %>" >立即跳转</a></p>
</div>
<jsp:include page="adminMaster_footer.jsp"></jsp:include>