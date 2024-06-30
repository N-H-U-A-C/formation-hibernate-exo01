package dev.cb.store;

import dev.cb.store.business.model.*;
import dev.cb.store.business.service.ElectronicItemService;
import dev.cb.store.business.service.FashionItemService;
import dev.cb.store.business.service.FoodItemService;
import dev.cb.store.persistence.ElectronicItemRepository;
import dev.cb.store.persistence.FashionItemRepository;
import dev.cb.store.persistence.FoodItemRepository;
import dev.cb.store.persistence.SessionFactorySingleton;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // FoodItem
        FoodItemRepository foodItemRepository = new FoodItemRepository();
        FoodItemService foodItemService = new FoodItemService(foodItemRepository);
        // FashionItem
        FashionItemRepository fashionItemRepository = new FashionItemRepository();
        FashionItemService fashionItemService = new FashionItemService(fashionItemRepository);
        // ElectronicItem
        ElectronicItemRepository electronicItemRepository = new ElectronicItemRepository();
        ElectronicItemService electronicItemService = new ElectronicItemService(electronicItemRepository);

//        Item item1 = new ElectronicItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item2 = new ElectronicItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item1 = new FashionItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
//        Item item2 = new FashionItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
        Item item1 = new FoodItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
        Item item2 = new FoodItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
        electronicItemService.save(item1);
        Optional<Item> optionalElectronicItem = electronicItemService.findById(Long.valueOf(1L));
        optionalElectronicItem.ifPresentOrElse(System.out::println, () -> System.out.println("Item not found"));
//        electronicItemService.update(item2);
//        electronicItemService.delete(item2);
//        electronicItemService.restockById(item2.getId(), 50);
        System.out.println(electronicItemService.findAll());
    }
}
