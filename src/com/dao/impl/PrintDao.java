package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONException;
import org.json.JSONObject;

import com.dao.Dao;
import com.db.HibernateSessionFactory;


public class PrintDao implements Dao{
	
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
		return null;
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
		JSONObject jsonObj = null;
		int bjdm=0;
		int kcdm=0;
		String status="";
		try {
			jsonObj = new JSONObject(SQL);
			bjdm=Integer.parseInt(jsonObj.getString("bjdm"));
			kcdm=Integer.parseInt(jsonObj.getString("kcdm"));
			status=jsonObj.getString("status");
			/*System.out.println(jsonObj.toString());*/
		} catch (JSONException e) {
			return null;
		}
		/*System.out.println("进入到数据库查询类PrintDao");*/
		List<Object[]> list=null;
		String HQL="SELECT t2.category,t1.cid ,t1.cname as sd,t2.cname as df,t2.credits ,t4.englishname ,t4.sid ,t4.sname,t2.year,t1.englishname as en,t2.cid as wd,t2.examFlag "
				+ "FROM educationaloa.t_classname AS t1,educationaloa.t_course AS t2 ,educationaloa.t_courseclass AS t3 ,educationaloa.t_student AS t4 "
				+ "where t3.cid = t2.cid AND t3.classid=t1.cid and t4.classnameid=t1.cid and t1.cid=:bjdm AND t2.cid=:kcdm AND t4.status=:status";
		Session session = HibernateSessionFactory.getSession();
		/*System.out.println("获取session后，将要开启事务！！！！");*/
		session.beginTransaction();
		/*System.out.println("com.dao：数据库查询开始");*/
		try{
			list=session.createSQLQuery(HQL).setInteger("bjdm", bjdm).setInteger("kcdm", kcdm).setString("status", status).list();
		}catch(Exception e){
			/*System.out.println("查询数据库失败！！！！");*/
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
			/*System.out.println("com.dao：数据库查询结束");*/
		}
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getSelectBySQL(String SQL) {
		JSONObject jsonObj = null;
		int bjdm=0;
		int kcdm=0;
		String status="";
		try {
			jsonObj = new JSONObject(SQL);
			bjdm=Integer.parseInt(jsonObj.getString("bjdm"));
			kcdm=Integer.parseInt(jsonObj.getString("kcdm"));
			status=jsonObj.getString("status");
		} catch (JSONException e) {
			return null;
		}
		List<Object[]> list=null;
		String HQL="select t1.category,t4.cid,t4.cname,t1.pname,t1.credits,t3.englishname as en,t3.sid,t3.sname,t1.year,t4.englishname,t1.pid,t1.examFlag "
				+ "from educationaloa.t_publiccourse as t1,educationaloa.t_publicelective as t2,educationaloa.t_student as t3,educationaloa.t_classname as t4 "
				+ "where t1.pid = t2.pcid and t2.sid = t3.sid and t3.classnameid = t4.cid and t3.status = :status and  t1.pid=:kcdm and t4.cid = :bjdm";
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
			list=session.createSQLQuery(HQL).setInteger("bjdm", bjdm).setInteger("kcdm", kcdm).setString("status", status).list();
		}catch(Exception e){
			return null;
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return list;
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		String msg="{'bjm':'计算机科学与技术2014-1','kcm':'软件工程'}";
		JSONObject jsonObj;
		List<Object[]> list=new PrintDao().getBySQL(msg);
		for(Object[] obj : list){
			System.out.println(obj[10]+"dddd    ");
			
			System.out.println(obj.length);
			if(obj[9]==null){
				System.out.println("222222222");
			}
		}
		System.out.println(list.size());
		/*System.out.println(list.get(2));*/
	}

}
