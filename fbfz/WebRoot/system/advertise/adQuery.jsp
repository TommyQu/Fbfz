<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm" action="../admin/systemusermanager!query.action" method="post">
	<input type="hidden" name="currentPage" value="${pageModel.currentPage}"/>
	<input type="hidden" name="pageSize" value="${pageModel.pageSize }"/>
	<div class="searchBar">
		<table class="searchContent"> 
			<tr>
				<td>位置:</td>
				<td>
					<select name="state" class="combox">
							<option value="0">所有位置</option>
							<option value="1" ${state==1?"selected":""}>首页</option>
							<option value="2" ${state==2?"selected":""}>二级页</option>
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
			<li><a class="add" href="../admin/systemusermanager!preparedAdd.action" target="navTab"><span>新增</span></a></li>		
			<li><a class="edit" href="../admin/systemusermanager!toUpdate.action?userid={sid_user}" title="管理员信息编辑" target="navTab"><span>编辑</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="../admin/systemusermanager!locked.action?userid={sid_user}" target="ajaxTodo"><span>删除</span></a></li>
		
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>

				<th>商家名称</th>
				<th>录入时间</th>
				<th>位置</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp" %>
</div>
