package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Student;

public class StudentDao implements Dao {

	@Override
	public boolean add(Object obj) {
		Student stu = (Student) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(stu);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		
	}

	@Override
	public boolean del(Object obj) {
		Student stu = (Student) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.delete(stu);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	public Student get(String id) {// 根据学生id返回学生对象
		Student stu = null;
		String HQL = "from Student where sid=:sid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			stu = (Student) session.createQuery(HQL)
					.setString("sid", id).uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return stu;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getStudentByBJAndZT(String nj,String zt){
		List<Object[]> data = new ArrayList<Object[]>();
		String sql = "select t1.sid,t1.sname,t1.englishname,t1.sex,t1.number,t1.political,t1.national,t1.amissionTime,t1.graduationTime,t1.classnameid,t2.cname as ts,t1.professionsid,t3.pname,t1.colleagesid,t4.cname,t1.note,t1.status "
				+ "from t_student t1,t_classname t2,t_professional t3,t_colleage t4 "
				+ "where t1.classnameid=t2.cid and t1.professionsid=t3.pid and t1.colleagesid=t4.cid and t1.classnameid like :nj and t1.status=:status";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			data =  session.createSQLQuery(sql).setString("nj", nj+"%").setString("status", zt).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return data; 
	}

	@Override
	public boolean update(Object obj) {// 更新学生信息
		Student stu = (Student) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.update(stu);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List query(String hql) {
		// TODO Auto-generated method stub
		return null;
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
	public static void main(String args[]){
		/*StudentDao s=new StudentDao();*/
		//Student stu=s.get("201403204214");
		//System.out.println(stu.getSname()+stu.getAmissionTime());
		//System.out.println(stu.getClassName().getCname());//修改了映射文件
		
		//stu.setNote("wewe1");
		//if(	s.update(stu)){
		//	System.out.println("111");
		//}
		
	}
	
	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
