package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.FourWheeler;
import com.test.hibernate.dto.TwoWheeler;
import com.test.hibernate.dto.UserDetails21;
import com.test.hibernate.dto.Vehicle17;

public class Chapter21_CRUDOperations {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/* CREATE
		 * for(int i = 1; i <= 10; i++) {
			UserDetails21 user = new UserDetails21();
			user.setUserName("User "+i);
			session.save(user);
		}*/
		
		// READ
		/*UserDetails21 user = (UserDetails21) session.get(UserDetails21.class, 2);
		System.out.println("User Name -> "+user.getUserName());*/
		
		//UPDATE
		UserDetails21 user = (UserDetails21) session.get(UserDetails21.class, 6);
		user.setUserName("Update User 6");
		session.update(user);
		
		//DELETE
		//session.delete(user);
		
		session.getTransaction().commit();
		session.close();
	}
}