package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.DetailDao;
import com.entity.Goods;

public class DetailDaoImpl extends BaseDao implements DetailDao {

	@Override
	public int getDetail(int oid, Goods good) {
		String sql="insert into orderdetail values(?,?,?,?,?,?)";
		Object[] obj ={good.getGid(),oid,good.getGname(),good.getGpic(),good.getGprice(),good.getCount()};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public List<Goods> getHot() {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select *,sum(gnum) from orderdetail group by gid order by sum(gnum) desc";
		Object[] obj =null;
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good =new Goods(rs.getInt(1), rs.getDouble(5), rs.getString(4), rs.getString(3),rs.getInt(7));
				list.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> hotPageData(int pagesize, int pageCount) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select *,sum(gnum) from orderdetail group by gid order by sum(gnum) desc limit ?,?";
		Object[] obj ={(pageCount-1)*pagesize,pagesize};
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good =new Goods(rs.getInt(1), rs.getDouble(5), rs.getString(4), rs.getString(3),rs.getInt(7));
				list.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
