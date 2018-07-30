/**  
 * @Title: PublicElectiveService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年10月14日
 */
package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.PublicCourseDao;
import com.dao.impl.PublicElectiveDao;
import com.po.PublicCourse;
import com.po.Student;
import com.util.ExcelUtil;
import com.vo.ElectiveStudentVO;

/**
 * ClassName: PublicElectiveService 
 * @Description: TODO
 * @author Victor
 * @date 2017年10月14日
 */
public class PublicElectiveService {
	
	public static boolean addCourseClass(List<Object[]> data){
		
		boolean result = false;
		PublicElectiveDao peDao = new PublicElectiveDao();
		result = peDao.addList(data);
		return result;
	}
	public static boolean deletePublicElective(PublicCourse pc){
		PublicElectiveDao peDao = new PublicElectiveDao();
		return peDao.deleteByCourseId(pc.getPid());
	}
	public static boolean addElectiveStudent(ArrayList<ArrayList<Object>> data,String years){
		PublicCourseDao pcDao = new PublicCourseDao();
		PublicElectiveDao peDao = new PublicElectiveDao();
		List<Object[]> info = new ArrayList<Object[]>();
		for(int i = 1 ;i < data.size() ;i++){
			Object[] temp = new Object[3];
			PublicCourse selectCourse = (PublicCourse) pcDao.get(Integer.parseInt(data.get(i).get(1).toString()));
			if(selectCourse == null){
				return false;
			}
			Student student = StudentService.getStudent(data.get(i).get(0).toString());
			if(student == null){
				return false;
			}
			temp[0] = data.get(i).get(0);
			temp[1] = data.get(i).get(1);
			temp[2] = years;
			info.add(temp);
		}
		return peDao.addList(info);
	}
	public static String exportStudentByCid(String courseId,String URL){
		List<ElectiveStudentVO> data = new ArrayList<ElectiveStudentVO>();
		boolean result = false;
		PublicElectiveDao peDao = new PublicElectiveDao();
		int cId = Integer.parseInt(courseId);
		List<Object[]> tempData = peDao.getElectiveStudentVOByCourseId(cId);
		if(tempData == null ){
			return "导出文件失败";
		}
		if(tempData.size() == 0){
			return "无选课学生信息";
		}
		String temp = "";
		temp += courseId+"("+tempData.get(0)[3]+")";
		String fileName = temp+".xls";
		String path=URL+"\\"+fileName;
		for(Object[] obj:tempData){
			ElectiveStudentVO esVO= new ElectiveStudentVO();
			esVO.setStudentId(obj[0].toString());
			esVO.setStudentName(obj[1].toString());
			esVO.setCourseId(obj[2].toString());
			esVO.setCourseName(obj[3].toString());
			esVO.setClassNameId(obj[4].toString());
			esVO.setClassName(obj[5].toString());
			esVO.setYears(obj[6].toString());
			data.add(esVO);
		}
		result = ExcelUtil.createElectiveStudentExcel(data, path);
		if(result){
			return fileName;
		}
		return "导出文件失败";
	}
	

}
