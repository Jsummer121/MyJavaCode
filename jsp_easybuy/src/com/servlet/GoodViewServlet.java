package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Goods;
import com.service.impl.GoodServiceImpl;

public class GoodViewServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String gid=request.getParameter("gid");
			//
			Cookie cookie=new Cookie("gid", gid);
			//
			response.addCookie(cookie);
			GoodServiceImpl gsi= new GoodServiceImpl();
			Goods good= gsi.getGoodById(Integer.parseInt(gid));
			request.setAttribute("good", good);
			request.getRequestDispatcher("goodView.jsp").forward(request, response);
	}

}
