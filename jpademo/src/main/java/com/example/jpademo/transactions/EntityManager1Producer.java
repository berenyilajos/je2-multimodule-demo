package com.example.jpademo.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
	
    private static int i = 0;
    private int count = 0;
    private static int cl = 0;
    private int close = 0;
    private int close2 = 0;
  @PersistenceUnit(unitName="demo1")
  EntityManagerFactory emf1;

    @PersistenceUnit(unitName="demo2")
    EntityManagerFactory emf2;

  @Produces
  @TransactionScoped
  @Demo1Database
  public EntityManager createEntityManager1() {
      i++; count++;
      System.err.println("i = " + i + ", count = " + count);
      if (emf1 == null) {
          System.err.println("EMF was not not injected, so created!!!");
          emf1 = Persistence.createEntityManagerFactory("demo1");
	  }
	  return emf1.createEntityManager();
  }

    public void close1(
            @Disposes @Demo1Database EntityManager entityManager) {
      cl++; close++;
      if (entityManager.isOpen()) {
          close2++;
          entityManager.close();
      }
        System.err.println("cl = " + cl + ", close = " + close + ", close2 = " + close2);
    }

    @Produces
    @TransactionScoped
    @Demo2Database
    public EntityManager createEntityManager2() {
        i++; count++;
        System.err.println("i = " + i + ", count = " + count);
        if (emf2 == null) {
            System.err.println("EMF was not not injected, so created!!!");
            emf2 = Persistence.createEntityManagerFactory("demo2");
        }
        return emf2.createEntityManager();
    }

    public void close2(
            @Disposes @Demo2Database EntityManager entityManager) {
        cl++; close++;
        if (entityManager.isOpen()) {
            close2++;
            entityManager.close();
        }
        System.err.println("cl = " + cl + ", close = " + close + ", close2 = " + close2);
    }

}
