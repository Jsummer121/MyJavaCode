package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.entity.Receinfo;
import com.entity.User;
import com.service.impl.RecServiceImpl;

public class AddRecServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session =request.getSession();
		User user=(User) session.getAttribute("user");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		System.out.println(name);
		System.out.println(phone);
		System.out.println(address);
		RecServiceImpl rsi= new RecServiceImpl();
		Receinfo rec=new Receinfo(0, user.getUid(), name, phone, address);
		JSONObject obj =new JSONObject();
		int i=rsi.addRec(rec);
		if(i>0){
			obj.put("info", "添加成功");
		}else{
			obj.put("info", "添加失败");
		}
		PrintWriter out =response.getWriter();
		out.print(obj);
		out.flush();out.close();
	}

}
