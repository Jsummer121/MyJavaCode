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
		
		//���÷�ҳ����
		int pagesize=5;
		//�����Ʒ����
		GoodServiceImpl gsi=new GoodServiceImpl();
		List<Goods> list =gsi.getAll();
		int totalCount=list.size();
		//��÷�ҳ��
		int pageCount=gsi.pageCount(pagesize, totalCount);
		String num =request.getParameter("num");
		System.out.println(num);
		//�״ε�½����numֵΪ��
		if(num==null||num.equals("")){
			num="1";
		}
		int numb=Integer.parseInt(num);
		request.setAttribute("num", numb);
		//��ȡ��ǰҳ������
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
			obj.put("info", "ɾ���ɹ���");
		}else{
			obj.put("info", "ɾ��ʧ�ܣ�");
		}
		out.print(obj);
		out.flush();
		out.close();
		
	}
	public void productUpdateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid=request.getParameter("gid");
		GoodServiceImpl gsi=new GoodServiceImpl();
		//������Ʒid�����Ʒ��Ϣ
		Goods good =gsi.getGoodById(Integer.parseInt(gid));
		//��÷�����Ŀ��Ϣ
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
		//��÷�����Ŀ��Ϣ
		List<Goodc> list=gsi.getAllc();
		List<Gchild> list2=gsi.getAllch();
		request.setAttribute("gc", list);
		request.setAttribute("gch", list2);
		request.getRequestDispatcher("product-add.jsp").forward(request, response);
		
	}
	public void productModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ʵ����һ��Ӳ���ļ����������������ϴ����ServletFileUpload
		DiskFileItemFactory factory= new DiskFileItemFactory();
		//ʹ�ù�������ʵ�����ϴ����ServletFileUpload
		ServletFileUpload upload= new ServletFileUpload(factory);
		String gid=request.getParameter("gid");
		String gname="";
		String gchname="";
		String gpic="";
		String gprice="";
		String gbrand="";
		String gstock="";
		try {
			//������б������ݡ�.parseRequest(request)��������
			List<FileItem> items= upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item=items.get(i);
				if(item.isFormField())//��ͨ����
				{
					//��ñ�Ԫ�ص�name
					String name=item.getFieldName();
					if(name.equals("gname")){
						//��ȡ��Ԫ�ص�ֵ
						gname=item.getString("utf-8");
					}
					if(name.equals("parentId")){
						//��ȡ��Ԫ�ص�ֵ
						gchname=item.getString("utf-8");
					}
					if(name.equals("productPrice")){
						//��ȡ��Ԫ�ص�ֵ
						gprice=item.getString("utf-8");
					}
					if(name.equals("gbrand")){
						//��ȡ��Ԫ�ص�ֵ
						gbrand=item.getString("utf-8");
					}
					if(name.equals("gstock")){
						//��ȡ��Ԫ�ص�ֵ
						gstock=item.getString("utf-8");
					}
				}else//�ϴ��ļ�
				{
					//����ļ�����·��
					String filepath=getServletContext().getRealPath("/");
					//��ȡ�ļ�����
					String filename=item.getName();
					gpic=filename;
					String path=filepath+"images/"+filename;
					File file=new File(path);
					//����һ���ļ����൱�ڷ���������һ���ļ�
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
		//��������
		Goods good=new Goods(Integer.parseInt(gid), gch.getGcid(), gch.getGchid(), Double.parseDouble(gprice), gpic, gbrand, gname, Integer.parseInt(gstock));
		//�޸����ݿ�
		
		int i=gsi.updateGood(gch, good);
		
		if(i>0){
			out.print("<script>alert('�޸ĳɹ�');location.href='managerHomePage.jsp'</script>");
			//request.getRequestDispatcher("managerHomePage.jsp").forward(request, response);
		}else{
			out.print("<script>alert('�޸�ʧ��');history.back()</script>");
		}
		
	}
	public void productAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ʵ����һ��Ӳ���ļ����������������ϴ����ServletFileUpload
		DiskFileItemFactory factory= new DiskFileItemFactory();
		//ʹ�ù�������ʵ�����ϴ����ServletFileUpload
		ServletFileUpload upload= new ServletFileUpload(factory);
		String gname="";
		String gchname="";
		String gpic="";
		String gprice="";
		String gbrand="";
		String gstock="";
		try {
			//������б������ݡ�.parseRequest(request)��������
			List<FileItem> items= upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item=items.get(i);
				if(item.isFormField())//��ͨ����
				{
					//��ñ�Ԫ�ص�name
					String name=item.getFieldName();
					if(name.equals("gname")){
						//��ȡ��Ԫ�ص�ֵ
						gname=item.getString("utf-8");
					}
					if(name.equals("parentId")){
						//��ȡ��Ԫ�ص�ֵ
						gchname=item.getString("utf-8");
					}
					if(name.equals("productPrice")){
						//��ȡ��Ԫ�ص�ֵ
						gprice=item.getString("utf-8");
					}
					if(name.equals("gbrand")){
						//��ȡ��Ԫ�ص�ֵ
						gbrand=item.getString("utf-8");
					}
					if(name.equals("gstock")){
						//��ȡ��Ԫ�ص�ֵ
						gstock=item.getString("utf-8");
					}
				}else//�ϴ��ļ�
				{
					//����ļ�����·��
					String filepath=getServletContext().getRealPath("/");
					//��ȡ�ļ�����
					String filename=item.getName();
					gpic=filename;
					String path=filepath+"images/"+filename;
					File file=new File(path);
					//����һ���ļ����൱�ڷ���������һ���ļ�
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
		//��������
		Goods good=new Goods(0, gch.getGcid(), gch.getGchid(), Double.parseDouble(gprice), gpic, gbrand, gname, Integer.parseInt(gstock));
		//�޸����ݿ�
		
		int i=gsi.addGood(good);
		
		if(i>0){
			out.print("<script>alert('��ӳɹ�');location.href='managerHomePage.jsp'</script>");
//			request.getRequestDispatcher("managerHomePage.jsp").forward(request, response);
		}else{
			out.print("<script>alert('���ʧ��');history.back()</script>");
		}
		
	}
}
