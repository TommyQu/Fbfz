<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../admin/typemanager!getAllbig.action" target="navTab"><span>新增</span></a></li>
			<li><a class="delete" href="../admin/typemanager!delete.action?typeid={sid_type}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="../admin/typemanager!jumptoUpdate.action?typeid={sid_type}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="158">
		<thead>
			<tr>

				<th>类别名称</th>
				<th>排序号</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="types.{?#this.fatherid==null}" var="big">
			<tr target="sid_type" rel="${big.typeid}">
				<td>${big.typename}</td>
				<td>${big.orderno}</td>
			</tr>
			<s:iterator value="types.{?#this.fatherid==#big.typeid}" var="small">
			<tr target="sid_type" rel="${small.typeid}">
				<td style="padding-left: 50px;">${small.typename}</td>
				<td>${small.orderno}</td>
			</tr>
			</s:iterator>
		</s:iterator>
		
		</tbody>
	</table>
</div>

