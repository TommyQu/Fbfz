<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="../front/frontusermember!query.action" method="post" id="pagerForm">
		<input type="hidden" name="currentPage" value="${pageModel.currentPage}">
		<input type="hidden" name="pageSize" value="${pageModel.pageSize}">
		
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>账号：<input type="text" name="loginname"
						value="${username} " /></td>
					<td>状态</td>
					<td><select class="combox" name="state">
							<option value="0">所有状态</option>
							<option value="1" ${state==1?'selected':''} >正常</option>
							<option value="2" ${state==2?'selected':''} >冻结</option>

					</select></td>
					<td>建档日期：<input type="text" class="date" readonly="true" /></td>
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
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete" href="../front/frontusermember!locked.action?userid={sid_user}"
				target="navTab"><span>冻结</span>
			</a>
			</li>
			<li><a class="icon" href="../front/frontusermember!removelocked.action?userid={sid_user}"
				target="navTab"><span>解冻</span>
			</a>
			</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="10"></th>
				<th>用户账号</th>
				<th>电子邮箱</th>
				<th>性别</th>
				<th>状态</th>
				<th>最后登录ip</th>
				<th>最后登录客户端</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result">
				<tr target="sid_user" rel="${userid}">
					<td></td>
					<td>${username}</td>
					<td>${email}</td>
					<td>${usersex==0?'男':'女'}</td>
					<td>${state==1?'正常':'冻结'}</td>
					<td>${ip}</td>
					<td>${client}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="../system/pagebar.jsp" %>
</div>
