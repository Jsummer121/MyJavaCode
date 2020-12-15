package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
import com.entity.Gchild;
import com.entity.Goodc;
import com.entity.Goods;
import com.service.impl.GoodServiceImpl;


public class ProductServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op.equals("all")){
			productAll(request, response);
		}else if(op.equals("updateM")){
			productUpdateModify(request, response);
		}else if(op.equals("modify")){
			productModify(request, response);
		}else if(op.equals("add")){
			productAdd(request, response);
		}else if(op.equals("updateA")){
			productUpdateAdd(request, response);
		}else if(op.equals("deleteGood")){
			productUpdateDeleteGood(request, response);
		}
		
	}
	public void productAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置分页数据
		int pagesize=5;
		//获得商品总数
		GoodServiceImpl gsi=new GoodServiceImpl();
		List<Goods> list =gsi.getAll();
		int totalCount=list.size();
		//获得分页数
		int pageCount=gsi.pageCount(pagesize, totalCount);
		String num =request.getParameter("num");
		System.out.println(num);
		//首次登陆进来num值为空
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//获取当前页的数据
		List<Goods> list2=gsi.pageData(pagesize, numb);
		//
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("num", numb);
		request.setAttribute("goods", list2);
		request.getRequestDispatcher("product.jsp").forward(request, response);
		
	}
	public void productUpdateDeleteGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String gid=request.getParameter("gid");
		GoodServiceImpl gsi=new GoodServiceImpl();
		int i=gsi.deleteGood(Integer.parseInt(gid));
		JSONObject obj =new JSONObject();
		if(i>0){
			obj.put("info", "删除成功！");
		}else{
			obj.put("info", "删除失败！");
		}
		out.print(obj);
		out.flush();
		out.close();
		
	}
	public void productUpdateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid=request.getParameter("gid");
		GoodServiceImpl gsi=new GoodServiceImpl();
		//根据商品id获得商品信息
		Goods good =gsi.getGoodById(Integer.parseInt(gid));
		//获得分类类目信息
		List<Goodc> list=gsi.getAllc();
		List<Gchild> list2=gsi.getAllch();
		request.setAttribute("gc", list);
		request.setAttribute("gch", list2);
		request.setAttribute("good", good);
		request.getRequestDispatcher("product-modify.jsp").forward(request, response);
		
	}
	public void productUpdateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodServiceImpl gsi=new GoodServiceImpl();
		//获得分类类目信息
		List<Goodc> list=gsi.getAllc();
		List<Gchild> list2=gsi.getAllch();
		request.setAttribute("gc", list);
		request.setAttribute("gch", list2);
		request.getRequestDispatcher("product-add.jsp").forward(request, response);
		
	}
	public void productModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//实例化一个硬盘文件工厂，用来配置上传组件ServletFileUpload
		DiskFileItemFactory factory= new DiskFileItemFactory();
		//使用工厂对象实例化上传组件ServletFileUpload
		ServletFileUpload upload= new ServletFileUpload(factory);
		String gid=request.getParameter("gid");
		String gname="";
		String gchname="";
		String gpic="";
		String gprice="";
		String gbrand="";
		String gstock="";
		try {
			//获得所有表单的数据。.parseRequest(request)解析请求
			List<FileItem> items= upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item=items.get(i);
				if(item.isFormField())//普通表单域
				{
					//获得表单元素的name
					String name=item.getFieldName();
					if(name.equals("gname")){
						//获取表单元素的值
						gname=item.getString("utf-8");
					}
					if(name.equals("parentId")){
						//获取表单元素的值
						gchname=item.getString("utf-8");
					}
					if(name.equals("productPrice")){
						//获取表单元素的值
						gprice=item.getString("utf-8");
					}
					if(name.equals("gbrand")){
						//获取表单元素的值
						gbrand=item.getString("utf-8");
					}
					if(name.equals("gstock")){
						//获取表单元素的值
						gstock=item.getString("utf-8");
					}
				}else//上传文件
				{
					//获得文件保存路径
					String filepath=getServletContext().getRealPath("/");
					//获取文件名称
					String filename=item.getName();
					gpic=filename;
					String path=filepath+"images/"+filename;
					File file=new File(path);
					//复制一个文件，相当于服务器生成一个文件
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		GoodServiceImpl gsi=new GoodServiceImpl();
		Gchild gch=gsi.getGchild(gchname);
		//创建对象
		Goods good=new Goods(Integer.parseInt(gid), gch.getGcid(), gch.getGchid(), Double.parseDouble(gprice), gpic, gbrand, gname, Integer.parseInt(gstock));
		//修改数据库
		
		int i=gsi.updateGood(gch, good);
		
		if(i>0){
			out.print("<script>alert('修改成功');location.href='managerHomePage.jsp'</script>");
			//request.getRequestDispatcher("managerHomePage.jsp").forward(request, response);
		}else{
			out.print("<script>alert('修改失败');history.back()</script>");
		}
		
	}
	public void productAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//实例化一个硬盘文件工厂，用来配置上传组件ServletFileUpload
		DiskFileItemFactory factory= new DiskFileItemFactory();
		//使用工厂对象实例化上传组件ServletFileUpload
		ServletFileUpload upload= new ServletFileUpload(factory);
		String gname="";
		String gchname="";
		String gpic="";
		String gprice="";
		String gbrand="";
		String gstock="";
		try {
			//获得所有表单的数据。.parseRequest(request)解析请求
			List<FileItem> items= upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item=items.get(i);
				if(item.isFormField())//普通表单域
				{
					//获得表单元素的name
					String name=item.getFieldName();
					if(name.equals("gname")){
						//获取表单元素的值
						gname=item.getString("utf-8");
					}
					if(name.equals("parentId")){
						//获取表单元素的值
						gchname=item.getString("utf-8");
					}
					if(name.equals("productPrice")){
						//获取表单元素的值
						gprice=item.getString("utf-8");
					}
					if(name.equals("gbrand")){
						//获取表单元素的值
						gbrand=item.getString("utf-8");
					}
					if(name.equals("gstock")){
						//获取表单元素的值
						gstock=item.getString("utf-8");
					}
				}else//上传文件
				{
					//获得文件保存路径
					String filepath=getServletContext().getRealPath("/");
					//获取文件名称
					String filename=item.getName();
					gpic=filename;
					String path=filepath+"images/"+filename;
					File file=new File(path);
					//复制一个文件，相当于服务器生成一个文件
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		GoodServiceImpl gsi=new GoodServiceImpl();
		Gchild gch=gsi.getGchild(gchname);
		//创建对象
		Goods good=new Goods(0, gch.getGcid(), gch.getGchid(), Double.parseDouble(gprice), gpic, gbrand, gname, Integer.parseInt(gstock));
		//修改数据库
		
		int i=gsi.addGood(good);
		
		if(i>0){
			out.print("<script>alert('添加成功');location.href='managerHomePage.jsp'</script>");
//			request.getRequestDispatcher("managerHomePage.jsp").forward(request, response);
		}else{
			out.print("<script>alert('添加失败');history.back()</script>");
		}
		
	}
}
