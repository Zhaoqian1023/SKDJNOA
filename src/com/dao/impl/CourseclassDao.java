package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;

public class CourseclassDao implements Dao{

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addList(List<Object[]> data){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "insert into t_courseclass(classid,cid) values(:classid,:cid)";
		try {
			for(Object[] obj:data){
				session.createSQLQuery(SQL).setInteger("classid",Integer.parseInt(obj[0].toString())).setInteger("cid", Integer.parseInt(obj[1].toString())).executeUpdate();
			}
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		
	}
	public boolean updateList(List<Object[]> data){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "update t_courseclass set classid=:classid where cid = :cid";
		try {
			for(Object[] obj:data){
				session.createSQLQuery(SQL).setInteger("classid",Integer.parseInt(obj[0].toString())).setInteger("cid", Integer.parseInt(obj[1].toString())).executeUpdate();
			}
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
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteByCourseid(List<Object> courseId){

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "delete from t_courseclass where cid = :cid";
		try {
			for(Object obj:courseId){
				session.createSQLQuery(SQL).setInteger("cid",Integer.parseInt(obj.toString())).executeUpdate();
			}
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
	public Object get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
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

}
