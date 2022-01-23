package com.product.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	
	private static SessionFactory sessionfactory;
	
	
	public static synchronized SessionFactory getSessionFactory() {
	    if ( sessionfactory == null ) {

	        // exception handling omitted for brevity

	    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml")
	                .build();

	        sessionfactory = new MetadataSources( serviceRegistry )
	                    .buildMetadata()
	                    .buildSessionFactory();
	    }
	    return sessionfactory;
	}

    public static SessionFactory sessionFactory() {
    	return getSessionFactory();
    }

}
