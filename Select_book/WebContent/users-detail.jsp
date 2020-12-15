<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="dbc.DbCoon" %>
<%@ page import="java.sql.*" %>
<%@ page import="vo.Users" %>
<%@ page import="dao.UsersDao" %>
<%@ page import="dao.UsersDaoImpl" %>

<html>
  <head>
  	<title>My JSP 'users-detail.jsp' starting page</title>
  </head>
  
  <body>
    <%
    //获取前一网页浏览器地址栏中传递过来的id的参数值
    int id=Integer.parseInt(request.getParameter("id"));
    //连接类实例化
    /*
    DbConn dbconn=new DbConn();
    String sql="select * from user where id=?";
    PreparedStatement pstmt=dbconn.getConnection().prepareStatement(sql);
    pstmt.setInt(1,id);
    
    ResultSet rs=pstmt.executeQuery();
 */
 
 	UsersDao usersdao=new UsersDaoImpl();
 	Users users=usersdao.queryById(id);
   %> 
   <table width=800 border=1>
   <%
   /*
   if(rs.next()){
    //int id=
    String username=rs.getString("username");
    String password=rs.getString("password");
    String email=rs.getString("email");
    String gender=rs.getString("gender");
    String content=rs.getString("content");
    String img=rs.getString("img");
  */
   if(users!=null){
    String username=users.getUsername();
    String password=users.getPassword();
    String email=users.getEmail();
    String gender=users.getGender();
    String content=users.getContent();
    String phone = users.getPhone();
    String img=users.getImg();
  
    %>
   <tr><td>用户名：<%=username %></td></tr>
   <tr><td>密码：<%=password %></td></tr>
   <tr><td>手机号：<%=phone %></td></tr>
   <tr><td>邮件：<%=email %></td></tr>
   <tr><td>性别：<%=gender %></td></tr>
   <tr><td>简介：<%=content %></td></tr>
   <tr><td>图像：<img src=uploadpic/<%=img %>></td></tr>
   <% 
    }
   %>
</table>
  </body>
</html>
