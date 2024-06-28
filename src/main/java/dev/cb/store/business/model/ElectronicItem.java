package dev.cb.store.business.model;

import java.time.LocalDate;

public class ElectronicItem extends Item {

    private int batteryCapacity;

    public ElectronicItem() {
    }

    public ElectronicItem(String label, String description, double price, int quantity, LocalDate restockingDate, int batteryCapacity) {
        super(label, description, price, quantity, restockingDate);
        this.batteryCapacity = batteryCapacity;
    }

    public ElectronicItem(long id, String label, String description, double price, int quantity, LocalDate restockingDate, int batteryCapacity) {
        super(id, label, description, price, quantity, restockingDate);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
