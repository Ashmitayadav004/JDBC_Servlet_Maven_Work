package com.telusko.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		Alien a = null;

		// ✅ Modern configuration (Hibernate 6.x and above)
		Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

		// ✅ Correct way to create ServiceRegistry
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		// ✅ Build SessionFactory using the ServiceRegistry
		SessionFactory sf = config.buildSessionFactory(registry);

		// ✅ Open a session and begin transaction
		try (Session session1 = sf.openSession()) {
			Transaction tx = session1.beginTransaction();

			a = (Alien) session1.get(Alien.class, 14);
			System.out.print(a);
			tx.commit();
			session1.close();
			
			try (Session session2 = sf.openSession()) {
				Transaction tx2 = session2.beginTransaction();

			a = (Alien) session2.get(Alien.class, 14);
			System.out.print(a);
			tx2.commit();
		}

		sf.close();

	}
	}
}