package dev.cb.store.persistence;

import dev.cb.store.business.model.Sale;
import dev.cb.store.business.model.Status;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class SaleRepository {

    private SessionFactory sessionFactory;

    public SaleRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // specific CRUD
    public Optional<Status> findStatusById(Long id) {
        return sessionFactory.fromTransaction(session -> {
            return Optional.ofNullable(
                    session.createSelectionQuery("select s.status from Sale s where s.id = ?1", Status.class)
                            .setParameter(1, id)
                            .getSingleResultOrNull()
            );
        });
    }

    // basic CRUD
    public void save(Sale sale) {
        sessionFactory.inTransaction(session -> session.persist(sale));
    }

    public Optional<Sale> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Sale.class, id)));
    }

    public List<Sale> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Sale", Sale.class)
                        .getResultList());
    }

    public void update(Sale sale) {
        sessionFactory.inTransaction(session -> session.merge(sale));
    }

    public void delete(Sale sale) {
        sessionFactory.inTransaction(session -> session.delete(sale));
    }
}
