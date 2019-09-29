package com.zcl.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        JpaUtils.entityManagerFactory = entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void setEntityManager(EntityManager entityManager) {
        JpaUtils.entityManager = entityManager;
    }

    public static void factoryClose(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
