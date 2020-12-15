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
<script type="text/javascript">
	function changeNum() {
		var num =document.getElementById("choose").value;
		location.href="HomepageServlet?id=${requestScope.gchid }&num="+num;
	}
</script>
</head>
<body>

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
			<h2>全部商品</h2>
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
					<li ><a href="HomepageServlet?num=1&id=${requestScope.gchid }">首页</a></li>
					<li><a 
						<c:if test="${requestScope.num==1}">href="HomepageServlet?num=${requestScope.num}&id=${requestScope.gchid }" </c:if>
						  <c:if test="${requestScope.num!=1}">href="HomepageServlet?num=${requestScope.num-1}&id=${requestScope.gchid }" </c:if>
						>上一页</a></li>
					<li><a 
						<c:if test="${requestScope.num==requestScope.pageCount }">href="HomepageServlet?num=${requestScope.num}&id=${requestScope.gchid }" </c:if>
						  <c:if test="${requestScope.num!=requestScope.pageCount}">href="HomepageServlet?num=${requestScope.num+1}&id=${requestScope.gchid }" </c:if>
						>下一页</a></li>
					<li><a href="HomepageServlet?num=${requestScope.pageCount }&id=${requestScope.gchid }">尾页</a></li>
					<li><select id="choose" onchange="changeNum()" >
					<c:forEach begin="1" end="${requestScope.pageCount }" var="n">
					<option value="${n }" <c:if test="${n==requestScope.num }">selected</c:if> >${n }</option>
					</c:forEach>
					</select></li>
					
				</ul>
			</div>
		</div>
		
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach begin="0" end="11" items="${sessionScope.hot }" var="hot">
				<li>
					<dl>
						<dt><a href="GoodViewServlet?gid=${hot.gid }" target=""><img src="images/${hot.gpic }" /></a></dt>
						<dd class="title"><a href="GoodViewServlet?gid=${hot.gid }" target="">${hot.gname }</a></dd>
						<dd class="price">￥${hot.gprice }</dd>
					</dl>
				</li>
				</c:forEach>
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
