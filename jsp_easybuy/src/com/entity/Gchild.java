package com.entity;

public class Gchild {
	private int gchid;
	private int gcid;
	private String gchname;
	private String gcname;

	
	public int getGchid() {
		return gchid;
	}
	public void setGchid(int gchid) {
		this.gchid = gchid;
	}
	public int getGcid() {
		return gcid;
	}
	public void setGcid(int gcid) {
		this.gcid = gcid;
	}
	public String getGchname() {
		return gchname;
	}
	public void setGchname(String gchname) {
		this.gchname = gchname;
	}
	public String getGcname() {
		return gcname;
	}
	public void setGcname(String gcname) {
		this.gcname = gcname;
	}
	public Gchild(int gchid, int gcid, String gchname) {
		super();
		this.gchid = gchid;
		this.gcid = gcid;
		this.gchname = gchname;
	}
	public Gchild(int gchid, int gcid, String gchname, String gcname) {
		super();
		this.gchid = gchid;
		this.gcid = gcid;
		this.gchname = gchname;
		this.gcname = gcname;
	}
}
