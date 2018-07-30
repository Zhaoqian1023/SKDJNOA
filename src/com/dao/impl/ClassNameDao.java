package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.ClassName;


public class ClassNameDao implements Dao {

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
//根据cname返回班级对象
	public Object get(String cname) {
		ClassName classname = null;
		String HQL = "from ClassName where cname=:cname";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			classname = (ClassName) session.createQuery(HQL)
					.setString("cname", cname).uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return classname;
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

	@Override
	public Object get(int id) {
		String hql = "from ClassName where cid = :cid";
		ClassName className = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			className= (ClassName) session.createQuery(hql).setInteger("cid", id).uniqueResult();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return className;
	}

}
