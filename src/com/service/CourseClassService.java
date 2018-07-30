/**  
 * @Title: CourseClassService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年8月28日
 */
package com.service;

import java.util.List;

import com.dao.impl.CourseclassDao;

/**
 * ClassName: CourseClassService 
 * @Description: TODO
 * @author Victor
 * @date 2017年8月28日
 */
public class CourseClassService {
	
	public static boolean addCourseClass(List<Object[]> data){
		
		boolean result = false;
		CourseclassDao ccDao = new CourseclassDao();
		result = ccDao.addList(data);
		return result;
	}
	public static boolean deleteCourseClass(List<Object> courseId){
		CourseclassDao ccDao = new CourseclassDao();
		boolean result = false;
		result = ccDao.deleteByCourseid(courseId);
		return result;
	}
	
	public static boolean updateCourseClass(List<Object[]> data){
			
			boolean result = false;
			CourseclassDao ccDao = new CourseclassDao();
			result = ccDao.updateList(data);
			return result;
	}

}
