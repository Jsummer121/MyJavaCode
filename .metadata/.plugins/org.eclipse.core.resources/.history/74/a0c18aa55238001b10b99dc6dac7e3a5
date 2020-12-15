package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Goods;
import com.service.impl.GoodServiceImpl;

public class SeclectGoodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gname=request.getParameter("gname");
		if(gname==null||gname.equals("")){
			request.getRequestDispatcher("HomepageServlet").forward(request, response);
		}else{
			
			GoodServiceImpl gsi =new GoodServiceImpl();
			List<Goods> list =gsi.selectGood(gname);
			request.setAttribute("good", list);
			request.getRequestDispatcher("goodsList.jsp").forward(request, response);
		}
	}

}
