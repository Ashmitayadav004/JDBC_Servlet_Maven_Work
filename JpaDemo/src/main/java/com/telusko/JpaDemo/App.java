package com.telusko.JpaDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	Alien a1= new Alien();
    	a1.setAid(2);
    	a1.setColor("Pink");
    	a1.setName("Hiral");
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager  em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	em.persist(a1);
    	em.getTransaction().commit();
    	
    	em.getTransaction().begin();
       Alien a = em.find(Alien.class,12);
       System.out.println(a);
    }
}
