package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.OrderDetail;
import com.entity.Orders;
import com.entity.User;
import com.service.impl.OrderServiceImpl;

public class LookOrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("order")){
			order(request, response);
		}else if (op.equals("detail")){
			detail(request, response);
		}
				
	}
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		User user= (User) session.getAttribute("user");
		OrderServiceImpl osi=new OrderServiceImpl();
		List<Orders> list = osi.getOrderByUid(user.getUid());
		request.setAttribute("order", list);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}
	public void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid= request.getParameter("oid");
		OrderServiceImpl osi=new OrderServiceImpl();
		List<OrderDetail> list =osi.getDetail(Integer.parseInt(oid));
		request.setAttribute("detail", list);
		request.setAttribute("oid", Integer.parseInt(oid));
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
		
	}

}
