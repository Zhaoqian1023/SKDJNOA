package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.Dao;
import com.db.HibernateSessionFactory;
import com.po.SaveTemp;

public class SaveTempDao implements Dao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean add(Object obj) {
		List<SaveTemp> listData = (List)obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try {
			for(SaveTemp st:listData){
				session.save(st);
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

	@SuppressWarnings("unused")
	@Override
	public boolean del(Object obj) {
		SaveTemp data = (SaveTemp)obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String hql = "delete SaveTemp where classId = :classId and courseId = :courseId";
		try {
			int deleteEntities = session.createQuery(hql)
				      .setString("classId",data.getClassId())
				      .setString("courseId", data.getCourseId())
				      .executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
	
	@SuppressWarnings("unused")
	public boolean delGX(Object obj) {
		SaveTemp data = (SaveTemp)obj;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String hql = "delete SaveTemp where courseId = :courseId";
		try {
			int deleteEntities = session.createQuery(hql)
				      .setString("courseId", data.getCourseId())
				      .executeUpdate();
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
		return null;
	}

	@Override
	public boolean update(Object obj) {
		
		
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List query(String hql) {
		List<SaveTemp> listData = null;
		String[] data = hql.split(",");
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String HQL = "from SaveTemp where classId = :classId and courseId = :courseId and flag = :flag";
		try{
			listData=session.createQuery(HQL).setString("classId", data[0])
					.setString("courseId", data[1])
					.setString("flag", data[2])
					.list();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			
			HibernateSessionFactory.closeSession(session);
		}
		return listData;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getBySQL(String SQL) {
		List<SaveTemp> listData = null;
		String[] data = SQL.split(",");
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String HQL = "from SaveTemp where courseId = :courseId and flag = :flag";
		try{
			listData=session.createQuery(HQL).setString("courseId", data[0])
					.setString("flag", data[1])
					.list();
			
		}catch(Exception e){
			return null;
		}finally{
			
			HibernateSessionFactory.closeSession(session);
		}
		return listData;
	}
	public static void main(String[] args) {
		SaveTemp data = new SaveTemp();
		data.setClassName("电气工程及其自动化2015-2");
		data.setCourseName("工程数学");
		//String temp = "电气工程及其自动化2015-2,工程数学";
		SaveTempDao sdao = new SaveTempDao();
		sdao.del(data);
		/*List<SaveTemp> list = sdao.query(temp);
		for(SaveTemp st:list){
			System.out.println(st.getStudentName());
		}*/
	}
	


}
