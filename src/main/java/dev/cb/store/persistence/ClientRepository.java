package dev.cb.store.persistence;

import dev.cb.store.business.model.Client;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ClientRepository {

    private SessionFactory sessionFactory;

    public ClientRepository() {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // basic CRUD
    public void save(Client client) {
        sessionFactory.inTransaction(session -> session.persist(client));
    }

    public Optional<Client> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Client.class, id)));
    }

    public List<Client> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Client", Client.class)
                        .getResultList());
    }

    public void update(Client client) {
        sessionFactory.inTransaction(session -> session.merge(client));
    }

    public void delete(Client client) {
        sessionFactory.inTransaction(session -> session.delete(client));
    }
}
