package com.ericsson.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails21;

public class Chapter24_HQLQueries {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		/*for (int i = 1; i <= 10; i++) {
			UserDetails21 user = new UserDetails21();
			user.setUserName("User " + i);
			session.save(user);
		}*/
		
		/*Query query = session.createQuery("from UserDetails21 where userId > 32770");
		List users = query.list();*/
		
		Query query = session.createQuery("from UserDetails21");
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails21> users = (List<UserDetails21>) query.list();
		
		session.getTransaction().commit();
		session.close();
		for(UserDetails21 user : users) {
			System.out.println(user.getUserName());
		}
	}
}