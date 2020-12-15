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
	function add(){
		var name=$("#name").val();
		var phone=$("#phone").val();
		var address=$("#address").val();
		if(name==""||phone==""||address==""){
			alert("不能为空");
		}else{
			$.ajax({
			url:"AddRecServlet",
			type:"post",
			data:{
				"name":name,
				"phone":phone,
				"address":address
			},
			dataType:"json",
			success:function(result){
			if(result.info=="添加成功"){
				alert(result.info);
				location.href="ReceinfoServlet";
			}else{
				alert(result.info);
			}
				
			},
			error:function(){
				alert("出错了。。。");
			}
		}); 
		}
	
	} 
	function jump() {
		$("input[type=text]").html("");
	}
</script>
<style >
	.thumb img{
		width:300px;
		height:300px;
	}
	.wrap1{
		float:left;
		width:700px;
		height:322px;
	
	}
	.sale{
		margin-left: 250px;
	}
	#form{
		margin-left: 250px;
	}
	#form dd{
		margin-top: 30px;
		height:30px;
	}
</style>
</head>
<body>
<div id="position" class="wrap">
	您现在的位置：<a href="HomepageServlet">易买网</a>&gt;<a href="ReceinfoServlet">管理收货信息</a> &gt;添加收货人
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
<div class="wrap1">
  <!-- main begin-->
  <div class="sale">
    <h3 class="lf">收货人信息</h3>
  </div>
  <div id="form">
      <div class="login logns produce">
            <dd >
              <label>收货人姓名：</label>
              <input type="text" class="inputh lf" id="name" name="name" />
            </dd>
            <dd>
              <label>收货人电话：</label>
              <input type="text" class="inputh lf" id="phone" name="phone" />
            </dd>
            <dd>
              <label>收货人地址：</label>
              <input type="text" class="inputh lf" id="address" name="address" />
            <dd class="hegas">
                <input name="" type="button" onclick="add()" value="添  加"  />
                <input name="" type="button" id="concel" value="取 消" onclick="jump()"  />
            </dd>
          </dl>
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