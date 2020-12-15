package com.dao;

import java.util.List;

import com.entity.Goods;
import com.entity.OrderDetail;
import com.entity.Orders;
import com.entity.Receinfo;

public interface OrderDao {
	//���ɶ�����
	public int getOrder(int uid,int oid,double money,Receinfo rec);
	//�����û�id��ö���
	public List<Orders>  getOrderByUid(int uid);
	//�޸Ķ���
	public int updateO(int uid,int oid,String ostatus,double money,Receinfo rec);
	//ͨ������id�鿴��������
	public List<OrderDetail> getDetail(int oid);
}
