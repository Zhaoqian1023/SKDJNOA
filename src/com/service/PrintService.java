package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.Dao;
import com.dao.impl.PrintDao;
import com.dao.impl.SaveTempDao;
import com.po.SaveTemp;
import com.vo.AttendanceVO;
import com.vo.SaveScoreVO;

public class PrintService {
	
	@SuppressWarnings("unchecked")
	public static List<AttendanceVO> printAttendance(String bjdm, String kcdm, String status){
		String SQL="{'bjdm':'"+bjdm+"','kcdm':'"+kcdm+"','status':'"+status+"'}";
		List<AttendanceVO> list=new ArrayList<AttendanceVO>();
		Dao printDao = new PrintDao();
		List<Object[]> objList=printDao.getBySQL(SQL);
		for(Object[] obj:objList){
			AttendanceVO avo=new AttendanceVO();
			avo.setCategory(obj[0].toString());
			avo.setClassId(Integer.parseInt(obj[1].toString()));
			avo.setClassName(obj[2].toString());
			avo.setCourseName(obj[3].toString());
			avo.setCredits(Float.parseFloat(obj[4].toString()));
			avo.setEnglishName(obj[5].toString());
			avo.setSid(obj[6].toString());
			avo.setSname(obj[7].toString());
			avo.setYears(obj[8].toString());
			if(obj[9]!=null){
				avo.setClassEnglish(obj[9].toString());
			}
			avo.setCourseId(Integer.parseInt(obj[10].toString()));
			avo.setExamFlag(Integer.parseInt(obj[11].toString()));
			list.add(avo);
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public static List<AttendanceVO> printSelectAttendance(String bjdm, String kcdm, String status){
		String SQL="{'bjdm':'"+bjdm+"','kcdm':'"+kcdm+"','status':'"+status+"'}";
		List<AttendanceVO> list=new ArrayList<AttendanceVO>();
		PrintDao printDao = new PrintDao();
		List<Object[]> objList=printDao.getSelectBySQL(SQL);
		for(Object[] obj:objList){
			AttendanceVO avo=new AttendanceVO();
			avo.setCategory(obj[0].toString());
			avo.setClassId(Integer.parseInt(obj[1].toString()));
			avo.setClassName(obj[2].toString());
			avo.setCourseName(obj[3].toString());
			avo.setCredits(Float.parseFloat(obj[4].toString()));
			avo.setEnglishName(obj[5].toString());
			avo.setSid(obj[6].toString());
			avo.setSname(obj[7].toString());
			avo.setYears(obj[8].toString());
			if(obj[9]!=null){
				avo.setClassEnglish(obj[9].toString());
			}
			avo.setCourseId(Integer.parseInt(obj[10].toString()));
			avo.setExamFlag(Integer.parseInt(obj[11].toString()));
			list.add(avo);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SaveScoreVO> printSaveScore(String bjdm, String kcdm, String fangshi){
		String hql = bjdm+","+kcdm+","+fangshi;
		List<SaveTemp> stList = new ArrayList<SaveTemp>();
		List<SaveScoreVO> ssvList = new ArrayList<SaveScoreVO>();
		Dao saveDao = new SaveTempDao();
		stList = saveDao.query(hql);
		String tempFinalScore = null;
		String tempRemark = null;
		for(SaveTemp st:stList){
			switch (st.getRemark()) {
				case "0": tempRemark = "未选";break;
				case "1": tempRemark = "无";break;
				case "2": tempRemark = "作弊";break;
				case "3": tempRemark = "违纪";break;
				case "4": tempRemark = "旷考";break;
				case "5": tempRemark = "缓考";break;
				case "6": tempRemark = "取消考试资格";break;
			}
			if(st.getFinalScore() != null){
				switch (st.getFinalScore()) {
					case "1": tempFinalScore = "优";break;
					case "2": tempFinalScore = "良";break;
					case "3": tempFinalScore = "中";break;
					case "4": tempFinalScore = "及格";break;
					case "5": tempFinalScore = "不及格";break;
				}
			}
			SaveScoreVO ssv = new SaveScoreVO();
			ssv.setClassId(st.getClassId());
			ssv.setClassName(st.getClassName());
			ssv.setCourseCategory(st.getCourseCategory());
			ssv.setCourseName(st.getCourseName());
			ssv.setCredit(st.getCredit());
			ssv.setFinalScore(tempFinalScore);
			ssv.setFinalScoreNum(st.getFinalScore());
			ssv.setFlag(st.getFlag());
			ssv.setOrdinaryProportion(st.getOrdinaryProportion());
			ssv.setOrdinaryScore(st.getOrdinaryScore());
			ssv.setPaperProportion(st.getPaperProportion());
			ssv.setPaperScore(st.getPaperScore());
			ssv.setRemark(tempRemark);
			ssv.setRemarkNum(st.getRemark());
			ssv.setStId(st.getStId());
			ssv.setStudentId(st.getStudentId());
			ssv.setStudentName(st.getStudentName());
			ssv.setYears(st.getYears());
			ssv.setCourseId(st.getCourseId());
			ssv.setExamFlag(st.getExamFlag());
			ssvList.add(ssv);
		}
		
		return ssvList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SaveScoreVO> printSaveScoreGX(String kcdm, String fangshi){
		String hql = kcdm+","+fangshi;
		List<SaveTemp> stList = new ArrayList<SaveTemp>();
		List<SaveScoreVO> ssvList = new ArrayList<SaveScoreVO>();
		SaveTempDao saveDao = new SaveTempDao();
		stList = saveDao.getBySQL(hql);
		String tempFinalScore = null;
		String tempRemark = null;
		for(SaveTemp st:stList){
			switch (st.getRemark()) {
				case "0": tempRemark = "未选";break;
				case "1": tempRemark = "无";break;
				case "2": tempRemark = "作弊";break;
				case "3": tempRemark = "违纪";break;
				case "4": tempRemark = "旷考";break;
				case "5": tempRemark = "缓考";break;
				case "6": tempRemark = "取消考试资格";break;
			}
			if(st.getFinalScore() != null){
				switch (st.getFinalScore()) {
					case "1": tempFinalScore = "优";break;
					case "2": tempFinalScore = "良";break;
					case "3": tempFinalScore = "中";break;
					case "4": tempFinalScore = "及格";break;
					case "5": tempFinalScore = "不及格";break;
				}
			}
			SaveScoreVO ssv = new SaveScoreVO();
			ssv.setClassId(st.getClassId());
			ssv.setClassName(st.getClassName());
			ssv.setCourseCategory(st.getCourseCategory());
			ssv.setCourseName(st.getCourseName());
			ssv.setCredit(st.getCredit());
			ssv.setFinalScore(tempFinalScore);
			ssv.setFinalScoreNum(st.getFinalScore());
			ssv.setFlag(st.getFlag());
			ssv.setOrdinaryProportion(st.getOrdinaryProportion());
			ssv.setOrdinaryScore(st.getOrdinaryScore());
			ssv.setPaperProportion(st.getPaperProportion());
			ssv.setPaperScore(st.getPaperScore());
			ssv.setRemark(tempRemark);
			ssv.setRemarkNum(st.getRemark());
			ssv.setStId(st.getStId());
			ssv.setStudentId(st.getStudentId());
			ssv.setStudentName(st.getStudentName());
			ssv.setCourseId(st.getCourseId());
			ssv.setExamFlag(st.getExamFlag());
			ssv.setYears(st.getYears());
			ssvList.add(ssv);
		}
		return ssvList;
	}

}
