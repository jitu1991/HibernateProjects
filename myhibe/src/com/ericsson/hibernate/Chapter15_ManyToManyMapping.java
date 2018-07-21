package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails15;
import com.test.hibernate.dto.Vehicle15;

public class Chapter15_ManyToManyMapping {

	public static void main(String[] args) {

		UserDetails15 user = new UserDetails15();
		user.setUserName("abc");
		
		Vehicle15 vehicle1 = new Vehicle15();
		vehicle1.setVehicleName("car");
		Vehicle15 vehicle2 = new Vehicle15();
		vehicle2.setVehicleName("bike");

		user.getListOfVehicles().add(vehicle1);
		user.getListOfVehicles().add(vehicle2);
		
		vehicle1.getUserList().add(user);
		vehicle2.getUserList().add(user);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}