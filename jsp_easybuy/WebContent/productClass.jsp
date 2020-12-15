<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="managerHeader.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.gc }" var="gc">
				<tr>
					<td class="first w4 c">${gc.gcid }</td>
					<td>${gc.gcname }</td>
					<td class="w1 c"><a href="ProductClassServlet?op=modify&gcid=${gc.gcid }">修改</a>
					 <a href="ProductClassServlet?op=delete&gcid=${gc.gcid}">删除</a></td>
				</tr>
				<c:forEach items="${requestScope.gch }" var="gch">
				<c:if test="${gc.gcid==gch.gcid }">
				<tr>
					<td class="first w4 c">${gch.gchid }</td>
					<td class="childClass">${gch.gchname }</td>
					<td class="w1 c"><a href="ProductClassServlet?op=modify&gchid=${gch.gchid }">修改</a>
					 <a href="ProductClassServlet?op=delete&gchid=${gch.gchid}">删除</a></td>
				</tr>
				</c:if>
				</c:forEach>
				
				</c:forEach>
			
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
