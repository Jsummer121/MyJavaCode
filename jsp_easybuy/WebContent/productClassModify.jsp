<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="managerHeader.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
	function updateP() {
		var gcid=${requestScope.gcid };
		var gchid=${requestScope.gchid };
		var name=$("input[type=text]").val();
		alert(gcid+"---"+gchid+"---"+name);
		$.ajax({
			url:"ProductClassServlet?op=update",
			type:"post",
			data:{
				"gcid":gcid,
				"gchid":gchid,
				"name":name
			},
			dataType:"json",
			success:function(result){
				if(result.info=="修改成功"){
					alert(result.info);
					location.href="managerHomePage.jsp";
				}
			},
			error:function(){
				alert("出错了。。。");
			}
		
		});
	}

</script>
<div class="main">
		<h2>修改类目</h2>
		<div class="manage">
			<form action="manage-result.html">
				<table class="form">
					<tr>
						<td class="field">请选择需要添加的类目：</td>
						<td>
							<select name="parentId">
							<c:forEach items="${requestScope.gc }" var="gc">
								
								<option value="${gc.gcname }" 
								<c:if test="${gc.gcid==requestScope.gcid }">selected</c:if>>${gc.gcname }</option>
								
								<c:forEach items="${requestScope.gch }" var="gch">
								<c:if test="${gc.gcid==gch.gcid}">
								<option value="${gch.gchname }"
								<c:if test="${gch.gchid==requestScope.gchid }">selected</c:if>>二级类目---${gch.gchname }</option>
								</c:if>
								</c:forEach>
								
							</c:forEach>
							</select>
						</td>
					
					</tr>
					<tr>
						<td class="field">修改类目名称：</td>
						<td><input type="text" class="text" name="className" value="输入修改的名称" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button" name="button" value="修改" onclick="updateP()"/></label></td>
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
