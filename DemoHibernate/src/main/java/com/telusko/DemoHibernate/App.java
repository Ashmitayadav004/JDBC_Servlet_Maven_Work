package com.telusko.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Alien telusko = new Alien();
        telusko.setAid(12);
        telusko.setColor("Yelloww");
        telusko.setName("Chiktoo");

        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(telusko); // ✅ Replaces session.save() in Hibernate 7
            tx.commit();
        }

        sf.close();
        System.out.println("Alien saved successfully!");
    }
}
