<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm" action="../admin/usermembermanager!query.action" method="post">
	<input type="hidden" name="currentPage" value="${pageModel.currentPage}"/>
	<input type="hidden" name="pageSize" value="${pageModel.pageSize }"/>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					用户账号：<s:textfield name="username"></s:textfield>
				</td>
				<td>状态:</td>
				<td>
					<select name="state" class="combox">
							<option value="0">所有状态</option>
							<option value="1" ${state==1?"selected":""}>正常</option>
							<option value="2" ${state==2?"selected":""}>冻结</option>
					</select>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
 <div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		
			<li><a class="edit" href="../admin/usermembermanager!usermemberlocked.action?userid={sid_member}" title="确定要冻结会员" target="ajaxTodo"><span>冻结</span></a></li>
			<li><a class="edit" href="../admin/usermembermanager!usermemberunlocked.action?userid={sid_member}" title="确定要冻结会员" target="ajaxTodo"><span>解冻</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>

				<th>用户账号</th>
				<th>邮箱</th>
				<th>性别</th>
				<th>状态</th>
				<th>最后登录IP</th>
				<th>最后登录客户端</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result" var="member">
			<tr target="sid_member" rel="${member.userid}">
				<td>${member.username}</td>
				<td>${member.email}</td>
				<td>${member.usersex==1?"男":"女" }</td>
				<td>${member.state==1?"正常":"冻结" }</td>
				<td>${member.ip}</td>
				<td>${member.client==1?"PC":"手机"}</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp" %>
</div>
