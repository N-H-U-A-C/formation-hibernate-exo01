package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class ItemRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ItemRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public void save(Item item) {
        sessionFactory.inTransaction(session -> session.persist(item));
    }

    public Optional<Item> findById(long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Item.class, id)));
    }

    public List<Item> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Item", Item.class)
                        .getResultList());
    }
}
