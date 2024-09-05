package com.myproj.ConfigJava;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class HibernateSession {
	private static HibernateSession object;
	static Session sess;
	static SessionFactory fact = null;
	public static Session getSession() {
		if(fact==null) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		 fact=config.buildSessionFactory();
		
		}
		
		sess= fact.openSession();
		
		
		return sess;
	}
	public static  void closeSessionfact() {
		
		sess.close();
		//fact.close();
	}
}
	


