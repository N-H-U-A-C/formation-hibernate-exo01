package dev.cb.store.business.service;

import dev.cb.store.persistence.ItemRepository;

public class FoodItemService extends ItemService {

    public FoodItemService(ItemRepository itemRepository) {
        super(itemRepository);
    }
}
