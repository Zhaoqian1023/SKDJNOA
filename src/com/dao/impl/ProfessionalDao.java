package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Professional;

public class ProfessionalDao implements Dao{

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
//根据专业名字返回专业对象
	public Object get(String pname) {
		Professional professional = null;
		String HQL = "from Professional where pname=:pname";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			professional = (Professional) session.createQuery(HQL)
					.setString("pname", pname).uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return professional;
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
		// TODO Auto-generated method stub
		return null;
	}

}
