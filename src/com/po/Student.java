package com.po;


public class Student {
	
	private String sid;
	private String sname;
	private String englishname;
	private String sex;
	private String number;
	private String political;
	private String national;
	private String amissionTime;
	private String graduationTime;
	
	private ClassName className;
	private Professional professions;
	private Colleage colleages;
	private String note;
	private String status;
	private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sid, String sname, String englishname, String sex,
			String number, String political, String national,
			String amissionTime, String graduationTime,
			ClassName className, Professional professions, Colleage colleages,
			String note, String status, String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.englishname = englishname;
		this.sex = sex;
		this.number = number;
		this.political = political;
		this.national = national;
		this.amissionTime = amissionTime;
		this.graduationTime = graduationTime;
		this.className = className;
		this.professions = professions;
		this.colleages = colleages;
		this.note = note;
		this.status = status;
		this.password = password;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getAmissionTime() {
		return amissionTime;
	}
	public void setAmissionTime(String amissionTime) {
		this.amissionTime = amissionTime;
	}
	public String getGraduationTime() {
		return graduationTime;
	}
	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}
	public ClassName getClassName() {
		return className;
	}
	public void setClassName(ClassName className) {
		this.className = className;
	}
	public Professional getProfessions() {
		return professions;
	}
	public void setProfessions(Professional professions) {
		this.professions = professions;
	}
	public Colleage getColleages() {
		return colleages;
	}
	public void setColleages(Colleage colleages) {
		this.colleages = colleages;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
