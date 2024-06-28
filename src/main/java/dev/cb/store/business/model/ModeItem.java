package dev.cb.store.business.model;

import java.time.LocalDate;

public class ModeItem extends Item{

    private ClothingCategory clothingCategory;
    private int size;

    public ModeItem() {
    }

    public ModeItem(String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, int size) {
        super(label, description, price, quantity, restockingDate);
        this.clothingCategory = clothingCategory;
        this.size = size;
    }

    public ModeItem(long id, String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, int size) {
        super(id, label, description, price, quantity, restockingDate);
        this.clothingCategory = clothingCategory;
        this.size = size;
    }

    public ClothingCategory getClothingCategory() {
        return clothingCategory;
    }

    public void setClothingCategory(ClothingCategory clothingCategory) {
        this.clothingCategory = clothingCategory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
