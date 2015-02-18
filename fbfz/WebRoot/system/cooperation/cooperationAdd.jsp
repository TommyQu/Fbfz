<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
	function selectstype(bigid){
		if(!bigid)return
		var url="../admin/cooperationmanager!querySmallType.action";
		var param={bigtypeid:bigid};
		var html = '<option value="0">所有小类别</option>';
		$.getJSON(url,param,function(result){
			$.each(result,function(i,data){
				
					html+="<option value='"+data.typeid+"'>"+data.typename+"</option>";
				
			});
			var $ref = $("#typeid");
			var $refCombox = $ref.parents("div.combox:first");
			$ref.html(html).insertAfter($refCombox);
			$refCombox.remove();
			$ref.trigger("change").combox();
		});
	
	}
	function selectarea(bigid){
		if(!bigid)return
		var url="../admin/cooperationmanager!querySmallArea.action";
		var data={bigareaid:bigid};
		var html = '<option value="0">所有小区域</option>';
		$.getJSON(url,data,function(result){
			$.each(result,function(i,data){
					html+="<option value='"+data.areaid+"'>"+data.areaname+"</option>";
			
			});
			var $ref = $("#areaid");
			var $refCombox = $ref.parents("div.combox:first");
			$ref.html(html).insertAfter($refCombox);
			$refCombox.remove();
			$ref.trigger("change").combox();
		});
	
	}
</script>
<div class="pageContent">
		<form method="post" action="../admin/cooperationmanager!save.action" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>商家名称：</label>
				<input name="shopname" class="required" type="text" size="30" value="" alt="请输入商家名称"/>
			</p>
			
			<p>
				<label>等级：</label>
				<select name="viplevel" class="combox required">
							<option value="1" ${viplevel==1?"selected":""}>普通</option>
							<option value="2" ${viplevel==2?"selected":""}>白银VIP</option>
							<option value="3" ${viplevel==3?"selected":""}>白金VIP</option>
							<option value="4" ${viplevel==4?"selected":""}>钻石VIP</option>
				</select>
			</p>
			<p>
				<label>所属区域:</label>
				<s:select cssClass="combox" onchange="selectarea(this.value)" list="areas" listKey="areaid" listValue="areaname" name="bigareaid" headerKey="0" headerValue="全部区域"></s:select>
			</p>
			<p>
				<label>所属类别:</label>
				<s:select cssClass="combox"  onchange="selectstype(this.value)" 
				list="types" listKey="typeid" listValue="typename" 
				name="bigtypeid" headerKey="0" headerValue="全部类别"></s:select>
			</p>
			<p>
				<label>&nbsp;</label>
				<select class="combox required" id="areaid" name="areaid">
					<option value="0">请选择小区域</option>
					</select>
			</p>
			<p>
				<label>&nbsp;</label>
				<select class="combox required" id="typeid" name="typeid">
					<option value="0">请选择小类</option>
				</select>
			</p>
			<p>
				<label>联系电话：</label>
				<input name="sn" type="text" size="30" value=""/>
			</p>
			<p>
				<label>手机号码：</label>
				<input name="sn" type="text" size="30" value=""/>
			</p>
			<p>
				<label>经度：</label>
				<input name="sn" type="text" size="30" value=""/>
			</p>
			<p>
				<label>维度：</label>
				<input name="sn" type="text" size="30" value=""/>
			</p>
			<dl class="nowrap">
				<dt>商家小图片：</dt>
				<dd><input name="filedata" size="80" type="file" /></dd>
			</dl>
			<dl class="nowrap">
				<dt>地址：</dt>
				<dd><input name="address" size="80" type="text" /></dd>
			</dl>
			<div class="unit">
				<label>商家描述：</label>
				<textarea class="editor" name="description" 
				upImgUrl="../admin/xheditupload.action" upImgExt="jpg,jpeg,gif,png"  
				upLinkUrl="../admin/xheditupload.action" upLinkExt="zip,rar,txt"
				upFlashUrl="../admin/xheditupload.action" upFlashExt="swf"
				upMediaUrl="../admin/xheditupload.action" upMediaExt="avi"
				rows="10" cols="80"></textarea>
			</div>
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