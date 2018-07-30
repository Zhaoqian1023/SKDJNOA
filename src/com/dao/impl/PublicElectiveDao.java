/**  
 * @Title: PublicElectiveDao.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年10月14日
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.db.HibernateSessionFactory;

/**
 * ClassName: PublicElectiveDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年10月14日
 */
public class PublicElectiveDao {
	
	public boolean addList(List<Object[]> data){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "insert into t_publicelective(sid,pcid,year) values(:sid,:pcid,:year)";
		try {
			for(Object[] obj:data){
				session.createSQLQuery(SQL).setString("sid",obj[0].toString()).setInteger("pcid", Integer.parseInt(obj[1].toString())).setString("year", obj[2].toString())
				.executeUpdate();
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
	public boolean deleteByCourseId(int cid){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "delete from t_publicelective where pcid=:pcid";
		try {
			session.createSQLQuery(SQL).setInteger("pcid", cid).executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getElectiveStudentVOByCourseId(int courseId){
		List<Object[]> data = new ArrayList<Object[]>(); 
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String SQL = "select t1.sid,t1.sname,t2.pid,t2.pname,t4.cid,t4.cname,t2.year "
				+ "from t_student as t1,t_publiccourse as t2,t_publicelective as t3,t_classname as t4 "
				+ "where t1.sid = t3.sid and t2.pid = t3.pcid and t1.classnameid = t4.cid and t1.status = '在校' and t2.pid = :courseId";
		try {
			data=session.createSQLQuery(SQL).setInteger("courseId", courseId).list();
		} catch (Exception e) {
			return null;
		}finally{	
			HibernateSessionFactory.closeSession(session);
		}
		
		return data;
	}

}
