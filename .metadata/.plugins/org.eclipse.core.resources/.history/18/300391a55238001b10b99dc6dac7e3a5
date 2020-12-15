package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Goods;
import com.service.impl.GoodServiceImpl;

public class CookieServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookie=request.getCookies();
		GoodServiceImpl gsi=new GoodServiceImpl();
		List<Goods> list =new ArrayList<Goods>();
		String gid=null;
		for(Cookie coo:cookie){
			if(coo.getName().equals("gid")){
				gid=coo.getValue();
				Goods good=gsi.getGoodById(Integer.parseInt(gid));
				list.add(good);
			}
		}
		HttpSession session =request.getSession();
		session.setAttribute("goods", list);
	}

}
