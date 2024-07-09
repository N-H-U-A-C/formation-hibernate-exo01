package dev.cb.store.business.service;

import dev.cb.store.business.model.Item;
import dev.cb.store.persistence.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public void update(Item item) {
        Optional<Item> optionalItem = itemRepository.findById(item.getId());
        optionalItem.ifPresent(fetchedItem -> {
            fetchedItem.update(item);
            itemRepository.update(fetchedItem);
        });
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }

    public void restockById(long id, int quantity) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        optionalItem.ifPresent(fetchedItem -> {
            fetchedItem.restock(fetchedItem, quantity);
            itemRepository.update(fetchedItem);
        });
    }
}
