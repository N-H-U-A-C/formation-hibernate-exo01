package dev.cb.store.business.service;

import dev.cb.store.persistence.ItemRepository;

public class ElectronicItemService extends ItemService {

    public ElectronicItemService(ItemRepository itemRepository) {
        super(itemRepository);
    }
}
