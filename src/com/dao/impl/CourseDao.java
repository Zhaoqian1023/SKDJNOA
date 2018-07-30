package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Course;

public class CourseDao implements Dao{
	
//添加教学计划
	@Override
	public boolean add(Object obj) {
		Course c = (Course) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
	public int addCoursePlan(Course course){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(course);
			session.getTransaction().commit();
			return course.getCid();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return 0;
		} finally{
			HibernateSessionFactory.closeSession(session);
		}
	}

	@Override
	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteByYears(String years){
		String HQL = "delete Course where year = :years";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.createQuery(HQL).setString("years", years).executeUpdate();
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
		String hql = "from Course where cid = :cid";
		Course course = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			course=(Course) session.createQuery(hql).setInteger("cid", id).uniqueResult();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return course;
	}
	@SuppressWarnings("unchecked")
	public List<Course> getByYear(String years){
		String hql = "from Course where year = :years";
		List<Course> courseList = new ArrayList<Course>();
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			courseList=session.createQuery(hql).setString("years", years).list();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return courseList;
	}
	
	
	@Override
	public boolean update(Object obj) {
		Course course = (Course) obj;
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
	public List<Course> query(String msg) {
		JSONObject jsonObj = null;
		String professional="";
		String years="";
		try {
			jsonObj = new JSONObject(msg);
			professional=jsonObj.getString("professional");
			years = jsonObj.getString("years");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			return null;
		}
		/*System.out.println("进入到数据库查询类CourseDso");*/
		String SQL="select t2.* from t_courseclass t1,t_course t2,t_classname t3 "
				+ "where t1.classid=t3.cid and t1.cid=t2.cid  and "
				+ "t3.cname=:professional and year=:years";
		List<Course> courseList = new ArrayList<Course>();
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try {
			courseList=session.createSQLQuery(SQL).addEntity(Course.class)
					.setString("professional", professional)
					.setString("years", years)
					.list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		/*System.out.println("com.dao：数据库查询结束");*/
		return courseList;
	}
//根据学年查询教学计划
	@SuppressWarnings("unchecked")
	public List<Course> querybyYear(String years) {
		String SQL="select t1.* from t_course t1 where  t1.year=:years";
		List<Course> courseList = new ArrayList<Course>();
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			courseList=session.createSQLQuery(SQL).addEntity(Course.class).setString("years", years).list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return courseList;
	}

	@Override
	public List<Course> getPage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}
	//更新修改教学计划库
	public boolean update(List<Course> c) {// 更新学生信息
		Transaction tx = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < c.size(); i++) {
				session.update(c.get(i));
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				/*System.out.println("tx closs");*/
				tx = null;
			}
			HibernateSessionFactory.closeSession(session);
		}
	}
		
		
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getBySQL(String SQL) {
		int teacherId = Integer.parseInt(SQL.split(",")[0]);
		String yearsString = SQL.split(",")[1];
		SQL="select t1.cname as kcm,t3.cname as bjm,t3.englishname as bjmus,"
				+ "t1.cid as kcdm,t3.cid as bjdm "
				+ "from t_course t1,t_courseclass t2 ,t_classname t3 "
				+ "where t1.cid = t2.cid "
				+ "and t2.classid = t3.cid "
				+ "and t1.year = :year " 
				+ "and t1.tid=:teacherId";
		List<Object[]> resultList = new ArrayList<Object[]>();
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try {
			resultList=session.createSQLQuery(SQL).setString("year", yearsString).setInteger("teacherId", teacherId).list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		/*System.out.println("com.dao：数据库查询结束");*/
		return resultList;

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getByTeacherAndYears(String teacher,String years) {
		int teacherId = Integer.parseInt(teacher);
		String SQL="select t1.cname as kcm,t3.cname as bjm,t3.englishname as bjmus,t1.cid as kcdm,t3.cid as bjdm from t_course t1,t_courseclass t2 ,t_classname t3 "
				+ "where t1.cid = t2.cid and t2.classid = t3.cid and t1.tid=:teacherId and t1.year=:years";
		List<Object[]> resultList = new ArrayList<Object[]>();
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try {
			resultList=session.createSQLQuery(SQL).setInteger("teacherId", teacherId).setString("years", years).list();	
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		/*System.out.println("com.dao：数据库查询结束");*/
		return resultList;
	}
	@SuppressWarnings("rawtypes")
	public List createFile(String years){
		List data = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t1.cid, t1.cname as s2,t1.category,t1.credits,t1.time,t1.year,t1.beginTime,t1.endTime,t1.tid,t4.tname,t1.examFlag,t2.classid,t3.cname as s1,t1.courseNum "
				+ "from t_course t1,t_courseclass t2,t_classname t3,t_teacher t4 "
				+ "where t1.cid=t2.cid and t3.cid=t2.classid and t4.tid=t1.tid and t1.year=:years";
		try {
			data = new ArrayList<Object[]>();
			data = session.createSQLQuery(sql).setString("years", years).list();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return data;
	}
	
	public static void main(String[] args) {
		CourseDao cd = new CourseDao();
		/*List<Object[]> resultList = new ArrayList<Object[]>();
		String professional="计算机科学与技术2014-1";
		String status="在校";
		String msg="{'professional':'"+professional+"','status':'"+status+"'}";
		courseList=cd.query(msg);
		resultList = cd.getBySQL("123427"); 
		for(Object[] c:resultList){
			System.out.println(c[0]+"   "+c[1]);
			
		}*/
		List<Course> l=cd.querybyYear("2016-2017/2");
		System.out.println(l.size());
	}

}
