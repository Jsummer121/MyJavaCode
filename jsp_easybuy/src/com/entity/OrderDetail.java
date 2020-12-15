package com.entity;

public class OrderDetail {
	private int gid;
	private int oid;
	private String gname;
	private String gpic;
	private double gprice;
	private int gnum;

	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGpic() {
		return gpic;
	}
	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	

	public OrderDetail(int gid, int oid, String gname, String gpic,
			double gprice, int gnum) {
		super();
		this.gid = gid;
		this.oid = oid;
		this.gname = gname;
		this.gpic = gpic;
		this.gprice = gprice;
		this.gnum = gnum;
	}

	
	
}
