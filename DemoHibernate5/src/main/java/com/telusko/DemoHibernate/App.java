package com.telusko.DemoHibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
			Transaction tx = session.beginTransaction();
			System.out.println("Data fetch successfully!");
			
			Student s1 = session.get(Student.class, 1);
			
			System.out.println(s1.getName());
			
			//for lazyy
			
//			Collection<Laptop> laps = s1.getLaptop();
//			for(Laptop l : laps) {
//				System.out.println(l);
//			}
			tx.commit();
		}

		sf.close();

	}
}
