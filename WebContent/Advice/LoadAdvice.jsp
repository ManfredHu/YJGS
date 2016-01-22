<%@page import="com.yjgs.bll.AdviceBll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Master/masterPage_header.jsp"></jsp:include>
<title>建议反馈</title>
<script type="text/javascript" src="../JS/login.js"></script>
<link rel="stylesheet" href="../Css/Advice.css" />
<jsp:include page="../Master/masterPage_header2.jsp">
	<jsp:param value="产品中心" name="now" />
</jsp:include>
<div id="content">
	<div class="nowTips">
		<span>您当前的位置：<a href="LoadAdvice.jsp">建议反馈</a></span>
	</div>
	<%
		int typeID = 0;
		int curPage = 1;
		int pageNum = 1;
		if (request.getParameter("page") != null) {

			curPage = Integer.valueOf(request.getParameter("page"));
		}

		AdviceBll pBll = new AdviceBll();
		pageNum = pBll.getPageNum();
		if (curPage > pageNum) {

			response.sendRedirect("../Advice/LoadAdvice.jsp?page="
					+ (curPage - 1));
			return;
		}
	%>
	<%
		//加载先前的建议反馈
		AdviceBll adviceBll = new AdviceBll();

		pBll.loadAdvicesList(out, curPage);
	%>
	<div id="pageNum">
		<%
			//加载页码选项
			pBll.loadPageLinks(out, request);
		%>
		<form class="productForm" method="post" action="GoToAdvicePage">
		<span>当前第<span id="pagenow"><%=curPage%></span>页,
		</span> <span>共<%=pageNum%>页,
		</span> <span>跳转到</span> <select name="page">
			<%
				pBll.loadPageOption(out, pageNum);
			%>
		</select> <input type="hidden" name="typeID" value=<%=typeID%> /> <span>页</span>
		<input type="submit" value="确定" />
	</form>
	</div>
	
	<form class="formforadvise" action="AdviceDealSel" method="post">
		<div>
			<span class="one"><span class="number">1</span>反馈内容：</span>
			<textarea onfocus="blue(this);" onblur="isNull(this);" placeholder="请输入建议内容..." class="textareaforadvise" name="text"></textarea>
		</div>
		<div>
		<span class="one"><span class="number">2</span>您的邮箱：</span>
		<input class="textinput youxiang" type="text" name="email" placeholder="请输入邮箱..." onfocus="blue(this);" onblur="checkEmail(this)" /> 
		</div>
		<div class="divyzm">
		<input class="textinput" type="text"
			name="yanzhengma" id="yanzhengma" placeholder="请输入验证码..."
			maxlength="4" onfocus="blue(this);" onblur="checkNum(this)" />
			<a id="checkNum" href="javascript:changeImage();"> 
				<img alt="验证码 " src="Yanzhengma" width="100" height="30" id="imgRandom" />
			</a> 
		</div>
		<input class="save" type="submit" value="提交" />
	</form>
</div>
<jsp:include page="../Master/masterPage_footer.jsp"></jsp:include>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script type="text/javascript">
	DeleteProductPage();
	function changeAdvise() {
		var list = $(".adminReply");
		for(var i=0;i<list.length;i++){
			if(list[i].innerHTML!="管理员回复：暂无"){
				list[i].parentNode.style.backgroundPosition = "-139px -56px";
			}else{
				list[i].remove();
			}
		}
	}
	addLoadEvent(changeAdvise);
</script>