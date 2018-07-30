package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.dao.impl.TeacherDao;
import com.dao.impl.UsersDao;
import com.opensymphony.xwork2.ActionSupport;

import com.po.Teacher;
import com.po.Users;
import com.service.PasswordUpdate;
import com.service.UsersLogin;
import com.util.JsonUtil;
import com.util.MD5Util;

@SuppressWarnings("serial")
public class UsersAction extends ActionSupport {

	private String uid;
	private String passWord;
	private String newpassword;
	private Users users;
	private String page;
	private int tid;
	private String uname;

	private HttpSession session;

	public String login() {
		passWord = passWord.replace("%2B", "+");
		if(uid == null || passWord == null || "".equals(uid) || "".equals(passWord)){
			JsonUtil.sendError();
			return NONE;
		}
		String upwd = MD5Util.getMD5(passWord);
		//防止SQL注入
		/*String str = uid+passWord;
		String inj_str ="'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String[] inj_stra=inj_str.split("\\|");
		for (int i=0; i < inj_stra.length; i++ ){
			if (str.indexOf(inj_stra[i])>=0){
				JsonUtil.sendError();
				return NONE;
			}
		}*/
		//验证
		Users us = null;
		us = UsersLogin.getUsers(uid,upwd);
		if (us != null) {
			try {
				users = us;
				session = ServletActionContext.getRequest().getSession();
				session.setAttribute("users", users);
				session.setAttribute("teacher", users.getUname());
			} catch (Exception e) {
				JsonUtil.sendError();
			}
			JsonUtil.sendSuccess();
		} else {
			JsonUtil.sendError();
		}
		return NONE;
	}

	

	public String update() {
		session = ServletActionContext.getRequest().getSession();
		Users u = (Users) session.getAttribute("users");
		u.setPassWord(newpassword);
		if (PasswordUpdate.passwordUpdate(u)) {
			session.setAttribute("users", null);
			return "Success";
		}
		return "error";
	}

	public String quit() {
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("users", null);
		page = "index";
		return "judgeSuccess";
	}

	public String userAdd() {
		session = ServletActionContext.getRequest().getSession();
		UsersDao udao = new UsersDao();
		TeacherDao tdao = new TeacherDao();
		Teacher d = (Teacher) tdao.get(tid);
		if (null == d) {
			session.setAttribute("addusererror2", "success");
			return "adduser";
		}
		if (udao.get(tid) != null) {
			session.setAttribute("addusererror1", "success");
			return "adduser";
		}
		Users user = new Users();
		user.setUid(tid);
		user.setUname(uname);
		user.setPassWord("");
		boolean b = udao.add(user);
		if (b) {
			session.setAttribute("addusersuccess", "success");
			return "adduser";
		}
		session.setAttribute("addusererror", "error");
		return "adduser";

	}

	public String deluser() {
		session = ServletActionContext.getRequest().getSession();
		UsersDao udao = new UsersDao();
		Users user = (Users) udao.get(tid);
		if (null != user) {
			boolean b = udao.del(user);
			if (b) {
				session.setAttribute("delusersuccess", "success");
				return "adduser";
			} else {
				session.setAttribute("delusererror", "error");
				return "adduser";
			}
		}
		session.setAttribute("delusererror", "error");
		return "adduser";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	

}
