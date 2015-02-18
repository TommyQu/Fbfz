<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm" action="../admin/appraisemanager!query.action" method="post">
	<input type="hidden" name="currentPage" value="${pageModel.currentPage}"/>
	<input type="hidden" name="pageSize" value="${pageModel.pageSize }"/>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					评价会员：<s:textfield name="membername"></s:textfield>
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
			<li><a class="edit" href="../admin/appraisemanager!delete.action?appid={sid_appraise}" title="确定要删除吗?" target="ajaxTodo"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>评价信息</th>
				<th>评价会员</th>
				<th>评价时间</th>
			</tr>
		<tbody>
			<s:iterator value="pageModel.result" var="appraise">
			<tr target="sid_appraise" rel="${appraise.appid}">
				<td>${appraise.content}</td>
				<td>${appraise.membername}</td>
				<td>${appraise.apptime}</td>
			</tr>
			</s:iterator>
		</tbody>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp" %>
</div>
