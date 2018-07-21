package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.Student;

public class Chapter9_AttributeOverrides {

	public static void main(String[] args) {

		Student student = new Student();
		student.setName("Student10");
		
		Address address1 = new Address();
		address1.setCity("9 city");
		address1.setPinCode("9 pincode");
		address1.setState("9 state");
		address1.setStreet("9 street");
		
		Address address2 = new Address();
		address2.setCity("10 city");
		address2.setPinCode("10 pincode");
		address2.setState("10 state");
		address2.setStreet("10 street");

		//student.setHomeAddress(address1);
		//student.setOfficeAddress(address2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
}