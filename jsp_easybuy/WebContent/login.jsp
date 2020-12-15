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
	function changeNum() {
		var num =document.getElementById("choose").value;
		location.href="HomepageServlet?num="+num;
	}
	$(function(){
		$("#btn").click(function(){
		 var name=$("#userName").val();
		 var pass=$("#passWord").val();
		 var veryCode=$("#veryCode").val();
		 	if(name==""||pass==""||veryCode==""){
		 		$("#msg").html("用户名，密码不能为空");
		 	}else{
		 		$.ajax({
				url:"LoginServlet",
				type:"post",
				data:{
				"username":name,
				"passWord":pass,
				"veryCode":veryCode
				},
				dataType:"json",
				success:function(result){
					if(result.info=="普通用户登录成功"){
						location.href="HomepageServlet";
					}else if(result.info=="管理员登录成功"){
						location.href="managerHomePage.jsp";
					}else{
						$("#msg").html(result.info);
					}
				},
				error:function(){
				 	alert("出错了。。。");
				}
			});
		 	}		
		});
		
	})
	function refresh() {
		document.getElementById("yzm").src="CheckCodeServlet?time="+new Date().getTime();
	}
</script>
<style>
	 #form{
     clear:both; padding:20px 50px ;
   }
   .text{
    height:25px;
    width:200px;
    
   }
   tr{
     height:43px;
   }
</style>
</head>
<body>

<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
		<div id=form>
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" id="userName" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" id="veryCode" name="veryCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" />
						<img src="CheckCodeServlet" alt="" id="yzm"/>
     					<a href="javascript:refresh()" >刷新</a>
     					</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><button id="btn" value="登录" >登录</button> </label><span id="msg"></span> </td>
					</tr>
				</table>
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
