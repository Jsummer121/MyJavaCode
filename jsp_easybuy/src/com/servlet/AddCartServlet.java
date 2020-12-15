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

import com.alibaba.fastjson.JSONObject;
import com.entity.Goods;
import com.entity.User;
import com.service.impl.GoodServiceImpl;

public class AddCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("user");
		PrintWriter out= response.getWriter();
		//创建json对象
		JSONObject obj= new JSONObject();
		if(user==null){
			obj.put("info", "还未登录，请先登录");
		}else{
			String count=request.getParameter("count");
			String gid=request.getParameter("gid");
			GoodServiceImpl gsi =new GoodServiceImpl();
			Goods good=gsi.getGoodById(Integer.parseInt(gid));
			boolean flag=true;
			Goods g=null;
			List<Goods> list=(List<Goods>) session.getAttribute("good");
			if(list==null){
				list=new ArrayList<Goods>();
			}else{
				for(int i=0;i<list.size();i++){
					 g=list.get(i);
					if(g.getGid()==Integer.parseInt(gid)){
						g.setCount(g.getCount()+Integer.parseInt(count));
						flag=false;  
						break;
					}
				}
				
			}
			if(flag==true){
				g=new Goods(good.getGid(), good.getGprice(), good.getGpic(), good.getGbrand(), good.getGname(), Integer.parseInt(count));
				list.add(g);
			}
			session.setAttribute("good", list);
		
			
			if(session.getAttribute("good")!=null){
				obj.put("info", "加入购物车成功");
			}else{
				obj.put("info", "加入购物车失败");
			}
		}
		response.setContentType("text/html;charset=utf-8");
		out.print(obj);
		out.flush();
		out.close();
	}

}
