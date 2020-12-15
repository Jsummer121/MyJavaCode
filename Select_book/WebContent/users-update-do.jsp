<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.text.*"%>  <%-- 获取系统时间必须导入的--%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %> <%-- 获取系统时间必须导入的--%>

<%@ page import="java.sql.*" %>
<%@ page import="dbc.DbCoon" %>
<%//@ page import="dao.UsersDao" %>
<%//@ page import="dao.UsersDaoImpl" %>

<%@ page import="com.jspsmart.upload.SmartUpload" %>
<html>
  <body>
 <%
    SmartUpload su = new SmartUpload();// 新建一个SmartUpload对象
	su.initialize(pageContext);// 上传初始化
	su.upload();// 上传文件
	su.save("/uploadpic");// 将上传文件全部保存到指定目录,返回上传文件控件的个数
	
	//out.println("原图"+su.getRequest().getParameter("picture")+"<BR><BR>");// 利用Request对象获取参数picture之值,显示原图名称
	
	com.jspsmart.upload.File file = su.getFiles().getFile(0);//因为只有一个上传控件，如有多个，可激活注释的代码
 
 //获取前一网页传递过来的参数值
int id=Integer.parseInt(request.getParameter("id"));

DbCoon dbconn=new DbCoon();
PreparedStatement pstmt=null;

//获取用户名、密码、邮件。。。等表单元素的值
String username=su.getRequest().getParameter("username");
String password=su.getRequest().getParameter("password");
String email=su.getRequest().getParameter("email");
String gender=su.getRequest().getParameter("gender");
String content=su.getRequest().getParameter("content");
//获取原来的图片，通过隐藏域表单元素获取
String img=su.getRequest().getParameter("img");
 //获取新的图片的名称
String img1=file.getFileName();
//获取日期和时间
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //获取日期和时间
String time=sdf.format(new Date()); 

//isMissing的作用：这个方法用于判断用户是否选择了文件，也即对应的表单项是否有值。选择了文件时，它返回false。未选文件时，它返回true。
if (file.isMissing()==false) // 如果选择了新的图片
{
//保存新上传的照片
file.saveAs("e:/javasy/Select_book/WebContent/uploadpic/"+ img, su.SAVE_PHYSICAL);

//删除原图片
java.io.File file1=new File("e:/javasy/Select_book/WebContent/uploadpic/"+ img);
file1.delete();

String sql="update user set username=?,password=?,email=?,gender=?,content=?,img=?,time=? where id=?";
pstmt=dbconn.getConnection().prepareStatement(sql);
pstmt.setString(1,username);
pstmt.setString(2,password);
pstmt.setString(3,email);
pstmt.setString(4,gender);
pstmt.setString(5,content);
//pstmt.setString(6,request.getParameter("img"));
pstmt.setString(6,img1);
pstmt.setString(7,time);
pstmt.setInt(8,id);

pstmt.executeUpdate();//更新数据库

}
else{
String sql1="update user set username=?,password=?,email=?,gender=?,content=?,time=? where id=?";
pstmt=dbconn.getConnection().prepareStatement(sql1);
pstmt.setString(1,username);
pstmt.setString(2,password);
pstmt.setString(3,email);
pstmt.setString(4,gender);
pstmt.setString(5,content);

pstmt.setString(6,time);
pstmt.setInt(7,id);
pstmt.executeUpdate();//更新数据库
}

pstmt.close();
dbconn.close();

//网页的重定向
//response.sendRedirect("users-update.jsp");
  %> 
   修改完毕，<a href=users-show.jsp>返回主页面</a><br/>
  2秒钟会自动跳转到主页面
  <%response.setHeader("refresh","2;URL=users-show.jsp"); %>

  <!-- <script language='javascript'>alert('您已成功修改信息!');window.location.href='users-show.jsp';</script>");//跳回到指定页-->
  </body>
</html>
