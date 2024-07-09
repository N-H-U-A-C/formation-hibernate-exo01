package dev.cb.store.business.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.Objects;

@Entity
public class SaleLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "saleLineId")
    private Long id;
    private int quantity;
    @Formula("sl1_0.quantity * i1_0.price")
    private double price;

    // TODO change OneToOne to OneToMany
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId")
    private Item item;


    public SaleLine() {
    }

    public SaleLine(int quantity, double price, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.item = item;
    }

    public SaleLine(Long id, int quantity, double price, Item item) {
        this(quantity, price, item);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleLine saleLine)) return false;
        return Objects.equals(getId(), saleLine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SaleLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", item=" + item +
                '}';
    }
}
