package com.service.impl;

import java.util.List;

import com.dao.impl.OrderDaoImpl;
import com.entity.OrderDetail;
import com.entity.Orders;
import com.entity.Receinfo;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDaoImpl odi= new OrderDaoImpl();
	@Override
	public int getOrder(int uid, int oid, double money, Receinfo rec) {
		// TODO Auto-generated method stub
		return odi.getOrder(uid, oid, money, rec);
	}
	@Override
	public List<Orders> getOrderByUid(int uid) {
		// TODO Auto-generated method stub
		return odi.getOrderByUid(uid);
	}
	@Override
	public int updateO(int uid, int oid, String ostatus, double money,
			Receinfo rec) {
		// TODO Auto-generated method stub
		return odi.updateO(uid, oid, ostatus, money, rec);
	}
	@Override
	public List<OrderDetail> getDetail(int oid) {
		// TODO Auto-generated method stub
		return odi.getDetail(oid);
	}

}
