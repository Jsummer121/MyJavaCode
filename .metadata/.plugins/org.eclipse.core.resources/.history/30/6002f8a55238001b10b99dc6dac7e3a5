package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	/*
	 * 与数据库建立连接
	 */
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/easybuy?characterEncoding=utf-8", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/*
	 * 增、删、改、通用方法
	 */
	public int executeUpdate(String sql,Object[] obj){
		int n=0;
		Connection con =this.getConnection();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					//循环遍历向占位符赋值
					ps.setObject(i+1, obj[i]);
				}
			}
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, null);
		}
		return n; 
	}
	/*
	 * 查询通用方法
	 */
	public ResultSet executeQuery(String sql,Object[] obj){
		Connection con =this.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					//循环遍历向占位符赋值
					ps.setObject(i+1, obj[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/*
	 * 释放资源（关闭所有对象）
	 */
	public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
