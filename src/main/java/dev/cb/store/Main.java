package dev.cb.store;

import dev.cb.store.business.model.FoodItem;
import dev.cb.store.business.model.Item;
import dev.cb.store.business.service.FoodItemService;
import dev.cb.store.persistence.FoodItemRepository;
import dev.cb.store.persistence.SessionFactorySingleton;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        FoodItemRepository foodItemRepository = new FoodItemRepository();
        FoodItemService foodItemService = new FoodItemService(foodItemRepository);

        FoodItem foodItem1 = new FoodItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
        FoodItem foodItem2 = new FoodItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
        foodItemService.save(foodItem1);
//        Optional<Item> optionalFoodItem = foodItemService.findById(Long.valueOf(1L));
//        optionalFoodItem.ifPresentOrElse(System.out::println, () -> System.out.println("FoodItem not found"));
//        foodItemService.update(foodItem2);
//        foodItemService.delete(new FoodItem(1L, "label", "description", 11.5, 5, LocalDate.now(), LocalDate.now()));
        foodItemService.restockById(1L, 50);
        System.out.println(foodItemService.findAll());
////
    }
}
