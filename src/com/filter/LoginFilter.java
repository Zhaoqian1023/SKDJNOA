package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.po.Management;
import com.po.Student;
import com.po.Users;

@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter {
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private HttpSession session = null;
	private String uri = null;
	private String contextPath = null;
	private Management manager = null;
	private Users user = null;
	private Student student = null;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		request =(HttpServletRequest) req;
		response = (HttpServletResponse) resp;
		session = request.getSession();   
		uri = request.getServletPath();
		contextPath=request.getContextPath();//根
		//参数信息
		/*String str = request.getQueryString();
		//检测sql注入
		if(str != null){
			String inj_str ="'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
			String[] inj_stra=inj_str.split("\\|");
			for (int i=0; i < inj_stra.length; i++ ){
				if (str.indexOf(inj_stra[i])>=0 ){
					System.out.println(inj_stra[i]);
					response.sendRedirect(contextPath+"/home.jsp"); 
					return;  
				}
			}
		}*/
		
		
		 if(uri.equals("")){
			 uri+="/";
		 }
		 if(!(uri.indexOf("/css/")>-1 || uri.indexOf("/assets/")>-1 
				 || uri.indexOf("/fonts/")>-1
				 || uri.indexOf("/images/")>-1
				 || uri.indexOf("/img/")>-1
				 || uri.indexOf("/js/")>-1)){
			 manager=(Management) session.getAttribute("manager");
			 user=(Users) session.getAttribute("users");
			 student = (Student) session.getAttribute("studentLogin");
			 if(uri.indexOf("/manager/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login_manager.jsp")
					 ){
				 if(manager == null){//转入管理员登陆页面  
		               response.sendRedirect(contextPath+"/manager/login_manager.jsp"); 
		               return;  
				 }  
			 }
			 if(uri.indexOf("/admin/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login.jsp")
					){
				 if(user == null){//转入管理员登陆页面 
		               response.sendRedirect(contextPath+"/admin/login.jsp"); 
		               return;  
				 }   
			 }
			 if(uri.indexOf("/admin_US/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login.jsp")
						){
				 if(user == null){//转入管理员登陆页面 
		               response.sendRedirect(contextPath+"/admin_US/login.jsp"); 
		               return;  
				 }   
			 }
			 if(uri.indexOf("/student/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("StudentLogin.jsp") && !uri.endsWith("changepwd.jsp")
						){
				 if(student == null){//转入学生登陆页面  
					 response.sendRedirect(contextPath+"/student/StudentLogin.jsp"); 
					 return;  
				 }   
			}
		 }
         chain.doFilter(req, resp);    
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	} 

}
