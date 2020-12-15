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
import com.entity.Goods;

public class CheckCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		List<Goods> list =(List<Goods>) session.getAttribute("good");
		double price=0;
		if(list==null){
	  		price=0;
	  	}else{
	  		for(Goods good :list){
	  		
	  			price=price+good.getMoney();
	  		}
	  	}
		JSONObject obj=new JSONObject();
		obj.put("info", price);
		PrintWriter out= response.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}

}
