package com.action;

import java.util.List;










import com.opensymphony.xwork2.ActionSupport;
import com.service.PrintService;
import com.service.PublicCourseService;
import com.vo.AttendanceVO;
import com.vo.SaveScoreVO;

@SuppressWarnings("serial")
public class PrintAction extends ActionSupport {
	
	private String bjm;
	private String year;
	private String kcm;
	private String kcdm;
	private String bjdm;
	private String page;
	private String status;
	private String nextPage;
	private String fangshi;
	private List<AttendanceVO> list;
	private List<SaveScoreVO> listST;
	
	//按照班级和课程代码打印学生名单（必修课程）
	public String printFunction(){
		if(bjdm == null || kcdm == null){
			return "printError";
		}
		
		list =PrintService.printAttendance(bjdm, kcdm, status);
		
		if(list.size()==0||list==null){
			return "printError";
		}else{
			nextPage="print"+page;
		}
		return "printSuccess";
	}
	
	//输出待录入成绩的学生课程信息(必修)
	public String printFunctionasinput(){
		if(bjdm == null || kcdm == null){
			return "printError";
		}
		//先从缓存表中先获取成绩
		/*System.out.println("进入PrintService.printSaveScore(bjm,kcm,fangshi)前！");*/
		listST = PrintService.printSaveScore(bjdm,kcdm,fangshi);
		/*System.out.println("listST.size:"+listST.size());*/
		if(listST.size() > 0){//有预报寻的数据
			nextPage = "save"+page;
		}else{//无预保存，则进入全新的录入成绩页面
			list = PrintService.printAttendance(bjdm, kcdm, status);
			if(list.size()==0||list==null){
				return "printError";
			}else{
				nextPage="print"+page;
			}
		}
		return "printSuccess";
	
	}
	//输出待录入成绩的学生课程信息(选修)
	public String printFunctionasinput_select(){
		if(bjdm == null || kcdm == null){
			return "printError";
		}
		//先从缓存表中先获取成绩
		listST = PrintService.printSaveScore(bjdm,kcdm,fangshi);
		if(listST.size() > 0){//有预报寻的数据
			nextPage = "save"+page;
		}else{//无预保存，则进入全新的录入成绩页面
			list = PrintService.printSelectAttendance(bjdm, kcdm, status);
			if(list.size()==0||list==null){
				return "printError";
			}else{
				nextPage="print"+page;
			}
		}
		return "printSuccess";
	
	}
	//输出系选修课学生名单
	public String printSelect(){
		if(bjdm == null || kcdm == null){
			return "printError";
		}
		
		list =PrintService.printSelectAttendance(bjdm, kcdm, status);
		if(list.size()==0||list==null){
			return "printError";
		}else{
			nextPage="print"+page;
		}
		return "printSuccess";
	}
	
	//输出公选课待录入成绩的学生课程信息
	public String printGXAsInput(){
		listST = PrintService.printSaveScoreGX(kcdm,fangshi);
		if(listST.size() > 0){
			nextPage = "save"+page;
		}else{
			list = PublicCourseService.getAttendanceVO(year, kcdm, status);
			if(list.size()==0||list==null){
				return "printError";
			}else{
				nextPage = page;
			}
		}
		return "printSuccess";
	}
	
	
	
	

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getBjm() {
		return bjm;
	}

	public void setBjm(String bjm) {
		this.bjm = bjm;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKcm() {
		return kcm;
	}

	public void setKcm(String kcm) {
		this.kcm = kcm;
	}

	public List<AttendanceVO> getList() {
		return list;
	}

	public void setList(List<AttendanceVO> list) {
		this.list = list;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFangshi() {
		return fangshi;
	}
	public void setFangshi(String fangshi) {
		this.fangshi = fangshi;
	}
	public List<SaveScoreVO> getListST() {
		return listST;
	}
	public void setListST(List<SaveScoreVO> listST) {
		this.listST = listST;
	}
	public String getKcdm() {
		return kcdm;
	}
	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}
	public String getBjdm() {
		return bjdm;
	}
	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}
	
	
	

}
