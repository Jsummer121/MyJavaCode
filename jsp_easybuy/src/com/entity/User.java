package com.entity;

public class User {
	private int uid;
	private String uname;
	private String upass;
	private int type;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public User(int uid, String uname, String upass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User(int uid, String uname, String upass, int type) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}
	

}
