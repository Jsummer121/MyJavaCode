package com.service;

import java.util.List;

import com.entity.Goods;

public interface DetailService {
	//���ɶ�������
	public int getDetail(int oid,Goods good);
	//�鿴������Ʒid
	public List<Goods>  getHot();
	//������Ʒ���з�ҳ
	public List<Goods> hotPageData(int pagesize,int pageCount);
}
