package com.po;

import java.util.Set;

public class ClassName {
	private int cid;
	private String cname;
	private String englishname;
	private Professional professions;
	private Set<Course> courses;
	public ClassName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClassName(int cid, String cname, String englishname,
			Professional professions) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.englishname = englishname;
		this.professions = professions;
	}

	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Professional getProfessions() {
		return professions;
	}
	public void setProfessions(Professional professions) {
		this.professions = professions;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	

}
