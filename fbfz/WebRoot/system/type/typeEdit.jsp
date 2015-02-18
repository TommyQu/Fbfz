<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="pageContent">
	<form method="post" action="../admin/typemanager!update.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="typeid" value="${typeid}">
			<fieldset>
				<dl>
					<dt>分类名称：</dt>
					<dd>
						<input name="typename" class="required" type="text" size="30"
							alt="${typename}" />
					</dd>
				</dl>
				<dl>
					<dt>排序号：</dt>
					<dd>
						<input name="orderno" type="text" size="5" value="${orderno}" />
					</dd>
				</dl>
				<dl>
					<dt>所属大区：</dt>
					<dd>
						<select name="fatherid" class="combox">
							<option value="">无</option>
							<s:iterator value="types.{?#this.fatherid==null}" var="big">
								<option value="${big.typeid}" target="sid_type" rel="${big.typeid}">${big.typename}</option>
							</s:iterator>
						</select>
					</dd>
				</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>

