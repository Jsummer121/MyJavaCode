package com.service;

import java.util.List;

import com.entity.OrderDetail;
import com.entity.Orders;
import com.entity.Receinfo;

public interface OrderService {
	//生成订单表
	public int getOrder(int uid,int oid,double money,Receinfo rec);
	//根据用户id获得订单
	public List<Orders>  getOrderByUid(int uid);
	//修改订单
	public int updateO(int uid,int oid,String ostatus,double money,Receinfo rec);
	//通过订单id查看订单详情
	public List<OrderDetail> getDetail(int oid);
}
