package dao;
import dbc.DbCoon;
import vo.Users;
import dao.UsersDao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class UsersDaoImpl implements UsersDao{
	public void addUsers(Users users) throws Exception{//添加
	DbCoon dbconn=null;
	dbconn=new DbCoon();
	String sql="insert into user(username,password,email,gender,content,img,time,phone) values (?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt=null;
	try{
		pstmt=dbconn.getConnection().prepareStatement(sql);	
		pstmt.setString(1,users.getUsername());
		pstmt.setString(2,users.getPassword());
		pstmt.setString(3,users.getEmail());
		pstmt.setString(4,users.getGender());
		pstmt.setString(5,users.getContent());
		pstmt.setString(6,users.getImg());
		pstmt.setString(7,users.getTime());
		pstmt.setString(8,users.getPhone());
		pstmt.executeUpdate();
	}catch(Exception e){
		 	throw new Exception("操作中出现异常");
		}finally{
			 dbconn.close();
			 pstmt.close();
		}
	}

	@Override
	public List<Users> queryAllUsers() throws Exception {
		List<Users> list=new ArrayList<Users>();//创建一个list对象
		DbCoon dbconn=null;
		ResultSet rs = null;
		dbconn=new DbCoon();
		Users users=null;
		String sql="select * from user";
		PreparedStatement pstmt=null;
		try{
			pstmt=dbconn.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				users=new Users();//创建一个封装类的实例
				users.setId(rs.getInt("id"));
			    users.setUsername(rs.getString("username"));
			    users.setPassword(rs.getString("password"));
			    users.setEmail(rs.getString("email"));
			    users.setGender(rs.getString("gender"));
			    users.setContent(rs.getString("content"));
			    users.setImg(rs.getString("img"));
			    users.setTime(rs.getString("time"));
			    users.setPhone(rs.getString("phone"));
			    list.add(users);
			}
        }catch(Exception e){
			throw new Exception("操作中出现异常");	
		}finally{
			rs.close();
			pstmt.close();
			dbconn.close();
		}
		return list;//返回list
	}

	@Override
	public void deleteById(int id) throws Exception {
		DbCoon dbconn=new DbCoon();
		String sql="delete from user where id=?";
		PreparedStatement pstmt=null;
		try{
		pstmt=dbconn.getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		}
		catch(Exception e){
		   throw new Exception("操作出现异常");
		}
		pstmt.close();
		dbconn.close();
	}

	@Override
	public Users queryById(int id) throws Exception {
		DbCoon dbconn=new DbCoon();
		Users users=null;
		String sql="select * from user where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=dbconn.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				users=new Users();
				users.setId(rs.getInt("id"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setEmail(rs.getString("email"));
				users.setGender(rs.getString("gender"));
				users.setContent(rs.getString("content"));
				users.setImg(rs.getString("img"));
				users.setTime(rs.getString("time"));
				users.setPhone(rs.getString("phone"));
			}
		}catch(Exception e){
			throw new Exception("操作出现异常");
		}
		finally{
			dbconn.close();
			rs.close();
			pstmt.close();
		}		
		return users;	
	}
}
