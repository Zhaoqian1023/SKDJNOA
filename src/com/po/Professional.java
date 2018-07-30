package com.po;

public class Professional {
	private int pid;
	private String pname;
	private Colleage colleage;
	public Professional() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Professional(int pid, String pname, Colleage colleage) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.colleage = colleage;
	}

	public Colleage getColleage() {
		return colleage;
	}

	public void setColleage(Colleage colleage) {
		this.colleage = colleage;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	

}
