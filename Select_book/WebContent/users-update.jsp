<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="vo.Users" %>
<%@ page import="dao.UsersDao" %>
<%@ page import="dao.UsersDaoImpl" %>
<html>
  <head>
	<script type="text/javascript" src="js/form.js"></script>
  </head>
  
 <body>
 <%
 int id=Integer.parseInt(request.getParameter("id"));
 UsersDao usersdao=new UsersDaoImpl();
 Users users=usersdao.queryById(id);
 if(users!=null){
    String username=users.getUsername();
    String password=users.getPassword();
    String email=users.getEmail();
    String gender=users.getGender();
    String content=users.getContent();
    String img=users.getImg();
  %>
 <font size=30pt color=red>用户修改</font><br>
 <form name="form1" method="post" action="users-update-do.jsp?id=<%=id %>" Enctype="multipart/form-data" onsubmit="return checkForm();">

   用户名：<input type="text" value="<%=username %>" name="username" onkeyup="checkUsername();"><span id="usernameMsg"></span><font color="#999999">字母数字下划线1到10位, 不能是数字开头</font><br />
   密码：<input type="password" name="password" value="<%=password %>"  onkeyup="checkPassword();"><span id="passwordMsg"></span><font color="#999999">密码请设置6-16位字符</font><br />
   密码：<input type="password" name="repassword" value="<%=password %>" onkeyup="checkConfirm();"><br />
   邮箱：<input type="text" name="email" value="<%=email %>" onkeyup="checkEmail();"><span id="emailMsg"></span><font color="#999999">请输入有效的邮箱地址</font><br /> 
   性别：<input type="radio" name="gender" value="男" <% if(gender.equals("男")) {out.print("checked=checked");}%>>男
       <input type="radio" name="gender" value="女" <% if(gender.equals("女")) {out.print("checked=checked");}%>>女<br />
 个人介绍：<textarea name="content" rows=5 cols=60><%=content %></textarea><br />
 个人图像：<input type="file" name="pic" ><img src=uploadpic/<%=img %> width=450 height=300/><input type="hidden" name="img" value="<%=img%>" ><br />
 <input type="submit" value="修改">
 <input type="reset" value="重置">
 </form>
 <%} %>
 </body>
</html>
