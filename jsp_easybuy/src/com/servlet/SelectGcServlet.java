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
import com.entity.Goods;
import com.service.impl.GoodServiceImpl;

public class SelectGcServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodServiceImpl gsi=new GoodServiceImpl();
		String gcid= request.getParameter("gcid");
		
		//设置页面显示条数
		int pagesize =8;
		//获得一级商品总数量
		int gcCount=gsi.gcCount(Integer.parseInt(gcid));
	
		//获取总页数
		int pageCount=gsi.pageCount(pagesize, gcCount);
		
		String  num =request.getParameter("num");
		//首次登陆进来num值为空
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//获取当前页的数据
		List<Goods> list =gsi.gcpageData(pagesize, numb,Integer.parseInt(gcid));
		System.out.println(list);
		//获得一级类目下二级类目名称
		List<Gchild> list2 =new ArrayList<Gchild>();
		list2=gsi.getAllch(Integer.parseInt(gcid));
		
		
		HttpSession session =request.getSession();
		request.setAttribute("pageCount",pageCount );
		request.setAttribute("good", list);
		session.setAttribute("gch", list2);
		request.setAttribute("gcid", Integer.parseInt(gcid));
		request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	}

}
