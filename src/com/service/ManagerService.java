package com.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.Dao;
import com.dao.impl.CourseDao;
import com.dao.impl.LogDao;
import com.dao.impl.ManagerDao;
import com.dao.impl.PublicCourseDao;
import com.dao.impl.ScoreDao;
import com.dao.impl.StudentDao;
import com.dao.impl.TeacherDao;
import com.dao.impl.UsersDao;
import com.po.Log;
import com.po.Management;
import com.po.ScoreManagement;
import com.po.Users;
import com.util.ExcelUtil;
import com.util.MD5Util;
import com.util.RandomUtil;

public class ManagerService {
	
	public static boolean judgeLogin(String mid, String mpwd){
		/*System.out.println("进入到service逻辑类judgelogin");*/
		int id;
		try {
			id=Integer.parseInt(mid);
		} catch (Exception e) {
			return false;
		}
		Management manager = null;
		//System.out.println("mid:"+mid+"mpwd:"+mpwd);
		Dao managerDao = new ManagerDao();
		manager=(Management) managerDao.get(id);
		/*System.out.println("com.service success");*/
		if(manager != null && manager.getPassWord().equals(mpwd)){
			//System.out.println("用户查询成功，返回true");
			return true;
		}
		return false;
	}
	
	public static Management getManagement(String mid,String upwd){
		int id;
		try {
			id = Integer.parseInt(mid);
		} catch (NumberFormatException e) {
			return null;
		}
		Management manager=null;
		Dao managerDao = new ManagerDao();
		manager=(Management) managerDao.get(id);
		if(upwd.equals(manager.getPassWord())){
			return manager;
		}
		return null;
	}
	
	
	public static String modifyTeacherPwd(String teacherId){
		int tid = Integer.parseInt(teacherId);
		String msgPwd = RandomUtil.genEasyPswd(8);
		String md5Pwd = MD5Util.getMD5(msgPwd);
		Dao userDao = new UsersDao();
		Users us = new Users();
		us.setUid(tid);
		us.setPassWord(md5Pwd);
		if(userDao.update(us)){
			return msgPwd;
		}
		return "fail";
	}
	
	public static boolean downLoadScore(String URL,String years){
		if(URL == null || "".equals(URL)){
			return false;
		}
		ScoreDao scoreDao = new ScoreDao();
		SimpleDateFormat Time = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = Time.format(new Date())+".xls";
		String path=URL+"\\"+fileName;
		/*System.out.println("path:"+path);*/
		path=path.replace('\\', '/');
		/*System.out.println("转型后path："+path);*///"d:/fg/fg/xxx.jsp"
		List<Object[]> list = null;
		list = scoreDao.createFile(years);
		/*System.out.println("成绩库大小："+list.size());*/
		if(list != null){
			return ExcelUtil.createExcel(list,path);
		}
		return false;
		/*return scoreDao.createFile();*/
		/*return TempDao.createFile(path);*/
		
	}
	public static boolean downLoadLogs(String URL){
		if(URL == null || "".equals(URL)){
			return false;
		}
		LogDao logsDao = new LogDao();
		SimpleDateFormat Time = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = Time.format(new Date())+".xls";
		String path=URL+"\\"+fileName;
		/*System.out.println("path:"+path);*/
		path=path.replace('\\', '/');
		/*System.out.println("转型后path："+path);*///"d:/fg/fg/xxx.jsp"
		List<Log> list = null;
		list = logsDao.getAll();
		/*System.out.println("成绩库大小："+list.size());*/
		if(list != null){
			return ExcelUtil.createLogsExcel(list,path);
		}
		return false;
		/*return scoreDao.createFile();*/
		/*return TempDao.createFile(path);*/
		
	}
	public static boolean downLoadStudent(String URL,String nj,String zt){
		if(URL == null || "".equals(URL)){
			return false;
		}
		StudentDao sDao = new StudentDao();
		SimpleDateFormat Time = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = nj+"级"+zt+Time.format(new Date())+".xls";
		String path=URL+"\\"+fileName;
		/*System.out.println("path:"+path);*/
		path=path.replace('\\', '/');
		/*System.out.println("转型后path："+path);*///"d:/fg/fg/xxx.jsp"
		List<Object[]> list = null;
		list = sDao.getStudentByBJAndZT(nj,zt);
		/*System.out.println("成绩库大小："+list.size());*/
		if(list != null){
			return ExcelUtil.createStudentExcel(list,path);
		}
		return false;
		/*return scoreDao.createFile();*/
		/*return TempDao.createFile(path);*/
		
	}
	@SuppressWarnings("unchecked")
	public static boolean downLoadCoursePlan(String URL,String years){
		if(URL == null || "".equals(URL)){
			return false;
		}
		CourseDao courseDao = new CourseDao();
		String temp = "";
		temp += years.substring(0,9)+"-"+years.substring(10);
		
		String fileName = temp+".xls";
		String path=URL+"\\"+fileName;
		path=path.replace('\\', '/');
		List<Object[]> list = null;
		list = courseDao.createFile(years);
		if(list != null){
			return ExcelUtil.createCoursePlanExcel(list,path);
		}
		return false;
	}
	public static boolean downLoadSelectCoursePlan(String URL,String years,String category){
		if(URL == null || "".equals(URL)){
			return false;
		}
		PublicCourseDao courseDao = new PublicCourseDao();
		String temp = "";
		temp += years.substring(0,9)+"-"+years.substring(10);
		
		String fileName = temp+".xls";
		String path=URL+"\\"+fileName;
		path=path.replace('\\', '/');
		List<Object[]> list = null;
		list = courseDao.createFile(years,category);
		if(list != null){
			return ExcelUtil.createSelectCoursePlanExcel(list,path);
		}
		return false;
	}
	public static boolean downLoadTeacher(String URL, String fileName){
		if(URL == null || "".equals(URL)){
			return false;
		}
		TeacherDao tDao = new TeacherDao();
		String tempFileName = fileName+".xls";
		String path=URL+"\\"+tempFileName;
		path=path.replace('\\', '/');
		List<Object[]> list = null;
		list = tDao.getAll();
		if(list != null){
			return ExcelUtil.createTeacherExcel(list,path);
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List showFile(String URL){
		/*System.out.println("showFile方法");*/
		List fileList=new ArrayList();
		File file=new File(URL);
		File[] arrFile=file.listFiles();
		for(int i=0;i<arrFile.length;i++){
			String msg=arrFile[i].getName();
			fileList.add(msg);
			/*System.out.println(msg+"+++");*/
		}
		return fileList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Log> showLogs(){
		/*System.out.println("showLogs方法");*/
		List<Log> logsList=new ArrayList<Log>();
		Dao logsDao = new LogDao();
		String hql=" ";
		logsList =logsDao.query(hql);
		return logsList;
	}

}
