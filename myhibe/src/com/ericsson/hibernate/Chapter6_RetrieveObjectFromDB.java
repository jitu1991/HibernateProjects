package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.Student;

public class Chapter6_RetrieveObjectFromDB {

	public static void main(String[] args) {

		Student student = new Student();
		student.setId(4);
		student.setName("Student4");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		student = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		student = (Student) session.get(Student.class, 2);
		System.out.println(student.getName());
	}
}