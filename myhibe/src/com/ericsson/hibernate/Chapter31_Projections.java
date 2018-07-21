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

public class Chapter31_Projections {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails28 exampleUser = new UserDetails28();
		//exampleUser.setUserId(65544);
		exampleUser.setUserName("User 5");

		Example example = Example.create(exampleUser);
		//Example example = Example.create(exampleUser).enableLike();
		//Example example = Example.create(exampleUser).excludeProperty("userName");
		
		Criteria criteria = session.createCriteria(UserDetails28.class)
				.add(example)
				//.setProjection(Projections.max("userId"))
				//.setProjection(Projections.count("userId"))
				//.addOrder(Order.desc("userId"))
				//.setProjection(Projections.property("userId"))
				;
		
		List<UserDetails28> users = (List<UserDetails28>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails28 user : users) {
			System.out.println(user.getUserName());
		}
	}
}