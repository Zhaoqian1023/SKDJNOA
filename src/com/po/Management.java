package com.po;

public class Management {
	private int mid;
	private String mname;
	private String passWord;
	public Management() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Management(int mid, String mname, String passWord) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.passWord = passWord;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
