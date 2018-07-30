package com.po;

public class ScoreManagement {
	
	private int smid;
	private String studentId;
	private String studentName;
	private int classId;
	private String className;
	private String year;
	private String category;
	private String course;
	private int courseId;
	private float credits;
	private float paperProportion;
	private float ordinaryProportion;
	private String paperGrade;
	private String ordinaryGrade;
	private String finalGrade;
	private String beizhu;
	private String resetGrade1;
	private String resetGrade2;
	private String resetGrade3;
	private int examFlag;
	private String teacherName;
	
	public ScoreManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ScoreManagement(int smid, String studentId, String studentName,
			int classId, String className, String year, String category,
			String course, int courseId, float credits, float paperProportion,
			float ordinaryProportion, String paperGrade, String ordinaryGrade,
			String finalGrade, String beizhu, String resetGrade1,
			String resetGrade2, String resetGrade3, int examFlag, String teacherName) {
		super();
		this.smid = smid;
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.className = className;
		this.year = year;
		this.category = category;
		this.course = course;
		this.courseId = courseId;
		this.credits = credits;
		this.paperProportion = paperProportion;
		this.ordinaryProportion = ordinaryProportion;
		this.paperGrade = paperGrade;
		this.ordinaryGrade = ordinaryGrade;
		this.finalGrade = finalGrade;
		this.beizhu = beizhu;
		this.resetGrade1 = resetGrade1;
		this.resetGrade2 = resetGrade2;
		this.resetGrade3 = resetGrade3;
		this.examFlag = examFlag;
		this.teacherName = teacherName;
	}
	public ScoreManagement( String studentId, String studentName,
			int classId, String className, String year, String category,
			String course, int courseId, float credits, float paperProportion,
			float ordinaryProportion, String paperGrade, String ordinaryGrade,
			String finalGrade, String beizhu, String resetGrade1,
			String resetGrade2, String resetGrade3, int examFlag, String teacherName) {
		super();
	
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.className = className;
		this.year = year;
		this.category = category;
		this.course = course;
		this.courseId = courseId;
		this.credits = credits;
		this.paperProportion = paperProportion;
		this.ordinaryProportion = ordinaryProportion;
		this.paperGrade = paperGrade;
		this.ordinaryGrade = ordinaryGrade;
		this.finalGrade = finalGrade;
		this.beizhu = beizhu;
		this.resetGrade1 = resetGrade1;
		this.resetGrade2 = resetGrade2;
		this.resetGrade3 = resetGrade3;
		this.examFlag = examFlag;
		this.teacherName = teacherName;
	}


	public String getBeizhu() {
		return beizhu;
	}



	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}



	public String getResetGrade1() {
		return resetGrade1;
	}

	public void setResetGrade1(String resetGrade1) {
		this.resetGrade1 = resetGrade1;
	}

	public String getResetGrade2() {
		return resetGrade2;
	}

	public void setResetGrade2(String resetGrade2) {
		this.resetGrade2 = resetGrade2;
	}

	public String getResetGrade3() {
		return resetGrade3;
	}

	public void setResetGrade3(String resetGrade3) {
		this.resetGrade3 = resetGrade3;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	public int getSmid() {
		return smid;
	}

	public void setSmid(int smid) {
		this.smid = smid;
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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
	}

	public float getPaperProportion() {
		return paperProportion;
	}

	public void setPaperProportion(float paperProportion) {
		this.paperProportion = paperProportion;
	}

	public float getOrdinaryProportion() {
		return ordinaryProportion;
	}

	public void setOrdinaryProportion(float ordinaryProportion) {
		this.ordinaryProportion = ordinaryProportion;
	}

	public String getPaperGrade() {
		return paperGrade;
	}

	public void setPaperGrade(String paperGrade) {
		this.paperGrade = paperGrade;
	}

	public String getOrdinaryGrade() {
		return ordinaryGrade;
	}

	public void setOrdinaryGrade(String ordinaryGrade) {
		this.ordinaryGrade = ordinaryGrade;
	}



	public int getExamFlag() {
		return examFlag;
	}



	public void setExamFlag(int examFlag) {
		this.examFlag = examFlag;
	}



	public String getTeacherName() {
		return teacherName;
	}



	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	

}
