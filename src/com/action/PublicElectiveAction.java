package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PublicElectiveService;

@SuppressWarnings("serial")
public class PublicElectiveAction extends ActionSupport {
	private String courseId;
	private String page;
	private String filePath;
	
	public String getStudentByCourse(){
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/electivestudentdownload");
		
		filePath = PublicElectiveService.exportStudentByCid(courseId,URL);
		page = "electivestudentdownload_manager";
		return "initSuccess";
	}

	
	
	
	
	
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
	

}
