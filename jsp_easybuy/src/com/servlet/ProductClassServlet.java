package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.entity.Gchild;
import com.entity.Goodc;
import com.service.impl.GoodCServiceImpl;
import com.service.impl.GoodServiceImpl;


public class ProductClassServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("all")){
			productClassAll(request, response);
		}else if(op.equals("modify")) {
			productClassModify(request, response);
		}else if(op.equals("update")){
			productClassUpdate(request, response);
		}else if(op.equals("add")){
			productClassAdd(request, response);
		}else if(op.equals("addclass")){
			productClassAddclass(request, response);
		}else if(op.equals("delete")){
			productClassDelete(request, response);
		}
	}
	public void productClassAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodServiceImpl gsi =new GoodServiceImpl();
		List<Goodc> list=gsi.getAllc();
		List<Gchild> list2=gsi.getAllch();
		request.setAttribute("gc", list);
		request.setAttribute("gch", list2);
		request.getRequestDispatcher("productClass.jsp").forward(request, response);
	}
	public void productClassModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gcid=request.getParameter("gcid");
		String gchid=request.getParameter("gchid");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		GoodServiceImpl gsi =new GoodServiceImpl();
		List<Goodc> list=gsi.getAllc();
		List<Gchild> list2=gsi.getAllch();
		request.setAttribute("gc", list);
		request.setAttribute("gch", list2);
		if(gcid!=null){
			request.setAttribute("gcid", Integer.parseInt(gcid));
		}else{
			request.setAttribute("gcid", "0");
		}
		
		if(gchid!=null){
			request.setAttribute("gchid", Integer.parseInt(gchid));
		}else{
			request.setAttribute("gchid", "0");
		}
		
		request.getRequestDispatcher("productClassModify.jsp").forward(request, response);
	}
	public void productClassUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gcid=request.getParameter("gcid");
		String gchid=request.getParameter("gchid");
		String name=request.getParameter("name");
		JSONObject obj= new JSONObject();
		GoodCServiceImpl gcs=new GoodCServiceImpl();
		if(Integer.parseInt(gcid)!=0){
			System.out.println(gcid);
			int i=gcs.UpdateGc(Integer.parseInt(gcid), name);
			if(i>0){
				obj.put("info", "修改成功");
			}
		}
		if(Integer.parseInt(gchid)!=0){
			System.out.println(gchid);
			int i=gcs.UpdateGch(Integer.parseInt(gchid), name);
			System.out.println(i);
			if(i>0){
				obj.put("info", "修改成功");
			}
		}
		PrintWriter out =response.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	public void productClassAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodServiceImpl gsi =new GoodServiceImpl();
		List<Goodc> list=gsi.getAllc();
		request.setAttribute("gc", list);
		request.getRequestDispatcher("productClassAdd.jsp").forward(request, response);
	}
	public void productClassAddclass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gcid=request.getParameter("gcid");
		String val=request.getParameter("val");
		String name=request.getParameter("name");
		JSONObject obj= new JSONObject();
		GoodCServiceImpl gcs=new GoodCServiceImpl();
		if(Integer.parseInt(val)==0){
			int i=gcs.addGc(name);
			if(i>0){
				obj.put("info", "添加成功");
			}
		}else{
			int i=gcs.addGch(Integer.parseInt(gcid), name);
			System.out.println(i);
			if(i>0){
				obj.put("info", "添加成功");
			}
		}
		PrintWriter out =response.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	public void productClassDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gcid=request.getParameter("gcid");
		String gchid=request.getParameter("gchid");
		System.out.println(gcid);
		System.out.println(gchid);
		GoodCServiceImpl gcs=new GoodCServiceImpl();
		if(gcid!=null){
			int i=gcs.deleteGc(Integer.parseInt(gcid));
			if(i>0){
				request.getRequestDispatcher("ProductClassServlet?op=all").forward(request, response);
			}
		}		
		if(gchid!=null){
			int i=gcs.deleteGch(Integer.parseInt(gchid));
			if(i>0){
				request.getRequestDispatcher("ProductClassServlet?op=all").forward(request, response);
			}
		}
		
	
	}
}
