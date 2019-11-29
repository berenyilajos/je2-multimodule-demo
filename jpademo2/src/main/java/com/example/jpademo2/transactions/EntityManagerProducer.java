package com.example.jpademo2.transactions;

import com.example.jpademo2.dao.qualifier.Demo2Database;
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
    @PersistenceUnit(unitName="demo2")
    private EntityManagerFactory emf;

    @Produces
    @Demo2Database
    @TransactionScoped
    public EntityManager createEntityManager() {
        i++; count++;
        System.err.println("demo2: i = " + i + ", count = " + count);
        if (emf == null) {
            System.err.println("EMF for demo2 was not not injected, so creating!!!");
            emf = Persistence.createEntityManagerFactory("demo2");
	    }
	    return emf.createEntityManager();
    }

    public void close(
            @Disposes @Demo2Database EntityManager entityManager) {
      cl++; close++;
      if (entityManager.isOpen()) {
          close2++;
          entityManager.close();
      }
        System.err.println("demo2: cl = " + cl + ", close = " + close + ", close2 = " + close2);
    }
}
