<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm"
		action="../role/rolemanager!query.action" method="post">
		<input type="hidden" name="currentPage"
			value="${pageModel.currentPage}" /> <input type="hidden"
			name="pageSize" value="${pageModel.pageSize}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>角色名：<input type="text" name="rolename"
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
			<li><a class="add" href="../role/jumptoaddRole!jump.action" target="navTab"><span>添加</span>
			</a>
			</li>
			<li><a class="delete"
				href="../role/rolemanager!delete?rid={sid_role}" target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span>
			</a>
			</li>
			<li><a class="edit"
				href="../role/jumptoupdateRole!jumptoupdate?rid={sid_role}"
				target="navTab"><span>修改</span>
			</a>
			</li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls"
				target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span>
			</a>
			</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="10"></th>
				<th>角色名</th>
				<th>角色描述</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result">
				<tr target="sid_role" rel="${roleid}">
					<td></td>
					<td>${rolename}</td>
					<td>${roledesr }</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp"%>
</div>
