package com.myproj.ConfigJava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class HibernateSession {
	private static HibernateSession object;
	static Session sess;
	
	public static Session getSession() {
		SessionFactory fact = null;
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		 fact=config.buildSessionFactory();
		
		if(sess==null  ) {
		
		sess= fact.openSession();
		}
		else{
			sess= fact.getCurrentSession();
		}
		return sess;
	}
}
	


