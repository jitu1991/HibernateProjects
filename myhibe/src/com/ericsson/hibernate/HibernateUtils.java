package com.ericsson.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private HibernateUtils() {
	}

	private static final SessionFactory sessionFactory;

	static {
		try {
			System.out.println("Get Factory");
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			System.out.println("Got Factory");
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {

		getSessionFactory().close();
	}
}
