package dev.cb.store.business.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    protected long id;
    @Column(name = "item_label")
    protected String label;
    @Column(name = "item_description")
    protected String description;
    @Column(name = "item_price")
    protected double price;
    @Column(name = "item_quantity")
    protected int quantity;
    @Column(name = "item_restockingDate")
    protected LocalDate restockingDate;

    public Item() {
    }

    public Item(String label, String description, double price, int quantity, LocalDate restockingDate) {
        this.label = label;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.restockingDate = restockingDate;
    }

    public Item(long id, String label, String description, double price, int quantity, LocalDate restockingDate) {
        this(label, description, price, quantity, restockingDate);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getRestockingDate() {
        return restockingDate;
    }

    public void setRestockingDate(LocalDate restockingDate) {
        this.restockingDate = restockingDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", restockingDate=" + restockingDate +
                '}';
    }
}
