package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails13;
import com.test.hibernate.dto.Vehicle;
import com.test.hibernate.dto.Vehicle13;

public class Chapter13_OneToOneMapping {

	public static void main(String[] args) {

		UserDetails13 user = new UserDetails13();
		user.setUserName("ZZ");
		
		Vehicle13 vehicle = new Vehicle13();
		vehicle.setVehicleName("car");
		user.setVehicle(vehicle);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
}