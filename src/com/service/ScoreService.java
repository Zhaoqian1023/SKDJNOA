package com.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.ScoreDao;
import com.po.ScoreManagement;
import com.vo.CourseResultVO;

public class ScoreService {
	// 该方法返回查询已录入的班级及课程成绩
	public static List<ScoreManagement> printScore(String bjdm, String kcdm, String years) {
		String SQL = "{'bjdm':'" + bjdm + "','kcdm':'" + kcdm + "','years':'"+years+"'}";
		List<ScoreManagement> list = new ArrayList<ScoreManagement>();
		ScoreDao dao = new ScoreDao();
		list = dao.query(SQL);
		System.out.println("list的大小"+list.size());
		return list;
	}
	// 该方法返回查询已录入的班级及课程成绩
	public static List<ScoreManagement> printScoreForCourse(String kcdm, String years) {
		String SQL = "{'kcdm':'" + kcdm + "','years':'"+years+"'}";
		List<ScoreManagement> list = new ArrayList<ScoreManagement>();
		ScoreDao dao = new ScoreDao();
		list = dao.queryForCourse(SQL);
		return list;
	}
	
	// 该方法根据学生学号返回学生的课程成绩
	public static List<ScoreManagement> studentScore(String sid) {
		String SQL = "{'sid':'" + sid +"'}";
		List<ScoreManagement> list = new ArrayList<ScoreManagement>();
		ScoreDao dao = new ScoreDao();
		list = dao.querySh(SQL);
		return list;
	}
	//用于删除成绩
	public static boolean deleteScore(String kcdm,String bjdm) {
		String json = "{'kcdm':'" + kcdm + "','bjdm':'" + bjdm +"'}";
		ScoreDao scd = new ScoreDao();
		return scd.delelte(json);
	}

	public static CourseResultVO scoreResult(List<ScoreManagement> list) {
		int stu1 = 0;
		int stu2 = 0;
		int stu3 = 0;
		int stu4 = 0;
		int stu5 = 0;
		int stu6=0;
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String avg = "";
		float ordinaryProportion=list.get(0).getOrdinaryProportion();
		
		float paperProportion=list.get(0).getPaperProportion();
		float sum=0;
		//System.out.println("start");
		for (ScoreManagement s : list) {
			
			if("".equals(s.getFinalGrade())){
				continue;
			}
			
			if (Float.parseFloat(s.getFinalGrade()) >= 90) {
				stu1 += 1;
			}
			if (Float.parseFloat(s.getFinalGrade()) >= 80
					&& Float.parseFloat(s.getFinalGrade()) < 90) {
				stu2 += 1;
			}
			if (Float.parseFloat(s.getFinalGrade()) >= 70
					&& Float.parseFloat(s.getFinalGrade()) < 80) {
				stu3 += 1;
			}
			if (Float.parseFloat(s.getFinalGrade()) >= 60
					&& Float.parseFloat(s.getFinalGrade()) < 70) {
				stu4 += 1;
			}
			if (Float.parseFloat(s.getFinalGrade()) < 60) {
				stu5 += 1;
			}
			sum+=Float.parseFloat(s.getFinalGrade());
			stu6+=1;
		}
		DecimalFormat formater = new DecimalFormat("#0.##");
		s1=formater.format((float)stu1/(float)stu6*100);
		s2=formater.format((float)stu2/(float)stu6*100);
		s3=formater.format((float)stu3/(float)stu6*100);
		s4=formater.format((float)stu4/(float)stu6*100);
		s5=formater.format((float)stu5/(float)stu6*100);
		avg=formater.format((float)sum/(float)stu6);
		String o=formater.format(ordinaryProportion);
		String p=formater.format(paperProportion);
		//System.out.println("end");
		CourseResultVO cvo=new CourseResultVO(stu1,stu2,stu3,stu4,stu5,s1+"%",s2+"%",s3+"%",s4+"%",s5+"%",avg,p+"%",o+"%");
		return cvo;
	}
	public static CourseResultVO scoreResultkcc(List<ScoreManagement> list) {
		int stu1 = 0;
		int stu2 = 0;
		int stu3 = 0;
		int stu4 = 0;
		int stu5 = 0;
		int stu6=0;
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String avg = "";
		float ordinaryProportion=list.get(0).getOrdinaryProportion();
		float paperProportion=list.get(0).getPaperProportion();
		for (ScoreManagement s : list) {
			if("".equals(s.getFinalGrade())){
				continue;
			}
			if ("优".equals(s.getFinalGrade())) {
				stu1 += 1;
			}
			if ("良".equals(s.getFinalGrade())) {
				stu2 += 1;
			}
			if ("中".equals(s.getFinalGrade())) {
				stu3 += 1;
			}
			if ("及格".equals(s.getFinalGrade())) {
				stu4 += 1;
			}
			if ("不及格".equals(s.getFinalGrade())) {
				stu5 += 1;
			}
			stu6+=1;
		}
		DecimalFormat formater = new DecimalFormat("#0.##");
		s1=formater.format((float)stu1/(float)stu6*100);
		s2=formater.format((float)stu2/(float)stu6*100);
		s3=formater.format((float)stu3/(float)stu6*100);
		s4=formater.format((float)stu4/(float)stu6*100);
		s5=formater.format((float)stu5/(float)stu6*100);
		String o=formater.format(ordinaryProportion);
		String p=formater.format(paperProportion);
		//System.out.println("end");
		CourseResultVO cvo=new CourseResultVO(stu1,stu2,stu3,stu4,stu5,s1+"%",s2+"%",s3+"%",s4+"%",s5+"%",avg,p+"%",o+"%");
		return cvo;
	}
	
	public static void main(String args[]) {

		/*DecimalFormat formater = new DecimalFormat("#0.##");
		 System.out.println(formater.format(58.7897456));
		
		List<ScoreManagement> list1 = printScore("电气工程及其自动化2013-2",
				"Electrical Power Design","2016-2017/1");
		for (ScoreManagement s : list1) {
			System.out.println(s.getStudentName());
		}*/
	}
}
