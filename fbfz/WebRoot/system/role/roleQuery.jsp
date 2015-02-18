<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html"
		method="post">
		<input type="hidden" name="currentPage"
			value="${pageModel.currentPage}" />
		<input type="hidden" name="pageSize" value="${pageModel.pageSize }" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						角色名：
						<input type="text" name="rolename" />
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									查询
								</button>
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
			<li>
				<a class="add" href="../admin/rolemanager!"
					target="navTab" ><span>新增</span>
				</a>
			</li>
			<li>
				<a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
				</a>
			</li>
			<li>
				<a class="edit" href="../admin/rolemanager!toUpdate.action?roleid={roleid}"
					target="navTab"><span>修改</span>
				</a>
			</li>

		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>

				<th>
					角色名称
				</th>
				<th>
					角色描述
				</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result" var="role">
				<tr target="roleid" rel="${role.roleid}">
					<td>
						${role.rolename}
					</td>
					<td>
						${role.roledesr}
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/common/pagebar.jsp"%>
</div>
