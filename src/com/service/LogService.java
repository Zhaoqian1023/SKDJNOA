package com.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.impl.LogDao;
import com.po.Log;

public class LogService {
	
	public static void addLog(Log log){
		
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String str=sdf.format(date);
		log.setLtime(str);
		//System.out.println(log.getLid()+log.getLuser()+log.getLcourse()+log.getLcontrol());
		//System.out.println(log.getLtime());
		LogDao ld=new LogDao();
		ld.add(log);
	}
	public static void main(String args[]){
		
		//Log log=new Log("", "ss","ww","ee", "课程录入");
		//LogService.addLog(log);
	}

}
