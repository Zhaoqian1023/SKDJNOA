package com.vo;

public class ElectiveStudentVO {
	
	private String studentId;
	private String studentName;
	private String courseId;
	private String courseName;
	private String classNameId;
	private String className;
	private String years;
	public ElectiveStudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassNameId() {
		return classNameId;
	}
	public void setClassNameId(String classNameId) {
		this.classNameId = classNameId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public ElectiveStudentVO(String studentId, String studentName,
			String courseId, String courseName, String classNameId,
			String className, String years) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.classNameId = classNameId;
		this.className = className;
		this.years = years;
	}
	
	

}
