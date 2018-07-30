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



@SuppressWarnings("serial")
public class BrowserFilter extends HttpServlet implements Filter {
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private String uri = null;
	private String contextPath = null;
	private String browser = null;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		request = (HttpServletRequest) req;
		response = (HttpServletResponse) resp;
		uri = request.getServletPath();
		contextPath = request.getContextPath();
		if (uri.equals("")){
			uri += "/";
		}
		if(!(uri.indexOf("/css/")>-1 || uri.indexOf("/assets/")>-1 
				 || uri.indexOf("/fonts/")>-1
				 || uri.indexOf("/images/")>-1
				 || uri.indexOf("/img/")>-1
				 || uri.indexOf("/js/")>-1)){
			
			if (uri.endsWith(".jsp") && !(uri.indexOf("browserwarn.jsp") > -1)
					&& !(uri.indexOf("home.jsp") > -1)
					&& !(uri.indexOf("error.jsp") > -1)) {// 过滤jsp页面
				browser = request.getHeader("User-Agent");
				//System.out.println(browser);
				if (browser.indexOf("compatible") > -1) {
					response.sendRedirect(contextPath + "/browserwarn.jsp");
					return;
				}
				
			}
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
