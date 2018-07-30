package com.po;


public class Log {
	private int lid;
	private String ltime;
	private int luid;
	private String luser;
	private String lclass;
	private String lcourse;
	private String lcontrol;
	private String lgenre;
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(int lid, String ltime, int luid, String luser, String lclass,
			String lcourse, String lcontrol, String lgenre) {
		super();
		this.lid = lid;
		this.ltime = ltime;
		this.luid = luid;
		this.luser = luser;
		this.lclass = lclass;
		this.lcourse = lcourse;
		this.lcontrol = lcontrol;
		this.lgenre = lgenre;
	}
	public Log(String ltime, int luid, String luser, String lclass,
			String lcourse, String lcontrol, String lgenre) {
		super();
		this.ltime = ltime;
		this.luid = luid;
		this.luser = luser;
		this.lclass = lclass;
		this.lcourse = lcourse;
		this.lcontrol = lcontrol;
		this.lgenre = lgenre;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}
	public int getLuid() {
		return luid;
	}
	public void setLuid(int luid) {
		this.luid = luid;
	}
	public String getLuser() {
		return luser;
	}
	public void setLuser(String luser) {
		this.luser = luser;
	}
	public String getLclass() {
		return lclass;
	}
	public void setLclass(String lclass) {
		this.lclass = lclass;
	}
	public String getLcourse() {
		return lcourse;
	}
	public void setLcourse(String lcourse) {
		this.lcourse = lcourse;
	}
	public String getLcontrol() {
		return lcontrol;
	}
	public void setLcontrol(String lcontrol) {
		this.lcontrol = lcontrol;
	}
	public String getLgenre() {
		return lgenre;
	}
	public void setLgenre(String lgenre) {
		this.lgenre = lgenre;
	}
	
	

}
