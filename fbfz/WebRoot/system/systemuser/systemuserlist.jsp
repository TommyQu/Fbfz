<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm"
		action="../admin/systemusermanager!query.action" method="post">
		<input type="hidden" name="currentPage"
			value="${pageModel.currentPage}" /> <input type="hidden"
			name="pageSize" value="${pageModel.pageSize}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>账号：<input type="text" name="loginname"
						value="${loginname}" /></td>
					<td>状态</td>
					<td><select class="combox" name="state">
							<option value="0">所有状态</option>
							<option value="1" ${state==1?'selected':''}>正常</option>
							<option value="2" ${state==2?'selected':''}>冻结</option>
					</select></td>
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
			<li><a class="add" href="../admin/preparedsystemuser!getAllRoles.action" target="navTab"><span>添加</span>
			</a>
			</li>
			<li><a class="delete"
				href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span>
			</a>
			</li>
			<li><a class="edit"
				href="../admin/systemusermanager!userlocked.action?uid={sid_user}"
				title="确定要冻结会员?" target="ajaxTodo"><span>冻结</span>
			</a>
			</li>
			<li><a class="edit"
				href="../admin/systemusermanager!userunlocked.action?uid={sid_user}"
				title="确定要解冻会员?" target="ajaxTodo"><span>解冻</span>
			</a>
			</li>
			<li><a class="edit"
				href="../admin/systemusermanager!jumptoUpdate?uid={sid_user}"
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
				<th>账号</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>电子邮箱</th>
				<th>手机</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result">
				<tr target="sid_user" rel="${userid}">
					<td></td>
					<td>${loginname}</td>
					<td>${username }</td>
					<td>${usersex==1?"男":"女"}</td>
					<td>${email}</td>
					<td>${mobileno}</td>
					<td>${state==1?'正常':'冻结'}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp"%>
</div>
