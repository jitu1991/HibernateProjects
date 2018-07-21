package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.dto.Student;
import com.test.hibernate.dto.UserDetails10;

public class Chapter10_SavingCollections {

	public static void main(String[] args) {
		
		UserDetails10 user = new UserDetails10();
		user.setUserName("YY");
		Address addr1 = new Address();
		addr1.setCity("10 city");
		addr1.setPinCode("23323");
		addr1.setState("10 state"); 
		addr1.setStreet("10 street");
		
		Address addr2 = new Address();
		addr2.setCity("11 city 1");
		addr2.setPinCode("2332 1");
		addr2.setState("11 state 1");
		addr2.setStreet("11 street 1");
		
		user.getListOfAddress().add(addr1);
		user.getListOfAddress().add(addr2);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}