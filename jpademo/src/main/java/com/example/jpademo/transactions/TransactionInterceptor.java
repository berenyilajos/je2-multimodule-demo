package com.example.jpademo.transactions;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 * A simple transaction interceptor which registers an entity mangager in a ThreadLocal and unregisters after the
 * method was called.
 * It does not support any kind of context propagation. If a transactional method calls another's bean transactional
 * method a new entity manager is created and added to the stack.
 *
 * @author Berenyi Lajos
 */
@Interceptor
@Transactional
public class TransactionInterceptor {

    @Inject
    private EntityManagerStoreImpl entityManagerStore;

    private Logger logger = LoggerFactory.getLogger(TransactionInterceptor.class);

    @AroundInvoke
    public Object runInTransaction(InvocationContext invocationContext) throws Exception {

        EntityManager em = entityManagerStore.createAndRegister();

        Object result = null;
        try {
            em.getTransaction().begin();

            result = invocationContext.proceed();

            em.getTransaction().commit();

        } catch (Exception e) {
            try {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                    logger.debug("Rolled back transaction");
                }
            } catch (HibernateException e1) {
                logger.warn("Rollback of transaction failed -> " + e1);
            }
            throw e;
        } finally {
            if (em != null) {
                entityManagerStore.unregister(em);
                em.close();
            }
        }


        return result;
    }
}
