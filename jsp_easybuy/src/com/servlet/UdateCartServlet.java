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

import com.alibaba.fastjson.JSONObject;
import com.entity.Goods;
import com.entity.User;
import com.service.impl.GoodServiceImpl;

public class UdateCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("update")){
			update(request, response);
		}else if(op.equals("delete")){
			delete(request, response);
		}else if(op.equals("check")){
			check(request, response);
		}else if(op.equals("sub")){
			sub(request, response);
		}else if(op.equals("buy")){
			buy(request, response);
		}
		
		
		
	
	}
	public void buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		List<Goods> list=(List<Goods>) session.getAttribute("good");
		List<Goods> list2=(List<Goods>) session.getAttribute("ordergood");
		if(list2!=null){
			for(Goods ordergood:list2){
				for(Goods good:list){
					if(good.getGid()==ordergood.getGid()){
						list.remove(good);
						break;
					}
				}
			}
			session.removeAttribute("ordergood");
			session.setAttribute("good", list);
		}
		
		request.getRequestDispatcher("buySuccess.jsp").forward(request, response);
	}
	public void sub(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] gid=request.getParameterValues("che");
		PrintWriter out =response.getWriter();
		if(gid==null){
			out.print("<script>alert('请选择购买的商品');history.back();</script>");
		}else{
			
			HttpSession session= request.getSession();
			List<Goods> list =(List<Goods>) session.getAttribute("good");
			List<Goods> list2=(List<Goods>) session.getAttribute("ordergood");
			if(list2==null){
				list2=new ArrayList<Goods>();
			}
			for(Goods g:list){
				for(String str:gid){
					if(Integer.parseInt(str)==g.getGid()){
						list2.add(g);
						break;
					}
				}
			}
			session.setAttribute("ordergood", list2);
			request.getRequestDispatcher("ReceinfoServlet").forward(request, response);
		}
	}
	public void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid=request.getParameter("gid");
		GoodServiceImpl gsi =new GoodServiceImpl();
		double money=0;
		HttpSession session= request.getSession();
		String sum1 =request.getParameter("sum");
		if(sum1==null){
			sum1="0";
		}
		List<Goods> list =(List<Goods>) session.getAttribute("good");
		for(Goods g:list){
			if(g.getGid()==Integer.parseInt(gid)){
				money=g.getMoney();
				break;
			}
		}
		double sum =Double.parseDouble(sum1);
		sum=sum+money;
		request.setAttribute("sum", sum);
		JSONObject obj= new JSONObject();
		obj.put("info", sum);
		PrintWriter out =response.getWriter();
		out.print(obj);
		out.flush();
		out.close();
//		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid=request.getParameter("gid");
		String count=request.getParameter("count");
		GoodServiceImpl gsi =new GoodServiceImpl();
		Goods good =gsi.getGoodById(Integer.parseInt(gid));
		HttpSession session= request.getSession();
		List<Goods> list =(List<Goods>) session.getAttribute("good");
		for(Goods g:list){
			if(g.getGid()==Integer.parseInt(gid)){
				g.setCount(Integer.parseInt(count));
				break;
			}
		}
	
		session.setAttribute("good", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid=request.getParameter("gid");
		GoodServiceImpl gsi =new GoodServiceImpl();
		Goods good =gsi.getGoodById(Integer.parseInt(gid));
		HttpSession session= request.getSession();
		List<Goods> list =(List<Goods>) session.getAttribute("good");
		for(Goods g:list){
			if(g.getGid()==Integer.parseInt(gid)){
				list.remove(g);
				break;
			}
		}
	
		session.setAttribute("good", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}

}
