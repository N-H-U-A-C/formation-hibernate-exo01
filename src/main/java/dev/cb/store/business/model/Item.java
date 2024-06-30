package dev.cb.store.business.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "itemType")
public abstract class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId")
    protected Long id;
    protected String label;
    protected String description;
    protected double price;
    protected int stockQuantity;
    protected LocalDate restockingDate;

    public Item() {
    }

    public Item(String label, String description, double price, int stockQuantity, LocalDate restockingDate) {
        this.label = label;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.restockingDate = restockingDate;
    }

    public Item(Long id, String label, String description, double price, int stockQuantity, LocalDate restockingDate) {
        this(label, description, price, stockQuantity, restockingDate);
        this.id = id;
    }

    public void restock(Item item, int quantity) {
        item.setStockQuantity(quantity);
        item.setRestockingDate(LocalDate.now());
    }

    public void update(Item item) {
        this.setLabel(item.getLabel());
        this.setDescription(item.getDescription());
        this.setPrice(item.getPrice());
        this.setStockQuantity(item.getStockQuantity());
        this.setRestockingDate(item.getRestockingDate());
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }

    public LocalDate getRestockingDate() {
        return restockingDate;
    }

    public void setRestockingDate(LocalDate restockingDate) {
        this.restockingDate = restockingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", restockingDate=" + restockingDate +
                '}';
    }
}
