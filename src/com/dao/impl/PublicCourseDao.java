package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONException;
import org.json.JSONObject;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.PublicCourse;


public class PublicCourseDao implements Dao{

	@Override
	public boolean add(Object obj) {
		PublicCourse course = (PublicCourse) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(course);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally{
			HibernateSessionFactory.closeSession(session);
		}
	}
	public int addCoursePlan(PublicCourse course){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(course);
			session.getTransaction().commit();
			return course.getPid();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return 0;
		} finally{
			HibernateSessionFactory.closeSession(session);
		}
	}

	@Override
	public boolean del(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.delete(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally{
			HibernateSessionFactory.closeSession(session);
		}
	}

	@Override
	public Object get(int id) {
		String hql = "from PublicCourse where pid = :pid";
		PublicCourse course = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			course=(PublicCourse) session.createQuery(hql).setInteger("pid", id).uniqueResult();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return course;
	}
	@SuppressWarnings("unchecked")
	public List<PublicCourse> get(String teacher, String years, String category){
		List<PublicCourse> list = new ArrayList<PublicCourse>();
		int teacherid = Integer.parseInt(teacher);
		String sql = "SELECT t1.* FROM educationaloa.t_publiccourse as t1,educationaloa.t_teacher as t2 where t1.tid = t2.tid and t1.year=:years and t2.tid=:teacherid and t1.category=:category";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list=session.createSQLQuery(sql).addEntity(PublicCourse.class).setString("years", years).setInteger("teacherid", teacherid).setString("category", category)
					.list();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getSelect(String teacher, String years, String category){
		List<Object[]> list = new ArrayList<Object[]>();
		int teacherid = Integer.parseInt(teacher);
		String sql = "select t1.pname,t3.cname,t3.englishname,t1.pid,t3.cid "
				+ "from educationaloa.t_publiccourse as t1,educationaloa.t_publicelective as t2 ,educationaloa.t_classname as t3,educationaloa.t_student as t4 "
				+ "where t1.pid = t2.pcid and t2.sid = t4.sid and t3.cid = t4.classnameid and t1.tid=:teacherid and t1.year=:years and t1.category=:category "
				+ "group by t1.pid,t3.cid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list=session.createSQLQuery(sql).setString("years", years).setInteger("teacherid", teacherid).setString("category", category)
					.list();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	
	@Override
	public boolean update(Object obj) {
		PublicCourse course = (PublicCourse) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.merge(course);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PublicCourse> query(String msg) {
		/* 解决公选课问题思路：
		 * 1、整体业务流程为根据课程名选择班级
		 * 2、可以按照班级打印学生名单*/
		String years=msg.split(",")[0];
		String category = msg.split(",")[1];
		String HQL = "from PublicCourse where year=:year and category=:category";
		List<PublicCourse> courseList = new ArrayList<PublicCourse>();
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			courseList=session.createQuery(HQL).setString("year", years).setString("category", category).list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return courseList;
		
	}

	@Override
	public List<PublicCourse> getPage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getBySQL(String SQL) {
		JSONObject jsonObj = null;
		String years = "";
		String kcdm = "";
		String status = "";
		try {
			jsonObj = new JSONObject(SQL);
			years=jsonObj.getString("years");
			kcdm=jsonObj.getString("kcdm");
			status=jsonObj.getString("status");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Object[]> list=null;
		String HQL="SELECT t1.category,t4.englishname as egname,t4.cid,t4.cname,t1.pid,t1.pname ,t1.credits,t3.englishname,t1.examFlag,t3.sid,t3.sname,t1.year as en "
				+ "FROM educationaloa.t_publiccourse AS t1,educationaloa.t_publicelective AS t2 ,educationaloa.t_student AS t3,educationaloa.t_classname AS t4 "
				+ "where t1.pid = t2.pcid AND t2.sid = t3.sid and t3.classnameid = t4.cid  AND t1.pid=:kcdm AND t3.status=:status AND t1.year=:years";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
			list=session.createSQLQuery(HQL).setString("kcdm", kcdm).setString("status", status).setString("years", years).list();
		}catch(Exception e){
			/*System.out.println("查询数据库失败！！！！");*/
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
			/*System.out.println("com.dao：数据库查询结束");*/
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<PublicCourse> querySelect(String msg) {
		JSONObject jsonObj = null;
		String professional = "";
		String years = "";
		String category = "";
		try {
			jsonObj = new JSONObject(msg);
			professional=jsonObj.getString("professional");
			years = jsonObj.getString("years");
			category = jsonObj.getString("category");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			return null;
		}
		/*System.out.println("进入到数据库查询类CourseDso");*/
		String SQL="select t1.* "
				+ "from educationaloa.t_publiccourse as t1,educationaloa.t_publicelective as t2,educationaloa.t_student as t3,educationaloa.t_classname t4 "
				+ "where t1.pid = t2.pcid and t2.sid = t3.sid and t3.classnameid = t4.cid and t1.category = :category and t1.year=:years and t4.cname=:professional group by t1.pid;";
		List<PublicCourse> courseList = new ArrayList<PublicCourse>();
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try {
			courseList=session.createSQLQuery(SQL).addEntity(PublicCourse.class)
					.setString("professional", professional)
					.setString("years", years)
					.setString("category", category)
					.list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		/*System.out.println("com.dao：数据库查询结束");*/
		return courseList;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> createFile(String years,String category){
		List<Object[]> data = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t1.pid, t1.pname,t1.category,t1.credits,t1.time,t1.year,t1.beginTime,t1.endTime,t1.tid,t2.tname,t1.examFlag,t1.courseNum "
				+ "from educationaloa.t_publiccourse as t1,t_teacher as t2 "
				+ "where t2.tid=t1.tid and t1.year=:years and t1.category = :category";
		try {
			data = new ArrayList<Object[]>();
			data = session.createSQLQuery(sql).setString("category", category).setString("years", years).list();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return data;
	}
	public static void main(String[] args) {
		/*String years="2016-2017/2";
		String kcm="公共关系学";
		String status="在校";
		String SQL = "{'years':'"+years+"','kcm':'"+kcm+"','status':'"+status+"'}";
		List<AttendanceVO> list=new ArrayList<AttendanceVO>();
		Dao pcd = new PublicCourseDao();
		List<Object[]> objList = pcd.getBySQL(SQL);
		for(Object[] obj:objList){
			AttendanceVO avo=new AttendanceVO();
			avo.setSname(obj[10].toString());
			System.out.println(avo.getSname());
		}*/
		
		/*String teacher = "赵洪挺";
		String years = "2016-2017/2";
		PublicCourseDao pcd = new PublicCourseDao();
		List<PublicCourse> list = pcd.get(teacher,years);
		for(PublicCourse pc:list){
			System.out.println(pc.getPname());
		}*/
	}

}
