package com.dao;

import java.util.List;

import com.entity.Receinfo;

public interface ReceinfoDao {
	//添加收货人信息
	public int addRec(Receinfo rec);
	//修改收货人信息
	public int updateRec(Receinfo rec);
	//删除收货人信息
	public int deleteRec(int rid);
	//获得所有用户收货人信息
	public List<Receinfo> getRec(int uid);
	//获得具体收货人信息
	public Receinfo  getReceinfo(int rid);
}
