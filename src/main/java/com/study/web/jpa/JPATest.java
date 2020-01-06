package com.study.web.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
       // System.out.println(em);
        
        User user = new User();
        user.setAge(25);
        user.setName("peter");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }

}
