<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'center.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		var i=3;
		function initPage(){
			window.setTimeout("gopage()",3000);
			dochange();
		}
		function gopage(){
			if(${!(empty center_url)}){
				location.href="<%=request.getContextPath()%>/${center_url}";
			}
			if(${!(empty center_script)}){
				${center_script}
			}
		}
		function dochange(){
			document.getElementById("xxx").innerHTML=i;
			i--;
			window.setTimeout("dochange()",1000);
		}
	</script>
  </head>
  <body onload="initPage()">
  	   <div>${msgtitle}</div>
       <div>默认<span id="xxx">3</span>秒自动跳转到默认页</div>
       
       <div><a href="javascript:gopage()">访问默认页</a></div>
  </body>
</html>
