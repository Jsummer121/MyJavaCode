<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dbc.DbCoon" %>
<%@ page import="dao.UsersDao" %>
<%@ page import="dao.UsersDaoImpl" %>
<html>
 <%
int id=Integer.parseInt(request.getParameter("id"));
 /*
DbConn dbconn=new DbConn();
String sql="delete from user where id=?";
PreparedStatement pstmt=dbconn.getConnection().prepareStatement(sql);
pstmt.setInt(1, id);
pstmt.executeUpdate();
pstmt.close();
dbconn.close();
*/
UsersDao usersdao=new UsersDaoImpl();
try{
usersdao.deleteById(id);
}
catch(Exception e){}
//网页的重定向
response.sendRedirect("users-show.jsp");
  %> 
 </html>
