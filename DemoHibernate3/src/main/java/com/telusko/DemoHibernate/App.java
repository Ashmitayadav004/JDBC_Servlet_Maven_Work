package com.telusko.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	
    	AlienName an = new AlienName();
    	an.setFname("Ashmita");
    	an.setMname("Indra Bahadur");
    	an.setLname("Yadav");
    	

        Alien telusko =new Alien();
        telusko.setAid(14);
        telusko.setColor("Pink");
        telusko.setAname(an);
       
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
        session.persist(telusko);
           
            tx.commit();
        }

        sf.close();
        System.out.println("Successfully");
    }
}
