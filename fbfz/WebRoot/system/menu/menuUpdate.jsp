<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="pageContent">
	<form method="post" action="../menu/menumanager!updateMenu.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<s:hidden name="menuid"></s:hidden>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
				<dl>
					<dt>菜单名：</dt>
					<dd>
						<input name="menuname" class="required" type="text" size="30"
							value="${menuname}" alt="请输入菜单名" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>菜单路径：</dt>
					<dd>
						<input name="menuuri" type="text" size="60" value="${menuuri}" />
					</dd>
				</dl>
				<dl>
					<dt>排序号：</dt>
					<dd>
						<input name="orderno" class="required" type="text" size="30"
							value="${orderno}" alt="请输入排序号" />
					</dd>
				</dl>
				<dl>
					<dt>父类菜单：</dt>
					<dd>
						<input name="fatherid" class="required" type="text" size="30"
							value="${fatherid}" readonly="true" />
					</dd>
				</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
