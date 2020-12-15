package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String name= request.getParameter("username");
		String pass=request.getParameter("passWord");
		String veryCode=request.getParameter("veryCode");
		//获得验证码图片上的数据
		String checkCode=(String) request.getSession().getAttribute("autoCode");
		//创建json对象
		JSONObject obj= new JSONObject();
		if(!veryCode.equals(checkCode)){
			obj.put("info", "验证码输入错误！");
		}else{
			UserServiceImpl usi=new UserServiceImpl();
			User user=usi.login(name, pass);
			
			if(user!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if(user.getType()==1){
					obj.put("info", "管理员登录成功");
				}else{
					obj.put("info", "普通用户登录成功");
				}
			}else{
				obj.put("info", "登录失败");
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.print(obj);
		out.flush();
		out.close();
	}

}
