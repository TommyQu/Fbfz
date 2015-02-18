<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../admin/areamanager!getAllbig.action" target="navTab"><span>新增</span></a></li>
			<li><a class="delete" href="../admin/areamanager!delete.action?areaid={sid_area}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="../admin/areamanager!jumptoUpdate.action?areaid={sid_area}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="158">
		<thead>
			<tr>

				<th>区域名称</th>
				<th>排序号</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="areas.{?#this.fatherid==null}" var="big">
			<tr target="sid_area" rel="${big.areaid}">
				<td>${big.areaname}</td>
				<td>${big.orderno}</td>
			</tr>
			<s:iterator value="areas.{?#this.fatherid==#big.areaid}" var="small">
			<tr target="sid_area" rel="${small.areaid}">
				<td style="padding-left: 50px;">${small.areaname}</td>
				<td>${small.orderno}</td>
			</tr>
			</s:iterator>
		</s:iterator>
		
		</tbody>
	</table>
</div>

