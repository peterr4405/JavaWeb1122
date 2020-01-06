package com.study.web.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest_update {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);

        User user = em.find(User.class, 1L);
        System.out.println("修改前: " + user);
        if (user != null) {

            user.setAge(30);
            user.setName("jason");
            System.out.println("修改後: " + user);
            
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        } else {
            System.out.println("查無資料");
        }

        em.close();
    }

}
