package dev.cb.store.presentation;

import dev.cb.store.business.model.*;
import dev.cb.store.business.service.FashionItemService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class FashionItemMenu extends ItemMenu {

    public FashionItemMenu(FashionItemService fashionItemService) {
        super(fashionItemService);
    }

    @Override
    protected void initialize() {
        this.actions = new HashMap<>();
        actions.put(1, this::create);
        actions.put(2, this::update);
        actions.put(3, () -> this.changeActualMenu(3));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.entityName = "Fashion Item";
        this.menuText = """
                \n=== Manage fashion items ===
                                
                1. Add a fashion item
                2. Update a fashion item
                3. Return to item menu
                0. Exit
                """;
    }

//    private void delete() {
//        Optional<Item> optionalItem = itemService.getById(this.inputId());
//        optionalItem.ifPresentOrElse(
//                item -> this.itemService.delete(item),
//                () -> System.out.println(this.entityName + " not found")
//        );
//    }

    private void update() {
        Optional<Item> optionalItem = itemService.getById(this.inputId());
        optionalItem.ifPresentOrElse(
                // TODO refactor cast
                item -> this.itemService.update(this.inputUpdatedItem((FashionItem) item)),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void create() {
        this.itemService.save(this.inputNewFashionItem());
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

    private Item inputUpdatedItem(FashionItem fashionItem) {
        System.out.println("= Current fashion item =");
        System.out.println("\nCurrent label: " + fashionItem.getLabel());
        inputLabel(fashionItem);
        System.out.println("\nCurrent description: " + fashionItem.getDescription());
        inputDescription(fashionItem);;
        System.out.println("\nCurrent price: " + fashionItem.getPrice());
        inputPrice(fashionItem);
        System.out.println("\nCurrent stock quantity: " + fashionItem.getStockQuantity());
        inputStockQuantity(fashionItem);
        System.out.println("\nCurrent clothing category: " + fashionItem.getClothingCategory());
        inputClothingCategory(fashionItem);
        System.out.println("\nCurrent size: " + fashionItem.getSize());
        inputSize(fashionItem);
        return fashionItem;
    }

    private void inputSize(FashionItem fashionItem) {
        fashionItem.setSize(Ihm.readInput(this.entityName.toLowerCase(), "size"));
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

//    private void inputStockQuantity(Item foodItem) {
//        foodItem.setStockQuantity(Integer.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "stock quantity")));
//    }

//    private void inputPrice(Item foodItem) {
//        foodItem.setPrice(Double.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "price")));
//    }

//    private void inputDescription(Item foodItem) {
//        foodItem.setDescription(Ihm.readInput(this.entityName.toLowerCase(), "description"));
//    }

//    private void inputLabel(Item foodItem) {
//        foodItem.setLabel(Ihm.readInput(this.entityName.toLowerCase(), "label"));
//    }
}
