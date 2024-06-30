package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;

import java.util.List;

public class FashionItemRepository extends ItemRepository {

    public FashionItemRepository() {
        super();
    }

    @Override
    public List<Item> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from FashionItem", Item.class)
                        .getResultList());
    }
}
