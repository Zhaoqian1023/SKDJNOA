package com.vo;

public class AttendanceVO {
	private String className;
	private int classId;
	private String years;
	private String courseName;
	private String category;
	private float credits;
	private String sid;
	private String sname;
	private String englishName;
	private String classEnglish;
	private int courseId;
	private int examFlag;
	
	public AttendanceVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AttendanceVO(String className, int classId, String years,
			String courseName, String category, float credits, String sid,
			String sname, String englishName, String classEnglish,
			int courseId, int examFlag) {
		super();
		this.className = className;
		this.classId = classId;
		this.years = years;
		this.courseName = courseName;
		this.category = category;
		this.credits = credits;
		this.sid = sid;
		this.sname = sname;
		this.englishName = englishName;
		this.classEnglish = classEnglish;
		this.courseId = courseId;
		this.examFlag = examFlag;
	}



	public int getExamFlag() {
		return examFlag;
	}



	public void setExamFlag(int examFlag) {
		this.examFlag = examFlag;
	}



	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
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

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getClassEnglish() {
		return classEnglish;
	}

	public void setClassEnglish(String classEnglish) {
		this.classEnglish = classEnglish;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	



}
