package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	//��ѯ�����û�
	public List<User>  getAll();
	//�����û�
	public int  addUser(User user);
	//�û���¼
	public User  login(String name,String pass);
}
