package dev.cb.store.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "fooditems")
public class FoodItem extends Item {

    @Column(name = "fooditem_expirationdate")
    private LocalDate expirationDate;

    public FoodItem() {
        super();
    }

    public FoodItem(String label, String description, double price, int quantity, LocalDate restockingDate, LocalDate expirationDate) {
        super(label, description, price, quantity, restockingDate);
        this.expirationDate = expirationDate;
    }

    public FoodItem(long id, String label, String description, double price, int quantity, LocalDate restockingDate, LocalDate expirationDate) {
        super(id, label, description, price, quantity, restockingDate);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + stockQuantity +
                ", restockingDate=" + restockingDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
