package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Teacher;

public class TeacherDao implements Dao{

	@Override
	public boolean add(Object obj) {
		Teacher tea = (Teacher) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(tea);
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
		Teacher tea = (Teacher) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.delete(tea);
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
		Teacher tea = null;
		String HQL = "from Teacher where tid=:tid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			tea = (Teacher) session.createQuery(HQL)
					.setInteger("tid", id).uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return tea;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getAll(){
		String sql = "select t1.tid,t1.tname,t1.position,t1.title,t2.dname "
				+ "from t_teacher as t1,t_department as t2 "
				+ "where t1.did = t2.did";
		List<Object[]> list = new ArrayList<Object[]>();
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			list=session.createSQLQuery(sql).list();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}

	@Override
	public boolean update(Object obj) {
		Teacher tea = (Teacher) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.update(tea);
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
		TeacherDao t=new TeacherDao();
		Teacher tea=(Teacher)t.get(199);
		System.out.println(tea.getTname());
	}

}
