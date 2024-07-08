package dev.cb.store.business.model;

import jakarta.persistence.*;

import javax.sound.sampled.Line;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "saleId")
    private Long id;
    private LocalDateTime date;
    // TODO get right formula (sum saleline price)
//    @Formula("(SELECT sum(saleline.quantity * item.price) FROM sale\n" +
//            " LEFT JOIN saleline ON sale.saleid = saleline.saleid\n" +
//            " LEFT JOIN item ON saleline.itemid = item.itemid)")
    @Transient
    private double price;
    private Status status;

    // TODO change fetch eager to fetch lazy + use join fetch or EntityGraph
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "saleId")
    private List<SaleLine> saleLines = new ArrayList<>();

    public Sale() {
    }

    public Sale(LocalDateTime date, double price, Status status) {
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public Sale(Long id, LocalDateTime date, double price, Status status) {
        this(date, price, status);
        this.id = id;
    }

    public void update(Sale sale) {
        this.setDate(sale.getDate());
        this.setPrice(sale.getPrice());
        this.setStatus(sale.getStatus());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<SaleLine> getSaleLines() {
        return saleLines;
    }

    public void setSaleLines(List<SaleLine> saleLines) {
        this.saleLines = saleLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale sale)) return false;
        return Objects.equals(getId(), sale.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", price=" + price +
                ", status=" + status +
                ", saleLines=" + saleLines +
                '}';
    }
}
