package com.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.Dao;
import com.dao.impl.SaveTempDao;
import com.dao.impl.ScoreDao;
import com.po.Log;
import com.po.Management;
import com.po.SaveTemp;
import com.po.ScoreManagement;
import com.po.Users;
import com.service.LogService;
import com.service.PublicCourseService;
import com.service.ScoreService;
import com.vo.CourseResultVO;
import com.vo.QueryByTeacherVO;

@SuppressWarnings("serial")
public class SourceAction extends SupureAction {
	private int classId;
	private String className;
	private String year;
	private String category;
	private String course;
	private int courseId;
	private float credits;
	private String paperProportion;
	private String ordinaryProportion;
	private String resetGrade1;
	private String resetGrade2;
	private String resetGrade3;
	private int examFlag;
	private String page;
	private String nextPage;
	private List<ScoreManagement> list;
	private List<ScoreManagement> list1;
	private List<List<ScoreManagement>> printAll;
	private String flag;
	private CourseResultVO cr;
	private HttpSession session;
	private String kcdm;
	private String bjdm;
	//录入百分制成绩
	public String add() {
		ScoreDao sdao = new ScoreDao();
		session = ServletActionContext.getRequest().getSession();
		String teacherName = (String) session.getAttribute("teacher");
		// 是否已经录入
		if (sdao.get(className, course, year).size() > 0) {
			return "Fail";
		}
		// 先判断输入的比重是否为空
		if ("".equals(paperProportion) || "".equals(ordinaryProportion)) {
			nextPage = page + "error";
			return "inputerror";
		} // 判断比重是否为数字或者小数
		if (!paperProportion.trim().matches("^[0.0-9.0]+$")) {
			nextPage = page + "error";
			return "inputerror";
		}// 判断比重是否为数字或者小数
		if (!ordinaryProportion.trim().matches("^[0.0-9.0]+$")) {
			nextPage = page + "error";
			return "inputerror";
		}
		String[] studentname = request.getParameterValues("studentName");
		String[] studentid = request.getParameterValues("studentId");
		String[] pagergrade = request.getParameterValues("paperGrade");
		String[] ordinarygrade = request.getParameterValues("ordinaryGrade");
		String[] bz = request.getParameterValues("beizhu");
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();
		String fianlgrade1 = "";
		float finalgrade = 0.0f;
		/*DecimalFormat formater = new DecimalFormat("#0.##");*/
		String bz1 = "";
		for (int i = 0; i < studentname.length; i++) {
			if("".equals(ordinarygrade[i].trim())){
				ordinarygrade[i] = "0";
			}
			ScoreManagement s = new ScoreManagement();
			if ("1".equals(bz[i])) {
				if ("".equals(pagergrade[i].trim())
						|| "".equals(ordinarygrade[i].trim())) {
					nextPage = page + "error";
					return "inputerror";
				}

				if (!pagergrade[i].trim().matches("^[0.0-9.0]+$")) {
					nextPage = page + "error";
					return "inputerror";
				}
				if (!(ordinarygrade[i].trim().matches("^[0.0-9.0]+$"))) {
					nextPage = page + "error";
					return "inputerror";
				}
				finalgrade = (Float.parseFloat(pagergrade[i].trim()) * Float
						.parseFloat(paperProportion.trim()))
						/ 100
						+ (Float.parseFloat(ordinarygrade[i].trim()) * Float
								.parseFloat(ordinaryProportion.trim())) / 100;
				// 此处插入判断外教课
				if (59.5 <= finalgrade && finalgrade <= 60) {
					finalgrade = 60;
				}
				/*fianlgrade1 = formater.format(finalgrade);*/
				fianlgrade1 = (new BigDecimal(finalgrade).setScale(0, BigDecimal.ROUND_HALF_UP)).toString();
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade(pagergrade[i]);
				s.setOrdinaryGrade(ordinarygrade[i]);
				s.setFinalGrade(fianlgrade1);
				s.setBeizhu("无");
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("3".equals(bz[i]) || "4".equals(bz[i]) || "6".equals(bz[i])
					|| "2".equals(bz[i])) {
				if (!"".equals(pagergrade[i].trim())
						|| !"0".equals(ordinarygrade[i].trim())) {
					nextPage = page + "error";
					return "inputerror";
				}
				if ("2".equals(bz[i])) {
					bz1 = "作弊";
				}
				if ("3".equals(bz[i])) {
					bz1 = "违纪";
				}
				if ("4".equals(bz[i])) {
					bz1 = "旷考";
				}
				if ("6".equals(bz[i])) {
					bz1 = "取消考试资格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade("0");
				s.setOrdinaryGrade("0");
				s.setFinalGrade("0");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
			if ("0".equals(bz[i]) || "5".equals(bz[i])) {
				if (!"".equals(pagergrade[i].trim())
						|| !"0".equals(ordinarygrade[i].trim())) {
					nextPage = page + "error";
					return "inputerror";
				}
				if ("0".equals(bz[i])) {
					bz1 = "未选";
				}
				if ("5".equals(bz[i])) {
					bz1 = "缓考";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
		}
		if (sdao.addAll(sm)) {
			Users user = (Users) session.getAttribute("users");
			Log log = new Log("", user.getUid(), user.getUname(), className,
					course, "课程成绩录入", "教师");
			LogService.addLog(log);
			//删除缓存成绩
			Dao saveDao = new SaveTempDao();
			SaveTemp st = new SaveTemp();
			st.setClassId(String.valueOf(sm.get(0).getClassId()));
			st.setCourseId(String.valueOf(sm.get(0).getCourseId()));
			saveDao.del(st);
			return "Success";
		} else {
			return "error";
		}
	}

	// 五级记分制课程成绩录入
	public String addkcc() {
		ScoreDao sdao = new ScoreDao();
		session = ServletActionContext.getRequest().getSession();
		String teacherName = (String) session.getAttribute("teacher");
		if (sdao.get(className, course, year).size() > 0) {// 是否已经录入
			return "Fail";
		}
		
		if ("".equals(paperProportion.trim())
				|| "".equals(ordinaryProportion.trim())) {
			nextPage = page + "error";
			return "inputerror";
		} // 判断是否为数字或者小数
		if (!paperProportion.trim().matches("^[0.0-9.0]+$")) {
			nextPage = page + "error";
			return "inputerror";
		}
		if (!ordinaryProportion.trim().matches("^[0.0-9.0]+$")) {
			nextPage = page + "error";
			return "inputerror";
		}

		String[] studentname = request.getParameterValues("studentName");
		String[] studentid = request.getParameterValues("studentId");
		String[] finalGrade = request.getParameterValues("finalGrade");
		String[] bz = request.getParameterValues("beizhu");
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();

		for (int i = 0; i < studentname.length; i++) {
			ScoreManagement s = new ScoreManagement();
			String bz1 = "";
			String finalGrade1 = "";
			if ("1".equals(bz[i])) {
				if ("1".equals(finalGrade[i])) {
					finalGrade1 = "优";
				}
				if ("2".equals(finalGrade[i])) {
					finalGrade1 = "良";
				}
				if ("3".equals(finalGrade[i])) {
					finalGrade1 = "中";
				}
				if ("4".equals(finalGrade[i])) {
					finalGrade1 = "及格";
				}
				if ("5".equals(finalGrade[i])) {
					finalGrade1 = "不及格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade(finalGrade1);
				s.setBeizhu("无");
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("3".equals(bz[i]) || "4".equals(bz[i]) || "6".equals(bz[i])
					|| "2".equals(bz[i])) {

				if ("2".equals(bz[i])) {
					bz1 = "作弊";
				}
				if ("3".equals(bz[i])) {
					bz1 = "违纪";
				}
				if ("4".equals(bz[i])) {
					bz1 = "旷考";
				}
				if ("6".equals(bz[i])) {
					bz1 = "取消考试资格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("不及格");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("0".equals(bz[i]) || "5".equals(bz[i])) {

				if ("0".equals(bz[i])) {
					bz1 = "未选";
				}
				if ("5".equals(bz[i])) {
					bz1 = "缓考";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(classId);
				s.setClassName(className);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(Float.parseFloat(paperProportion));
				s.setOrdinaryProportion(Float.parseFloat(ordinaryProportion));
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
		}
		if (sdao.addAll(sm)) {

			Users user = (Users) session.getAttribute("users");
			Log log = new Log("", user.getUid(), user.getUname(), className,
					course, "课程成绩录入", "教师");
			LogService.addLog(log);
			//删除缓存成绩
			Dao saveDao = new SaveTempDao();
			SaveTemp st = new SaveTemp();
			st.setClassId(String.valueOf(sm.get(0).getClassId()));
			st.setCourseId(String.valueOf(sm.get(0).getCourseId()));
			saveDao.del(st);
			return "Success";
		} else {
			return "error";
		}
	}
	
	//公选课成绩录入（百分制）
	public String addGX(){
		ScoreDao sdao = new ScoreDao();
		session = ServletActionContext.getRequest().getSession();
		String teacherName = (String) session.getAttribute("teacher");
		// 是否已经录入
		if (sdao.get(course, year).size() > 0) {
			return "Fail";
		}
		
		String[] studentname = request.getParameterValues("studentName");
		String[] studentid = request.getParameterValues("studentId");
		String[] classnames = request.getParameterValues("classNames");
		String[] finalgradetemp = request.getParameterValues("finalGrade");
		String[] bz = request.getParameterValues("beizhu");
		String[] classid = request.getParameterValues("classid");
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();
		String fianlgrade1 = "";
		float finalgrade = 0.0f;
		/*DecimalFormat formater = new DecimalFormat("#0.##");*/
		String bz1 = "";
		for (int i = 0; i < studentname.length; i++) {
			ScoreManagement s = new ScoreManagement();
			if ("1".equals(bz[i])) {
				
				if (!(finalgradetemp[i].trim().matches("^[0.0-9.0]+$"))) {
					nextPage = page + "error";
					return "inputerror";
				}
				finalgrade = Float.parseFloat(finalgradetemp[i].trim()); 
				// 此处避免计算误差
				if (59.5 <= finalgrade && finalgrade <= 60) {
					finalgrade = 60;
				}
				/*fianlgrade1 = formater.format(finalgrade);*/
				fianlgrade1 = (new BigDecimal(finalgrade).setScale(0, BigDecimal.ROUND_HALF_UP)).toString();
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("0");
				s.setOrdinaryGrade("0");
				s.setFinalGrade(fianlgrade1);
				s.setBeizhu("无");
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("3".equals(bz[i]) || "4".equals(bz[i]) || "6".equals(bz[i])
					|| "2".equals(bz[i])) {
				if (!"".equals(finalgradetemp[i].trim())) {
					nextPage = page + "error";
					return "inputerror";
				}
				if ("2".equals(bz[i])) {
					bz1 = "作弊";
				}
				if ("3".equals(bz[i])) {
					bz1 = "违纪";
				}
				if ("4".equals(bz[i])) {
					bz1 = "旷考";
				}
				if ("6".equals(bz[i])) {
					bz1 = "取消考试资格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("0");
				s.setOrdinaryGrade("0");
				s.setFinalGrade("0");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
			if ("0".equals(bz[i]) || "5".equals(bz[i])) {
				if (!"".equals(finalgradetemp[i].trim())) {
					nextPage = page + "error";
					return "inputerror";
				}
				if ("0".equals(bz[i])) {
					bz1 = "未选";
				}
				if ("5".equals(bz[i])) {
					bz1 = "缓考";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
		}
		if (sdao.addAll(sm)) {
			Users user = (Users) session.getAttribute("users");
			Log log = new Log("", user.getUid(), user.getUname(), className,
					course, "课程成绩录入", "教师");
			LogService.addLog(log);
			//删除缓存成绩
			SaveTempDao saveDao = new SaveTempDao();
			SaveTemp st = new SaveTemp();
			st.setCourseId(String.valueOf(sm.get(0).getCourseId()));
			saveDao.delGX(st);
			return "Success";
		} else {
			return "error";
		}
		
	}
	
	// 五级记分制课程成绩录入(公选)
	public String addkccGX() {
		ScoreDao sdao = new ScoreDao();
		session = ServletActionContext.getRequest().getSession();
		String teacherName = (String) session.getAttribute("teacher");
		if (sdao.get(course, year).size() > 0) {// 是否已经录入
			return "Fail";
		}
		
		String[] studentname = request.getParameterValues("studentName");
		String[] studentid = request.getParameterValues("studentId");
		String[] classnames = request.getParameterValues("classNames");
		String[] finalGrade = request.getParameterValues("finalGrade");
		String[] bz = request.getParameterValues("beizhu");
		String[] classid = request.getParameterValues("classid");
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();

		for (int i = 0; i < studentname.length; i++) {
			ScoreManagement s = new ScoreManagement();
			String bz1 = "";
			String finalGrade1 = "";
			if ("1".equals(bz[i])) {
				if ("1".equals(finalGrade[i])) {
					finalGrade1 = "优";
				}
				if ("2".equals(finalGrade[i])) {
					finalGrade1 = "良";
				}
				if ("3".equals(finalGrade[i])) {
					finalGrade1 = "中";
				}
				if ("4".equals(finalGrade[i])) {
					finalGrade1 = "及格";
				}
				if ("5".equals(finalGrade[i])) {
					finalGrade1 = "不及格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade(finalGrade1);
				s.setBeizhu("无");
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("3".equals(bz[i]) || "4".equals(bz[i]) || "6".equals(bz[i])
					|| "2".equals(bz[i])) {

				if ("2".equals(bz[i])) {
					bz1 = "作弊";
				}
				if ("3".equals(bz[i])) {
					bz1 = "违纪";
				}
				if ("4".equals(bz[i])) {
					bz1 = "旷考";
				}
				if ("6".equals(bz[i])) {
					bz1 = "取消考试资格";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("不及格");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}

			if ("0".equals(bz[i]) || "5".equals(bz[i])) {

				if ("0".equals(bz[i])) {
					bz1 = "未选";
				}
				if ("5".equals(bz[i])) {
					bz1 = "缓考";
				}
				s.setStudentId(studentid[i]);
				s.setStudentName(studentname[i]);
				s.setClassId(Integer.parseInt(classid[i]));
				s.setClassName(classnames[i]);
				s.setYear(year);
				s.setCategory(category);
				s.setCourse(course);
				s.setCourseId(courseId);
				s.setCredits(credits);
				s.setPaperProportion(100);
				s.setOrdinaryProportion(0);
				s.setPaperGrade("");
				s.setOrdinaryGrade("");
				s.setFinalGrade("");
				s.setBeizhu(bz1);
				s.setResetGrade1("");
				s.setResetGrade2("");
				s.setResetGrade3("");
				s.setExamFlag(examFlag);
				s.setTeacherName(teacherName);
				sm.add(s);
			}
		}
		if (sdao.addAll(sm)) {

			Users user = (Users) session.getAttribute("users");
			Log log = new Log("", user.getUid(), user.getUname(), className,
					course, "课程成绩录入", "教师");
			LogService.addLog(log);
			//删除缓存成绩
			SaveTempDao saveDao = new SaveTempDao();
			SaveTemp st = new SaveTemp();
			st.setCourseId(String.valueOf(sm.get(0).getCourseId()));
			saveDao.delGX(st);
			return "Success";
		} else {
			return "error";
		}
	}
	
	
	//保存成绩（非公选）百分制
	public String save(){
		String[] studentName = request.getParameterValues("studentName");
		String[] studentId = request.getParameterValues("studentId");
		String[] paperScore = request.getParameterValues("paperGrade");
		String[] ordinaryScore = request.getParameterValues("ordinaryGrade");
		String[] remark = request.getParameterValues("beizhu");
		List<SaveTemp> scoreTempList = new ArrayList<SaveTemp>();
		for(int i = 0; i<studentName.length; i++){
			SaveTemp st = new SaveTemp();
			st.setClassId(String.valueOf(classId));
			st.setClassName(className);
			st.setYears(year);
			st.setCourseName(course);
			st.setStudentId(studentId[i]);
			st.setStudentName(studentName[i]);
			st.setOrdinaryScore(ordinaryScore[i]);
			st.setPaperScore(paperScore[i]);
			st.setRemark(remark[i]);
			st.setOrdinaryProportion(ordinaryProportion);
			st.setPaperProportion(paperProportion);
			st.setCredit(String.valueOf(credits));
			st.setCourseCategory(category);
			st.setFlag(flag);
			st.setCourseId(String.valueOf(courseId));
			st.setExamFlag(String.valueOf(examFlag));
			scoreTempList.add(st);
		} 
		//先删除已保存的该课程信息，在将新录入的成绩信息进行保存
		Dao saveDao = new SaveTempDao();
		if(saveDao.del(scoreTempList.get(0)) && saveDao.add(scoreTempList)){
			page = page + "success";
		}else{
			page = page + "error";
		}
		return "SaveFunction";
	}
	//保存五级记分制类型成绩（非公选）
	public String saveKcc(){
		String[] studentName = request.getParameterValues("studentName");
		String[] studentId = request.getParameterValues("studentId");
		String[] finalScore = request.getParameterValues("finalGrade");
		String[] remark = request.getParameterValues("beizhu");
		List<SaveTemp> scoreTempList = new ArrayList<SaveTemp>();
		for(int i = 0; i<studentName.length; i++){
			SaveTemp st = new SaveTemp();
			st.setClassId(String.valueOf(classId));
			st.setClassName(className);
			st.setYears(year);
			st.setCourseName(course);
			st.setStudentId(studentId[i]);
			st.setStudentName(studentName[i]);
			st.setRemark(remark[i]);
			st.setOrdinaryProportion(ordinaryProportion);
			st.setPaperProportion(paperProportion);
			st.setCredit(String.valueOf(credits));
			st.setCourseCategory(category);
			st.setFlag(flag);
			st.setFinalScore(finalScore[i]);
			st.setCourseId(String.valueOf(courseId));
			st.setExamFlag(String.valueOf(examFlag));
			scoreTempList.add(st);
		} 
		//先删除已保存的该课程信息，在将新录入的成绩信息进行保存
		Dao saveDao = new SaveTempDao();
		if(saveDao.del(scoreTempList.get(0)) && saveDao.add(scoreTempList)){
			page = page + "success";
		}else{
			page = page + "error";
		}
		return "SaveFunction";
	}
	
	//保存成绩（公选）百分制
	public String saveGX(){
		String[] studentName = request.getParameterValues("studentName");
		String[] studentId = request.getParameterValues("studentId");
		String[] classnames = request.getParameterValues("classNames");
		String[] finalgrade = request.getParameterValues("finalGrade");
		String[] remark = request.getParameterValues("beizhu");
		String[] classid = request.getParameterValues("classid");
		List<SaveTemp> scoreTempList = new ArrayList<SaveTemp>();
		for(int i = 0; i<studentName.length; i++){
			SaveTemp st = new SaveTemp();
			st.setClassId(classid[i]);
			st.setClassName(classnames[i]);
			st.setYears(year);
			st.setCourseName(course);
			st.setStudentId(studentId[i]);
			st.setStudentName(studentName[i]);
			st.setOrdinaryScore("");
			st.setPaperScore(finalgrade[i]);
			st.setRemark(remark[i]);
			st.setOrdinaryProportion("0");
			st.setPaperProportion("100");
			st.setCredit(String.valueOf(credits));
			st.setCourseCategory(category);
			st.setFlag(flag);
			st.setCourseId(String.valueOf(courseId));
			st.setExamFlag(String.valueOf(examFlag));
			scoreTempList.add(st);
		} 
		//先删除已保存的该课程信息，在将新录入的成绩信息进行保存
		SaveTempDao saveDao = new SaveTempDao();
		if(saveDao.delGX(scoreTempList.get(0)) && saveDao.add(scoreTempList)){
			page = page + "success";
		}else{
			page = page + "error";
		}
		return "SaveFunction";
	}
	
	//保存五级记分制类型成绩（公选）
	public String savekccGX(){
		String[] studentName = request.getParameterValues("studentName");
		String[] studentId = request.getParameterValues("studentId");
		String[] classnames = request.getParameterValues("classNames");
		String[] finalgrade = request.getParameterValues("finalGrade");
		String[] remark = request.getParameterValues("beizhu");
		String[] classid = request.getParameterValues("classid");
		List<SaveTemp> scoreTempList = new ArrayList<SaveTemp>();
		for(int i = 0; i<studentName.length; i++){
			SaveTemp st = new SaveTemp();
			st.setClassId(classid[i]);
			st.setClassName(classnames[i]);
			st.setYears(year);
			st.setCourseName(course);
			st.setStudentId(studentId[i]);
			st.setStudentName(studentName[i]);
			st.setRemark(remark[i]);
			st.setOrdinaryProportion("0");
			st.setPaperProportion("100");
			st.setCredit(String.valueOf(credits));
			st.setCourseCategory(category);
			st.setFlag(flag);
			st.setFinalScore(finalgrade[i]);
			st.setCourseId(String.valueOf(courseId));
			st.setExamFlag(String.valueOf(examFlag));
			scoreTempList.add(st);
		} 
		//先删除已保存的该课程信息，在将新录入的成绩信息进行保存
		SaveTempDao saveDao = new SaveTempDao();
		if(saveDao.delGX(scoreTempList.get(0)) && saveDao.add(scoreTempList)){
			page = page + "success";
		}else{
			page = page + "error";
		}
		return "SaveFunction";
	}
	
	

	// 按班级以及课程查询已录入课程成绩
	public String query() {
		String tempCourseId = "";
		String tempClassId = "";
		
		if (classId == 0 || courseId == 0) {
			return "printError";
		}
		tempClassId = String.valueOf(classId);
		tempCourseId = String.valueOf(courseId);
		list = ScoreService.printScore(tempClassId, tempCourseId, year);
		if (list.size() == 0 || list == null) {
			nextPage = page + "fail";
			return "Fail";
		} else {
			// 是否为考察课
			String str = "";
			for (int i = 0; i < list.size(); i++) {
				if (!"".equals(list.get(i).getFinalGrade())) {
					str = list.get(i).getFinalGrade();
					break;
				}
			}
			if (str.equals("优") || str.equals("良") || str.equals("中")
					|| str.equals("差") || str.equals("及格") || str.equals("不及格")) {
				
				cr = ScoreService.scoreResultkcc(list);

				nextPage = "printKcc" + page;
				return "printkccSuccess";
			}
			// 属于下列课程时成绩结果无需统计
			if (list.get(0).getCourse().equals("Electrical Power Design")
					|| list.get(0).getCourse()
							.equals("Design of RF-analogue electronics")
					|| list.get(0).getCourse()
							.equals("Analogue Electronic Design")
					|| list.get(0).getCourse()
							.equals("Electrical Machines and Power Systems")
					|| list.get(0)
							.getCourse()
							.equals("Engineering Design and Project Management")
					|| list.get(0).getCourse().equals("Electrical Engineering")
					|| list.get(0).getCourse()
							.equals("Digital Communication Systems")) {
				nextPage = "printBT" + page;
				return "BTSuccess";
			}
			cr = ScoreService.scoreResult(list);
			nextPage = "print" + page;
		}
		return "printSuccess";
	}
	// 按班级以及课程查询已录入课程成绩
	public String queryByCourse() {
		String tempCourseId = "";
		
		if (courseId == 0) {
			return "printError";
		}
		List<QueryByTeacherVO> temp = null;
		tempCourseId = String.valueOf(courseId);
		session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("users");
		temp = PublicCourseService.alreadyByTeacher(user, year, "公选");
		System.out.println("111111111"+temp.size()+user.getUid()+tempCourseId);
		for(QueryByTeacherVO obj:temp){
			List<ScoreManagement> tempScore = new ArrayList<ScoreManagement>();
			System.out.println("____________"+obj.getClassId()+"    "+obj.getCourseId());
			tempScore = ScoreService.printScore(obj.getClassId(), obj.getCourseId(), year);
			System.out.println("++++++++"+tempScore.size());
			if (tempScore.size() > 0) {
				boolean temps = printAll.add(tempScore);
				System.out.println("----------"+temps);
			} 
		}
		nextPage = "print" + page;
		System.out.println("22222222222222"+nextPage);
		return "printSuccess";
	}

	public String deleteaAll() {
		session = ServletActionContext.getRequest().getSession();
		if (kcdm == null || bjdm == null) {

			return "deleteError";
		}
		if (ScoreService.deleteScore(kcdm, bjdm)) {
			Management management = (Management) session
					.getAttribute("manager");
			Log log = new Log("", management.getMid(), management.getMname(),
					className, course, "课程成绩删除", "管理员");
			LogService.addLog(log);
			page="";
			return "deleteSuccess";
		}
		return "deleteFail";

	}

	
	@SuppressWarnings("static-access")
	public String updateSource() {
		session = ServletActionContext.getRequest().getSession();
		String[] examFlag1 = request.getParameterValues("examFlag1");
		String[] year1 = request.getParameterValues("year1");
		String[] ordinarygrade1 = request.getParameterValues("ordinarygrade");
		String[] papergrade1 = request.getParameterValues("papergrade");
		String[] finalgrade1 = request.getParameterValues("finalgrade");
		String[] resetgrade11 = request.getParameterValues("resetgrade1");
		String[] resetgrade21 = request.getParameterValues("resetgrade2");
		String[] resetgrade31 = request.getParameterValues("resetgrade3");
		String[] beizhu1 = request.getParameterValues("beizhu1");
		String[] sid1 = request.getParameterValues("sid");
		ScoreDao sDao = new ScoreDao();
		ScoreService scoreService = new ScoreService();
		String a = sid1[0];
		
		List<ScoreManagement> sm = scoreService.studentScore(a);
		List<ScoreManagement> temp = new ArrayList<ScoreManagement>();
		/*System.out.println(sid1.length);*/
		for (int i = 0; i < sid1.length; i++) {
			if (Integer.parseInt(examFlag1[i]) == sm.get(i).getExamFlag()
					&&sm.get(i).getYear().equals(year1[i])
					&&sm.get(i).getOrdinaryGrade().equals(ordinarygrade1[i])
					&&sm.get(i).getPaperGrade().equals(papergrade1[i])
					&&sm.get(i).getFinalGrade().equals(finalgrade1[i])
					&&sm.get(i).getResetGrade1().equals(resetgrade11[i])
					&&sm.get(i).getResetGrade2().equals(resetgrade21[i])
					&&sm.get(i).getResetGrade3().equals(resetgrade31[i])
					&&sm.get(i).getBeizhu().equals(beizhu1[i])) {
				continue;
			}else{
				ScoreManagement s = new ScoreManagement();
				s.setSmid(sm.get(i).getSmid());
				s.setStudentId(sm.get(i).getStudentId());
				s.setStudentName(sm.get(i).getStudentName());
				s.setClassId(sm.get(i).getClassId());
				s.setClassName(sm.get(i).getClassName());
				s.setYear(year1[i]);
				s.setCategory(sm.get(i).getCategory());
				s.setCourse(sm.get(i).getCourse());
				s.setCourseId(sm.get(i).getCourseId());
				s.setCredits(sm.get(i).getCredits());
				s.setPaperProportion(sm.get(i).getPaperProportion());
				s.setOrdinaryProportion(sm.get(i).getOrdinaryProportion());
				s.setPaperGrade(papergrade1[i]);
				s.setOrdinaryGrade(ordinarygrade1[i]);
				s.setFinalGrade(finalgrade1[i]);
				s.setResetGrade1(resetgrade11[i]);
				s.setResetGrade2(resetgrade21[i]);
				s.setResetGrade3(resetgrade31[i]);
				s.setBeizhu(beizhu1[i]);
				s.setExamFlag(Integer.parseInt(examFlag1[i]));
				s.setTeacherName(sm.get(i).getTeacherName());
				temp.add(s);	
			}
		}
		/*System.out.println(temp.size());*/
		if(temp.size()>0){
			boolean b=sDao.update(temp);
			if(b){
				Management management = (Management) session
						.getAttribute("manager");
				Log log = new Log("", management.getMid(), management.getMname(),
						sm.get(0).getStudentId(), sm.get(0).getStudentName(), "成绩修改", "管理员");
				LogService.addLog(log);
				
				
				
				session.setAttribute("scoreupdatesuccess", "1");
				return "updatescore";
			}else{
				session.setAttribute("scoreupdateerror", "1");
				return "updatescore";
			}
		}else{
			session.setAttribute("scoreupdateerror1", "1");
			return "updatescore";
		}
	}

	@SuppressWarnings({ "static-access", "unused" })
	public String queryScore() {
		session = ServletActionContext.getRequest().getSession();
		ScoreDao sDao = new ScoreDao();
		ScoreService scoreService = new ScoreService();
		if (null != request.getParameter("sid")) {
			list = scoreService.studentScore(request.getParameter("sid"));
			System.out.println(request.getParameter("sid"));
			if (list.size() > 0) {
				session.setAttribute("findscoresuccess", "success");
				return "findscoresuccess";
			} else {
				session.setAttribute("findscoreerror", "error");
				return "updatescore";
			}
		}
		session.setAttribute("findscoreerror", "error");
		return "updatescore";
	}

	/*
	 * // 补考成绩录入查询 public String bkcjQuery() { System.out.println(className +
	 * "  " + course + "   " + page); if (className == null || course == null) {
	 * return "printError"; } list = ScoreService.printScore(className, course,
	 * year);
	 * 
	 * if (list.size() == 0 || list == null) { nextPage = page + "fail"; return
	 * "Fail"; } else { // 是否为考察课 String str = ""; for (int i = 0; i <
	 * list.size(); i++) { if (null != list.get(i).getFinalGrade()) { str =
	 * list.get(i).getFinalGrade(); } } if (str.equals("优") || str.equals("良")
	 * || str.equals("中") || str.equals("差") || str.equals("及格") ||
	 * str.equals("不及格")) {
	 * 
	 * for (int i = 0; i < list.size(); i++) { if (null !=
	 * list.get(i).getFinalGrade()) { str = list.get(i).getFinalGrade(); } if
	 * (str.equals("不及格")) { list1.add(list.get(i)); } }
	 * 
	 * nextPage = "" + page; return ""; } // 计算该班成绩结果 float a = 0; if
	 * (list.get(0).getCourse().equals("Electrical Power Design") ||
	 * list.get(0).getCourse() .equals("Design of RF-analogue electronics") ||
	 * list.get(0).getCourse() .equals("Analogue Electronic Design")
	 * ||list.get(0).getCourse().equals("Electrical Machines and Power Systems")
	 * || list.get(0).getCourse().equals(
	 * "Engineering Design and Project Management")
	 * ||list.get(0).getCourse().equals("Electrical Engineering")
	 * ||list.get(0).getCourse().equals("Digital Communication Systems") ) { for
	 * (int i = 0; i < list.size(); i++) { if (null !=
	 * list.get(i).getFinalGrade()) { a =
	 * Float.parseFloat(list.get(i).getFinalGrade()); } if (a < 50.0) {
	 * list1.add(list.get(i)); } }
	 * 
	 * nextPage = "printBT" + page; return "BTSuccess"; } for (int i = 0; i <
	 * list.size(); i++) { if (null != list.get(i).getFinalGrade()) { a =
	 * Float.parseFloat(list.get(i).getFinalGrade()); } if (a < 60.0) {
	 * list1.add(list.get(i)); } } nextPage = "" + page; } return "";
	 * 
	 * }
	 */
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
	}

	public String getPaperProportion() {
		return paperProportion;
	}

	public void setPaperProportion(String paperProportion) {
		this.paperProportion = paperProportion;
	}

	public String getOrdinaryProportion() {
		return ordinaryProportion;
	}

	public void setOrdinaryProportion(String ordinaryProportion) {
		this.ordinaryProportion = ordinaryProportion;
	}

	public String getResetGrade1() {
		return resetGrade1;
	}

	public void setResetGrade1(String resetGrade1) {
		this.resetGrade1 = resetGrade1;
	}

	public String getResetGrade2() {
		return resetGrade2;
	}

	public void setResetGrade2(String resetGrade2) {
		this.resetGrade2 = resetGrade2;
	}

	public String getResetGrade3() {
		return resetGrade3;
	}

	public void setResetGrade3(String resetGrade3) {
		this.resetGrade3 = resetGrade3;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public List<ScoreManagement> getList() {
		return list;
	}

	public void setList(List<ScoreManagement> list) {
		this.list = list;
	}

	public CourseResultVO getCr() {
		return cr;
	}

	public void setCr(CourseResultVO cr) {
		this.cr = cr;
	}

	public List<ScoreManagement> getList1() {
		return list1;
	}

	public void setList1(List<ScoreManagement> list1) {
		this.list1 = list1;
	}

	public int getExamFlag() {
		return examFlag;
	}

	public void setExamFlag(int examFlag) {
		this.examFlag = examFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getKcdm() {
		return kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}

	public String getBjdm() {
		return bjdm;
	}

	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}

	public List<List<ScoreManagement>> getPrintAll() {
		return printAll;
	}

	public void setPrintAll(List<List<ScoreManagement>> printAll) {
		this.printAll = printAll;
	}



	


}
