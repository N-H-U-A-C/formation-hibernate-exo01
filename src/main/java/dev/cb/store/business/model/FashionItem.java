package dev.cb.store.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "fashionitems")
public class FashionItem extends Item {

    @Column(name = "fashionitem_clothingcategory")
    private ClothingCategory clothingCategory;
    @Column(name = "fashionitem_size")
    private int size;

    public FashionItem() {
    }

    public FashionItem(String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, int size) {
        super(label, description, price, quantity, restockingDate);
        this.clothingCategory = clothingCategory;
        this.size = size;
    }

    public FashionItem(long id, String label, String description, double price, int quantity, LocalDate restockingDate, ClothingCategory clothingCategory, int size) {
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

    @Override
    public String toString() {
        return "ModeItem{" +
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
