<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="pageContent">
	<form method="post" action="../resources/resourcesmanager!add.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>基本信息</legend>
			<dl>
				<dt>资源名称：</dt>
				<dd><input name="resourcename" class="required" type="text" size="30" value="" alt="请输入资源名称"/></dd>
			</dl>
			<dl>
				<dt>资源路径：</dt>
				<dd><input name="resuri" class="required" type="text" size="30" value="" alt="请输入资源路径"/></dd>
			</dl>
			<dl class="nowrap">
				<dt>资源描述：</dt>
				<dd><textarea name="resdescription" cols="80" rows="2"></textarea></dd>
			</dl>
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