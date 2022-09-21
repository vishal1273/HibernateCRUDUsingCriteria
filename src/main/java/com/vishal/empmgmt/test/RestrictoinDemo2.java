package com.vishal.empmgmt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.vishal.empmgmt.model.Book;

public class RestrictoinDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure("com/vishal/libmgmt/resource/hibernate.cfg.xml")
				.addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(Book.class);

		Criterion category = Restrictions.eq("category","Java");
		Criterion title = Restrictions.eq("title","Head First Java");
		Criterion combine = Restrictions.and(category,title);
		c.add(combine);
		List<Book> books = c.list();
		for (Book book : books) {
			System.out.println(book);
		}
		session.getTransaction().commit();
	}

}
