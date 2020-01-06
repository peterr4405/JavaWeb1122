package com.study.web.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATestQuery {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("Select u From User u").getResultList();
        System.out.println(list);

        List<User> list2 = em.createQuery("Select u From User u", User.class).getResultList();
        System.out.println(list2);

        String sql = "SELECT u FROM User u WHERE u.age = :age";
        Query query = em.createQuery(sql);
        query.setParameter("age", 40);
        System.out.println(query.getResultList());

//        --------------NameQuery--------------------------
        List list3 = em.createNamedQuery("User.findAll").getResultList();
        System.out.println(list3);

        Query query2 = em.createNamedQuery("User.findByName");
        query2.setParameter("name", "John2");
        System.out.println(query2.getResultList());

        Query query3 = em.createNamedQuery("User.findByAge");
        query3.setParameter("age", 40);
        System.out.println(query3.getResultList());

    }
}
