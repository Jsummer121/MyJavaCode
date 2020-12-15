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

	function addgood(gid){
		
		$.ajax({
			url:"AddCartServlet",
			type:"post",
			data:"gid="+gid,
			dataType:"json",
			success:function(result){
			if(result.info=="还未登录，请先登录"){
				alert(result.info);
				location.href="login.jsp";
			}else{
				alert(result.info);
			}
				
			},
			error:function(){
				alert("出错了。。。");
			}
		
		}); 
	} 
</script>
<style >
	.thumb img{
		width:300px;
		height:300px;
	}
</style>
</head>
<body>
<div id="position" class="wrap">
	您现在的位置：<a href="HomepageServlet">易买网</a> &gt; 查看订单
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<%
			GoodServiceImpl gsi= new GoodServiceImpl();
			List<Goodc> list1=new ArrayList<Goodc>();
			List<Gchild> list2=new ArrayList<Gchild>();
			list1=gsi.getAllc();
			for(Goodc gc:list1){ 
			list2=gsi.getAllch(gc.getGcid());
			%>
			<dt><%=gc.getGcname() %></dt>
			<% for(Gchild gch:list2){ %>
			<dd><a href="SelectGchServlet?id=<%=gch.getGchid() %>"><%=gch.getGchname() %></a></dd>
			<%}%>
			<%}%>
				
			</dl>
		</div>
		</div>
<div class="main">
		<h2>所有订单</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>订单ID</th>
					<th>用户id</th>
					<th>收货人姓名</th>
					<th>收货人地址</th>
					<th>收货人电话</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.order }" var="order">
				<tr>
					<td>${order.oid }</td>
					<td>${order.uid }</td>
					<td>${order.rname }</td>
					<td>${order.raddr}</td>
					<td>${order.rphone }</td>
					<td>${order.ostatus}</td>
					<th><a href="LookOrderServlet?op=detail&oid=${order.oid }">订单详情</a></th>
				</tr>	
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
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