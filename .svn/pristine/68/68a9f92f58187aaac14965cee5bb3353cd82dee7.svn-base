<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.yjgs.bll.MessageBll"%>
</head>
<body>
	<div id="aheader">
		<div id="mycenter">
			<a id="logo" href="../welcome/adminIndex.jsp">网站后台管理系统</a>
			<div class="atopright">
				<span>欢迎您，</span>
				<%
					try {
						String username = session.getAttribute("UserName").toString();
						out.print("<a id='name' href='../PermissionViewAndApply/PermissionStatus.jsp'>"
								+ username + "</a>");

					} catch (Exception e) {
						System.out.println("获取用户名错误！");
						e.printStackTrace();
						out.print("<a id='name' href='../PermissionViewAndApply/PermissionStatus.jsp'>管理员</a>");

					}
					MessageBll mBll = new MessageBll();
					mBll.loadMessageLink(out, request);
				%>
				<a id="exit" href="../ManagerLogin/goBack">退出</a>
			</div>
		</div>
	</div>
	<div id="acontent">
		<div id="mycenter">
			<div class="top">
				<span>您当前的位置：</span>
				<%
					request.setCharacterEncoding("UTF-8");
					String now = request.getParameter("now");
					if (now != null & !"".equals(now)) {
						out.write("<a id='now' href='#'>" + now + "</a>");
					} else {
						out.write("<a id='now' href='#'></a>");
					}
				%>
				<a id="toIndex" href="../FirstPage/FirstPage.jsp">进入网站</a>
			</div>
			<div id="nav">
				<h2>网站管理菜单</h2>
				<ul>
					<li>
						<h3>帐号管理</h3>
						<dl>
							<dd>
								<a href="../AccountManage/UpdatePwd.jsp">修改密码</a> <a
									href="../AccountManage/UpdateManaInfo.jsp">修改用户名</a> <a
									href="../AccountManage/UpdateProAnswer.jsp">修改密保问题</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>首页管理</h3>
						<dl>
							<dd>
								<a href="../FirstPageManage/FirstPagePicList.jsp">轮转照片设置</a> 
								<a href="../FirstPageManage/BottomParams.jsp">底部信息修改</a>
								<a href="../FirstPageManage/OtherPageManage.jsp">其他信息修改</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>产品管理</h3>
						<dl>
							<dd>
								<a href="../ProductManage/ProductAdd1.jsp">增加新产品</a> 
								<a href="../ProductManage/ProductList.jsp">管理全部产品</a> 
								<a href="../ProductManage/ProductTypeAdd.jsp">增加新类别</a> 
								<a href="../ProductManage/ProductTypeList.jsp">类别管理</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>新闻管理</h3>
						<dl>
							<dd>
								<a href="../NewsManage/PublishNews.jsp">发布新闻</a> 
								<a href="../NewsManage/ManagerNews.jsp">全部新闻管理</a> 
								<a href="../NewsManage/AddNewsType.jsp">增加系列</a>
								<a href="../NewsManage/UpdateNewsType.jsp">新闻类型管理</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>反馈管理</h3>
						<dl>
							<dd>
								<a href="../AdviceManage/ManageAdvice.jsp">管理所有反馈</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>企业信息管理</h3>
						<dl>
							<dd>
								<a href="../CompanyInfoManage/UpdateCompanyInfo.jsp">企业简介</a> 
								<a href="../CompanyInfoManage/UpdateCompanyRelation.jsp">企业联系方式设置</a> 
								<a href="../CompanyInfoManage/UpdateRecruitment.jsp">人才招聘管理</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>权限管理</h3>
						<dl>
							<dd>
								<a href="../PermissionManage/AddNewManager.jsp">添加新管理员</a> <a
									href="../PermissionManage/ManagerList.jsp">查看所有账号权限</a> <a
									href="../PermissionManage/ApplyDeal.jsp">查看申诉</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>功能管理</h3>
						<dl>
							<dd>
								<a href="../FunctionManage/FunctionManage.jsp">一级功能设置</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>权限查看与申请</h3>
						<dl>
							<dd>
								<a href="../PermissionViewAndApply/PermissionStatus.jsp">查看与申请权限</a>
								<a href="../PermissionViewAndApply/AppliesStatus.jsp">查看申请状态</a>
							</dd>
						</dl>
					</li>
					<li>
						<h3>忘记密码申述</h3>
						<dl>
							<dd>
								<a href="../ManagerComplaint/NewsRemind.jsp">管理员申述</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>