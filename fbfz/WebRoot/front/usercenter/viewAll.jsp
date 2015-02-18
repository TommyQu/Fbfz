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
				<div class="banner">
					<s:iterator value="allAdManager" status="s">
						<div
							class="<s:property value="#s.index%2==0?'leftbanner':'rightbanner'"/>">
							<img src="../uploadFile/${pic}" width="500px" alt="${shopname}" />
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
		<div class="body">
			<div class="body_resize">
				<div class="left">
					<img
						src="../uploadFile/<s:property value="topVip.get(0).getShoppic()"/>"
						class="img" alt="img" width="218" height="190" />
					<h2>
						推荐<span>商家</span>
					</h2>
					<p>
						<ul class="colist">
							<s:iterator value="topVip">
								<li><a href="#"><span>${shopname} 地址：${address }</span>
								</a>
								</li>
							</s:iterator>
						</ul>
					</p>
					<s:iterator value="allTypes.{? #this.coo_typeid==null}" var="big">
						<img src="images/reading.gif" alt="img" width="118" height="23"
							class="floated" />
						<div class="bg"></div>
						<img
							src="../uploadFile/<s:property value="topTypeShop.{^ #this.areaid==#big.typeid}.get(0).getShoppic()"/>"
							class="img" alt="img" width="218" height="190" />
						<h2>${typename}</h2>
						<p>
							<ul class="colist">
								<s:iterator value="topTypeShop.{? #this.areaid==#big.typeid}">
									<li><a href="#"><span>${shopname} 地址：${address}</span></a>
									</li>
								</s:iterator>
							</ul>
						</p>
					</s:iterator>

					<img src="images/reading.gif" alt="img" width="118" height="23"
						class="floated" />
					<div class="bg"></div>
				</div>
				<div class="center-resize">
					<s:iterator value="area.{?#this.are_areaid==null}" var="big" >
						<a href="../front/doublepage!update?id=${areaid }">${areaname}</a>
					</s:iterator>
				</div>
				<div class="right_resize">
					<s:iterator value="allTypes.{?#this.coo_typeid==null}" var="big">
						<div class="right block">
							<h2>${typename}</h2>
							<ul>
								<s:iterator value="allTypes.{? #this.coo_typeid==#big.typeid}">
									<li><a href="#">${typename}</a>
									</li>
								</s:iterator>
							</ul>
						</div>
					</s:iterator>
					
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</div>
	<div class="FBG">
		<div class="FBG_resize">
			<ul>
				<s:iterator value="topFive" begin="0" end="3">
					<li><a href="#"><img src="../uploadFile/${shoppic}" />
					</a>
					</li>
				</s:iterator>
			</ul>
			<ul class="FBG_TITLE">
				<s:iterator value="topFive" begin="0" end="3">
					<li><a href="#">${shopname}</a>
					</li>
				</s:iterator>
			</ul>
			<ul>
				<s:iterator value="topFive" begin="4" end="7">
					<li><a href="#"><img src="../uploadFile/${shoppic}" />
					</a>
					</li>
				</s:iterator>
			</ul>
			<ul class="FBG_TITLE">
				<s:iterator value="topFive" begin="4" end="7">
					<li><a href="#">${shopname}</a>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<%@ include file="/front/common/footer.jsp"%>
	</div>
</body>
</html>
