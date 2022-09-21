package com.vishal.empmgmt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vishal.empmgmt.model.Employee;

public class GetAllEmps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure("com/vishal/libmgmt/resource/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Employee.class);
		List<Employee> emps = c.list();

		session.getTransaction().commit();
		for (Employee employee : emps) {
			System.out.println(employee);
		}

	}

}
