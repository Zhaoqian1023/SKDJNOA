package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.impl.CourseDao;
import com.dao.impl.TeacherDao;
import com.opensymphony.xwork2.ActionSupport;
import com.po.ClassName;
import com.po.Course;
import com.po.Log;
import com.po.Management;
import com.po.Professional;
import com.po.PublicCourse;
import com.po.Teacher;
import com.po.Users;
import com.service.ClassNameServie;
import com.service.CourseClassService;
import com.service.CourseService;
import com.service.GetCourse;
import com.service.LogService;
import com.service.PublicCourseService;
import com.util.JsonUtil;
import com.vo.QueryByTeacherVO;

@SuppressWarnings("serial")
public class CourseAction extends ActionSupport {

	private String professional;
	private String category;
	private String years;
	private List<Professional> professionalList;
	@SuppressWarnings("rawtypes")
	private List courseName;
	private List<QueryByTeacherVO> VOList;
	private HttpSession session;
	private Users users;
	private String page;
	private List<Course> clist;
	private List<PublicCourse> pclist;
	private String courseId;
	private Course course;
	private String classNames;
	private String bjm;
	private String bjdm;
	
	public String getCourseByBJAndYears(){
		if("".equals(bjm) || "".equals(years)){
			return "error";
		}
		String tempCategory = "选修";
		clist = CourseService.getCourse(bjm, years);
		pclist = PublicCourseService.getCourse(bjm, years,tempCategory);
		ClassName tempClassName = new ClassName();
		tempClassName = ClassNameServie.getClassNameByCname(bjm);
		bjdm = String.valueOf(tempClassName.getCid());
		page = "printInfoOrdinary";
		return "queryinfo";
	}
	public String deleteCoursePlan(){
		boolean result = false;
		if(years == null || "".equals(years)){
			page = ""; 
			return "Error";
		}
		result = CourseService.deleteCoursePlan(years);
		if(result){
			return "Success";
		}
		
		return "Error";
	}

	public String byProfessional() {
		if (professional != null && category != null) {
			courseName = GetCourse
					.byProfessional(professional, category, years);
			JsonUtil.sendList(courseName);
		} else {
			JsonUtil.sendError();
		}
		return NONE;
	}

	public String byTeacher() {
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		/*System.out.println("进入通过教师信息查询所带课程action！！！");*/
		if (users != null) {
			/*System.out.println("通过教师信息查询所带课程！！！");*/
			VOList = GetCourse.byTeacher(users, years);
			/*System.out.println("返回课程名的个数" + VOList.size());
			System.out.println("跳转到page页面 " + page);*/
			return "queryCourseByTeacher";
		} else {
			return "error";
		}
	}

	public String alreadyByTeacher() {
		session = ServletActionContext.getRequest().getSession();
		users = (Users) session.getAttribute("users");
		if (users != null) {
			VOList = GetCourse.alreadyByTeacher(users, years);
			return "queryCourseByTeacher";
		} else {
			return "error";
		}
	}
	//通过课程编号查询课程信息
	public String queryCourseByCid() {
		session = ServletActionContext.getRequest().getSession();
		if (null != courseId) {
			course = CourseService.queryCourseByCid(courseId);
			
			if (course != null) {
				session.setAttribute("findcoursesuccess", "success");
				return "findcoursesuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updatecourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updatecourse";
	}

	// 根据学年查询教学计划
	public String queryCourse() {
		session = ServletActionContext.getRequest().getSession();
		CourseDao sDao = new CourseDao();
		if (null != years) {
			clist = sDao.querybyYear(years);
			if (clist.size() > 0) {
				session.setAttribute("findcoursesuccess", "success");
				return "findcoursesuccess";
			} else {
				session.setAttribute("findcourseerror", "error");
				return "updatecourse";
			}
		}
		session.setAttribute("findcourseerror", "error");
		return "updatecourse";
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
				|| request.getParameter("teachers1").equals("")
				|| request.getParameter("classId").equals("")) {
			
			return "Error";
		}
		//判断教师工号
		Teacher t = (Teacher) tdao.get(Integer.parseInt(request
				.getParameter("teachers1")));
		if (null == t) {
			return "Error";
		}
		Course c = new Course();
		c.setCid(Integer.parseInt(request.getParameter("cid1")));
		c.setCname(request.getParameter("cname1"));
		c.setCategory(request.getParameter("category1"));
		c.setCredits(Float.parseFloat(request.getParameter("credits1")));
		c.setTime(request.getParameter("time1"));
		c.setYear(request.getParameter("year1"));
		c.setBeginTime(Integer.parseInt(request.getParameter("beginTime1")));
		c.setEndTime(Integer.parseInt(request.getParameter("endTime1")));
		c.setTeachers(t);
		c.setExamFlag(Integer.parseInt(request.getParameter("examFlag1")));
		c.setCourseNum(request.getParameter("courseNum1"));
		boolean b = CourseService.updateCourse(c);
		if(b == false){
			return "Error";
		}
		List<Object[]> ccList = new ArrayList<Object[]>();
		String temp = request.getParameter("classId");
		Object[] tempArray = temp.split(",");
		
		for(int i = 0; i < tempArray.length; i++){
			Object[] courseClass = new Object[2];
			courseClass[0] = tempArray[i];
			courseClass[1] = request.getParameter("cid1");
			ccList.add(courseClass);
		}
		List<Object> tempData = new ArrayList<Object>();
		tempData.add(c.getCid());
		boolean result = false;
		if(CourseClassService.deleteCourseClass(tempData)){
			result = CourseClassService.addCourseClass(ccList);
		}
		if (result) {
			Management management = (Management) session
					.getAttribute("manager");
			Log log = new Log("", management.getMid(), management.getMname(),
					c.getCid() + "", c.getCname(), "必修课程修改", "管理员");
			LogService.addLog(log);
			return "Success";

		} else {
			return "Error";
		}
	}

	// 更新教学计划(全部更新)
	@SuppressWarnings("unused")
	public String updateCourse() {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = ServletActionContext.getRequest().getSession();
		String[] cid1 = request.getParameterValues("cid1");
		String[] cname1 = request.getParameterValues("cname1");
		String[] category1 = request.getParameterValues("category1");
		String[] credits1 = request.getParameterValues("credits1");
		String[] time1 = request.getParameterValues("time1");
		String[] year1 = request.getParameterValues("year1");
		String[] beginTime1 = request.getParameterValues("beginTime1");
		String[] endTime1 = request.getParameterValues("endTime1");
		String[] teachers1 = request.getParameterValues("teachers1");
		String[] examFlag1 = request.getParameterValues("examFlag1");
		CourseDao cDao = new CourseDao();
		TeacherDao tDao = new TeacherDao();
		List<Course> c = cDao.querybyYear(year1[0]);
		List<Course> temp = new ArrayList<Course>();

		for (int i = 0; i < year1.length; i++) {
			Teacher t = (Teacher) tDao.get(Integer.parseInt(teachers1[i]));
			System.out.println(t.getTname());
			if (null != t) {
				if (c.get(i).getCid() == Integer.parseInt(cid1[i])
						&& c.get(i).getCname().equals(cname1[i])
						&& c.get(i).getCategory().equals(category1[i])
						&& c.get(i).getCredits() == Integer
								.parseInt(credits1[i])
						&& c.get(i).getTime().equals(time1[i])
						&& c.get(i).getBeginTime() == Integer
								.parseInt(beginTime1[i])
						&& c.get(i).getEndTime() == Integer
								.parseInt(endTime1[i])
						&& c.get(i).getTeachers().getTid() == Integer
								.parseInt(teachers1[i])
						&& c.get(i).getExamFlag() == Integer
								.parseInt(examFlag1[i])) {
					continue;
				} else {
					Course cs = new Course();
					cs.setCid(Integer.parseInt(cid1[i]));
					cs.setCname(cname1[i]);
					cs.setCategory(category1[i]);
					cs.setCredits(Integer.parseInt(credits1[i]));
					cs.setTime(time1[i]);
					cs.setBeginTime(Integer.parseInt(beginTime1[i]));
					cs.setEndTime(Integer.parseInt(endTime1[i]));
					cs.setYear(year1[i]);
					cs.setTeachers(t);
					cs.setExamFlag(Integer.parseInt(examFlag1[i]));
					temp.add(cs);
				}
			} else {
				session.setAttribute("teachernotfind", "error");
				return "updatecourse";
			}
		}
		/*System.out.println(temp.size());*/
		if (temp.size() > 0) {
			boolean b = cDao.update(temp);
			if (b) {
				for (int i = 0; i < temp.size(); i++) {
					Management management = (Management) session
							.getAttribute("manager");
					Log log = new Log("", management.getMid(),
							management.getMname(), temp.get(i).getCid() + "",
							temp.get(i).getCname(), "成绩修改", "管理员");
					LogService.addLog(log);
				}
				session.setAttribute("courseupdatesuccess", "1");
				return "updatecourse";
			} else {
				session.setAttribute("courseupdateerror", "1");
				return "updatecourse";
			}
		} else {
			System.out.println("4444");
			session.setAttribute("courseupdateerror1", "1");
			return "updatecourse";
		}
	}

	// 添加课程
	public String addCourse() {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = ServletActionContext.getRequest().getSession();
		CourseDao cdao = new CourseDao();
		TeacherDao tdao = new TeacherDao();
		if (request.getParameter("cname1").equals("")
				|| request.getParameter("category1").equals("")
				|| request.getParameter("credits1").equals("")
				|| request.getParameter("time1").equals("")
				|| request.getParameter("year1").equals("")
				|| request.getParameter("beginTime1").equals("")
				|| request.getParameter("endTime1").equals("")
				|| request.getParameter("examFlag1").equals("")
				|| request.getParameter("teachers1").equals("")
				|| request.getParameter("classId").equals("")) {
			/*session.setAttribute("addcourseerror2", "error");
			return "updatecourse";*/
			return "Error";
		}
		//判断教师工号
		Teacher t = (Teacher) tdao.get(Integer.parseInt(request
				.getParameter("teachers1")));
		if (null == t) {
			/*session.setAttribute("addcourseerror1", "error");
			return "updatecourse";*/
			return "Error";
		}
		
		Course c = new Course();
		c.setCname(request.getParameter("cname1"));
		c.setCategory(request.getParameter("category1"));
		c.setCredits(Float.parseFloat(request.getParameter("credits1")));
		c.setTime(request.getParameter("time1"));
		c.setYear(request.getParameter("year1"));
		c.setCourseNum(request.getParameter("courseNum"));
		if("".equals(request.getParameter("beginTime1"))){
			c.setBeginTime(0);
		}else{
			c.setBeginTime(Integer.parseInt(request.getParameter("beginTime1")));
			
		}
		if("".equals(request.getParameter("endTime1"))){
			c.setEndTime(0);
		}else{
			c.setEndTime(Integer.parseInt(request.getParameter("endTime1")));
		}
		c.setTeachers(t);
		if("".equals(request.getParameter("examFlag1"))){
			c.setExamFlag(0);
		}else{
			c.setExamFlag(Integer.parseInt(request.getParameter("examFlag1")));
		}
		int tempCourseid = cdao.addCoursePlan(c);
		
		List<Object[]> ccList = new ArrayList<Object[]>();
		String temp = request.getParameter("classId");
		Object[] tempArray = temp.split(",");
		if(tempCourseid == 0){
			/*session.setAttribute("addcourseerror2", "error");
			return "updatecourse";*/
			return "Error";
		}
		for(int i = 0; i < tempArray.length; i++){
			Object[] courseClass = new Object[2];
			courseClass[0] = tempArray[i];
			courseClass[1] = String.valueOf(tempCourseid);
			ccList.add(courseClass);
		}
		boolean result = false;
		result = CourseClassService.addCourseClass(ccList);
		
		if (result) {
			Management management = (Management) session
					.getAttribute("manager");
			// String str=t.getTid();
			Log log = new Log("", management.getMid(), management.getMname(),
					tempCourseid + "", c.getCname(), "课程添加", "管理员");
			LogService.addLog(log);
			/*session.setAttribute("addcoursesuccess", "success");
			return "updatecourse";*/
			return "Success";

		} else {
			/*session.setAttribute("addcourseserror", "error");
			return "updatecourse";*/
			return "Error";
		}
		
		
	}
	

	public List<Course> getClist() {
		return clist;
	}

	public void setClist(List<Course> clist) {
		this.clist = clist;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Professional> getProfessionalList() {
		return professionalList;
	}

	public void setProfessionalList(List<Professional> professionalList) {
		this.professionalList = professionalList;
	}

	@SuppressWarnings("rawtypes")
	public List getCourseName() {
		return courseName;
	}

	@SuppressWarnings("rawtypes")
	public void setCourseName(List courseName) {
		this.courseName = courseName;
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

	public List<QueryByTeacherVO> getVOList() {
		return VOList;
	}

	public void setVOList(List<QueryByTeacherVO> vOList) {
		VOList = vOList;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getClassNames() {
		return classNames;
	}

	public void setClassNames(String classNames) {
		this.classNames = classNames;
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
	public List<PublicCourse> getPclist() {
		return pclist;
	}
	public void setPclist(List<PublicCourse> pclist) {
		this.pclist = pclist;
	}
	

}
