package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.impl.ClassNameDao;
import com.dao.impl.ColleageDao;
import com.dao.impl.ProfessionalDao;
import com.dao.impl.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.po.ClassName;
import com.po.Colleage;
import com.po.Log;
import com.po.Management;
import com.po.Professional;
import com.po.ScoreManagement;
import com.po.Student;
import com.service.LogService;
import com.service.StudentService;
import com.util.JsonUtil;
import com.util.MD5Util;


@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {

	private Student student;
	private String sid;
	private String sname;
	private String stuPassWord;
	private String englishname;
	private String sex;
	private String number;
	private String political;
	private String national;
	private String amissionTime;
	private String graduationTime;
	private String classnamename;
	private String professionsname;
	private String colleagesname;
	private String note;
	private String status;
	private HttpSession session;
	private String page;
	private Map<String,List<ScoreManagement>> dataMap;
	private String newpassword1;
	private String newpassword2;
	
	
	/**
	 * 
	 * @Description: 登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String login() {
		stuPassWord = stuPassWord.replace("%2B", "+");
		if(sid == null || sname == null || stuPassWord == null){
			JsonUtil.sendError();
			return NONE;
		}
		student = StudentService.getStudent(sid, sname, MD5Util.getMD5(stuPassWord));
		if (student != null) {
			try {
				session = ServletActionContext.getRequest().getSession();
				session.setAttribute("studentLogin", student);
			} catch (Exception e) {
				JsonUtil.sendError();
			}
			JsonUtil.sendSuccess();
		} else {
			JsonUtil.sendError();
		}
		return NONE;
	}
	public String changePwd(){
		if("".equals(newpassword1) || "".equals(newpassword2)){
			page = "error";
			return "initSuccess";
		}
		session = ServletActionContext.getRequest().getSession();
		student =(Student) session.getAttribute("studentLogin");
		if(student == null){
			page = "error";
		}else{
			boolean result = false;
			result = StudentService.changePwd(student,MD5Util.getMD5(newpassword1),MD5Util.getMD5(newpassword2));
			if(result){
				page = "StudentLogin";
			}
		}
		session.removeAttribute("studentLogin");
		return "initSuccess";
	}
	public String getScore(){
		session = ServletActionContext.getRequest().getSession();
		student =(Student) session.getAttribute("studentLogin");
		if(student == null){
			page = "error";
		}else{
			dataMap = StudentService.getScore(student.getSid());
			if(dataMap.get("info").size() == 0){
				page = "scoreerror";
			}
		}
		session.removeAttribute("studentLogin");
		return "initSuccess";
	}
	public String queryStudent() {
		StudentDao sdao = new StudentDao();
		student = sdao.get(sid.trim());
		if (null != student) {
			session = ServletActionContext.getRequest().getSession();
			if (null == student.getPolitical()) {
				session.setAttribute("political1", "");
			} else {
				session.setAttribute("political1", student.getPolitical());
			}
			session.setAttribute("sex1", student.getSex());
			session.setAttribute("colleagesname1", student.getColleages()
					.getCname());
			session.setAttribute("colleagesname2", student.getColleages()
					.getCname());
			session.setAttribute("colleagesname3", student.getColleages()
					.getCname());

			return "findstudentsuccess";
		}
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("findstudenterror", "1");
		return "updatestudent";
	}

	public String updateStudent() {
		session = ServletActionContext.getRequest().getSession();
		StudentDao studentDao = new StudentDao();
		ClassNameDao classnameDao = new ClassNameDao();
		ColleageDao colleageDao = new ColleageDao();
		ProfessionalDao professionalDao = new ProfessionalDao();
		ClassName classname = (ClassName) classnameDao.get(classnamename);
		Colleage colleage = (Colleage) colleageDao.get(colleagesname);
		Professional professional = (Professional) professionalDao
				.get(professionsname);
		if (classname != null && colleage != null && professional != null) {
			Student stu = new Student();
			if (null == englishname) {
				englishname = "";
			}
			if (null == note.trim()) {
				note = "";
			}
			stu.setSid(sid);
			stu.setSname(sname.trim());
			stu.setEnglishname(englishname);
			stu.setSex(sex);
			stu.setNumber(number.trim());
			stu.setPolitical(political);
			stu.setNational(national.trim());
			stu.setAmissionTime(amissionTime.trim());
			stu.setGraduationTime(graduationTime.trim());
			stu.setClassName(classname);
			stu.setProfessions(professional);
			stu.setColleages(colleage);
			stu.setNote(note);
			stu.setStatus(status);
			Student tempStudent= new Student();
			tempStudent = StudentService.getStudent(sid);
			stu.setPassword(tempStudent.getPassword());
			boolean b = studentDao.update(stu);
			if (b) {
				Management management = (Management) session
						.getAttribute("manager");
				Log log = new Log("", management.getMid(),
						management.getMname(), stu.getSid(),
						 stu.getSname(), "学生信息修改",
						"管理员");
				LogService.addLog(log);

				session.setAttribute("updatesuccess", "success");
				return "updatestudent";
			} else {
				session.setAttribute("updateerror", "error");
				return "updatestudent";
			}
		}
		session.setAttribute("updateerror", "error");
		return "updatestudent";
	}

	public String addStudent() {
		session = ServletActionContext.getRequest().getSession();
		StudentDao studentDao = new StudentDao();
		ClassNameDao classnameDao = new ClassNameDao();
		ColleageDao colleageDao = new ColleageDao();
		ProfessionalDao professionalDao = new ProfessionalDao();
		ClassName classname = (ClassName) classnameDao.get(classnamename);
		Colleage colleage = (Colleage) colleageDao.get(colleagesname);
		Professional professional = (Professional) professionalDao
				.get(professionsname);
		if (studentDao.get(sid.trim()) != null) {
			session.setAttribute("addstudenterror1", "error");
			return "updatestudent";
		}

		if (classname != null && colleage != null && professional != null) {
			Student stu = new Student();
			if (null == englishname) {
				englishname = "";
			}
			if (null == note) {
				note = "";
			}
			stu.setSid(sid.trim());
			stu.setSname(sname.trim());
			stu.setEnglishname(englishname);
			stu.setSex(sex);
			stu.setNumber(number.trim());
			stu.setPolitical(political);
			stu.setNational(national.trim());
			stu.setAmissionTime(amissionTime.trim());
			stu.setGraduationTime(graduationTime.trim());
			stu.setClassName(classname);
			stu.setProfessions(professional);
			stu.setColleages(colleage);
			stu.setNote(note);
			stu.setStatus(status);
			stu.setPassword(MD5Util.getMD5("123456"));

			boolean b = studentDao.add(stu);
			if (b) {
				Management management = (Management) session
						.getAttribute("manager");
				
				Log log = new Log("", management.getMid(),
						management.getMname(), stu.getSid(),
						 stu.getSname(), "学生添加",
						"管理员");
				LogService.addLog(log);
				session.setAttribute("addstudentsuccess", "success");
				return "updatestudent";
			} else {
				session.setAttribute("addstudenterror", "error");
				return "updatestudent";
			}
		}
		session.setAttribute("addstudenterror", "error");
		return "updatestudent";
	}

	public String delStudent() {
		session = ServletActionContext.getRequest().getSession();
		StudentDao studentDao = new StudentDao();
		Student stu = studentDao.get(sid);
		if (null != stu) {
			boolean b = studentDao.del(stu);
			if (b) {
				Management management = (Management) session
						.getAttribute("manager");
				
				Log log = new Log("", management.getMid(),
						management.getMname(),  stu.getSid(),
						 stu.getSname(),"学生删除",
						"管理员");
				LogService.addLog(log);
				session.setAttribute("delstudentsuccess", "success");
				return "updatestudent";
			} else {
				session.setAttribute("delstudenterror", "error");
				return "updatestudent";
			}
		}
		session.setAttribute("delstudenterror", "error");
		return "updatestudent";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getAmissionTime() {
		return amissionTime;
	}

	public void setAmissionTime(String amissionTime) {
		this.amissionTime = amissionTime;
	}

	public String getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getClassnamename() {
		return classnamename;
	}

	public void setClassnamename(String classnamename) {
		this.classnamename = classnamename;
	}

	public String getProfessionsname() {
		return professionsname;
	}

	public void setProfessionsname(String professionsname) {
		this.professionsname = professionsname;
	}

	public String getColleagesname() {
		return colleagesname;
	}

	public void setColleagesname(String colleagesname) {
		this.colleagesname = colleagesname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStuPassWord() {
		return stuPassWord;
	}
	public void setStuPassWord(String stuPassWord) {
		this.stuPassWord = stuPassWord;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Map<String, List<ScoreManagement>> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, List<ScoreManagement>> dataMap) {
		this.dataMap = dataMap;
	}
	public String getNewpassword1() {
		return newpassword1;
	}
	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	
	

}
