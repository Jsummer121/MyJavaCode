<%@page import="com.entity.Goodc"%>
<%@page import="com.entity.Gchild"%>
<%@page import="com.service.impl.GoodServiceImpl"%>
<%@page import="com.dao.impl.GoodDaoImpl"%>
<%@page import="com.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function changeNum() {
		var num =document.getElementById("choose").value;
		location.href="HomepageServlet?num="+num;
	}
/* 	function onc() {
		var book=document.getElementById("books");
		book.className="current";
		
	} */
	function lookcart(){
		
		$.ajax({
			url:"ShoppingCartServlet",
			type:"post",
			dataType:"json",
			success:function(result){
			if(result.info=="请先登录"){
				alert(result.info);
				location.href="login.jsp";
			}else{
				location.href="shopcart.jsp";
			}
				
			},
			error:function(){
				alert("出错了。。。");
			}
		
		}); 
	} 
	$(function(){
	 	$.ajax({
			url:"CookieServlet",
			type:"post",
			data:"",
			dataType:"json",
			success:function(result){
			
			},
			error:function(){
			}
		
		}); 
	});
	function secl() {
		var gname=$("#sel").val();
		location.href="SeclectGoodServlet?gname="+gname;
	}
</script>
<style>
	#header{
		background-image: url("images/aa.jpg");
		background-repeat: no-repeat;
		height:150px;
	}
	.img img{
		width:60px;
		height:60px;
	}
	#img img{
		margin-left:250px;
		z-index: -100;
		position: absolute;
	}
	#search{
		position: absolute;
		margin-left: 400px;
		margin-top: 50px;
		
	}
	#search input{
		height:40px;
		width:370px;
		font-size: 20px;
		border-radius:5px;
		
	}
	#search button{
		height:44px;
		width:70px;
		font-size: 20px;
		position: absolute;
		left:310px;
		border-radius:5px;
	}
</style>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" style="margin-left:150px;"/></div>
	<div id="search"><input id="sel" type="text" placeholder="搜索钥匙套?" /><button onclick="secl()">搜索</button></div>
	<!-- <div id="img"><img src="images/aaa.jpg"/></div> -->
	<c:choose>
	 <c:when test="${sessionScope.user!=null }">
	 <div class="help"><a href="javascript:lookcart()" class="shopping">购物车</a><a href="#">欢迎${sessionScope.user.uname }登录</a>
	 <a href="ConselServlet">退出登录</a><a href="LookOrderServlet?op=order">查看订单</a><a href="ReceinfoServlet">管理收货信息</a><a href="guestbook.html">留言</a></div>
	 </c:when>
	 <c:otherwise>
	<div class="help"><a href="javascript:lookcart()" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="reg.jsp">注册</a></div>
	 </c:otherwise>
	</c:choose>
	<div class="navbar" style="margin-top: 120px;">
		<ul class="clearfix">
			<li class="current"><a href="HomepageServlet">首页</a></li>
			<c:forEach items="${sessionScope.gc }" var="gc">
			<li id="books"><a href="SelectGcServlet?gcid=${gc.gcid }"  onclick="onc()">${gc.gcname }</a></li>
			</c:forEach>
		
			<li><a href="SelectBrandServlet?op=brand" id="brands" onclick="onc()">品牌商品</a></li>
			<li><a href="SelectBrandServlet?op=hot" name="goods" onclick="onc()">热销商品</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<c:forEach items="${sessionScope.gch }" var="gch">
			<li><a href="SelectGchServlet?id=${gch.gchid }">${gch.gchname }</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
  </body>
</html>
