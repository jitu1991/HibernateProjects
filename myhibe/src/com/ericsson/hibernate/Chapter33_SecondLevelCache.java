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

public class Chapter33_SecondLevelCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails28 user = (UserDetails28) session.get(UserDetails28.class, 65544);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails28 user2 = (UserDetails28) session.get(UserDetails28.class, 65544);		
		
		session.getTransaction().commit();
		session.close();

	}
}