package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name= request.getParameter("username");
		String pass=request.getParameter("passWord");
		String checkpass=request.getParameter("rePassWord");
		UserServiceImpl usi=new UserServiceImpl();
		List<User> list =usi.getAll();
		boolean flag=true;
		int i=0;
		//创建json对象
		JSONObject obj= new JSONObject();
		for(User user:list){
			if(name.equals(user.getUname())){
				flag=false;
			}
		}
		if(flag==false){
			obj.put("info", "用户名已存在");
		}else{
			if(!pass.equals(checkpass)){
				obj.put("info", "两次密码输入不一致");
			}else{
				User user=new User(0, name, pass, 0);
				i=usi.addUser(user);
				obj.put("info", "注册成功");
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println(obj);
		out.print(obj);
		out.flush();
		out.close();
		
	}

}
