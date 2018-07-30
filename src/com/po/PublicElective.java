package com.po;

public class PublicElective {
	//学生网上报选修课结果对象
	private int pid;
	private Student students;
	private PublicCourse publiccourses;
	private String year;
	public PublicElective() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PublicElective(int pid, Student students,
			PublicCourse publiccourses, String year) {
		super();
		this.pid = pid;
		this.students = students;
		this.publiccourses = publiccourses;
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public PublicCourse getPubliccourses() {
		return publiccourses;
	}
	public void setPubliccourses(PublicCourse publiccourses) {
		this.publiccourses = publiccourses;
	}
	public Student getStudents() {
		return students;
	}
	public void setStudents(Student students) {
		this.students = students;
	}
	

}
