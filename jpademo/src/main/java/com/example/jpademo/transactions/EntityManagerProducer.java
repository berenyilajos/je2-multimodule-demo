package com.example.jpademo.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
	
    private static int i = 0;
    private int count = 0;
    private static int cl = 0;
    private int close = 0;
    private int close2 = 0;
  @PersistenceUnit(unitName="memorygame")
  EntityManagerFactory emf;
  
//  private EntityManager entityManager = null;
  
//  @PersistenceContext(unitName="memorygame")
//  private EntityManager entityManager;

  @Produces
  @TransactionScoped
  public EntityManager createEntityManager() {
//      if (entityManager == null) {
//          entityManager = emf.createEntityManager();
//      }
//      return entityManager;
      i++; count++;
      System.err.println("i = " + i + ", count = " + count);
      if (emf == null) {
          System.err.println("EMF was not not injected, so created!!!");
          emf = Persistence.createEntityManagerFactory("memorygame");
	  }
	  return emf.createEntityManager();
  }

    public void close(
            @Disposes EntityManager entityManager) {
      cl++; close++;
      if (entityManager.isOpen()) {
          close2++;
          entityManager.close();
      }
        System.err.println("cl = " + cl + ", close = " + close + ", close2 = " + close2);
    }

}
