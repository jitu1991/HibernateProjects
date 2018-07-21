package com.ericsson.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails21;

public class Chapter26_HQLSelectAndPagination {

	public static void main(String[] args) {
		


		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select userName from UserDetails21");
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> users = (List<String>) query.list();//userName is of type String, So result would be list of Strings
		
		Query mapQuery = session.createQuery("select new map(userId, userName) from UserDetails21");
		List<Map> usersInMap = (List<Map>) mapQuery.list();
		
		session.getTransaction().commit();
		session.close();
		for(String user : users) {
			//System.out.println(user);
		}
		
		for(Map m: usersInMap) {
			System.out.println(m);
		}
	}
}