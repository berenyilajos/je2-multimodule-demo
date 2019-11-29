package com.example.jpademo2.transactions;

import com.example.jpademo2.dao.qualifier.Demo2Database;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
    private static int i = 0;
    private int count = 0;
    private static int cl = 0;
    private int close = 0;
    private int close2 = 0;

    @Inject
    @PersistenceUnitName("demo2")
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

    /**
     * Closes the entity manager factory instance so that the CDI container can be gracefully shutdown
     */
    @PreDestroy
    public void closeFactory() {
        if(emf.isOpen()) {
            emf.close();
        }
        System.err.println("demo2 EMF close!!!");
    }
}
