package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Users;

public class UsersDao implements Dao {

	@Override
	public boolean add(Object obj) {
		Users user = (Users)obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.save(user);
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
		Users user = (Users) obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			session.delete(user);
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
		Users users=null;
		String HQL = "from Users where uid=:uid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
			users=(Users)session.createQuery(HQL).setInteger("uid", id).uniqueResult();
			
		}catch(Exception e){
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return users;
	}

	@Override
	public boolean update(Object obj) {
		Users users=(Users)obj;
		int uid=users.getUid();
		String HQL = "update Users set passWord=:passWord where uid=:uid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
			session.createQuery(HQL).setString("passWord", users.getPassWord()).setInteger("uid", uid).executeUpdate();
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}finally{
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
	


}
