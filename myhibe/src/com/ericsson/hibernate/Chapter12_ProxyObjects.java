package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.Student;
import com.test.hibernate.dto.UserDetails10;
import com.test.hibernate.dto.UserDetails12;

public class Chapter12_ProxyObjects {

	public static void main(String[] args) {

		UserDetails12 user = new UserDetails12();
		user.setUserName("YY");
		Address addr1 = new Address();
		addr1.setCity("10 city");
		addr1.setPinCode("23323");
		addr1.setState("10 state"); 
		addr1.setStreet("10 street");
		
		Address addr2 = new Address();
		addr2.setCity("12 city 1");
		addr2.setPinCode("2332 1");
		addr2.setState("12 state 1");
		addr2.setStreet("12 street 1");
		
		user.getListOfAddress().add(addr1);
		user.getListOfAddress().add(addr2);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails12) session.get(UserDetails12.class, 655360);
		session.close(); //Gives exception org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role
		System.out.println(user.getListOfAddress().size());
		//session.close();
	}
}