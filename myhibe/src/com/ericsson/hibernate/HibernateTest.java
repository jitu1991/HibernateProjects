package com.ericsson.hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.test.hibernate.dto.FourWheeler;
import com.test.hibernate.dto.TwoWheeler;
import com.test.hibernate.dto.UserDetails;
import com.test.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		/**********************     Upto Tutorial 12     ************************/
		/*UserDetails user1 = new UserDetails();

		Address homeAddress = new Address();
		Address officeAddress = new Address();

		homeAddress.setCity("Home City");
		homeAddress.setStreet("Home Street");
		homeAddress.setState("Home State");
		homeAddress.setPinCode("11111");

		officeAddress.setCity("Office City");
		officeAddress.setStreet("Office Street");
		officeAddress.setState("Office State");
		officeAddress.setPinCode("22222");
		
		user1.setUserId(1);
		user1.setUserName("User1");
		user1.getListOfAddresses().add(homeAddress);
		user1.getListOfAddresses().add(officeAddress);
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		user1 = null;
		session = sessionFactory.openSession();
		user1 = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user1.getListOfAddresses().size());*/

		/*user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 7);
		System.out.println(user.getUserName());*/
		
		/*****************     Tutorial 13    ******************/
		
		UserDetails user1 = new UserDetails();
		//user1.setUserId(1);
		user1.setUserName("User1");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		user1.setVehicle(vehicle);
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		/*****************     Tutorial 14    ******************/
		
		/*UserDetails user1 = new UserDetails();
		//user1.setUserId(1);
		user1.setUserName("User1");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		vehicle1.setUser(user1);
		vehicle2.setUser(user1);
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
		
		/*****************     Tutorial 15    ******************/
		
		/*UserDetails user1 = new UserDetails();
		user1.setUserName("User1");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		
		vehicle1.getUserList().add(user1);
		vehicle2.getUserList().add(user1);
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
		/*****************     Tutorial 16    ******************/
		
		/*UserDetails user1 = new UserDetails();
		user1.setUserName("User1");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.persist(user1);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
		/*****************     Tutorial 17 & 18    ******************/
		
		/*Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		TwoWheeler cycle = new TwoWheeler();
		cycle.setVehicleName("Cycle");
		cycle.setSteeringHandle("Cycle Steering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porssche Steering Wheel");
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(cycle);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
/*****************     Tutorial 19    ******************/
		
		/*Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porssche Steering Wheel");
		
		System.out.println("Getting session factory");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
/*****************     Tutorial 21    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		//UserDetails user = (UserDetails) session.get(UserDetails.class, 2);

		//Update
		//user.setUserName("Updated User");
		//session.update(user);
		
		//Delete from table
		//session.delete(user);
		
		//Entering values in Table
		for(int i = 1; i <= 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();

		//Reading from table
		//System.out.println("User name is "+user.getUserName());
		System.out.println("Transaction Completed");*/
		
/*****************     Tutorial 22    ******************/
		
		/*UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		session.save(user);
		user.setUserName("Updated User");
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");*/
		
/*****************     Tutorial 24    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		//user.setUserName("Updated User name after session close");
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		user.setUserName("Updated User name after update");
		
		session.getTransaction().commit();
		session.close();		
		System.out.println("Transaction Completed");*/
		
/*****************     Tutorial 25 HQL    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		Query query = session.createQuery("from UserDetails where userId > 5");
		List users = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		System.out.println(users.size());*/
		
/*****************     Tutorial 26 HQL    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(3);
		query.setMaxResults(4);
		List<String> users = (List<String>)query.list();
		
		Query query = session.createQuery("select userId from UserDetails");
		Query query = session.createQuery("select userName from UserDetails");
		Query query = session.createQuery("select min(userId) from UserDetails");
		Query query = session.createQuery("select new map(userId, userName) from UserDetails");
		
		List<Integer> users = (List<Integer>)query.list();
		List<String> users = (List<String>)query.list();
		List<Map<Integer, String>> users = (List<Map<Integer, String>>)query.list();
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		for(String usr : users) {
			System.out.println(usr);
		}
		
		for(Integer usr : users) {
			System.out.println(usr);
		}
		
		for(Map<Integer, String> userMap : users) {
			System.out.println(userMap);
			
			Iterator<Map.Entry<Integer, String>> itr = userMap.entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry<Integer, String> map = itr.next();
				System.out.println("Key: "+map.getKey().toString()+"& Value is: "+map.getValue());
			}
			
			for (Map.Entry<Integer, String> pair : userMap.entrySet()) {
				System.out.println("Key: " + pair.getKey().toString()
						+ "& Value is: " + pair.getValue());
			}
		}*/
		
/*****************     Tutorial 27 HQL    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		int minUser = 5;
		Query query = session.createQuery("from UserDetails where userId > "+minUser);
		
		String minUser = "5";
		String userName = "User 10";
		Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUser));
		query.setString(1, userName);
		
		int minUser = 5;
		String userName = "User 10";
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
		query.setInteger("userId", minUser);
		query.setString("userName", userName);
		
		List<UserDetails> users = (List<UserDetails>)query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		for(UserDetails usr : users) {
			System.out.println(usr.getUserName());
		}*/
		
/*****************     Tutorial 28 NamedQueries    ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 2);
		
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User 3");
		
		List<UserDetails> users = (List<UserDetails>)query.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		for(UserDetails usr : users) {
			System.out.println(usr.getUserName());
		}*/
		
/*****************     Tutorial 29 Criteria API     ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User 10"));
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.like("userName", "%User 1%"))
				.add(Restrictions.between("userId", 5, 50));
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.between("userId", 1, 5), Restrictions.between("userId", 7, 10)));
		
		List<UserDetails> users = (List<UserDetails>)criteria.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		for(UserDetails usr : users) {
			System.out.println(usr.getUserName());
		}*/
		
/*****************     Tutorial 31 Projections     ******************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class)
									.setProjection(Projections.max("userId"))
									.addOrder(Order.asc("userId"));
									
		Criteria criteria = session.createCriteria(UserDetails.class)
				.addOrder(Order.asc("userId"));
				
		List<UserDetails> users = (List<UserDetails>)criteria.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");
		
		for(UserDetails usr : users) {
			System.out.println(usr.getUserName());
		}*/
		
		/**************    Query By Example     ****************/
		
		/*UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User 1%");
		
		Example example = Example.create(exampleUser).enableLike();
		//Example example = Example.create(exampleUser).excludeProperty("userName");
		
		Criteria criteria = session.createCriteria(UserDetails.class)
							.add(example);
		
		List<UserDetails> users = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("Transaction Completed");

		for (UserDetails usr : users) {
			System.out.println(usr.getUserName());
		}*/
		
/**************    Tutorial 32 - Cacheing     ****************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated User");
		
		//UserDetails user1 = (UserDetails) session1.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session1 = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session1.beginTransaction();
		
		UserDetails user1 = (UserDetails) session1.get(UserDetails.class, 1);
		session1.getTransaction().commit();
		session1.close();
		System.out.println("Transaction Completed");*/
		
/**************    Tutorial 33 - Second level Cacheing     ****************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session1 = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session1.beginTransaction();
		
		UserDetails user1 = (UserDetails) session1.get(UserDetails.class, 1);
		session1.getTransaction().commit();
		session1.close();
		System.out.println("Transaction Completed");*/
		
/**************    Tutorial 34 - Using Query Cache     ****************/
		
		/*SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Got session factory");
		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails user where user.userId = 1");
		query.setCacheable(true);
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session1 = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session1.beginTransaction();
		
		Query query1 = session1.createQuery("from UserDetails user where user.userId = 1");
		query1.setCacheable(true);
		List users1 = query1.list();

		session1.getTransaction().commit();
		session1.close();
		System.out.println("Transaction Completed");*/
	}
}