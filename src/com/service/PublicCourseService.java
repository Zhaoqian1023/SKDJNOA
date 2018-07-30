package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.Dao;
import com.dao.impl.PublicCourseDao;
import com.dao.impl.ScoreDao;
import com.po.PublicCourse;
import com.po.ScoreManagement;
import com.po.Teacher;
import com.po.Users;
import com.vo.AttendanceVO;
import com.vo.QueryByTeacherVO;

public class PublicCourseService {
	//获取选修课具体名单
	@SuppressWarnings("unchecked")
	public static List<AttendanceVO> getAttendanceVO(String years,String kcdm,String status){
		String SQL = "{'years':'"+years+"','kcdm':'"+kcdm+"','status':'"+status+"'}";
		List<AttendanceVO> data = new ArrayList<AttendanceVO>();
		Dao pcd = new PublicCourseDao();
		List<Object[]> objList = pcd.getBySQL(SQL);
		for(Object[] obj:objList){
			AttendanceVO avo=new AttendanceVO();
			avo.setCategory(obj[0].toString());
			if(obj[1] != null){				
				avo.setClassEnglish(obj[1].toString());
			}else{
				avo.setClassEnglish("");
			}
			avo.setClassId(Integer.parseInt(obj[2].toString()));
			avo.setClassName(obj[3].toString());
			avo.setCourseId(Integer.parseInt(obj[4].toString()));
			avo.setCourseName(obj[5].toString());
			avo.setCredits(Float.parseFloat(obj[6].toString()));
			avo.setEnglishName(obj[7].toString());
			avo.setExamFlag(Integer.parseInt(obj[8].toString()));
			avo.setSid(obj[9].toString());
			avo.setSname(obj[10].toString());
			avo.setYears(obj[11].toString());
			data.add(avo);
		}
		return data;
	}
	//根据教师筛选未录入成绩选修课
	public static List<PublicCourse> getCourseByTeacher(String teacher, String years, String category){
		if(teacher == null || years ==null){
			return null;
		}
		List<PublicCourse> data = new ArrayList<PublicCourse>();
		List<PublicCourse> resultData = new ArrayList<PublicCourse>();
		List<ScoreManagement> sList = null;
		PublicCourseDao publicCourseDao = new PublicCourseDao();
		ScoreDao sDao = new ScoreDao();
		data = publicCourseDao.get(teacher,years,category);
		for(PublicCourse pc:data){
			sList = sDao.get(pc.getPname(), pc.getYear());
			if(sList.size() > 0){
				continue;
			}else{
				resultData.add(pc);
			}
		}
		return resultData;
	}
	
	//根据教师筛选已录入成绩选修课
	@SuppressWarnings("unchecked")
	public static List<QueryByTeacherVO> alreadyByTeacher(Users user,String years, String category){
		List<Object[]> courseList = new ArrayList<Object[]>();
		List<QueryByTeacherVO> resultList = new ArrayList<QueryByTeacherVO>();
		int teacherId = user.getUid();
		String tempId = String.valueOf(teacherId);
		List<PublicCourse> data = new ArrayList<PublicCourse>();
		PublicCourseDao publicCourseDao = new PublicCourseDao();
		ScoreDao sDao = new ScoreDao();
		//该老师教学计划中该带的所有课程（公选）
		data = publicCourseDao.get(tempId,years,category);
		for(PublicCourse pc:data){
			//在成绩库中查询该门课程记录
			courseList = sDao.getVO(pc.getPid(), pc.getYear());
			if(courseList.size() > 0){
				for(Object[] obj:courseList){
					QueryByTeacherVO qtvo = new QueryByTeacherVO();
					qtvo.setClassName(obj[0].toString());
					qtvo.setCourseName(obj[1].toString());
					qtvo.setClassId(obj[2].toString());
					qtvo.setCourseId(obj[3].toString());
					resultList.add(qtvo);
				}
			}
		}
		System.out.println("----------"+resultList.size());
		return resultList;
	}
	//批量打印课程查询
	@SuppressWarnings("unchecked")
	public static List<QueryByTeacherVO> alreadyAllByTeacher(Users user,String years, String category){
		List<Object[]> courseList = new ArrayList<Object[]>();
		List<QueryByTeacherVO> resultList = new ArrayList<QueryByTeacherVO>();
		int teacherId = user.getUid();
		String tempId = String.valueOf(teacherId);
		List<PublicCourse> data = new ArrayList<PublicCourse>();
		PublicCourseDao publicCourseDao = new PublicCourseDao();
		ScoreDao sDao = new ScoreDao();
		//该老师教学计划中该带的所有课程（公选）
		data = publicCourseDao.get(tempId,years,category);
		for(PublicCourse pc:data){
			//在成绩库中查询该门课程记录
			courseList = sDao.getVO(pc.getPid(), pc.getYear());
			if(courseList.size() > 0){
				QueryByTeacherVO qtvo = new QueryByTeacherVO();
				qtvo.setClassName(courseList.get(0)[0].toString());
				qtvo.setCourseName(courseList.get(0)[1].toString());
				qtvo.setClassId(courseList.get(0)[2].toString());
				qtvo.setCourseId(courseList.get(0)[3].toString());
				resultList.add(qtvo);
			}
		}
		return resultList;
	}
	
	public static List<PublicCourse> getCourse(String bjm,String years,String category){
		List<PublicCourse> courseList = null;
		String msg="{'professional':'"+bjm+"','years':'"+years+"','category':'"+category+"'}";
		PublicCourseDao pcDao = new PublicCourseDao();
		courseList = pcDao.querySelect(msg);
		return courseList;
	}
	public static boolean addSelectCoursePlan(ArrayList<ArrayList<Object>> data,String years){
		PublicCourseDao pcDao = new PublicCourseDao();
		boolean result = false;
		for(int i = 1 ;i < data.size() ;i++){
			result = false;
			PublicCourse selectCourse = new PublicCourse();
			selectCourse.setPname(data.get(i).get(0).toString());
			selectCourse.setCategory(data.get(i).get(1).toString());
			if("".equals(data.get(i).get(2).toString())){
				selectCourse.setCredits(0);
			}else{
				selectCourse.setCredits(Float.parseFloat(data.get(i).get(2).toString()));
			}
			selectCourse.setTime(data.get(i).get(3).toString());
			selectCourse.setYear(years);
			if("".equals(data.get(i).get(4).toString())){
				selectCourse.setBeginTime(0);
			}else{
				selectCourse.setBeginTime(Integer.parseInt(data.get(i).get(4).toString()));
			}
			if("".equals(data.get(i).get(5).toString())){
				selectCourse.setEndTime(0);
			}else{
				selectCourse.setEndTime(Integer.parseInt(data.get(i).get(5).toString()));
			}
			Teacher teacher = new Teacher();
			teacher.setTid(Integer.parseInt(data.get(i).get(6).toString()));
			selectCourse.setTeachers(teacher);
			if("".equals(data.get(i).get(7).toString())){
				selectCourse.setExamFlag(0);
			}else{
				selectCourse.setExamFlag(Integer.parseInt(data.get(i).get(7).toString()));
			}
			if("".equals(data.get(i).get(8).toString())){
				selectCourse.setCourseNum("");
			}else{
				selectCourse.setCourseNum(data.get(i).get(8).toString());
			}
			result = pcDao.add(selectCourse);
			if(result == false){
				return false;
			}
			
		}
		return true;
	}
	
	public static PublicCourse queryCourseByCid(String cid){
		if("".equals(cid) || cid == null){
			return null;
		}
		int tempCid = Integer.parseInt(cid);
		PublicCourseDao pcDao = new PublicCourseDao();
		return (PublicCourse) pcDao.get(tempCid);
	}
	
	public static boolean updateCourse(PublicCourse course){
		PublicCourseDao pcDao = new PublicCourseDao();
		return pcDao.update(course);
	}
	
	public static boolean deleteCourse(String courseId){
		PublicCourseDao pcDao = new PublicCourseDao();
		int cid = Integer.parseInt(courseId);
		boolean result = false;
		PublicCourse pc =(PublicCourse) pcDao.get(cid); 
		if(pc == null){
			return false;
		}
		result = PublicElectiveService.deletePublicElective(pc);
		if(result){
			pcDao.del(pc);
		}
		return result;
	}
	public static boolean deleteElectiveStudent(String courseId){
		PublicCourseDao pcDao = new PublicCourseDao();
		int cid = Integer.parseInt(courseId);
		PublicCourse pc =(PublicCourse) pcDao.get(cid); 
		if(pc == null){
			return false;
		}
		return PublicElectiveService.deletePublicElective(pc);
	}

}
