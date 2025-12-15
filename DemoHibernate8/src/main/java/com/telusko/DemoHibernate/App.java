package com.telusko.DemoHibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {

//        Laptop laptop = new Laptop();
//        laptop.setLid(101);
//        laptop.setLname("Dell");
//        
//        Student s = new Student();
//        s.setName("Ashmita");
//        s.setRollno(1);
//        s.setMarks(50);
//        s.getLaptop().add(laptop);
//        laptop.getStudent().add(s);

//        s.setLaptop(laptop);

        // ✅ Modern configuration (Hibernate 6.x and above)
        Configuration config = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);

        // ✅ Correct way to create ServiceRegistry
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();

        // ✅ Build SessionFactory using the ServiceRegistry
        SessionFactory sf = config.buildSessionFactory(registry);

        // ✅ Open a session and begin transaction
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            
            //insert values
            
//            Random r = new Random();
//            
//            for(int i =1;i<=50;i++) {
//            	Student s = new Student();
//            	s.setRollno(i);
//            	s.setName("Name : "+i);
//            	s.setMarks(r.nextInt(100));
//            	session.persist(s);
//            	
            Query q = session.createQuery("from Student");
            List<Student> students =q.list();
            
            for(Student s : students) {
            	System.out.println(s);
            }
           
            
            tx.commit();
        }

        sf.close();
     
    }
}
