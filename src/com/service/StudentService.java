/**  
 * @Title: StudentService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年5月19日
 */
package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.impl.StudentDao;
import com.po.ScoreManagement;
import com.po.Student;
import com.util.MD5Util;
import com.util.RandomUtil;

/**
 * ClassName: StudentService 
 * @Description: TODO
 * @author Victor
 * @date 2017年5月19日
 */
public class StudentService {
	public static Student getStudent(String sid, String sname, String spwd){
		if(sid.length() != 12 ){
			return null;
		}
		StudentDao studentDao = new StudentDao();
		Student student=(Student) studentDao.get(sid);
		Student resultStudent = null;
		if(student != null){
			String nowSname = student.getSname();
			String nowSpwd = student.getPassword();
			if(sname.equals(nowSname) && spwd.equals(nowSpwd)){
				resultStudent = student;
			}
		}
		return resultStudent;
	}
	public static boolean changePwd(Student student,String newPassword1,String newPassword2){
		if(newPassword1.equals(newPassword2) && newPassword1 != null){
			student.setPassword(newPassword1);
			StudentDao studentDao = new StudentDao();
			return studentDao.update(student);
		}
		return false;
	}
	public static Map<String,List<ScoreManagement>> getScore(String sid){
		Map<String,List<ScoreManagement>> data = new HashMap<String,List<ScoreManagement>>();
		List<ScoreManagement> list = ScoreService.studentScore(sid);
		List<ScoreManagement> bx = new ArrayList<ScoreManagement>();
		List<ScoreManagement> xx = new ArrayList<ScoreManagement>();
		List<ScoreManagement> temp = new ArrayList<ScoreManagement>();
		if(list.size() > 0){
			ScoreManagement sm = new ScoreManagement();
			sm.setStudentName(list.get(0).getStudentName());
			sm.setStudentId(list.get(0).getStudentId());
			sm.setClassName(list.get(0).getClassName());
			sm.setClassId(list.get(0).getClassId());
			temp.add(sm);
		}
		for(ScoreManagement sm:list){
			if("".equals(sm.getFinalGrade())){
				sm.setFinalGrade(sm.getBeizhu());
			}
			if("公选".equals(sm.getCategory())){
				xx.add(sm);
			}else{
				bx.add(sm);
			}
		}
		data.put("bx", bx);
		data.put("xx", xx);
		data.put("info", temp);
		return data;
	}
	public static Student getStudent(String sid){
		StudentDao studentDao = new StudentDao();
		Student student=(Student) studentDao.get(sid);
		return student;
	}
	public static String modifyStudentPwd(String studentId){
		String msgPwd = RandomUtil.genEasyPswd(8);
		String md5Pwd = MD5Util.getMD5(msgPwd);
		Student student = new Student();
		StudentDao sDao = new StudentDao();
		student = sDao.get(studentId);
		student.setPassword(md5Pwd);
		if(sDao.update(student)){
			return msgPwd;
		}
		return "fail";
	}

}
