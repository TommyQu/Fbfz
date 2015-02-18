<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm"
		action="../resources/resourcesmanager!query.action" method="post">
		<input type="hidden" name="currentPage"
			value="${pageModel.currentPage}" /> <input type="hidden"
			name="pageSize" value="${pageModel.pageSize}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>资源名称：<input type="text" name="resourcename"
						value="" /></td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">查询</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../resources/resourcesmanager!jumptoadd.action" target="navTab"><span>添加</span>
			</a>
			</li>
			<li><a class="delete"
				href="../resources/resourcesmanager!delete.action?rid={sid_resource}" target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span>
			</a>
			</li>
			<li><a class="edit"
				href="../resources/resourcesmanager!jumptoupdate.action?rid={sid_resource}"
				target="navTab"><span>修改</span>
			</a>
			</li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="10"></th>
				<th>资源名称</th>
				<th>资源描述</th>
				<th>资源路径</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result">
				<tr target="sid_resource" rel="${resourceid}">
					<td></td>
					<td>${resourcename}</td>
					<td>${resdescription }</td>
					<td>${resuri}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp"%>
</div>
