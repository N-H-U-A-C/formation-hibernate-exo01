package dev.cb.store;

import dev.cb.store.business.model.*;
import dev.cb.store.business.service.*;
import dev.cb.store.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        // Sale
        SaleRepository saleRepository = new SaleRepository();
        SaleService saleService = new SaleService(saleRepository);

//        Sale sale1 = new Sale(LocalDateTime.now(), 55.5, Status.ONGOING);
//        Sale sale2 = new Sale(1L, LocalDateTime.now(), 100.5, Status.ONGOING);
//        saleService.save(sale1);
//        Optional<Sale> optionalSale = saleService.getById(Long.valueOf(1L));
//        optionalSale.ifPresentOrElse(System.out::println, () -> System.out.println("Sale not found"));
//        saleService.update(sale2);
//        saleService.delete(sale2);
        saleService.getAll().forEach(sale -> System.out.println(sale));
//        Optional<Status> optionalStatus = saleService.getStatusById(1L);
//        optionalStatus.ifPresentOrElse(System.out::println, () -> System.out.println("Status not found"));

        ItemService itemService = foodItemService;
//        Item item1 = new ElectronicItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item2 = new ElectronicItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item1 = new FashionItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
//        Item item2 = new FashionItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
        Item item1 = new FoodItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
        Item item2 = new FoodItem(401L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
//        itemService.save(item1);
//        Optional<Item> optionalItem = itemService.getById(Long.valueOf(401L));
//        optionalItem.ifPresentOrElse(System.out::println, () -> System.out.println("Item not found"));
//        itemService.update(item2);
//        itemService.delete(item2);
//        itemService.restockById(item2.getId(), 50);
//        itemService.getAll().forEach(item -> System.out.println(item));
    }
}
