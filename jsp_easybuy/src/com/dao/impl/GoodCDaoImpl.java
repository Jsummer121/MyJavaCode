package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.GoodCDao;
import com.entity.Gchild;
import com.entity.Goods;

public class GoodCDaoImpl extends BaseDao implements GoodCDao {

	@Override
	public int addGc(String gcname) {
		String sql="insert into goodc values(?,?)";
		Object[] obj= {0,gcname};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int addGch(int gcid, String gchname) {
		String sql="insert into gchild values(?,?,?)";
		Object[] obj= {0,gcid,gchname};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int UpdateGc(int gcid, String gcname) {
		String sql="update goodc set gcname=? where gcid=?";
		Object[] obj={gcname,gcid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int UpdateGch(int gchid, String gchname) {
		String sql="update gchild set gchname=? where gchid=?";
		Object[] obj={gchname,gchid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int deleteGc(int gcid) {
		String sql="delete from goodc where gcid=?";
		Object[] obj={gcid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int deleteGch(int gchid) {
		String sql="delete from gchild where gchid=?";
		Object[] obj={gchid};
		return super.executeUpdate(sql, obj);
	}



}
