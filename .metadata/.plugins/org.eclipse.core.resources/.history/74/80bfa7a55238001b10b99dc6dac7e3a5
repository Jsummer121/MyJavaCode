package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Gchild;
import com.entity.Goodc;
import com.entity.Goods;
import com.service.impl.DetailServiceImpl;
import com.service.impl.GoodServiceImpl;

public class HomepageServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GoodServiceImpl gsi= new GoodServiceImpl();
		DetailServiceImpl dsi=new DetailServiceImpl();
		//设置页面显示条数
		int pagesize =8;
		//获得商品总数量
		int totalCount=gsi.totalCount();
		//获取总页数
		int pageCount=gsi.pageCount(pagesize, totalCount);
		
		String  num =request.getParameter("num");
		//首次登陆进来num值为空
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//获取当前页的数据
		List<Goods> list =gsi.pageData(pagesize, numb);
		
		//获取一级类目名称
		List<Goodc> list1=gsi.getAllc();
		
		//获得二级类目名称
		List<Gchild> list2 =gsi.getAllch();
		
		//获得热销商品
		List<Goods> listHot = dsi.getHot();
		
		
		HttpSession session =request.getSession();
		request.setAttribute("pageCount",pageCount );
		request.setAttribute("good", list);
		session.setAttribute("hot", listHot);
		session.setAttribute("gc", list1);
		session.setAttribute("gch", list2);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
