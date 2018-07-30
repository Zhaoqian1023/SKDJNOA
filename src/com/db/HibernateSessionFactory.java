package com.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateSessionFactory {
	private static Configuration cfg;
	private static ServiceRegistry sr;
	private static SessionFactory sf;
	
	
	public static Session getSession(){
		/*System.out.println("getSession");*/
		if(cfg==null){
			/*System.out.println("加载cfg");*/
			cfg = new Configuration().configure();
		}
		if(sr==null){
			/*System.out.println("注册cfg");*/
			sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		}
		if(sf==null){
			/*System.out.println("创建sessoinfactory");*/
		 sf = cfg.buildSessionFactory(sr);
		}
		/*System.out.println("获取session");*/
		Session session = sf.getCurrentSession();
		return session;
	}
	
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen()){
				session.close();
				session = null;
			}
		}
		/*System.out.println("session关闭");*/
	}

}







