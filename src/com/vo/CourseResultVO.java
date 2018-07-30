package com.vo;

public class CourseResultVO {
	private int stu1=0;
	private int stu2=0;
	private int stu3=0;
	private int stu4=0;
	private int stu5=0;
	private String s1="";
	private String s2="";
	private String s3="";
	private String s4="";
	private String s5="";
	private String avg="";
	private String paperProportion="";
	private String ordinaryProportion="";
	public CourseResultVO(int stu1, int stu2, int stu3, int stu4, int stu5,
			String s1, String s2, String s3, String s4, String s5, String avg,
			String paperProportion, String ordinaryProportion) {
		super();
		this.stu1 = stu1;
		this.stu2 = stu2;
		this.stu3 = stu3;
		this.stu4 = stu4;
		this.stu5 = stu5;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.avg = avg;
		this.paperProportion = paperProportion;
		this.ordinaryProportion = ordinaryProportion;
	}
	public int getStu1() {
		return stu1;
	}
	public void setStu1(int stu1) {
		this.stu1 = stu1;
	}
	public int getStu2() {
		return stu2;
	}
	public void setStu2(int stu2) {
		this.stu2 = stu2;
	}
	public int getStu3() {
		return stu3;
	}
	public void setStu3(int stu3) {
		this.stu3 = stu3;
	}
	public int getStu4() {
		return stu4;
	}
	public void setStu4(int stu4) {
		this.stu4 = stu4;
	}
	public int getStu5() {
		return stu5;
	}
	public void setStu5(int stu5) {
		this.stu5 = stu5;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getS4() {
		return s4;
	}
	public void setS4(String s4) {
		this.s4 = s4;
	}
	public String getS5() {
		return s5;
	}
	public void setS5(String s5) {
		this.s5 = s5;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getPaperProportion() {
		return paperProportion;
	}
	public void setPaperProportion(String paperProportion) {
		this.paperProportion = paperProportion;
	}
	public String getOrdinaryProportion() {
		return ordinaryProportion;
	}
	public void setOrdinaryProportion(String ordinaryProportion) {
		this.ordinaryProportion = ordinaryProportion;
	}
	
}
