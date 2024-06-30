package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class ItemRepository {

    protected SessionFactory sessionFactory;

    public ItemRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // basic CRUD
    public void save(Item item) {
        sessionFactory.inTransaction(session -> session.persist(item));
    }

    public Optional<Item> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Item.class, id)));
    }

    public List<Item> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Item", Item.class)
                        .getResultList());
    }

    public void update(Item item) {
        sessionFactory.inTransaction(session -> session.merge(item));
    }

    public void delete(Item item) {
        sessionFactory.inTransaction(session -> session.delete(item));
    }
}
