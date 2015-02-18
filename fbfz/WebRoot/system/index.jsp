<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/system/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>吃喝玩乐在福州系统管理主窗口</title>

<link href="dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>



<script src="dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="dwz/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("dwz/dwz.frag.xml", {
		//	loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"../login.jsp",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"currentPage", numPerPage:"pageSize"}, //【可选】
		debug:true,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="<%=basePath%>/login.jsp">标志</a>
				<ul class="nav">
					<li><a href="login.html">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
				<s:iterator value="menus.{?#this.fatherid==null}" var="big">
					<div class="accordionHeader">
						<h2><span>Folder</span>${menuname}</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<s:iterator value="menus.{?#this.fatherid==#big.menuid}">
							<li><a href="<%=request.getContextPath()%>/${menuuri}" target="navTab" rel="tab${menuid}">${menuname }</a></li>
							</s:iterator>
						</ul>
				 	</div>
				</s:iterator>
				<!-- 
					<div class="accordionHeader">
						<h2><span>Folder</span>个人信息管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="user/userUpdate.html" target="navTab" rel="userUpdate">个人信息修改</a></li>
							<li><a href="user/pwdUpdate.html" target="navTab" rel="pwdUpdate">密码修改</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="systemUser/adminAdd.html" target="navTab" rel="adminAdd">新增管理员</a></li>
							<li><a href="../admin/systemusermanager!query.action" target="navTab" rel="adminQuery">管理员管理</a></li>
							<li><a href="role/roleAdd.html" target="navTab" rel="roleAdd">新增角色</a></li>
							<li><a href="role/roleQuery.html" target="navTab" rel="roleQuery">角色管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">新增菜单</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">菜单管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">新增资源</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">资源管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">会员管理</a></li>
						</ul>
					</div>
                    <div class="accordionHeader">
						<h2><span>Folder</span>业务管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">新增区域</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">区域管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">新增分类</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">分类管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">新增联盟商家</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">联盟商家管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">评价管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">新增广告</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">广告管理</a></li>
						</ul>
					</div>
                -->
					<!--  -->
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
						</div>
                        
						<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>


</body>
</html>