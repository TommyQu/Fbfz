<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 <div class="menu">
        <ul>
          <li><a href="index.html" class="active"><span>首页</span></a></li>
          <s:iterator value="allTypes.{? #this.coo_typeid==null}">
          <li><a href="services.html"><span>${typename}</span></a></li>
          </s:iterator>
		   <li><a href="contact.html"><span>关于我们</span></a></li>
          <li><a href="contact.html"><span>收藏我们</span></a></li>
          <li><a href="contact.html"><span>注册</span></a></li>
          <li><a href="contact.html"><span>登陆</span></a></li>
        </ul>
</div>