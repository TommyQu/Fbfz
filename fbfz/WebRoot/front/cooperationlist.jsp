<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'cooperationlist.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 查询表单 -->
    <form action="<%=request.getContextPath()%>/coquery!query.action" method="post">
    <table width="100%" border="1">
    	<tr>
    		<td>商家名称：</td>
    		<td><s:textfield name="shopname"/></td>
    		<td>商家等级：</td>
    		<td><s:select list="#{1:'普通商家',2:'白银',3:'白金',4:'钻石'}" name="viplevel" headerKey="0" headerValue="全部等级"/></td>
    	</tr>
    	<tr>
    		<td>
    		<input type="submit" value="查询"/>
    		</td>
    	</tr>
    </table>
    </form>
    <!-- 显示内容 -->
    <table width="100%" border="1">
    	<tr>
    		<td>商家名称</td>
    		<td>商家图片</td>
    		<td>商家等级</td>
    	</tr>
    	<s:iterator value="pageModel.result">
    	<tr>
    		<td>${shopname}</td>
    		<td><img src="uploadFile/${shoppic}" width="100" height="100"/></td>
    		<td>${viplevelName}</td>
    	</tr>
    	</s:iterator>
    </table>
    <!-- 分页导航 -->
    <div>
    	<form id="inner_pageForm" action="<%=request.getContextPath()%>/coquery!query.action" method="post">
    		<input type="hidden" id="inner_currentPage" name="currentPage" value="${pageModel.currentPage }"/>
    		<s:hidden name="shopname"/>
    		<s:hidden name="viplevel"></s:hidden>
    	<span>当前${pageModel.currentPage}页/共${pageModel.allPage}页，每页<input type="text" name="pageSize" value="${pageModel.pageSize}" size=3/>条/共${pageModel.allCount}条记录 </span>
    	<span>
    	<s:if test="pageModel.currentPage<=1">
    		首页 上页
    	</s:if>
    	<s:else>
    		<a href="javascript:firstPage();">首页</a> <a href="javascript:prePage();">上页</a>
    	</s:else>
    	<s:if test="pageModel.currentPage>=pageModel.allPage">
    		 下页  尾页
    	</s:if>
    	<s:else>
    		<a href="javascript:nextPage();">下页</a> <a href="javascript:lastPage()">尾页</a>
    	</s:else>
    	</span>
    	<script>
    		function firstPage(){
    			document.getElementById("inner_currentPage").value=1;
    			document.getElementById("inner_pageForm").submit();
    		}
    		function prePage(){
    			document.getElementById("inner_currentPage").value=${pageModel.currentPage-1};
    			document.getElementById("inner_pageForm").submit();
    		}
    		function lastPage(){
    			document.getElementById("inner_currentPage").value=${pageModel.allPage};
    			document.getElementById("inner_pageForm").submit();
    		}
    		function nextPage(){
    			document.getElementById("inner_currentPage").value=${pageModel.currentPage+1};
    			document.getElementById("inner_pageForm").submit();
    		}
    	</script>
    	</form>
    </div>
  </body>
</html>
