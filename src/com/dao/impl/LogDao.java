package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Log;

public class LogDao implements Dao {
	public boolean add(Log log) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(log);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		
	}

	@Override
	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> query(String hql) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		List<Log> logList = new ArrayList<Log>();
		try{
			logList = session.createQuery("from Log order by lid desc").setMaxResults(300).list();
		}catch(Exception e){
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return logList;
	}
	@SuppressWarnings("unchecked")
	public List<Log> getAll() {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		List<Log> logList = new ArrayList<Log>();
		try{
			logList = session.createQuery("from Log order by lid desc").list();
		}catch(Exception e){
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return logList;
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
		// TODO Auto-generated method stub
		return false;
	}

}
