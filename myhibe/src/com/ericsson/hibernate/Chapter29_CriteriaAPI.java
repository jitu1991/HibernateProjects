package com.ericsson.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.UserDetails28;

public class Chapter29_CriteriaAPI {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails28.class);
		//criteria.add(Restrictions.eq("userName", "User 5"));
		//criteria.add(Restrictions.gt("userId", 65540));
		//criteria.add(Restrictions.like("userName", "%User 4%"));
		//criteria.add(Restrictions.between("userId", 65540, 65544));
		
		criteria.add(Restrictions.or(Restrictions.between("userId", 65537, 65539), Restrictions.between("userId", 65542, 65544)));
		
		List<UserDetails28> users = (List<UserDetails28>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails28 user : users) {
			System.out.println(user.getUserName());
		}
	}
}