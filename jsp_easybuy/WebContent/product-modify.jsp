<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="managerHeader.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
</style>
	<div class="main">
		<h2>修改商品</h2>
		<div class="manage">
			<form action="ProductServlet?op=modify&gid=${requestScope.good.gid }" method="post"  enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="gname" value="${requestScope.good.gname }" /></td>
					</tr>
					<tr>
						<td class="field">所属类目：</td>
						<td>
							<select name="parentId">
							<c:forEach items="${requestScope.gc }" var="gc">
								
								<option value="${gc.gcname }" 
								<c:if test="${gc.gcid==requestScope.good.gcid }">selected</c:if>>${gc.gcname }</option>
								
								<c:forEach items="${requestScope.gch }" var="gch">
								<c:if test="${gc.gcid==gch.gcid}">
								<option value="${gch.gchname }"
								<c:if test="${gch.gchid==requestScope.good.gchid }">selected</c:if>>---${gch.gchname }</option>
								</c:if>
								</c:forEach>
								
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" value="${requestScope.good.gpic }"/></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${requestScope.good.gprice }" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="gbrand" value="${requestScope.good.gbrand }" /></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="gstock" value="${requestScope.good.gstock}"/></td>
					</tr>
					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
