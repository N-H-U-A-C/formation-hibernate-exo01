package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;

import java.util.List;

public class ElectronicItemRepository extends ItemRepository {

    public ElectronicItemRepository() {
        super();
    }

    @Override
    public List<Item> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from ElectronicItem", Item.class)
                        .getResultList());
    }
}
