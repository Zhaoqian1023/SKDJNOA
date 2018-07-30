package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.Management;


public class ManagerDao implements Dao {

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

	@Override
	public Object get(int id) {
		/*System.out.println("进入到数据库查询类ManagerDso");*/
		Management manager=null;
		String HQL = "from Management where mid=:mid";
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try{
			manager=(Management)session.createQuery(HQL).setInteger("mid", id).uniqueResult();
			
		}catch(Exception e){
			/*System.out.println("from Management where mid=? 失败！！");*/
			return null;
		}finally{
			
			HibernateSessionFactory.closeSession(session);
			/*System.out.println("com.dao：数据库查询结束");*/
		}
		return manager;
	}

	@Override
	public boolean update(Object obj) {
		Management manager = (Management)obj;
		int mid = manager.getMid();
		String passWord = manager.getPassWord();
		String HQL = "update Management set passWord=:passWord where mid=:mid";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
			session.createQuery(HQL).setString("passWord", passWord).setInteger("mid", mid).executeUpdate();
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
