package com.vishal.empmgmt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.vishal.empmgmt.model.Employee;

public class RestrictoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure("com/vishal/libmgmt/resource/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(Employee.class);


		Criterion sal = Restrictions.gt("salary", 4000);
		c.add(sal);
		List<Employee> emps = c.list();

		session.getTransaction().commit();
		for (Employee employee : emps) {
			System.out.println(employee);
		}

	}

}
