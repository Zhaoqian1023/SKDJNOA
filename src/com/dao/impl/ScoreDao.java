package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.ScoreManagement;

public class ScoreDao implements Dao {
//成绩录入
	public boolean addAll(List<ScoreManagement> scm) {
		Transaction tx = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < scm.size(); i++) {
				session.save(scm.get(i));
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
	//更新成绩
	public boolean update(List<ScoreManagement> scm) {// 更新学生信息
		Transaction tx = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < scm.size(); i++) {
				session.update(scm.get(i));
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
	
	/*
	//补考成绩录入
public boolean bkcjInput(List<ScoreManagement> scm){
	Transaction tx = null;
	Session session = HibernateSessionFactory.getSession();
	try {
		tx = session.beginTransaction();
		for (int i = 0; i < scm.size(); i++) {
			session.update(scm.get(i));
		}
		tx.commit();
		return true;
	} catch (Exception e) {
		tx.rollback();
		e.printStackTrace();
		return false;
	} finally {
		if (tx != null) {
			System.out.println("tx closs");
			tx = null;
		}
		HibernateSessionFactory.closeSession(session);
	}

}
*/
	@Override
	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	//该方法判断成绩是否已录入
	@SuppressWarnings("unchecked")
	public List<ScoreManagement> get(String bjm, String kcm,String years) {

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t.* from t_scoremanagement t where t.year=:years and t.className=:bjm and t.coursename=:kcm";
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();
		try {
			sm = session.createSQLQuery(sql).addEntity(ScoreManagement.class).setString("years", years).setString("bjm", bjm).setString("kcm", kcm)
					.list();
		} catch (Exception e) {
			return null;
		} finally {

			HibernateSessionFactory.closeSession(session);
		}
		return sm;
	}
	//该方法判断公选课成绩是否已录入
	@SuppressWarnings("unchecked")
	public List<ScoreManagement> get(String kcm,String years) {

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t.* from t_scoremanagement t where t.year=:years and t.coursename=:kcm";
		List<ScoreManagement> sm = new ArrayList<ScoreManagement>();
		try {
			sm = session.createSQLQuery(sql).addEntity(ScoreManagement.class).setString("years", years).setString("kcm", kcm)
					.list();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return sm;
	}
	//查询VO对象
	@SuppressWarnings("rawtypes")
	public List getVO(int kcdm,String years) {

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t.className,t.coursename,t.classId,t.courseId "
				+ "from educationaloa.t_scoremanagement t "
				+ "where t.year=:years and t.courseId = :kcdm "
				+ "group by t.classId,t.className,t.coursename,t.courseId ";
		List sm = new ArrayList();
		try {
			sm = session.createSQLQuery(sql).setString("years", years).setInteger("kcdm", kcdm).list();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return sm;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// 返回已录入课程成绩

	@SuppressWarnings("unchecked")
	public List<ScoreManagement> query(String SQL) {
		JSONObject jsonObj = null;
		int bjdm = 0;
		int kcdm = 0;
		String years = "";
		try {
			jsonObj = new JSONObject(SQL);
			bjdm = Integer.parseInt(jsonObj.getString("bjdm"));
			kcdm = Integer.parseInt(jsonObj.getString("kcdm"));
			years = jsonObj.getString("years");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			return null;
		}
		List<ScoreManagement> list = null;
		String HQL = "select t.* from t_scoremanagement t where t.year=:years and t.classId=:bjdm and t.courseId=:kcdm";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list = session.createSQLQuery(HQL).addEntity(ScoreManagement.class).setString("years", years).setInteger("bjdm", bjdm).setInteger("kcdm", kcdm)
					.list();

		} catch (Exception e) {
			return null;
		} finally {

			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<ScoreManagement> queryForCourse(String SQL) {
		JSONObject jsonObj = null;
		int kcdm = 0;
		String years = "";
		try {
			jsonObj = new JSONObject(SQL);
			kcdm = Integer.parseInt(jsonObj.getString("kcdm"));
			years = jsonObj.getString("years");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			return null;
		}
		List<ScoreManagement> list = null;
		String HQL = "select t.* from t_scoremanagement t where t.year=:years and t.courseId=:kcdm group by smid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list = session.createSQLQuery(HQL).addEntity(ScoreManagement.class).setString("years", years).setInteger("kcdm", kcdm)
					.list();

		} catch (Exception e) {
			return null;
		} finally {

			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	
//根据学号和学期查询学生成绩
	@SuppressWarnings("unchecked")
	public List<ScoreManagement> querySh(String SQL) {
		JSONObject jsonObj = null;
		String sid = "";
		
		try {
			jsonObj = new JSONObject(SQL);
			sid = jsonObj.getString("sid");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<ScoreManagement> list = null;
		String HQL = "select t.* from t_scoremanagement t where  t.studentId=:sid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list = session.createSQLQuery(HQL).addEntity(ScoreManagement.class).setString("sid", sid)
					.list();

		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	//下载成绩库（新增课程编码，院系，身份证号）
	@SuppressWarnings("unchecked")
	public List<Object[]> createFile(String years) {
		List<Object[]> list = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String sql = "select t1.*,t2.number,t3.dname,t4.courseNum "
				+ "from t_scoremanagement t1,t_student t2,t_department t3,t_course t4 "
				+ "where t1.studentId = t2.sid and t2.colleagesid = t3.did "
				+ "and t1.courseId = t4.cid and t1.category = t4.category "
				+ "and t1.year=:years";
		String newSql = "select t1.*,t2.number,t3.dname,t4.courseNum "
				+ "from t_scoremanagement t1,t_student t2,t_department t3,t_publiccourse t4 "
				+ "where t1.studentId = t2.sid and t2.colleagesid = t3.did "
				+ "and t1.courseId = t4.pid and t1.category = t4.category "
				+ "and t1.year=:years";
		try {
			list = new ArrayList<Object[]>();
			list = session.createSQLQuery(sql).setString("years", years).list();
			List<Object[]> newList = new ArrayList<Object[]>();
			newList = session.createSQLQuery(newSql).setString("years", years).list();
			list.addAll(newList);
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	
//删除成绩
	public boolean delelte(String json) {
		JSONObject jsonObj = null;
		int bjdm = 0;
		int kcdm = 0;
		try {
			jsonObj = new JSONObject(json);
			bjdm = Integer.parseInt(jsonObj.getString("bjdm"));
			kcdm = Integer.parseInt(jsonObj.getString("kcdm"));
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return false;
		}
		String HQL = "delete ScoreManagement s where s.classId =:bjdm and s.courseId=:kcdm";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			int deletedEntities = session.createQuery(HQL).setInteger("bjdm", bjdm).setInteger("kcdm", kcdm).executeUpdate();
			session.getTransaction().commit();
			if (deletedEntities > 0) {
				return true;
			}
		} catch (Exception e) {
			/*System.out.println("失败！！！");*/
			session.getTransaction().rollback();

		} finally {

			HibernateSessionFactory.closeSession(session);
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getBySQL(String SQL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object obj) {
		return false;

	}

	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) {
		ScoreDao sc = new ScoreDao();
		/*
		 * String s = "{\"bjm\":\"计算机科学与技术2014-1\",\"kcm\":\"IPhone移动技术基础\"}";
		 * System.out.println(sc.delelte(s));
		 */
		/*String url = "E:/123qw.xls";*/
		/*
		 * if(sc.createFile(url)){ System.out.println("成功！！"); }else{
		 * System.out.println("失败！！"); }
		 */
		/*
		 * String path="D:\\Program Files\\Tomcat7\\";
		 * System.out.println(path.replaceAll("\\", "/"));
		 */
		String s = "{\"xh\":\"201403204214\",\"years\":\"2016-2017/1\"}";
		List<ScoreManagement> list = sc.querySh(s);
		for (ScoreManagement sct : list) {
			System.out.println(sct.getStudentName()+sct.getFinalGrade());
		}

	}
}
