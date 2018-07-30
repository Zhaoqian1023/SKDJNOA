/**  
 * @Title: CourseService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年8月28日
 */
package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.CourseDao;
import com.po.Course;
import com.po.Teacher;

/**
 * ClassName: CourseService 
 * @Description: TODO
 * @author Victor
 * @date 2017年8月28日
 */
public class CourseService {
	
	public static boolean addCoursePlan(ArrayList<ArrayList<Object>> data,String years){
		List<Object[]> temp = new ArrayList<Object[]>();
		CourseDao cDao = new CourseDao();
		int courseId = 0;
		for(int i = 1 ;i < data.size() ;i++){
			courseId = 0;
			Course course = new Course();
			course.setCname(data.get(i).get(1).toString());
			course.setCategory(data.get(i).get(2).toString());
			if("".equals(data.get(i).get(3).toString())){
				course.setCredits(0);
			}else{
				course.setCredits(Float.parseFloat(data.get(i).get(3).toString()));
			}
			course.setTime(data.get(i).get(4).toString());
			course.setYear(years);
			if("".equals(data.get(i).get(5).toString())){
				course.setBeginTime(0);
			}else{
				course.setBeginTime(Integer.parseInt(data.get(i).get(5).toString()));
			}
			if("".equals(data.get(i).get(6).toString())){
				course.setEndTime(0);
			}else{
				course.setEndTime(Integer.parseInt(data.get(i).get(6).toString()));
			}
			Teacher teacher = new Teacher();
			teacher.setTid(Integer.parseInt(data.get(i).get(7).toString()));
			course.setTeachers(teacher);
			if("".equals(data.get(i).get(8).toString())){
				course.setExamFlag(0);
			}else{
				course.setExamFlag(Integer.parseInt(data.get(i).get(8).toString()));
			}
			if("".equals(data.get(i).get(9).toString())){
				course.setCourseNum("");
			}else{
				course.setCourseNum(data.get(i).get(9).toString());
			}
			
			courseId = cDao.addCoursePlan(course);
			if(courseId == 0){
				return false;
			}
			Object[] o = new Object[2];
			o[0] = data.get(i).get(0).toString();
			o[1] = String.valueOf(courseId);
			temp.add(o);
		}
		return CourseClassService.addCourseClass(temp);
	}
	public static boolean deleteCoursePlan(String years){
		boolean result = false;
		List<Object> courseId = new ArrayList<Object>();
		List<Course> courseList = GetCourse.getCourseByYear(years);
		for(Course course:courseList){
			courseId.add(course.getCid());
		}
		result = CourseClassService.deleteCourseClass(courseId);
		if(result){
			CourseDao cDao = new CourseDao();
			return cDao.deleteByYears(years);
		}
		return false;
	}
	public static Course queryCourseByCid(String cid){
		if("".equals(cid) || cid == null){
			return null;
		}
		int tempCid = Integer.parseInt(cid);
		CourseDao cDao = new CourseDao();
		return (Course) cDao.get(tempCid);
	}
	public static boolean updateCourse(Course course){
		CourseDao cDao = new CourseDao();
		return cDao.update(course);
	}
	public static List<Course> getCourse(String bjm,String years){
		List<Course> courseList = null;
		String msg="{'professional':'"+bjm+"','years':'"+years+"'}";
		CourseDao cDao = new CourseDao();
		courseList = cDao.query(msg);
		return courseList;
	}

}
