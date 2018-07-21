package com.ericsson.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.UserDetails28;

public class Chapter34_QueryCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails28 user where user.userId=65544");
		query.setCacheable(true);
		
		List userList = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query2 = session.createQuery("from UserDetails28 user where user.userId=65544");
		query2.setCacheable(true);

		List userList2 = query2.list();
		
		session.getTransaction().commit();
		session.close();

	}
}