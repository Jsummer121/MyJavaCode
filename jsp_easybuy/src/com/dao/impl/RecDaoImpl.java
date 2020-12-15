package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.ReceinfoDao;
import com.entity.Goods;
import com.entity.Receinfo;

public class RecDaoImpl extends BaseDao implements ReceinfoDao {

	@Override
	public int addRec(Receinfo rec) {
		
		String sql="insert into receinfo values(?,?,?,?,?)";
		Object[] obj={rec.getRid(),rec.getUid(),rec.getRname(),rec.getRphone(),rec.getRaddr()};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int updateRec(Receinfo rec) {
		String sql="update  receinfo set rname=?,rphone=?,paddr=? where rid=?";
		Object[] obj={rec.getRname(),rec.getRphone(),rec.getRaddr(),rec.getRid()};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int deleteRec(int rid) {
		String sql="delete from   receinfo where rid=?";
		Object[] obj={rid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public List<Receinfo> getRec(int uid) {
		List<Receinfo> list = new ArrayList<Receinfo>();
		String sql="select * from receinfo where uid=?";
		Object[] obj ={uid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Receinfo rec=new Receinfo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(rec);
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
	public Receinfo getReceinfo(int rid) {
		Receinfo rec=null;
		String sql="select * from receinfo where rid=?";
		Object[] obj ={rid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				rec=new Receinfo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, null, rs);
		}
		return rec;
	}

}
