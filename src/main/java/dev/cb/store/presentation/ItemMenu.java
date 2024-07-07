package dev.cb.store.presentation;

import dev.cb.store.business.model.*;
import dev.cb.store.business.service.ItemService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class ItemMenu extends Menu {

    private ItemService itemService;

    public ItemMenu(ItemService itemService) {
        super();
        this.itemService = itemService;
        this.actions = new HashMap<>();
        actions.put(1, this::create);
        actions.put(2, this::read);
        actions.put(3, this::readAll);
//        actions.put(4, this::update);
        actions.put(5, this::delete);
        actions.put(6, () -> this.changeActualMenu(0));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.entityName = "Item";
        this.menuText = """
                \n=== Manage items ===
                                
                1. Add an item
                2. Display an item (by id)
                3. Display all items
                4. Update an item
                5. Delete an item
                6. Return to main menu
                0. Exit
                """;
    }

    private void delete() {
        Optional<Item> optionalItem = itemService.getById(this.inputId());
        optionalItem.ifPresentOrElse(
                item -> this.itemService.delete(item),
                () -> System.out.println(this.entityName + " not found")
        );
    }

//    private void update() {
//        Optional<Item> optionalItem = itemService.getById(this.inputId());
//        optionalItem.ifPresentOrElse(
//                item -> this.itemService.update(this.inputUpdatedItem(item)),
//                () -> System.out.println(this.entityName + " not found")
//        );
//    }

    private void readAll() {
        this.itemService.getAll().forEach(System.out::println);
    }

    private void read() {
        Optional<Item> optionalItem = this.itemService.getById(this.inputId());
        optionalItem.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void create() {
        this.itemService.save(this.inputNewItem());
    }

    private Long inputId() {
        return Long.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "id"));
    }

    private Item inputNewItem() {
        String itemType = Ihm.readInput(this.entityName.toLowerCase(), """
                item type
                1. Fashion item
                2. Food item
                3. Electronic item
                """);
        return switch (itemType) {
            case "2" -> inputNewFoodItem();
            case "3" -> inputNewElectronicItem();
            default -> inputNewFashionItem();
        };
    }

    private Item inputNewFashionItem() {
        FashionItem fashionItem = new FashionItem();
        inputLabel(fashionItem);
        inputDescription(fashionItem);
        inputPrice(fashionItem);
        inputStockQuantity(fashionItem);
        fashionItem.setRestockingDate(LocalDate.now());
        inputClothingCategory(fashionItem);
        inputSize(fashionItem);
        return fashionItem;
    }

    private Item inputNewFoodItem() {
        FoodItem foodItem = new FoodItem();
        inputLabel(foodItem);
        inputDescription(foodItem);
        inputPrice(foodItem);
        inputStockQuantity(foodItem);
        foodItem.setRestockingDate(LocalDate.now());
        inputExpirationDate(foodItem);
        return foodItem;
    }

    private Item inputNewElectronicItem() {
        ElectronicItem electronicItem = new ElectronicItem();
        inputLabel(electronicItem);
        inputDescription(electronicItem);
        inputPrice(electronicItem);
        inputStockQuantity(electronicItem);
        electronicItem.setRestockingDate(LocalDate.now());
        inputBatteryCapacity(electronicItem);
        return electronicItem;
    }

    private void inputSize(FashionItem fashionItem) {
        fashionItem.setDescription(Ihm.readInput(this.entityName.toLowerCase(), "size"));
    }

    private void inputClothingCategory(FashionItem fashionItem) {
        String clothingCategory = Ihm.readInput(this.entityName.toLowerCase(), """
                clothing category
                1. Man
                2. Woman
                3. Child
                """);
        fashionItem.setClothingCategory(
                switch (clothingCategory) {
                    case "2" -> ClothingCategory.WOMAN;
                    case "3" -> ClothingCategory.CHILD;
                    default -> ClothingCategory.MAN;
                }
        );
    }

    private void inputBatteryCapacity(ElectronicItem electronicItem) {
        electronicItem.setStockQuantity(Integer.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "battery capacity")));
    }

    private void inputExpirationDate(FoodItem foodItem) {
        foodItem.setExpirationDate(LocalDate.parse(Ihm.readInput(this.entityName.toLowerCase(), "expiration date")));
    }

    private void inputStockQuantity(Item foodItem) {
        foodItem.setStockQuantity(Integer.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "stock quantity")));
    }

    private void inputPrice(Item foodItem) {
        foodItem.setPrice(Double.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "price")));
    }

    private void inputDescription(Item foodItem) {
        foodItem.setDescription(Ihm.readInput(this.entityName.toLowerCase(), "description"));
    }

    private void inputLabel(Item foodItem) {
        foodItem.setLabel(Ihm.readInput(this.entityName.toLowerCase(), "label"));
    }

//    private Item inputUpdatedItem(Item item) {
//        System.out.println("= Current item =");
//        System.out.println("\nCurrent first name: " + item.getFirstName());
//        inputFirstName(item);
//        System.out.println("\nCurrent last name: " + item.getLastName());
//        inputLastName(item);
//        System.out.println("\nCurrent email: " + item.getEmail());
//        inputEmail(item);
//        return item;
//    }
}
