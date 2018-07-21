package com.ericsson.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.UserDetails28;

public class Chapter28_NamedQueries {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
//		Query query = session.getNamedQuery("UserDetails28.byId");
//		query.setInteger(0, 65536);
//		List<UserDetails28> users = (List<UserDetails28>) query.list();

		Query query = session.getNamedQuery("UserDetails28.byName");
		query.setString(0, "User 1");
		List<UserDetails28> users = (List<UserDetails28>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails28 user : users) {
			System.out.println(user.getUserName());
		}
	}
}