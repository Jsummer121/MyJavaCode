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

import com.entity.Goods;
import com.service.impl.DetailServiceImpl;
import com.service.impl.GoodServiceImpl;

public class SelectBrandServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op =request.getParameter("op");
		if(op.equals("brand")){
			brand(request, response);
		}else if (op.equals("hot")){
			hot(request, response);
		}

	}
	public void hot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DetailServiceImpl dsi=new DetailServiceImpl();
		//获得热销商品
		List<Goods> list = dsi.getHot();
		for(Goods d: list){
			System.out.println(d.getSum());
		}
		GoodServiceImpl gsi =new GoodServiceImpl();
		//设置页面显示条数
		int pagesize =8;
		//获得热销商品总数量
		int hotCount=list.size();
		
		//获取总页数
		int pageCount=gsi.pageCount(pagesize, hotCount);
		
		String  num =request.getParameter("num");
		//首次登陆进来num值为空
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//获取当前页的数据
		List<Goods> listHot =dsi.hotPageData(pagesize, numb);
		
		List<Goods> list2= new ArrayList<Goods>();
		
		HttpSession session =request.getSession();
		request.setAttribute("pageCount",pageCount );
		request.setAttribute("good", listHot);
	    session.setAttribute("brand", list2);
		request.getRequestDispatcher("hotList.jsp").forward(request, response);

	}
	public void brand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodServiceImpl gsi =new GoodServiceImpl();
		//设置页面显示条数
		int pagesize =8;
		//获得品牌总数量
		int brandCount=gsi.brandCount();
		
		//获取总页数
		int pageCount=gsi.pageCount(pagesize, brandCount);
		
		String  num =request.getParameter("num");
		//首次登陆进来num值为空
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//获取当前页的数据
		List<Goods> list =gsi.brandpageData(pagesize, numb);
		
		//获得所有品牌商品
		List<Goods> list2 =new ArrayList<Goods>();
		list2=gsi.getBrand();
		
		
		HttpSession session =request.getSession();
		request.setAttribute("pageCount",pageCount );
		request.setAttribute("good", list);
	    session.setAttribute("brand", list2);
		request.getRequestDispatcher("brandList.jsp").forward(request, response);

	}

}
