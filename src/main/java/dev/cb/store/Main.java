package dev.cb.store;

import dev.cb.store.business.model.FoodItem;
import dev.cb.store.business.model.Item;
import dev.cb.store.persistence.FoodItemRepository;
import dev.cb.store.persistence.SessionFactorySingleton;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        FoodItemRepository foodItemRepository = new FoodItemRepository();

        FoodItem foodItem1 = new FoodItem("label", "description", 11.5, 5, LocalDate.now(), LocalDate.now());
        foodItemRepository.save(foodItem1);
        Optional<Item> optionalFoodItem = foodItemRepository.findById(foodItem1.getId());
        optionalFoodItem.ifPresentOrElse(System.out::println, () -> System.out.println("FoodItem not found"));
        FoodItem foodItem2 = new FoodItem(1,"label", "test update", 11.5, 5, LocalDate.now(), LocalDate.now());
        foodItemRepository.update(foodItem2);
//        foodItemRepository.delete(new FoodItem(1, "label", "description", 11.5, 5, LocalDate.now(), LocalDate.now()));
        System.out.println(foodItemRepository.findAll());
//
    }
}
