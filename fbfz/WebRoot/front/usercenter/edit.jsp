<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/front/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>HotWebsiteTemplates.net</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<!-- CuFon ends -->
</head>

<body>

	<div class="main">
		<div class="header">
			<div class="header_resize">
				<%@ include file="/front/common/menu.jsp"%>
			</div>
		</div>
		<div class="body">
			<div class="body_resize">
				<div class="left">
					<ul>
						<li><a href="">编辑个人信息</a>
						</li>
						<li><a href="">修改密码</a>
						</li>
						<li><a href="">我的收藏</a>
						</li>
					</ul>
				</div>
				<div class="right_resize">


					<div class="right block">
						<h2>个人信息</h2>
						<form action="../front/usercenter/vip!edit.action" method="post">
							<input type="hidden" name="userid"
								value="${sessionScope.user.userid}" />
							<table>
								<tr>
									<td>用户名</td>
									<td>邮箱</td>
									<td>QQ</td>
									<td>电话</td>
								</tr>
								<tr>
									<td><input type="text" name="username"
										value="${username}" readonly="true" />
									</td>
									<td><input type="text" name="email"
										value="${email}" />
									</td>
									<td><input type="text" name="qq"
										value="${qq}" />
									</td>
									<td><input type="text" name="mobileno"
										value="${mobileno}" />
									</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<s:submit/>
								</tr>
							</table>

						</form>
					</div>
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</div>
	<%@ include file="/front/common/footer.jsp"%>
	</div>
</body>
</html>
