package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class NotFound extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String foundError(){
		/*System.out.println("not found!!!!!!!!!!!!!!");*/
		return "notfoundaction";
	}

}
