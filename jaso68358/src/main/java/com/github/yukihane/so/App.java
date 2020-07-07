package com.github.yukihane.so;

import com.github.yukihane.so.entity.Company;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myunit");
        final EntityManager em = emf.createEntityManager();

        final Company c = new Company();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);
        tx.commit();

        em.close();
    }
}
