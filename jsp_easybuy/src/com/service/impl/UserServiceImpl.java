package com.service.impl;

import java.util.List;

import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	UserDaoImpl udi=new UserDaoImpl();
	@Override
	public List<User> getAll() {
		
		return udi.getAll();
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return udi.addUser(user);
	}
	@Override
	public User login(String name, String pass) {
		// TODO Auto-generated method stub
		return udi.login(name, pass);
	}

}
