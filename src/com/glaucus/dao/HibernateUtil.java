package com.glaucus.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration config = new Configuration().configure("/com/glaucus/resource/Hibernate.cfg.xml");
		ServiceRegistry serviceRegistery = new ServiceRegistryBuilder()
				.applySettings(config.getProperties())
				.buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistery);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
