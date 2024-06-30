package dev.cb.store.business.service;

import dev.cb.store.persistence.ItemRepository;

public class FashionItemService extends ItemService {

    public FashionItemService(ItemRepository itemRepository) {
        super(itemRepository);
    }
}
