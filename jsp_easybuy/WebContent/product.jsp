<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="managerHeader.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
	.thumb img{
		width:60px;
		height:60px;
	}
	
</style>
<script>
	function changeNum() {
		var num =document.getElementById("choose").value;
		location.href="ProductServlet?op=all&gcid=${requestScope.gcid}&num="+num;
	}
	function deleteGood(gid){
		if(confirm("确认删除吗？")){
			$.ajax({
				url:"ProductServlet?op=deleteGood",
				data:"gid="+gid,
				dataType:"json",
				type:"post",
				success:function(result){
				  alert(result.info);
				},
				error:function(){
				  alert("出错了。。。");
				}
			
			});
			/* 
			location.href="ProductServlet?op=deleteGood&gid="+gid; */
		}else{
			history.back();
		}
	}

</script>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.goods }" var="good">
				<tr>
					<td class="first w4 c">${good.gid }</td>
					<td class="thumb"><img src="images/${good.gpic}" /><a href="" target="">${good.gname }</a></td>
					<td class="w1 c"><a href="ProductServlet?op=updateM&gid=${good.gid }">修改</a> <a href="javascript:deleteGood(${good.gid });">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li ><a href="ProductServlet?op=all&num=1">首页</a></li>
					<li><a 
						<c:if test="${requestScope.num==1}">href="ProductServlet?op=all&num=${requestScope.num}" </c:if>
						  <c:if test="${requestScope.num!=1}">href="ProductServlet?op=all&num=${requestScope.num-1}" </c:if>
						>上一页</a></li>
					<li><a 
						<c:if test="${requestScope.num==requestScope.pageCount }">href="ProductServlet?op=all&num=${requestScope.num}" </c:if>
						  <c:if test="${requestScope.num!=requestScope.pageCount}">href="ProductServlet?op=all&num=${requestScope.num+1}" </c:if>
						>下一页</a></li>
					<li><a href="ProductServlet?op=all&num=${requestScope.pageCount }">尾页</a></li>
					<li><select id="choose" onchange="changeNum()" >
					<c:forEach begin="1" end="${requestScope.pageCount }" var="n">
					<option value="${n }" <c:if test="${n==requestScope.num }">selected</c:if> >${n }</option>
					</c:forEach>
					</select></li>
					
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
