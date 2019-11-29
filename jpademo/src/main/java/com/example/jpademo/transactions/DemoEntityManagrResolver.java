package com.example.jpademo.transactions;

import com.example.common.dao.db.DemoDatabase;
import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class DemoEntityManagrResolver implements EntityManagerResolver {

    @Inject
    @DemoDatabase
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
