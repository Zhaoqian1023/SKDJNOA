package com.po;

import java.util.Set;

public class Course {
	private int cid;
	private String cname;
	private String category;
	private float credits;
	private String time;
	private int beginTime;
	private String year;
	private int endTime;
	private Teacher teachers;
	private Set<ClassName> classNames;
	private String courseNum;
	private int examFlag;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String cname, String category, float credits,
			String time, int beginTime, String year, int endTime,
			Teacher teachers, Set<ClassName> classNames, String courseNum,
			int examFlag) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.category = category;
		this.credits = credits;
		this.time = time;
		this.beginTime = beginTime;
		this.year = year;
		this.endTime = endTime;
		this.teachers = teachers;
		this.classNames = classNames;
		this.courseNum = courseNum;
		this.examFlag = examFlag;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCredits() {
		return credits;
	}
	public void setCredits(float credits) {
		this.credits = credits;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public Teacher getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}
	public Set<ClassName> getClassNames() {
		return classNames;
	}
	public void setClassNames(Set<ClassName> classNames) {
		this.classNames = classNames;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public int getExamFlag() {
		return examFlag;
	}
	public void setExamFlag(int examFlag) {
		this.examFlag = examFlag;
	}
	
	
	
	

}
