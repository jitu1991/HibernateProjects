package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails14;
import com.test.hibernate.dto.Vehicle;
import com.test.hibernate.dto.Vehicle14;

public class Chapter14_OneToManyMapping {

	public static void main(String[] args) {

		UserDetails14 user = new UserDetails14();
		user.setUserName("ZZ");
		
		Vehicle14 vehicle1 = new Vehicle14();
		vehicle1.setVehicleName("car");
		Vehicle14 vehicle2 = new Vehicle14();
		vehicle2.setVehicleName("bike");

		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		//For many to one mapping
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		
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