package com.telusko.DemoHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		// ✅ Modern configuration (Hibernate 6.x and above)
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		// ✅ Correct way to create ServiceRegistry
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		// ✅ Build SessionFactory using the ServiceRegistry
		SessionFactory sf = config.buildSessionFactory(registry);

		// ✅ Open a session and begin transaction
		try (Session session = sf.openSession()) {
			int b = 60;
			Transaction tx = session.beginTransaction();
			
			
			 String sqlQuery = "SELECT * FROM student WHERE marks > 60";	          
	            NativeQuery<Student> query = session.createNativeQuery(sqlQuery, Student.class);
	            List<Student> students = query.list();


				for (Student s : students) {
				    System.out.println(s);
				}

			tx.commit();
		}

		sf.close();

	}
}
