<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pageContent">
		<form method="post" action="demo/common/ajaxDone.html" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>商家名称：</label>
				<input name="shopname" class="required" type="text" size="30" value="" alt="请输入商家名称"/>
			</p>
			
			<p>
				<label>位置：</label>
				<select name="viplevel" class="combox required">
							<option value="1" ${viplevel==1?"selected":""}>首页</option>
							<option value="2" ${viplevel==2?"selected":""}>二级页</option>
				</select>
			</p>
			<p>
				<label>排序号：</label>
				<input name="sn" type="text" size="30" value=""/>
			</p>
			<p>
			
			</p>
			<dl class="nowrap">
				<dt>广告图片：</dt>
				<dd><input name="filedata" size="80" type="file" /></dd>
			</dl>
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