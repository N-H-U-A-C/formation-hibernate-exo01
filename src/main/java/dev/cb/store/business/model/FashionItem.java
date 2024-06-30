package dev.cb.store.business.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
//@DiscriminatorValue("FashionItem")
public class FashionItem extends Item {

    private ClothingCategory clothingCategory;
    private String size;

    public FashionItem() {
    }

    public FashionItem(String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, String size) {
        super(label, description, price, quantity, restockingDate);
        this.clothingCategory = clothingCategory;
        this.size = size;
    }

    public FashionItem(long id, String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, String size) {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FashionItem{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", restockingDate=" + restockingDate +
                ", clothingCategory=" + clothingCategory +
                ", size=" + size +
                '}';
    }
}
