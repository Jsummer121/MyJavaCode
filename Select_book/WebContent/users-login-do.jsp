<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbc.DbCoon"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("username");//获取用户输入的用户名
String password = request.getParameter("password");//获取用户输入的密码
DbCoon dbconn=null;
ResultSet rs = null;
dbconn=new DbCoon();
String sql = "select * from user where username=? and password=?";
PreparedStatement pstmt=null;
try {
	pstmt=dbconn.getConnection().prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, password);
	rs = pstmt.executeQuery();
	if (rs.next()) {
		session.setAttribute("username", name);
		//如果有值，则说明登录成功，即重定向到登录到首页
		response.sendRedirect("index.jsp");
	}else {
		session.setAttribute("username", "");
		response.sendRedirect("users-login.jsp");
	}
} catch (SQLException e) {
	e.printStackTrace();
}finally{
	try {
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	dbconn.close();
}
%>
</body>
</html>