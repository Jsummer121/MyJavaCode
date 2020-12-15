<%@page import="com.entity.Goodc"%>
<%@page import="com.entity.Gchild"%>
<%@page import="com.service.impl.GoodServiceImpl"%>
<%@page import="com.dao.impl.GoodDaoImpl"%>
<%@page import="com.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function updateG(gid) {
		
		var count = $("#"+gid).val();
		location.href="UdateCartServlet?gid="+gid+"&count="+count+"&op=update";  
	}
	function checkAll(){
		var allc=document.getElementById("allC");
		var arr=document.getElementsByName("che");
		for(var i=0;i<arr.length;i++){
			arr[i].checked=allc.checked;
		}
		
		$.ajax({
		url:"CheckCartServlet",
		type:"post",
		data:"",
		dataType:"json",
		success:function(result){
			if(allc.checked){
				$("#summ").html(result.info);
			}else{
				$("#summ").html(0);
			}
		},
		error:function(){
			alert("出错了。。。。");
		}
	});
	} 
	function checkG(gid) {
		var flag=false;
		var sum =$("#summ").html();
		var arr=document.getElementsByName("che");
		for(var i=0;i<arr.length;i++){
			if(arr[i].checked){
				flag=true;
				break;
			}
		}
		if(flag==true){
			$.ajax({
				url:"UdateCartServlet?op=check",
				type:"post",
				data:{
				"gid":gid,
				"sum":sum
				},
				dataType:"json",
				success:function(result){
					$("#summ").html(+result.info);
				},
				error:function(){
				 	alert("出错了。。。");
				}
			});
		}else{
			$("#summ").html(0);
		}
	
		/* location.href="UdateCartServlet?op=check&gid="+gid; */
	}
</script>
<style>
	.img img{
		width: 60px; 
		height:60px;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>

<div id="position" class="wrap">
	您现在的位置：<a href="HomepageServlet">易买网</a> &gt; 购物车
</div>
  <%
/*   	double price=0;
  	List<Goods> list =(List<Goods>)request.getSession().getAttribute("goodChecked");
  	if(list==null){
  		price=0;
  	}else{
  		for(Goods good :list){
  		
  			price=price+good.getMoney();
  		}
  	} */
  
   %>

<div class="wrap">
	<div id="shopping">
		 <form  action="UdateCartServlet?op=sub" method="post">
			<table>
				<tr>
					<th><input type="checkbox" id="allC" name="number" value="" onclick="checkAll()"/>全选</th>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${sessionScope.good }" var="good">
				<tr id="product_id_1">
					<td><input type="checkbox"  name="che" value="${good.gid }" onclick="checkG(${good.gid })"/></td>
					<td class="img"><img src="images/${good.gpic }" /></td>
					<td class="thumb"><a href="product-view.html">${good.gname }</a>
						<input type="hidden" id="gid" value="${good.gid }" />
					</td>
					<td class="price" id="price_id_1">
						<span>￥${good.gprice }</span>
						<input type="hidden"  value="99" />
					</td>
					<td class="number">
						<dl>
							<dt><input  type="count" id="${good.gid }" value="${good.count }" /></dt>
							<button type="button" onclick="updateG(${good.gid })">修改</button>
						</dl>
					</td> 
					<td class="delete"><a href="UdateCartServlet?gid=${good.gid }&op=delete";>删除</a></td>
				</tr>
				</c:forEach> 
			</table>
			<h3>总金额：<span id="summ">0</span></h3>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>

		

<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
