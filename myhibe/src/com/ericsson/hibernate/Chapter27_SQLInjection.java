package com.ericsson.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails21;

public class Chapter27_SQLInjection {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		String minUserId = "32771";
		String userName = "User 9";
		
		/*Query query = session.createQuery("from UserDetails21 where userId > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, userName);*/
		
		//Another way without index
		Query query = session.createQuery("from UserDetails21 where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		
		List<UserDetails21> users = (List<UserDetails21>) query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails21 user : users) {
			System.out.println(user.getUserName());
		}
	}
}