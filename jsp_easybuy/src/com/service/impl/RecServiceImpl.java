package com.service.impl;

import java.util.List;

import com.dao.impl.RecDaoImpl;
import com.entity.Receinfo;
import com.service.RecService;

public class RecServiceImpl implements RecService {
	
	RecDaoImpl rdi= new RecDaoImpl();
	@Override
	public int addRec(Receinfo rec) {
		// TODO Auto-generated method stub
		return rdi.addRec(rec);
	}

	@Override
	public int updateRec(Receinfo rec) {
		// TODO Auto-generated method stub
		return rdi.updateRec(rec);
	}

	@Override
	public int deleteRec(int rid) {
		// TODO Auto-generated method stub
		return rdi.deleteRec(rid);
	}

	@Override
	public List<Receinfo> getRec(int uid) {
		// TODO Auto-generated method stub
		return rdi.getRec(uid);
	}

	@Override
	public Receinfo getReceinfo(int rid) {
		// TODO Auto-generated method stub
		return rdi.getReceinfo(rid);
	}

}
