package dao;


import java.util.List;

import vo.Users;

public interface UsersDao {
	public void addUsers(Users users) throws Exception;//添加
	
	public List queryAllUsers() throws Exception;//查询所有
	
	public void deleteById(int id) throws Exception;//删除
	
	public Users queryById(int id) throws Exception;//按id查询
	
}
