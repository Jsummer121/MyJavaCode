package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.GoodDao;
import com.entity.Gchild;
import com.entity.Goodc;
import com.entity.Goods;


public class GoodDaoImpl extends BaseDao implements GoodDao {

	@Override
	public List<Goods> getAll() {
		List<Goods> list = new ArrayList<Goods>();
		String sql="select * from goods";
		Object[] obj =null;
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public List<Goods> getGc(int gcid) {
		List<Goods> list = new ArrayList<Goods>();
		String sql="select * from goods where gcid=?";
		Object[] obj ={gcid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public List<Goods> getGch(int gchid) {
		List<Goods> list = new ArrayList<Goods>();
		String sql="select * from goods where gchid=?";
		Object[] obj ={gchid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public List<Goods> getBrand() {
		List<Goods> list = new ArrayList<Goods>();
		String sql="select * from goods where gbrand is not null";
		Object[] obj =null;
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public List<Goodc> getAllc() {
		List<Goodc> list = new ArrayList<Goodc>();
		String sql="select * from goodc ";
		Object[] obj =null;
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goodc gc=new Goodc(rs.getInt(1), rs.getString(2));
				list.add(gc);
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
	public  List<Gchild>  getAllch(int gcid) {
		List<Gchild> list = new ArrayList<Gchild>();
		String sql="select * from gchild where gcid=? ";
		Object[] obj ={gcid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Gchild gch=new Gchild(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list.add(gch);
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
	public int totalCount() {
		int i=0;
		String sql="select count(1) from goods";
		Object[] obj =null;
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int pageCount(int pagesize, int totalCount) {
		// TODO Auto-generated method stub
		return totalCount%pagesize==0?totalCount/pagesize:totalCount/pagesize+1;
	}

	@Override
	public List<Goods> pageData(int pagesize, int pageCount) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select * from goods limit ?,?";
		Object[] obj ={(pageCount-1)*pagesize,pagesize};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public int gcCount(int gcid) {
		int i=0;
		String sql="select count(1) from goods where gcid=?";
		Object[] obj ={gcid};
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int brandCount() {
		int i=0;
		String sql="select count(1) from goods where gbrand is not null";
		Object[] obj =null;
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Goods> gcpageData(int pagesize, int pageCount, int gcid) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select * from goods where gcid=? limit ?,?";
		Object[] obj ={gcid,(pageCount-1)*pagesize,pagesize};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public List<Goods> brandpageData(int pagesize, int pageCount) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select * from goods where gbrand is not null limit ?,?";
		Object[] obj ={(pageCount-1)*pagesize,pagesize};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public Goods getGoodById(int gid) {
		Goods good=null;
		String sql="select * from goods where gid=?";
		Object[] obj ={gid};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, null, rs);
		}
		return good;
	}

	@Override
	public List<Gchild> getAllch() {
		List<Gchild> list = new ArrayList<Gchild>();
		String sql="select * from gchild ";
		Object[] obj =null;
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Gchild gch=new Gchild(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list.add(gch);
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
	public int gchCount(int gchid) {
		int i=0;
		String sql="select count(1) from goods where gchid=?";
		Object[] obj ={gchid};
		ResultSet rs= super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Goods> gchpageData(int pagesize, int pageCount, int gchid) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select * from goods where gchid=? limit ?,?";
		Object[] obj ={gchid,(pageCount-1)*pagesize,pagesize};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Goods good= new Goods(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(good);
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
	public int updateGood(Gchild gch,Goods good) {
		String sql="update goods set gcid=?,gchid=?,gprice=?,gpic=?,gbrand=?,gname=?,gstock=? where gid=?";
		Object[] obj ={gch.getGcid(),gch.getGchid(),good.getGprice(), good.getGpic(),good.getGbrand(),good.getGname(),good.getGstock(),good.getGid()};
		return super.executeUpdate(sql, obj);
	}
	public Gchild getGchild(String gchname){
		Gchild gch=null;
		String sql="select * from gchild where gchname=?";
		Object[] obj={gchname};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				gch=new Gchild(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gch;
	}

	@Override
	public int deleteGood(int gid) {
		String sql="delete from goods where gid =?";
		Object[] obj ={gid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public int addGood(Goods good) {
		String sql="insert into goods values(?,?,?,?,?,?,?,?)";
		Object[] obj ={good.getGid(),good.getGcid(),good.getGchid(),good.getGprice(), good.getGpic(),good.getGbrand(),good.getGname(),good.getGstock()};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public List<Goods> selectGood(String gname) {
		List<Goods> list =new ArrayList<Goods>();
		Connection con = super.getConnection();
		String sql="select gid,gname,gpic,gprice from goods where gname like '%"+gname+"%'";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Goods good =new Goods(rs.getInt(1), rs.getDouble(4), rs.getString(3), rs.getString(2));
				list.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
