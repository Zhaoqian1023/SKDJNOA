package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.po.Log;
import com.po.Management;
import com.service.ManagerService;
import com.service.PasswordUpdate;
import com.service.StudentService;
import com.util.JsonUtil;
import com.util.MD5Util;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport {

	private String teacherId;
	@SuppressWarnings("rawtypes")
	private List fileList;
	private List<Log> logsList;
	private String mid;
	private String passWord;
	private String newpassword;
	private Management manager;
	private String page;
	private String years;
	private HttpSession session;
	private String studentId;
	private String nj;
	private String zt;
	private String fileName;
	
	public String login(){
		/*System.out.println("login:begin");*/
		passWord = passWord.replace("%2B", "+");
		if(mid == null || passWord == null || "".equals(mid) || "".equals(passWord)){
			JsonUtil.sendError();
			return NONE;
		}
		String upwd=MD5Util.getMD5(passWord);
		//验证
		/*String str = mid+passWord;
		String inj_str ="'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String[] inj_stra=inj_str.split("\\|");
		for (int i=0; i < inj_stra.length; i++ ){
			if (str.indexOf(inj_stra[i])>=0){
				JsonUtil.sendError();
				return NONE;
			}
		}*/
		Management man = null;
		man = ManagerService.getManagement(mid,upwd);
		if(man != null){
			manager = man;
			session = ServletActionContext.getRequest().getSession();
			session.setAttribute("manager", manager);
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	
	public String update(){
		session=ServletActionContext.getRequest().getSession();
		manager=(Management) session.getAttribute("manager");
		manager.setPassWord(newpassword);
		if(PasswordUpdate.passwordUpdateManager(manager)){
			/*System.out.println("跳转页面："+page);*/
			session.setAttribute("manager", null);
			return "ManagerSuccess";
		}
		return "error";
	}
	public String quit(){
		session=ServletActionContext.getRequest().getSession();
		session.setAttribute("manager", null);
		page="index_manager";
		return "judgeManagerSuccess";
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String forgetPwd(){
		if(teacherId != null){
			String  newPwd=ManagerService.modifyTeacherPwd(teacherId);
			List msgList =new ArrayList();
			if(!"fail".equals(newPwd)){
				msgList.add(newPwd);
				JsonUtil.sendList(msgList);
			}
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String forgetStudentPwd(){
		if(studentId != null){
			String  newPwd=StudentService.modifyStudentPwd(studentId);
			List msgList =new ArrayList();
			if(!"fail".equals(newPwd)){
				msgList.add(newPwd);
				JsonUtil.sendList(msgList);
			}
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	
	public String fileDownLoad(){
		String tempYears = years.replace('/', '-');
		String temp = "/manager/downloadscore/"+tempYears;
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath(temp);
		if(ManagerService.downLoadScore(URL,years)){
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	public String downloadCoursePlan(){
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/courseplandownload");
		if("".equals(years) || years == null){
			return "error";
		}
		if(ManagerService.downLoadCoursePlan(URL,years)){
			page = "";
			return "Success";
		}else{
			page = "";
			return "Error";
		}
	}
	public String downloadSelectCoursePlan(){
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/selectcourseplandownload");
		if("".equals(years) || years == null){
			return "error";
		}
		String category = "选修";
		if(ManagerService.downLoadSelectCoursePlan(URL,years,category)){
			page = "";
			return "Success";
		}else{
			page = "";
			return "Error";
		}
	}
	public String downloadTeacher(){
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/teacherdownload");
		if("".equals(fileName) || fileName == null){
			return "error";
		}
		if(ManagerService.downLoadTeacher(URL,fileName)){
			page = "";
			return "Success";
		}else{
			page = "";
			return "Error";
		}
	}
	public String downloadPublicCoursePlan(){
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/publiccourseplandownload");
		if("".equals(years) || years == null){
			return "error";
		}
		String category = "公选";
		if(ManagerService.downLoadSelectCoursePlan(URL,years,category)){
			page = "";
			return "Success";
		}else{
			page = "";
			return "Error";
		}
	}
	public String initFile(){
		String tempYears = years.replace('/', '-');
		String temp = "/manager/downloadscore/"+tempYears;
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath(temp);
		fileList=ManagerService.showFile(URL);
		return "initSuccess";
	}
	
	public String showLogs(){
		logsList = ManagerService.showLogs();
		return "initSuccess";
	}
	
	public String initLogsFile(){
		String temp = "/manager/logsdownload";
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath(temp);
		fileList=ManagerService.showFile(URL);
		return "initSuccess";
	}
	public String initStudentFile(){
		String temp = "/manager/studentdownload";
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath(temp);
		fileList=ManagerService.showFile(URL);
		return "initSuccess";
	}
	public String logsDownLoad(){
			
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/logsdownload");
		if(ManagerService.downLoadLogs(URL)){
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	public String studentDownLoad(){
		if("".equals(nj) || "".equals(zt) || nj == null || zt == null){
			JsonUtil.sendError();
		}
		String URL=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/manager/studentdownload");
		if(ManagerService.downLoadStudent(URL,nj,zt)){
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	

	
	
	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	

	
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public List<Log> getLogsList() {
		return logsList;
	}

	public void setLogsList(List<Log> logsList) {
		this.logsList = logsList;
	}

	@SuppressWarnings("rawtypes")
	public List getFileList() {
		return fileList;
	}

	@SuppressWarnings("rawtypes")
	public void setFileList(List fileList) {
		this.fileList = fileList;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public Management getManager() {
		return manager;
	}

	public void setManager(Management manager) {
		this.manager = manager;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getNj() {
		return nj;
	}

	public void setNj(String nj) {
		this.nj = nj;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	
	
	

}
