package com.service.impl;

import java.util.List;

import com.dao.impl.DetailDaoImpl;
import com.entity.Goods;
import com.service.DetailService;

public class DetailServiceImpl implements DetailService {
	DetailDaoImpl ddi =new DetailDaoImpl();
	@Override
	public int getDetail(int oid, Goods good) {
		// TODO Auto-generated method stub
		return ddi.getDetail(oid, good);
	}
	@Override
	public List<Goods> getHot() {
		// TODO Auto-generated method stub
		return ddi.getHot();
	}
	@Override
	public List<Goods> hotPageData(int pagesize, int pageCount) {
		// TODO Auto-generated method stub
		return ddi.hotPageData(pagesize, pageCount);
	}

}
