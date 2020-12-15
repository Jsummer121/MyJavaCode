package com.entity;

public class Receinfo {
	private int rid;
	private int uid;
	private String rname;
	private String rphone;
	private String raddr;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRaddr() {
		return raddr;
	}
	public void setRaddr(String raddr) {
		this.raddr = raddr;
	}
	public Receinfo(int rid, int uid, String rname, String rphone, String raddr) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.rname = rname;
		this.rphone = rphone;
		this.raddr = raddr;
	}
	
}
