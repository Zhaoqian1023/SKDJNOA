package com.po;


public class PublicCourse {
	//在官网上公布的待选修的公选课对象
	private int pid;
	private String pname;
	private String category;
	private float credits;
	private String time;
	private int beginTime;
	private String year;
	private int endTime;
	private Teacher teachers;
	private String courseNum;
	private int examFlag;
	public PublicCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PublicCourse(int pid, String pname, String category, float credits,
			String time, int beginTime, String year, int endTime,
			Teacher teachers, String courseNum, int examFlag) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.category = category;
		this.credits = credits;
		this.time = time;
		this.beginTime = beginTime;
		this.year = year;
		this.endTime = endTime;
		this.teachers = teachers;
		this.courseNum = courseNum;
		this.examFlag = examFlag;
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
