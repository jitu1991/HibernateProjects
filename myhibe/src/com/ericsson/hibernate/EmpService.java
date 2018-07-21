package com.ericsson.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpService {
	public static void main(String[] args) {
		//saveEmp(1, "Fifth");
		 getEmp(105);

	}

	private static void getEmp(int id) {
		Employee emp;
		try {
			Session session = HibernateUtils.getSessionFactory().openSession();
			emp = (Employee) session.get(Employee.class, id);
			System.out.println(emp.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void saveEmp(int id, String name) {
		Employee emp;
		try {
			Session session = HibernateUtils.getSessionFactory().openSession();
			emp = new Employee();
			//emp.setId(id);
			emp.setName(name);
			Transaction tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			System.out.println("saved");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
