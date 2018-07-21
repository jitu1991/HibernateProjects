package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.Student;

public class Chapter7_PrimaryKeyID {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setName("Student5");
		
		Student student2 = new Student();
		student2.setName("Student6");

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}