package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Goods;
import com.service.impl.GoodServiceImpl;

public class SelectGchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String gchid=request.getParameter("id");
		GoodServiceImpl gsi =new GoodServiceImpl();
		//设置页面显示条数
		int pagesize =8;
		//获得商品总数量
		int totalCount=gsi.gchCount(Integer.parseInt(gchid));
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
		List<Goods> list =gsi.gchpageData(pagesize, numb, Integer.parseInt(gchid));
		request.setAttribute("gchid",Integer.parseInt(gchid) );
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("good", list);
		request.getRequestDispatcher("gchGoodPage.jsp").forward(request, response);
	}

}
