package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.hibernate.dto.FourWheeler;
import com.test.hibernate.dto.TwoWheeler;
import com.test.hibernate.dto.Vehicle17;

public class Chapter17_Inheritence {

	public static void main(String[] args) {

		Vehicle17 vehicle = new Vehicle17();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("BMW");
		car.setSteeringWheel("BMW Steering wheel");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}
}