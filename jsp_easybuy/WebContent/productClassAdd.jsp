<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="managerHeader.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
	
	function changeA() {
		var val=$("#sec").val();
		if(val==1){
			$(".bd").css("display","block");
		}else{
			$(".bd").css("display","none");
		}
	}
	function addP() {
		var name=$("input[type=text]").val();
		var gcid=$("#sele").val();
		var val=$("#sec").val();
		$.ajax({
			url:"ProductClassServlet?op=addclass",
			type:"post",
			data:{
				"gcid":gcid,
				"val":val,
				"name":name
			},
			dataType:"json",
			success:function(result){
				if(result.info=="添加成功"){
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
<style>

	.bd{
		display:none;
		width: 200px;
	}
</style>
<div class="main">
		<h2>添加类目</h2>
		<div class="manage">
			<form action="manage-result.html">
				<table class="form">
					<tr>
						<td class="field">请选择需要添加的类目：</td>
						<td>
							<select name="parentId" id="sec" onchange="changeA()">
								<option value="0" selected="selected">一级类目</option>
								<option value="1">二级类目</option>
							</select>
						</td>
						
					</tr>
					<tr class="bd">
						<td class="field">请选择一级类目：</td>
						<td>
							<select name="parentId" id="sele">
							<c:forEach items="${requestScope.gc }" var="gc">
								<option value="${gc.gcid }">${gc.gcname }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">添加类目名称：</td>
						<td><input type="text" class="text" name="className" value="电脑" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button" name="button" value="添加" onclick="addP()"/></label></td>
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
