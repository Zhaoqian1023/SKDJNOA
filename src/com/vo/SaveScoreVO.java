package com.vo;

public class SaveScoreVO {
	private int stId;
	private String className;
	private String classId;
	private String years;
	private String courseName;
	private String studentId;
	private String studentName;
	private String ordinaryScore;
	private String paperScore;
	private String remark;
	private String remarkNum;
	private String ordinaryProportion;
	private String paperProportion;
	private String credit;
	private String courseCategory;
	private String flag;
	private String finalScore;
	private String finalScoreNum;
	private String courseId;
	private String examFlag;
	public SaveScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SaveScoreVO(int stId, String className, String classId,
			String years, String courseName, String studentId,
			String studentName, String ordinaryScore, String paperScore,
			String remark, String remarkNum, String ordinaryProportion,
			String paperProportion, String credit, String courseCategory,
			String flag, String finalScore, String finalScoreNum,
			String courseId, String examFlag) {
		super();
		this.stId = stId;
		this.className = className;
		this.classId = classId;
		this.years = years;
		this.courseName = courseName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.ordinaryScore = ordinaryScore;
		this.paperScore = paperScore;
		this.remark = remark;
		this.remarkNum = remarkNum;
		this.ordinaryProportion = ordinaryProportion;
		this.paperProportion = paperProportion;
		this.credit = credit;
		this.courseCategory = courseCategory;
		this.flag = flag;
		this.finalScore = finalScore;
		this.finalScoreNum = finalScoreNum;
		this.courseId = courseId;
		this.examFlag = examFlag;
	}

	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
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
	public String getOrdinaryScore() {
		return ordinaryScore;
	}
	public void setOrdinaryScore(String ordinaryScore) {
		this.ordinaryScore = ordinaryScore;
	}
	public String getPaperScore() {
		return paperScore;
	}
	public void setPaperScore(String paperScore) {
		this.paperScore = paperScore;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkNum() {
		return remarkNum;
	}
	public void setRemarkNum(String remarkNum) {
		this.remarkNum = remarkNum;
	}
	public String getOrdinaryProportion() {
		return ordinaryProportion;
	}
	public void setOrdinaryProportion(String ordinaryProportion) {
		this.ordinaryProportion = ordinaryProportion;
	}
	public String getPaperProportion() {
		return paperProportion;
	}
	public void setPaperProportion(String paperProportion) {
		this.paperProportion = paperProportion;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
	public String getFinalScoreNum() {
		return finalScoreNum;
	}
	public void setFinalScoreNum(String finalScoreNum) {
		this.finalScoreNum = finalScoreNum;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getExamFlag() {
		return examFlag;
	}

	public void setExamFlag(String examFlag) {
		this.examFlag = examFlag;
	}
	

}
