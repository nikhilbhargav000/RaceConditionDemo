package com.glaucus.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utilities class
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration config = new Configuration().configure("/com/glaucus/resource/Hibernate.cfg.xml");
		ServiceRegistry serviceRegistery = new ServiceRegistryBuilder()
				.applySettings(config.getProperties())
				.buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistery);
	}
	
	/**
	 * 
	 * @return : Session Factory static instance 
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
