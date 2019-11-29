package com.example.jpademo2.transactions;

import com.example.jpademo2.dao.qualifier.Demo2Database;
import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class Demo2EntityManagerResolver implements EntityManagerResolver {

    @Inject
    @Demo2Database
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
