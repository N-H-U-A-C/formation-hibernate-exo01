package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ItemRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ItemRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public Item save(Item item) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            return item;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public Optional<Item> findById(long id) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Optional<Item> optionalItem = Optional.ofNullable(session.get(Item.class, id));
            session.getTransaction().commit();
            return optionalItem;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    public List<Item> findAll() {

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            TypedQuery<Item> query = session.createQuery("from Item", Item.class);
            List<Item> items = query.getResultList();
            session.getTransaction().commit();
            return items;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}
