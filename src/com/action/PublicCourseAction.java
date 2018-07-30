package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.Dao;
import com.dao.impl.PublicCourseDao;
import com.dao.impl.TeacherDao;
import com.opensymphony.xwork2.ActionSupport;
import com.po.ClassName;
import com.po.Log;
import com.po.Management;
import com.po.PublicCourse;
import com.po.Teacher;
import com.po.Users;
import com.service.ClassNameServie;
import com.service.GetCourse;
import com.service.LogService;
import com.service.PublicCourseService;
import com.vo.AttendanceVO;
import com.vo.QueryByTeacherVO;

@SuppressWarnings("serial")
public class PublicCourseAction extends ActionSupport {
	private String years;
	private String page;
	private List<PublicCourse> data;
	private String status;
	private String kcm;
	private String kcdm;
	private List<AttendanceVO> list;
	private HttpSession session;
	private Users users;
	private List<QueryByTeacherVO> VOList;
	private String tempCategory;
	private String bjm;
	private String bjdm;
	private String courseId;
	private PublicCourse PCourse;
	
	
	// 添加课程(选修)
	public String addSelectCourse() {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = ServletActionContext.getRequest().getSession();
		PublicCourseDao pcdao = new PublicCourseDao();
		TeacherDao tdao = new TeacherDao();
		if (request.getParameter("cname1").equals("")
				|| request.getParameter("category1").equals("")
				|| request.getParameter("credits1").equals("")
				|| request.getParameter("time1").equals("")
				|| request.getParameter("year1").equals("")
				|| request.getParameter("beginTime1").equals("")
				|| request.getParameter("endTime1").equals("")
				|| request.getParameter("examFlag1").equals("")
				|| request.getParameter("teachers1").equals("")) {
			return "Error";
		}
		//判断教师工号
		Teacher t = (Teacher) tdao.get(Integer.parseInt(request
				.getParameter("teachers1")));
		if (null == t) {
			return "Error";
		}
		
		PublicCourse pc = new PublicCourse();
		pc.setPname(request.getParameter("cname1"));
		pc.setCategory(request.getParameter("category1"));
		pc.setCredits(Float.parseFloat(request.getParameter("credits1")));
		pc.setTime(request.getParameter("time1"));
		pc.setYear(request.getParameter("year1"));
		pc.setCourseNum(request.getParameter("courseNum1"));
		if("".equals(request.getParameter("beginTime1"))){
			pc.setBeginTime(0);
		}else{
			pc.setBeginTime(Integer.parseInt(request.getParameter("beginTime1")));
			
		}
		if("".equals(request.getParameter("endTime1"))){
			pc.setEndTime(0);
		}else{
			pc.setEndTime(Integer.parseInt(request.getParameter("endTime1")));
		}
		pc.setTeachers(t);
		if("".equals(request.getParameter("examFlag1"))){
			pc.setExamFlag(0);
		}else{
			pc.setExamFlag(Integer.parseInt(request.getParameter("examFlag1")));
		}
		int tempCourseid = pcdao.addCoursePlan(pc);
		
		if(tempCourseid == 0){
			return "Error";
		}
		
		Management management = (Management) session
				.getAttribute("manager");
		Log log = new Log("", management.getMid(), management.getMname(),
				tempCourseid + "", pc.getPname(), "选修课程添加", "管理员");
		LogService.addLog(log);
		return "Success";
	}
	// 添加课程(公选)
	public String addPublicCourse() {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = ServletActionContext.getRequest().getSession();
		PublicCourseDao pcdao = new PublicCourseDao();
		TeacherDao tdao = new TeacherDao();
		if (request.getParameter("cname1").equals("")
				|| request.getParameter("category1").equals("")
				|| request.getParameter("credits1").equals("")
				|| request.getParameter("time1").equals("")
				|| request.getParameter("year1").equals("")
				|| request.getParameter("beginTime1").equals("")
				|| request.getParameter("endTime1").equals("")
				|| request.getParameter("examFlag1").equals("")
				|| request.getParameter("teachers1").equals("")) {
			return "Error";
		}
		//判断教师工号
		Teacher t = (Teacher) tdao.get(Integer.parseInt(request
				.getParameter("teachers1")));
		if (null == t) {
			return "Error";
		}
		
		PublicCourse pc = new PublicCourse();
		pc.setPname(request.getParameter("cname1"));
		pc.setCategory(request.getParameter("category1"));
		pc.setCredits(Float.parseFloat(request.getParameter("credits1")));
		pc.setTime(request.getParameter("time1"));
		pc.setYear(request.getParameter("year1"));
		pc.setCourseNum(request.getParameter("courseNum1"));
		if("".equals(request.getParameter("beginTime1"))){
			pc.setBeginTime(0);
		}else{
			pc.setBeginTime(Integer.parseInt(request.getParameter("beginTime1")));
			
		}
		if("".equals(request.getParameter("endTime1"))){
			pc.setEndTime(0);
		}else{
			pc.setEndTime(Integer.parseInt(request.getParameter("endTime1")));
		}
		pc.setTeachers(t);
		if("".equals(request.getParameter("examFlag1"))){
			pc.setExamFlag(0);
		}else{
			pc.setExamFlag(Integer.parseInt(request.getParameter("examFlag1")));
		}
		int tempCourseid = pcdao.addCoursePlan(pc);
		
		if(tempCourseid == 0){
			return "Error";
		}
		
		Management management = (Management) session
				.getAttribute("manager");
		Log log = new Log("", management.getMid(), management.getMname(),
				tempCourseid + "", pc.getPname(), "公选课程添加", "管理员");
		LogService.addLog(log);
		return "Success";
	}
	
	//展示全部公选课课程名
	@SuppressWarnings("unchecked")
	public String getCourseName(){
		String temp = "公选";
		if("select".equals(tempCategory)){
			temp = "选修";
		}
		String msg = years+","+temp;
		Dao publicCourseDao = new PublicCourseDao();
		data = publicCourseDao.query(msg);
		return "queryPublicCourse";
	}
	//查询全部系选修课程名
	public String getCourseByBJAndYears(){
		if("".equals(bjm) || "".equals(years)){
			return "error";
		}
		String category = "选修";
		data = PublicCourseService.getCourse(bjm, years,category);
		ClassName tempClassName = new ClassName();
		tempClassName = ClassNameServie.getClassNameByCname(bjm);
		bjdm = String.valueOf(tempClassName.getCid());
		page = "printInfoOrdinary_select";
		return "queryinfo";
	}
	
	//根据课程名打印公选课选课学生名单
	public String printAtt(){
		list = PublicCourseService.getAttendanceVO(years,kcdm,status);
		if(list.size() > 0){
			return "queryPublicCourse";
		}
		return "error";
	}
	
	//根据老师选择对应课程(公共选修)
	public String getCourseByTeacher(){
		String temp = "公选";
		if("select".equals(tempCategory)){
			temp = "选修";
		}
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		String teacherId = String.valueOf(users.getUid());
		if(users != null){
			data = PublicCourseService.getCourseByTeacher(teacherId,years,temp);
			return "queryPublicCourse";
		}
		return "error";
	}
	//根据老师选择对应课程(选修)
	public String getSelectCourseByTeacher(){
		String category = "";
		if("select".equals(tempCategory)){
			category = "选修";
		}
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		if (users != null) {
			VOList = GetCourse.byTeacher_Select(users, years,category);
			return "queryCourseByTeacher";
		} else {
			return "error";
		}
	}
	//根据教师姓名查询已录入的成绩
	public String alreadyByTeacher(){
		String temp = "公选";
		if("select".equals(tempCategory)){
			temp = "选修";
		}
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		if (users != null) {
			VOList = PublicCourseService.alreadyByTeacher(users, years, temp);
			return "queryPublicCourse";
		} else {
			return "error";
		}
		
	}
	//根据教师姓名查询已录入的成绩
	public String alreadyByTeacherAll(){
		String temp = "公选";
		if("select".equals(tempCategory)){
			temp = "选修";
		}
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		if (users != null) {
			VOList = PublicCourseService.alreadyAllByTeacher(users, years, temp);
			return "queryPublicCourse";
		} else {
			return "error";
		}
		
	}
	//通过课程编号查询课程信息
	public String queryCourseByCid() {
		session = ServletActionContext.getRequest().getSession();
		if (null != courseId) {
			PCourse = PublicCourseService.queryCourseByCid(courseId);
			if (PCourse != null) {
				session.setAttribute("findcoursesuccess", "success");
				return "findselectcoursesuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updateselectcourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updateselectcourse";
	}
	//通过课程编号删除课程（查询）
	public String queryCourseToDeleteByCid() {
		session = ServletActionContext.getRequest().getSession();
		if (null != courseId) {
			PCourse = PublicCourseService.queryCourseByCid(courseId);
			if (PCourse != null) {
				session.setAttribute("findcoursesuccess", "success");
				return "findselectcoursetodeletesuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updateselectcourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updateselectcourse";
	}
	//查询需要导出选课情况的课程
	public String queryCourseToExportByCid() {
		session = ServletActionContext.getRequest().getSession();
		if (null != courseId) {
			PCourse = PublicCourseService.queryCourseByCid(courseId);
			if (PCourse != null) {
				session.setAttribute("findcoursesuccess", "success");
				return "findselectcoursetoexportsuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updateselectcourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updateselectcourse";
	}
	//通过课程编号查询课程信息
	public String queryPublicCourseByCid() {
		session = ServletActionContext.getRequest().getSession();
		if (null != courseId) {
			PCourse = PublicCourseService.queryCourseByCid(courseId);
			if (PCourse != null) {
				session.setAttribute("findcoursesuccess", "success");
				return "findpubliccoursesuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updatepubliccourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updatepubliccourse";
	}
	//删除课程根据课程编号
	public String deleteCourseByCid(){
		if("".equals(courseId) || courseId == null){
			return "Error";
		}
		session = ServletActionContext.getRequest().getSession();
		boolean result  = false ;
		result = PublicCourseService.deleteCourse(courseId);
		if(result == false){
			return "Error";
		}
		
		Management management = (Management) session
				.getAttribute("manager");
		Log log = new Log("", management.getMid(), management.getMname(),
				courseId + "", kcm, "非必须课程删除", "管理员");
		LogService.addLog(log);
		return "Success";
	}
	//删除选课学生，根据课程代码
	public String deleteStudentByCid(){
		if("".equals(courseId) || courseId == null){
			return "Error";
		}
		session = ServletActionContext.getRequest().getSession();
		boolean result  = false ;
		result = PublicCourseService.deleteElectiveStudent(courseId);
		if(result == false){
			return "Error";
		}
		
		Management management = (Management) session
				.getAttribute("manager");
		Log log = new Log("", management.getMid(), management.getMname(),
				courseId + "", "删除选课学生", "非必须课程删除", "管理员");
		LogService.addLog(log);
		return "Success";
	}
	//更新单门课程
	public String updateCourseByCid() {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = ServletActionContext.getRequest().getSession();
		TeacherDao tdao = new TeacherDao();
		if (request.getParameter("cid1").equals("")
				||request.getParameter("cname1").equals("")
				|| request.getParameter("category1").equals("")
				|| request.getParameter("credits1").equals("")
				|| request.getParameter("time1").equals("")
				|| request.getParameter("year1").equals("")
				|| request.getParameter("beginTime1").equals("")
				|| request.getParameter("endTime1").equals("")
				|| request.getParameter("examFlag1").equals("")
				|| request.getParameter("teachers1").equals("")) {
			
			return "Error";
		}
		//判断教师工号
		Teacher t = (Teacher) tdao.get(Integer.parseInt(request
				.getParameter("teachers1")));
		if (null == t) {
			return "Error";
		}
		PublicCourse pc = new PublicCourse();
		pc.setPid(Integer.parseInt(request.getParameter("cid1")));
		pc.setPname(request.getParameter("cname1"));
		pc.setCategory(request.getParameter("category1"));
		pc.setCredits(Float.parseFloat(request.getParameter("credits1")));
		pc.setTime(request.getParameter("time1"));
		pc.setYear(request.getParameter("year1"));
		pc.setBeginTime(Integer.parseInt(request.getParameter("beginTime1")));
		pc.setEndTime(Integer.parseInt(request.getParameter("endTime1")));
		pc.setTeachers(t);
		pc.setExamFlag(Integer.parseInt(request.getParameter("examFlag1")));
		pc.setCourseNum(request.getParameter("courseNum1"));
		boolean b = PublicCourseService.updateCourse(pc);
		if(b == false){
			return "Error";
		}
		
		Management management = (Management) session
				.getAttribute("manager");
		Log log = new Log("", management.getMid(), management.getMname(),
				pc.getPid() + "", pc.getPname(), "非必须课程修改", "管理员");
		LogService.addLog(log);
		return "Success";
	}
	
	
	
	
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<PublicCourse> getData() {
		return data;
	}
	public void setData(List<PublicCourse> data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<QueryByTeacherVO> getVOList() {
		return VOList;
	}

	public void setVOList(List<QueryByTeacherVO> vOList) {
		VOList = vOList;
	}

	public String getKcdm() {
		return kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}

	public String getTempCategory() {
		return tempCategory;
	}

	public void setTempCategory(String tempCategory) {
		this.tempCategory = tempCategory;
	}
	public String getBjm() {
		return bjm;
	}
	public void setBjm(String bjm) {
		this.bjm = bjm;
	}
	public String getBjdm() {
		return bjdm;
	}
	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public PublicCourse getPCourse() {
		return PCourse;
	}
	public void setPCourse(PublicCourse pCourse) {
		PCourse = pCourse;
	}
	
	
	

}
