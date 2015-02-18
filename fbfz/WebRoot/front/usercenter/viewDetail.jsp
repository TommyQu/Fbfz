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
		<input type="hidden" value="${shopid}" name="id" />
			<div class="body_resize">
				<div class="left">
					<ul>
						<li>商家详情</li>
						<li>商家名称：${shopname}</li>
						<li>商家电话：${telphone}</li>
						<li>商家地址：${address}</li>
						<li>点击数：${keepnum}</li>
						<li>综合分：${totalscore}</li>
						<li>服务分：${servicescore}</li>
						<li>环境分：${envscore}</li>
						<li>交通分：${transcore} </li>
						<li>特色分：${featurescore}</li>
					</ul>
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</div>
	<%@ include file="/front/common/footer.jsp"%>
	</div>
</body>
</html>
