package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import com.dao.BaseDao;
import com.dao.OrderDao;
import com.dao.ReceinfoDao;
import com.entity.Goods;
import com.entity.OrderDetail;
import com.entity.Orders;
import com.entity.Receinfo;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int getOrder(int uid,int oid,double money,Receinfo rec) {
		String sql=" insert into orders values(?,?,?,?,?,?,?)";
		Object[] obj={oid,uid,"Î´·¢»õ",money,rec.getRname(),rec.getRphone(),rec.getRaddr()};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public List<Orders> getOrderByUid(int uid) {
		List<Orders> list = new ArrayList<Orders>();
		String sql="select * from orders where uid=?";
		Object[] obj ={uid};
		ResultSet rs =super.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Orders order= new Orders(rs.getInt(1), uid, rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(order);
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
	public int updateO(int uid,int oid,String ostatus,double money,Receinfo rec) {
		String sql="update orders set uid=?,ostatus=?,omoney=?,rname=?,rphone=?,raddr=? where oid=?";
		Object [] obj={uid,ostatus,money,rec.getRname(),rec.getRphone(),rec.getRaddr(),oid};
		return super.executeUpdate(sql, obj);
	}

	@Override
	public List<OrderDetail> getDetail(int oid) {
		List<OrderDetail> list = new ArrayList<OrderDetail>() ;
		String sql="select * from orderdetail where oid=?";
		Object[] obj={oid};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while (rs.next()){
				OrderDetail detail=new OrderDetail(rs.getInt(1), oid, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
				list.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

}
