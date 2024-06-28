package dev.cb.store.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }
}
