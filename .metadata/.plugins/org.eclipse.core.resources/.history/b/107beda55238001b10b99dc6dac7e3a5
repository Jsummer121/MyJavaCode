package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.Goods;
import com.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		String sql="select * from user";
		Object[] obj =null;
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public int addUser(User user) {
		int i=0;
		String sql="insert user values(?,?,?,?);";
		Object[] obj={user.getUid(),user.getUname(),user.getUpass(),user.getType()};
		i=super.executeUpdate(sql, obj);
		return i;
	}

	@Override
	public User login(String name, String pass) {
		User user=null;
		String sql="select * from user";
		Object[] obj=null;
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				if(rs.getString(2).equals(name)&&rs.getString(3).equals(pass)){
					user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
