package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.impl.DepartmentDao;
import com.dao.impl.TeacherDao;
import com.dao.impl.UsersDao;
import com.opensymphony.xwork2.ActionSupport;
import com.po.Department;
import com.po.Log;
import com.po.Management;
import com.po.Teacher;
import com.po.Users;
import com.service.LogService;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport {

	private int tid;
	private String tname;
	private String position;
	private String title;
	private String dname;
	private Department dept;
	private Teacher teacher;
	private HttpSession session;

	public String queryTeacher() {
		TeacherDao tdao = new TeacherDao();

		teacher = (Teacher) tdao.get(tid);
		if (null != teacher) {
			return "findteachersuccess";
		}
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("findteachererror", "1");
		return "updateteacher";
	}

	public String updateTeacher() {
		session = ServletActionContext.getRequest().getSession();
		TeacherDao tdao = new TeacherDao();
		DepartmentDao ddao = new DepartmentDao();
		Department d = (Department) ddao.get(dname);
		if (null != d || "".equals(dname)) {
			Teacher t = new Teacher();
			t.setTid(tid);
			t.setTname(tname);
			t.setTitle(title);
			t.setPosition(position);
			t.setDept(d);
			boolean b = tdao.update(t);
			if (b) {
				
				Management management = (Management) session
						.getAttribute("manager");
				//String str=t.getTid();
				Log log = new Log("", management.getMid(),
						management.getMname(), t.getTid()+"",
						 t.getTname(), "教师信息更改",
						"管理员");
				LogService.addLog(log);
				
				
				session.setAttribute("updateteachersuccess", "success");
				return "updateteacher";
			} else {
				session.setAttribute("updateteachererror", "error");
				return "updateteacher";
			}
		}
		session.setAttribute("updateteachererror", "error");
		return "updateteacher";

	}

	public String addTeacher() {
		session = ServletActionContext.getRequest().getSession();
		TeacherDao tdao = new TeacherDao();
		UsersDao udao = new UsersDao();
		DepartmentDao ddao = new DepartmentDao();
		Department d = (Department) ddao.get(dname);
		if (tdao.get(tid) != null) {
			session.setAttribute("addteachererror1", "success");
			return "updateteacher";
		}

		if (d != null || "".equals(dname)) {
			Teacher tea = new Teacher();
			tea.setTid(tid);
			tea.setTname(tname);
			tea.setPosition(position);
			tea.setTitle(title);
			tea.setDept(d);
			boolean b = tdao.add(tea);
			Users user = new Users();
			user.setUid(tid);
			user.setUname(tname);
			user.setPassWord("");
			boolean c = udao.add(user);
			if (b && c) {
				Management management = (Management) session
						.getAttribute("manager");
				//String str=t.getTid();
				Log log = new Log("", management.getMid(),
						management.getMname(), tea.getTid()+"",
						 tea.getTname(), "教师添加",
						"管理员");
				LogService.addLog(log);
				session.setAttribute("addteachersuccess", "success");
				return "updateteacher";
			} else {
				session.setAttribute("addteachererror", "error");
				return "updateteacher";
			}
		}
		session.setAttribute("addteachererror", "error");
		return "updateteacher";
	}

	public String delTeacher() {
		session = ServletActionContext.getRequest().getSession();
		TeacherDao tdao = new TeacherDao();
		Teacher tea = (Teacher) tdao.get(tid);
		if (null != tea) {

			boolean b = tdao.del(tea);
			if (b) {
				Management management = (Management) session
						.getAttribute("manager");
				//String str=t.getTid();
				Log log = new Log("", management.getMid(),
						management.getMname(), tea.getTid()+"",
						 tea.getTname(), "教师信息更改",
						"管理员");
				LogService.addLog(log);
				session.setAttribute("delteachersuccess", "success");
				return "updateteacher";
			} else {
				session.setAttribute("delteachererror", "error");
				return "updateteacher";
			}
		}
		session.setAttribute("delteachererror", "error");
		return "updateteacher";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
