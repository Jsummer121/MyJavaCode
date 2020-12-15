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
<link href="css/cloud-zoom.css"  rel="stylesheet" type="text/css"/>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/cloud-zoom.1.0.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

	function addgood(gid){
		var count =$("#count").val();
		$.ajax({
			url:"AddCartServlet",
			type:"post",
			data:{
				"gid":gid,
				"count":count
			},
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
	function buyGood(gid) {
		var count =$("#count").val();
		$.ajax({
			url:"BuyGoodServlet?op=1",
			type:"post",
			data:"",
			dataType:"json",
			success:function(result){
			if(result.info=="请先登录"){
				alert(result.info);
				location.href="login.jsp";
			}else{
				alert(result.info);
				location.href="ReceinfoServlet?gid="+gid+"&count="+count;
			}
				
			},
			error:function(){
				alert("出错了。。。");
			}
		}); 
	}
</script>
<style >
	.demo img{
		width:250px;
		height:250px;
	}
	.infos{
		height:350px;
	}
	.thumb{
		width: 770px;
	}
	.demo{
		float:left;
	}
	.buy{
		float:left;
	}
</style>
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
		</div>

<div id="product" class="main">
		<h1>${requestScope.good.gname }</h1>
		<div class="infos">
		   <div class="demo">
		       <a  class="cloud-zoom" href="images/${requestScope.good.gpic }" rel="adjustX: 10, adjustY:-4, softFocus:true">
		       	<img src="images/${requestScope.good.gpic }" />
		       </a>
			</div>
			<div class="buy">
				<p>品    牌：${requestScope.good.gbrand }</p>
				<p>商城价：<span class="price">${requestScope.good.gprice }</span></p>
				<p>库　存：${requestScope.good.gstock }</p>
				<p>购买数量：<input  type="text" id="count" value="1" style="width:20px"/></p>
				<div class="button"><input type="button" name="button" value="" onclick="buyGood(${requestScope.good.gid })" />
				<a href="javascript:addgood(${requestScope.good.gid})">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${requestScope.good.gname }<br />
				
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
</div>
<div id="footer">
	Copyright &copy; 中软国际 All Rights Reserved.
</div>
</body>
</html>
