package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Department;

public class DepartmentDao implements Dao {

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
//根据单位名返回对象
	public Object get(String dname) {
		Department department = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			department = (Department) session.createQuery("from Department where dname=:dname")
					.setString("dname", dname).uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return department;
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
