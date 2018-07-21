package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.UserDetails16;
import com.test.hibernate.dto.Vehicle16;

public class Chapter16_CascadeTypeEtc {

	public static void main(String[] args) {

		UserDetails16 user = new UserDetails16();
		user.setUserName("First User");
		
		Vehicle16 vehicle1 = new Vehicle16();
		vehicle1.setVehicleName("car");
		Vehicle16 vehicle2 = new Vehicle16();
		vehicle2.setVehicleName("bike");

		user.getListOfVehicles().add(vehicle1);
		user.getListOfVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
}