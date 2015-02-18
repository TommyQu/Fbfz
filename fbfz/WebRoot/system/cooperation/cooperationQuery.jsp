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
				if(data.typeid=='${param.typeid}'){
					html+="<option value='"+data.typeid+"' selected>"+data.typename+"</option>";
				}else{
					html+="<option value='"+data.typeid+"'>"+data.typename+"</option>";
				}
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
				if(data.areaid=='${param.areaid}'){
					html+="<option value='"+data.areaid+"' selected>"+data.areaname+"</option>";
				}else{
					html+="<option value='"+data.areaid+"'>"+data.areaname+"</option>";
				}
			});
			var $ref = $("#areaid");
			var $refCombox = $ref.parents("div.combox:first");
			$ref.html(html).insertAfter($refCombox);
			$refCombox.remove();
			$ref.trigger("change").combox();
		});
	
	}
</script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" id="pagerForm" action="../admin/cooperationmanager!query.action" method="post">
	<input type="hidden" name="currentPage" value="${pageModel.currentPage}"/>
	<input type="hidden" name="pageSize" value="${pageModel.pageSize }"/>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td width="15%" align="right">联盟商家名称：</td>
				<td width="20%" align="left"><s:textfield name="shopname"></s:textfield></td>
				<td width="15%" align="right">VIP等级:	</td>
				<td width="20%" align="left"><select name="viplevel" class="combox">
							<option value="0">所有等级</option>
							<option value="1" ${viplevel==1?"selected":""}>普通</option>
							<option value="2" ${viplevel==2?"selected":""}>白银</option>
							<option value="3" ${viplevel==3?"selected":""}>白金</option>
							<option value="4" ${viplevel==4?"selected":""}>钻石</option>
					</select></td>
				<td width="15%" align="right">状态:</td>
				<td width="20%" align="left"><select name="state" class="combox">
							<option value="0">所有状态</option>
							<option value="1" ${state==1?"selected":""}>正常</option>
							<option value="2" ${state==2?"selected":""}>已注销</option>
					</select></td>
				</tr>
				<tr>
				<td width="15%" align="right">类别：</td>
				<td width="25%" align="left">
				<div>
				<s:select cssClass="combox"  onchange="selectstype(this.value)" 
				list="types" listKey="typeid" listValue="typename" 
				name="bigtypeid" headerKey="0" headerValue="全部类别"></s:select>
				<select class="combox" id="typeid" name="typeid">
					<option value="0">全部小类</option>
				</select>
				</div>
				</td>
				<td width="15%" align="right">区域：</td>
				<td width="15%" align="left">
				<s:select cssClass="combox" onchange="selectarea(this.value)" list="areas" listKey="areaid" listValue="areaname" name="bigareaid" headerKey="0" headerValue="全部区域"></s:select>
					<select class="combox" id="areaid" name="areaid">
					<option value="0">全部小区域</option>
					</select>
				</td>
				<td>&nbsp;</td>
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
			<li><a class="add" href="../admin/cooperationmanager!jumptoAdd.action" target="navTab"><span>新增</span></a></li>		
			<li><a class="edit" href="../admin/systemusermanager!toUpdate.action?userid={sid_user}" title="管理员信息编辑" target="navTab"><span>编辑</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="../admin/systemusermanager!locked.action?userid={sid_user}" target="ajaxTodo"><span>注销</span></a></li>
			<li><a class="icon" href="../admin/systemusermanager!unlocked.action?userid={sid_user}" target="ajaxTodo"><span>恢复</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>商家名称</th>
				<th>商家等级</th>
				<th>所属区域</th>
				<th>所属类型</th>
				<th>加盟时间</th>
				<th>成为VIP时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageModel.result" var="shop">
			<tr target="sid_user" rel="${shop.shopid}">
				<td>${shop.shopname}</td>
				<td>${shop.viplevel}</td>
				<td>${shop.areaname}</td>
				<td>${shop.typename}</td>
				<td><s:date name="#shop.createtime" format="yyyy-MM-dd HH:mm:ss"/></td>
				<td><s:date name="#shop.viptime" format="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${shop.state==1?"正常":"已注销"}</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/system/pagebar.jsp" %>
</div>
<script>
selectstype('${param.bigtypeid}');
selectarea('${param.bigareaid}')
</script>

