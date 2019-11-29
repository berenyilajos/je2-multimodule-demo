package com.example.jpademo.transactions;

import com.example.jpademo.dao.qualifier.DemoDatabase;
import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class DemoEntityManagerResolver implements EntityManagerResolver {

    @Inject
    @DemoDatabase
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
