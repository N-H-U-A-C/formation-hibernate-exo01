package dev.cb.store;

import dev.cb.store.business.model.*;
import dev.cb.store.business.service.*;
import dev.cb.store.persistence.*;
import dev.cb.store.presentation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
        // Client
        ClientRepository clientRepository = new ClientRepository();
        ClientService clientService = new ClientService(clientRepository);

        Map<Integer, Menu> menus = new HashMap<>();
        Menu mainMenu = new MainMenu();
        menus.put(0, mainMenu);
        Menu clientMenu = new ClientMenu(clientService);
        menus.put(1, clientMenu);
        Menu saleMenu = new SaleMenu(saleService);
        menus.put(2, saleMenu);

        Ihm.menus = menus;
        Ihm.actualMenu = menus.get(0);
        Ihm.run();

        Client client1 = new Client("test", "test", "test@gmail.com");
        Client client2 = new Client(52L, "update test", "test", "test@gmail.com");
//        clientService.save(client1);
//        Optional<Client> optionalClient = clientRepository.findById(Long.valueOf(1L));
//        optionalClient.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        clientService.update(client2);
//        clientService.delete(client2);
//        clientService.getAll().forEach(System.out::println);

//        Sale sale1 = new Sale(LocalDateTime.now(), 55.5, Status.ONGOING);
//        Sale sale2 = new Sale(1L, LocalDateTime.now(), 100.5, Status.ONGOING);
//        saleService.save(sale1);
//        Optional<Sale> optionalSale = saleService.getById(Long.valueOf(1L));
//        optionalSale.ifPresentOrElse(System.out::println, () -> System.out.println("Sale not found"));
//        saleService.update(sale2);
//        saleService.delete(sale2);
//        saleService.getAll().forEach(System.out::println);
//        Optional<Status> optionalStatus = saleService.getStatusById(1L);
//        optionalStatus.ifPresentOrElse(System.out::println, () -> System.out.println("Status not found"));

        ItemService itemService = foodItemService;
//        Item item1 = new ElectronicItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item2 = new ElectronicItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), 3600);
//        Item item1 = new FashionItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
//        Item item2 = new FashionItem(1L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), ClothingCategory.MAN, "5");
//        Item item1 = new FoodItem("label", "description", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
//        Item item2 = new FoodItem(401L,"label", "test update", 11.5, 5, LocalDate.parse("2024-06-10"), LocalDate.parse("2025-08-05"));
//        itemService.save(item1);
//        Optional<Item> optionalItem = itemService.getById(Long.valueOf(401L));
//        optionalItem.ifPresentOrElse(System.out::println, () -> System.out.println("Item not found"));
//        itemService.update(item2);
//        itemService.delete(item2);
//        itemService.restockById(item2.getId(), 50);
//        itemService.getAll().forEach(System.out::println);
    }
}
