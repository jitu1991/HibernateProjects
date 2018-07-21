package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.FourWheeler;
import com.test.hibernate.dto.TwoWheeler;
import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.Vehicle17;

public class Chapter22_TransientPersistentAndDetachedObjects {

	public static void main(String[] args) {
		UserDetails21 user = new UserDetails21();
		user.setUserName("Test User");

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		user.setUserName("Updated user");
		user.setUserName("Updated user again");
		
		session.getTransaction().commit();
		session.close();

		user.setUserName("Updated user after session close");
}
}