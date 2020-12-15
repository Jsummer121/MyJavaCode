<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="dbc.DbCoon" %>
<%@ page import="java.sql.*" %>

<%request.setCharacterEncoding("utf-8"); %>
<html>
<body>
<%
DbCoon dbconn=new DbCoon();
String sql="select * from user";
PreparedStatement pstmt=dbconn.getConnection().prepareStatement(sql);
ResultSet rs=pstmt.executeQuery();


%>
总共查询到<%//=count %>条记录
<table width=800 border=1>
<tr bgcolor="pink">
<td>序号</td>
<td>用户名</td>
<td>密码</td>
<td>邮件</td>
<td>性别</td>
<td>编辑</td>
</tr>

<%
while(rs.next()){
int id=rs.getInt("id");
String username=rs.getString("username");
String password=rs.getString("password");
String email=rs.getString("email");
String gender=rs.getString("gender");

%>

<tr>
<td><%=id%></td>
<td><a href="users-detail.jsp?id=<%=id %>"><%=username %></a></td>
<td><%=password %></td>
<td><%=email %></td>
<td><%=gender %></td>
<td> <a href="users-detail.jsp?id=<%=id %>">详细</a>  <a href="users-update.jsp?id=<%=id %>">修改</a> <a href="users-delete.jsp?id=<%=id%>&username=<%=username%>" onclick="return confirm('确定要删除吗？')">删除</a></td>
</tr>
<%
}

 %>
</table>
  </body>
</html>
