package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.entity.Goods;
import com.entity.Receinfo;
import com.entity.User;
import com.service.impl.DetailServiceImpl;
import com.service.impl.GoodServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.service.impl.RecServiceImpl;

public class BuyGoodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op=request.getParameter("op");
		if(op.equals("1")){
			before(request, response);
		}else if(op.equals("2")){
			after(request, response);
		}
	}
	
	public void before(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		JSONObject obj=new JSONObject();
		if(user==null){
			obj.put("info", "请先登录");
		}else{
			obj.put("info", "请选择收货人");
		}
		PrintWriter out =response.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	public void after(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		String gid=request.getParameter("gid");
		String rid=request.getParameter("rid");
		String count=request.getParameter("count");
		GoodServiceImpl gsi= new GoodServiceImpl();
		RecServiceImpl rsi= new RecServiceImpl();
		OrderServiceImpl osi= new OrderServiceImpl();
		DetailServiceImpl dsi= new DetailServiceImpl();
		List<Goods> list=(List<Goods>) session.getAttribute("ordergood");
		double money=0;
		double sum=0;
		if(list==null){
			//获得随机订单id
			int oid=(int) (Math.random()*1000000);
			//获得商品信息
			Goods good=gsi.getGoodById(Integer.parseInt(gid));
			//获得商品的购买数量
			Goods good2=new Goods(good.getGid(), good.getGprice(), good.getGpic(), good.getGbrand(), good.getGname(),Integer.parseInt(count) );
			//获得收货人信息
			Receinfo rec=rsi.getReceinfo(Integer.parseInt(rid));
			//生成订单
			int i=osi.getOrder(user.getUid(), oid, good2.getMoney(), rec);
			if(i>0){
				//生成订单详情
				int j=dsi.getDetail(oid, good2);
				request.setAttribute("good", good2);
				request.setAttribute("money",good2.getMoney());
				request.getRequestDispatcher("buycart.jsp").forward(request, response);
			}
			
		}else{
			//获得随机订单id
			int oid=(int) (Math.random()*1000000);
			//获得收货人信息
			Receinfo rec=rsi.getReceinfo(Integer.parseInt(rid));
			//生成订单
			int i=osi.getOrder(user.getUid(), oid, sum, rec);
			for(Goods g:list){
				//生成订单详情
				int j=dsi.getDetail(oid, g);
				System.out.println(j);
				money=g.getMoney();
				sum=sum+money;
			}
			request.setAttribute("sum",sum);
			//修改订单
			int k=osi.updateO(user.getUid(), oid, "未发货", sum, rec);
			request.getRequestDispatcher("buycart.jsp").forward(request, response);
			
		}
	}

}
