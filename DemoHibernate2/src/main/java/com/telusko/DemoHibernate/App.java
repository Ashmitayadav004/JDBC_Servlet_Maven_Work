package com.telusko.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Alien telusko =null;
       
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
           telusko =(Alien) session.get(Alien.class,4);
            tx.commit();
        }

        sf.close();
        System.out.println(telusko);
    }
}
