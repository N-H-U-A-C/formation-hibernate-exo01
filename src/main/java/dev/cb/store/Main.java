package dev.cb.store;

import dev.cb.store.business.model.FoodItem;
import dev.cb.store.business.model.Item;
import dev.cb.store.persistence.FoodItemRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        FoodItemRepository foodItemRepository = new FoodItemRepository();

        FoodItem foodItem = new FoodItem("label", "description", 11.5, 5, LocalDate.now(), LocalDate.now());
//        System.out.println(foodItemRepository.save(foodItem));
//        Optional<Item> optionalFoodItem = foodItemRepository.findById(foodItem.getId());
//        optionalFoodItem.ifPresentOrElse(System.out::println, () -> System.out.println("FoodItem not found"));
        System.out.println(foodItemRepository.findAll());

        //TODO check dépendance hibernate
    }
}
