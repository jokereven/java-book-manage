package com.svse.entity;

public class MyclassEntity {
//	cid mid(mname) gid(mname) mname mremark
	private int cid;
	private int mid;
	private String mname;
	private int gid;
	private String mremark;
	private String mojarmname;
	private String grademname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getMremark() {
		return mremark;
	}
	public void setMremark(String mremark) {
		this.mremark = mremark;
	}
	public String getMojarmname() {
		return mojarmname;
	}
	public void setMojarmname(String mojarmname) {
		this.mojarmname = mojarmname;
	}
	public String getGrademname() {
		return grademname;
	}
	public void setGrademname(String grademname) {
		this.grademname = grademname;
	}
}
