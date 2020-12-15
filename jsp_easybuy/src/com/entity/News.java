package com.entity;

public class News {
	private int nid;
	private String ntitle;
	private String  ncontent;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public News(int nid, String ntitle, String ncontent) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
	}
	
}
