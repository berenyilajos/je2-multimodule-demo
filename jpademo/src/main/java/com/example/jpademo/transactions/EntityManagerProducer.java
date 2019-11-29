package com.example.jpademo.transactions;

import com.example.jpademo.dao.qualifier.DemoDatabase;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
	
    private static int i = 0;
    private int count = 0;
    private static int cl = 0;
    private int close = 0;
    private int close2 = 0;
    @PersistenceUnit(unitName="demo")
    private EntityManagerFactory emf;

    @Produces
    @DemoDatabase
    @TransactionScoped
    public EntityManager createEntityManager() {
        i++; count++;
        System.err.println("demo: i = " + i + ", count = " + count);
        if (emf == null) {
            System.err.println("EMF for demo was not not injected, so creating!!!");
            emf = Persistence.createEntityManagerFactory("demo");
	    }
	    return emf.createEntityManager();
    }

    public void close(
            @Disposes @DemoDatabase EntityManager entityManager) {
      cl++; close++;
      if (entityManager.isOpen()) {
          close2++;
          entityManager.close();
      }
        System.err.println("demo: cl = " + cl + ", close = " + close + ", close2 = " + close2);
    }
}
