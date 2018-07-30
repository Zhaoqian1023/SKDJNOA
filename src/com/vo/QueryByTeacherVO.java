package com.vo;

public class QueryByTeacherVO {
	private String className;
	private String courseName;
	private String englishName;
	private String courseId;
	private String classId;
	public QueryByTeacherVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QueryByTeacherVO(String className, String courseName,
			String englishName, String courseId, String classId) {
		super();
		this.className = className;
		this.courseName = courseName;
		this.englishName = englishName;
		this.courseId = courseId;
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	
	

}
