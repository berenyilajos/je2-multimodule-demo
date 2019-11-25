package com.example.jpademo.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
	

//  @PersistenceUnit(unitName="memorygame")
  EntityManagerFactory emf;
  
//  private EntityManager entityManager = null;
  
//  @PersistenceContext(unitName="memorygame")
//  private EntityManager entityManager;

  @Produces
  @TransactionScoped
  protected EntityManager createEntityManager() {
//      if (entityManager == null) {
//          entityManager = emf.createEntityManager();
//      }
//      return entityManager;
	  if (emf == null) {
		  emf = Persistence.createEntityManagerFactory("memorygame");
	  }
	  return emf.createEntityManager();
  }

}
