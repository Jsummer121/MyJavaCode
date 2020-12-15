package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;

public class ShoppingCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("user");
		PrintWriter out= response.getWriter();
		//创建json对象
		JSONObject obj= new JSONObject();
		if(user==null){
			obj.put("info", "请先登录");
//			out.print("<script>alert('请先登录');location.href='login.jsp';</script>");
		}else{
			obj.put("info", "查看购物车");
		}
		response.setContentType("text/html;charset=utf-8");
		out.print(obj);
		out.flush();
		out.close();
	}

}
