package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.Dao;
import com.dao.impl.CourseDao;
import com.dao.impl.PublicCourseDao;
import com.dao.impl.ScoreDao;
import com.po.Course;
import com.po.PublicCourse;
import com.po.ScoreManagement;
import com.po.Users;
import com.vo.QueryByTeacherVO;

public class GetCourse {
	
	@SuppressWarnings("unchecked")
	public static List<QueryByTeacherVO> byTeacher(Users user,String years){
		List<QueryByTeacherVO> courseList = new ArrayList<QueryByTeacherVO>();
		int teacherId = user.getUid();
		String temp = String.valueOf(teacherId);
		CourseDao cDao = new CourseDao();
		List<Object[]> resultList = cDao.getByTeacherAndYears(temp,years);
		if(resultList == null){
			return null;
		}
		ScoreDao sDao = new ScoreDao();
		List<ScoreManagement> sList = null; 
		for(Object[] obj:resultList){
			if(obj[2] == null){
				obj[2] = "";
			}
			QueryByTeacherVO qt = new QueryByTeacherVO();
			qt.setCourseName(obj[0].toString());
			qt.setClassName(obj[1].toString());
			qt.setEnglishName(obj[2].toString());
			qt.setCourseId(obj[3].toString());
			qt.setClassId(obj[4].toString());
			//剔除已经录入的班级课程
			sList = sDao.get(obj[1].toString(), obj[0].toString(), years);
			//System.out.println(sList.get(0).getClassName()+"++++++");
			if(sList.size() > 0){
				continue;
			}
			courseList.add(qt);
		}
		return courseList;
	}
	public static List<QueryByTeacherVO> byTeacher_Select(Users user,String years,String category){
		List<QueryByTeacherVO> courseList = new ArrayList<QueryByTeacherVO>();
		int teacherId = user.getUid();
		String temp = String.valueOf(teacherId);
		PublicCourseDao cDao = new PublicCourseDao();
		List<Object[]> resultList = cDao.getSelect(temp,years,category);
		if(resultList == null){
			return null;
		}
		ScoreDao sDao = new ScoreDao();
		List<ScoreManagement> sList = null; 
		for(Object[] obj:resultList){
			if(obj[2] == null){
				obj[2] = "";
			}
			QueryByTeacherVO qt = new QueryByTeacherVO();
			qt.setCourseName(obj[0].toString());
			qt.setClassName(obj[1].toString());
			qt.setEnglishName(obj[2].toString());
			qt.setCourseId(obj[3].toString());
			qt.setClassId(obj[4].toString());
			//剔除已经录入的班级课程
			sList = sDao.get(obj[1].toString(), obj[0].toString(), years);
			if(sList.size() > 0){
				continue;
			}
			courseList.add(qt);
		}
		return courseList;
	}
	@SuppressWarnings("unchecked")
	public static List<QueryByTeacherVO> alreadyByTeacher(Users user,String years){
		List<QueryByTeacherVO> courseList = new ArrayList<QueryByTeacherVO>();
		int teacherId = user.getUid();
		String temp = String.valueOf(teacherId) + "," + years;
		Dao cDao = new CourseDao();
		List<Object[]> resultList = cDao.getBySQL(temp);
		ScoreDao sDao = new ScoreDao();
		List<ScoreManagement> sList = null; 
		if(resultList == null){
			return null;
		}
		for(Object[] obj:resultList){
			if(obj[2] == null){
				obj[2] = "";
			}
			QueryByTeacherVO qt = new QueryByTeacherVO();
			qt.setCourseName(obj[0].toString());
			qt.setClassName(obj[1].toString());
			qt.setEnglishName(obj[2].toString());
			qt.setCourseId(obj[3].toString());
			qt.setClassId(obj[4].toString());
			//查询已经录入的班级课程
			sList = sDao.get(obj[1].toString(), obj[0].toString(), years);
			//System.out.println(sList.get(0).getClassName()+"++++++");
			if(sList.size() > 0){
				courseList.add(qt);
			}
		}
		return courseList;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List byProfessional(String professional,String category,String years){
		List<Course> courseList = new ArrayList<Course>();
		List<PublicCourse> publicCourseList = new ArrayList<PublicCourse>();
		List list=new ArrayList();
		Dao cDao = new CourseDao();
		Dao pcDao = new CourseDao();
		String msg="{'professional':'"+professional+"','years':'"+years+"'}";
		if(category.equals("非公选")){
			//查询非公选课需要调用的函数
			courseList=cDao.query(msg);
			for(Course c:courseList){
				list.add(c.getCname());
			}
		}
		if(category.equals("公选")){
			//查询公选课需要调用的函数
			//按照课程名来选择班级
			publicCourseList=pcDao.query(msg);
			for(PublicCourse c:publicCourseList){
				list.add(c.getPname());
			}
			
			/*for(Course c:courseList){
				if(c.getCategory().equals("公选")){
					list.add(c.getCname());
				}
			}*/
		}
		return list;
	}
	
	public static Course getCourseByCid(String cid){
		Course course = null;
		Dao cDao = new CourseDao();
		course = (Course) cDao.get(Integer.parseInt(cid));
		return course;
	}
	public static List<Course> getCourseByYear(String years){
		List<Course> courseList = null;
		CourseDao cDao = new CourseDao();
		courseList = cDao.getByYear(years);
		return courseList;
	}
	

}
