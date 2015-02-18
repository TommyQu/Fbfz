<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="pageContent">
	<form method="post" action="../admin/systemusermanager!update.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
			<input type="hidden" name="userid" value="${userid}">
			<p>
				<label>用户账号：</label> <input name="loginname" class="required" value="${loginname}" readonly="true"
					type="text" size="30" />
			</p>
			<p>
				<label>用户姓名：</label> <input name="username" class="required" value="${username}"
					type="text" size="30" alt="请输入客户名称" />
			</p>
			<p>
				<label>手机：</label> <input name="mobileno" value="${mobileno}"
					type="text" size="30" />
			</p>

			<p>
				<label>身份证号码：</label> <input name="idcard" type="text" size="30" value="${idcard}" />
			</p>
			<p>
				<label>电子邮箱：</label> <input name="email" type="text" size="30" value="${email}" />
			</p>

			<p>
				<label>住址：</label> <input name="address" type="text" size="30" value="${address}" />
			</p>
			<p>
				<label>角色：</label><s:checkboxlist name="rolelist" list="roles" listKey="roleid" listValue="rolename"></s:checkboxlist>			
			</p>
			
			<label>性别：</label>
			<p>			
				<label><input type="radio" name="usersex" value="1"  checked />男</label> 
				<label><input type="radio" name="usersex" value="2" />女</label>
			</p>
				
							
			
			
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

