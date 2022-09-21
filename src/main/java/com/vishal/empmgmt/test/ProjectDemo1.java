package com.vishal.empmgmt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.vishal.empmgmt.model.Employee;

public class ProjectDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure("com/vishal/libmgmt/resource/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Employee.class);

		Projection name = Projections.property("name");
		Projection sal = Projections.property("salary");
		ProjectionList pl = Projections.projectionList();
		pl.add(name);
		pl.add(sal);

		c.setProjection(pl);
		List<Object[]> list = c.list();
		for (Object[] object : list) {
			System.out.println(object[0] + "\t" + object[1]);
		}

	}

}
