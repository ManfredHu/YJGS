<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>设置密保问题</title>
<link rel="shortcut icon" href="../Image/adminLogo.ico" />
<link rel="stylesheet" href="../Css/WritePPProblem.css" />
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body>
	<form id="writeProblem" action="WritePPProblemSel" method="post">
		<h1>设置密保问题</h1>
		<div>
			<ul>
				<li><span>第一个密保问题：</span> <input type="text" name="problem1"
					onblur="checkProblem(this);" onfocus="blue(this);"
					placeholder="请输入第一个问题..." /></li>
				<li class="answer"><span>答案：</span> <input type="text"
					name="answer1" onblur="checkAnswer(this);" onfocus="blue(this);"
					placeholder="请输入第一个问题答案..." /></li>
				<li class="problem"><span>第二个密保问题：</span> <input type="text"
					name="problem2" onblur="checkProblem(this);" onfocus="blue(this);"
					placeholder="请输入第二个问题..." /></li>
				<li class="answer"><span>答案：</span> <input type="text"
					name="answer2" onblur="checkAnswer(this);" onfocus="blue(this);"
					placeholder="请输入第二个问题答案..." /></li>
				<li class="problem"><span>第三个密保问题：</span> <input type="text"
					name="problem3" onblur="checkProblem(this);" onfocus="blue(this);"
					placeholder="请输入第三个问题..." /></li>
				<li class="answer"><span>答案：</span> <input type="text"
					name="answer3" onblur="checkAnswer(this);" onfocus="blue(this);"
					placeholder="请输入第三个问题答案..." /></li>
				<li><input onclick="return checkProblemAndAnswer(this);"
					id="login" type="submit" value="提交" /></li>
	
			</ul>
		
		<%
			if (request.getParameter("errorInfo") != null) {
				out.print("<p id='error'>" + request.getParameter("errorInfo")
						+ "</p>");
			}
		%>
		</div>
	</form>
</body>
</html>