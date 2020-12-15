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
import com.entity.User;
import com.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String name= request.getParameter("username");
		String pass=request.getParameter("passWord");
		String veryCode=request.getParameter("veryCode");
		//�����֤��ͼƬ�ϵ�����
		String checkCode=(String) request.getSession().getAttribute("autoCode");
		//����json����
		JSONObject obj= new JSONObject();
		if(!veryCode.equals(checkCode)){
			obj.put("info", "��֤���������");
		}else{
			UserServiceImpl usi=new UserServiceImpl();
			User user=usi.login(name, pass);
			
			if(user!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if(user.getType()==1){
					obj.put("info", "����Ա��¼�ɹ�");
				}else{
					obj.put("info", "��ͨ�û���¼�ɹ�");
				}
			}else{
				obj.put("info", "��¼ʧ��");
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.print(obj);
		out.flush();
		out.close();
	}

}
