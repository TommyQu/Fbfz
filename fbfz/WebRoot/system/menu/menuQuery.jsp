<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../menu/menumanager!jumptoMenu.action" target="navTab"><span>新增</span></a></li>
			<li><a class="delete" href="../menu/menumanager!delete?mid={sid_menu}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="../menu/menumanager!jumptoUpdate?mid={sid_menu}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>

				<th>菜单名称</th>
				<th>操作的链接</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="menus.{?#this.fatherid==null}" var="big">
			<tr target="sid_menu" rel="${big.menuid}">
				<td>${big.menuname}</td>
				<td>${big.menuuri}</td>
			</tr>
			<s:iterator value="menus.{?#this.fatherid==#big.menuid}" var="small">
			<tr target="sid_menu" rel="${small.menuid}">
				<td style="padding-left: 50px;">${small.menuname}</td>
				<td>${small.menuuri}</td>
			</tr>
			</s:iterator>
		</s:iterator>
		
		</tbody>
	</table>
</div>

