package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.FourWheeler;
import com.test.hibernate.dto.TwoWheeler;
import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.Vehicle17;

public class Chapter24_DetachedToPersistent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails21 user = (UserDetails21) session.get(UserDetails21.class, 1);
		
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		//user.setUserName("Test User after session close");
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}