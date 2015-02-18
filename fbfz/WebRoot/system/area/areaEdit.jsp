<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="pageContent">
	<form method="post" action="../admin/areamanager!update.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="area.areaid" value="${area.areaid}">
			<fieldset>
				<dl>
					<dt>区域名称：</dt>
					<dd>
						<input name="area.areaname" class="required" type="text" size="30"
							alt="${area.areaname}" />
					</dd>
				</dl>
				<dl>
					<dt>排序号：</dt>
					<dd>
						<input name="area.orderno" type="text" size="5" value="${area.orderno}" />
					</dd>
				</dl>
				<dl>
					<dt>所属大区：</dt>
					<dd>
						<select name="area.fatherid" class="combox">
							<option value="">无</option>
							<s:iterator value="areas.{?#this.fatherid==null}" var="big">
								<option value="${big.areaid}" target="sid_area" rel="${big.areaid}">${big.areaname}</option>
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

