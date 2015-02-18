<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<s:iterator begin="1" end="4" var="i">
					<option value="${i*5}" ${(pageModel.pageSize==i*5)?'selected':''}>${i*5}</option>
				</s:iterator>
			</select>
			<span>条，共${pageModel.allCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${pageModel.allCount}" numPerPage="${pageModel.pageSize}" pageNumShown="10" currentPage="${pageModel.currentPage}"></div>

</div>