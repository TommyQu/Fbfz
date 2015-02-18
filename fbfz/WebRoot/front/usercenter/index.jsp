<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/front/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
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
      <%@ include file="/front/common/menu.jsp" %>
    </div>
  </div>
  <div class="body">
    <div class="body_resize">
      <div class="left">
	  	<ul>
	  		<li><a href="../front/usercenter/vip!jumpToEdit.action">编辑个人信息</a></li>
	  		<li><a href="">修改密码</a></li>
	  		<li><a href="">我的收藏</a></li>
	  	</ul>
      </div>
       <div class="right_resize">
       	
       
        <div class="right block">
          <h2>个人信息</h2>
          <ul>
          	<li>用户名:${sessionScope.user.username}</li>
          	<li>最后登录时间:${sessionScope.user.lastlogintime }</li>
          </ul>
        </div>
		</div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <%@ include file="/front/common/footer.jsp" %>
</div>
</body>
</html>
