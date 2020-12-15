package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Receinfo;
import com.entity.User;
import com.service.impl.RecServiceImpl;

public class ReceinfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		RecServiceImpl rsi= new RecServiceImpl();
		List<Receinfo> list =rsi.getRec(user.getUid());
		request.setAttribute("rec", list);
		
		String gid=request.getParameter("gid");
		String count=request.getParameter("count");
		if(gid!=null){
			request.setAttribute("gid", Integer.parseInt(gid));
			
		}
		if(count!=null){
		
			request.setAttribute("count", Integer.parseInt(count));
		}
		request.getRequestDispatcher("receinfo.jsp").forward(request, response);
		
		
	}

}
