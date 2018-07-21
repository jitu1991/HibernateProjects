package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.Student;

public class Chapter8_EmbeddedObjects {

	public static void main(String[] args) {

		Student student = new Student();
		student.setName("Student9");
		
		Address address = new Address();
		address.setCity("9 city");
		address.setPinCode("9 pincode");
		address.setState("9 state");
		address.setStreet("9 street");
		
		//student.setAddress(address);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
}