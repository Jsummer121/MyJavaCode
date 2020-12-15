<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.SmartUpload"%>
<%@ page import="dbc.DbCoon"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="vo.Users"%>
<%@ page import="dao.UsersDao"%>
<%@ page import="dao.UsersDaoImpl"%>

<%
request.setCharacterEncoding("utf-8"); 
response.setCharacterEncoding("utf-8");
%>
<html>
<body>
<%
	SmartUpload su = new SmartUpload();
	su.initialize(pageContext);
	su.upload();
	su.save("/uploadpic");
	com.jspsmart.upload.File file = su.getFiles().getFile(0);
	String fileName = file.getFileName();
	if(file.isMissing()==true){
			out.println("没有选择任何文件夹");
		}else{
			file.saveAs("e:/javasy/Select_book/WebContent/uploadpic/"+ fileName, su.SAVE_PHYSICAL);
	}
	//依次获取表单元素的值
	String username=su.getRequest().getParameter("username");
	String password=su.getRequest().getParameter("password");
	String email=su.getRequest().getParameter("email");
	String gender=su.getRequest().getParameter("gender");
	String phone=su.getRequest().getParameter("phone");
	//获取个人简介
	String content=su.getRequest().getParameter("content");
	
	//获取当前日期时间
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //获取日期和时间
	String time=df.format(new Date());// time为日期时间字符串
%>

<%
//写入数据库
	Users users=new Users();
	users.setUsername(username);
	users.setPassword(password);
	users.setEmail(email);
	users.setGender(gender);
	users.setContent(content);
	users.setImg((String)fileName);//获取上传的文件名
	users.setTime(time);
	users.setPhone(phone);
	
	UsersDao usersdao=null;
	try{
		usersdao=new UsersDaoImpl();
		usersdao.addUsers(users);
		session.setAttribute("username", username);
		response.sendRedirect("users-login.jsp");
	}catch(Exception e)
	    {e.printStackTrace();}
%>
<script language="javascript">alert('注册成功！！！');history.back();</script>
</body>
</html>
