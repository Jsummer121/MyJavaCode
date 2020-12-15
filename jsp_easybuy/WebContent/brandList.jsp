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
			<c:forEach items="${sessionScope.brand }" var="brand">
			<li><a href="SelectGchServlet?id=${brand.gchid }">${brand.gbrand }</a></li>
			</c:forEach>
		</ul>
	</div>
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
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
			<c:forEach items="${sessionScope.goods }" var="good">
				<dt class="img"><img src="images/${good.gpic }" /></dt>
				<dd><a href="GoodViewServlet?gid=${good.gid }">${good.gname }</a></dd>
			</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>品牌商品</h2>
			<ul class="product clearfix">
			<c:forEach items="${requestScope.good }" var="good">
				<li>
					<dl>
						<dt><a href="GoodViewServlet?gid=${good.gid }" target=""><img src="images/${good.gpic }" /></a></dt>
						<dd class="title"><a href="GoodViewServlet?gid=${good.gid }" target="">${good.gname }</a></dd>
						<dd class="price">￥${good.gprice }</dd>
					</dl>
				</li>
			</c:forEach>	
			</ul>
			<div class="pager">
				<ul class="clearfix">
					<li ><a href="SelectBrandServlet?num=1&op=brand">首页</a></li>
					<li><a 
						<c:if test="${requestScope.num==1}">href="SelectBrandServlet?num=${requestScope.num}&op=brand" </c:if>
						  <c:if test="${requestScope.num!=1}">href="SelectBrandServlet?num=${requestScope.num-1}&op=brand" </c:if>
						>上一页</a></li>
					<li><a 
						<c:if test="${requestScope.num==requestScope.pageCount }">href="SelectBrandServlet?num=${requestScope.num}&op=brand" </c:if>
						  <c:if test="${requestScope.num!=requestScope.pageCount}">href="SelectBrandServlet?num=${requestScope.num+1}&op=brand" </c:if>
						>下一页</a></li>
					<li><a href="SelectBrandServlet?num=${requestScope.pageCount }&op=brand">尾页</a></li>
					<li><select id="choose" onchange="changeNum()" >
					<c:forEach begin="1" end="${requestScope.pageCount }" var="n">
					<option value="${n }" <c:if test="${n==requestScope.num }">selected</c:if> >${n }</option>
					</c:forEach>
					</select></li>
					
				</ul>
			</div>
		</div>
		
	
		
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
