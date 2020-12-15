package com.service;

import java.util.List;

import com.entity.Receinfo;

public interface RecService {
	//����ջ�����Ϣ
	public int addRec(Receinfo rec);
	//�޸��ջ�����Ϣ
	public int updateRec(Receinfo rec);
	//ɾ���ջ�����Ϣ
	public int deleteRec(int rid);
	//����ջ�����Ϣ
	public List<Receinfo> getRec(int uid);
	//��þ����ջ�����Ϣ
	public Receinfo  getReceinfo(int rid);
}
