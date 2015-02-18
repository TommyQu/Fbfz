<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="pageContent">
	<form method="post" action="../role/rolemanager!update.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<s:hidden name="roleid"></s:hidden>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>角色信息</legend>
			<dl>
				<dt>角色名：</dt>
				<dd><input name="rolename"  class="required" type="text" size="30" value="${rolename}" alt="请输入角色名"/></dd>
			</dl>
			<dl class="nowrap">
				<dt>角色描述：</dt>
				<dd><textarea name="roledesr" value="${roledesr}" cols="80" rows="2">${roledesr}</textarea></dd>
			</dl>
			</fieldset>
			<fieldset>
				<legend>权限与菜单</legend>
			<div class="tabs" currentIndex="0" eventType="click">
				<div class="tabsHeader">
					<div class="tabsHeaderContent">
						<ul>
							<li><a href="javascript:;"><span>选择菜单</span></a></li>
							<li><a href="javascript:;"><span>分配资源</span></a></li>
						</ul>
					</div>
				</div>
				<div class="tabsContent" style="height:250px;">
					<div>
						<ul class="tree treeFolder treeCheck expand">
							<li><a>全部</a>
								<ul>
									<s:iterator value="menus.{?#this.fatherid==null}" var="big">
										<li><a tname="rolemenus" tvalue="${big.menuid}" <s:property value="(#big.menuid in rolemenus)?'checked':''"/>>${big.menuname}</a>
											<ul>
											<s:iterator value="menus.{?#this.fatherid==#big.menuid}" var="small">
												<li><a tname="rolemenus" tvalue="${small.menuid}"  <s:property value="(#small.menuid in rolemenus)?'checked':''"/>>${small.menuname}</a></li>
											</s:iterator>
											</ul>
										</li>
									</s:iterator>
								</ul>
							</li>
						</ul>
					</div>
					<div>
						<ul class="tree treeFolder treeCheck expand">
							<li><a>全部</a>
								<ul>
									<s:iterator value="resources" var="rs">
										<li><a tname="roleresources" tvalue="${rs.resourceid}" <s:property value="(#rs.resourceid in roleresources)?'checked':''"/>>${rs.resourcename}</a></li>
									</s:iterator>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>