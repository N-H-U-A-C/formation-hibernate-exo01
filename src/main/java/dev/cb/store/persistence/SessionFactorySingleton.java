package dev.cb.store.persistence;

import dev.cb.store.business.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// TODO check try-with-resources
// TODO check synchronized
// TODO refactor with an enum
public class SessionFactorySingleton {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .build();
        sessionFactory = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClasses(Item.class, ElectronicItem.class, FashionItem.class, FoodItem.class, Sale.class, SaleLine.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }
}
