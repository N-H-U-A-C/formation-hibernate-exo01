package dev.cb.store.persistence;

import dev.cb.store.business.model.Item;

import java.util.List;

public class FoodItemRepository extends ItemRepository {

    public FoodItemRepository() {
        super();
    }

    @Override
    public List<Item> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from FoodItem", Item.class)
                        .getResultList());
    }
}
