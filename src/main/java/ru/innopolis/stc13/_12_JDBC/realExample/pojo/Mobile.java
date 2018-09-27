package ru.innopolis.stc13._12_JDBC.realExample.pojo;

import java.util.Objects;

public class Mobile {
    private int id;
    private String model;
    private float price;
    private Manufacturer manufacturer;

    public Mobile(int id, String model, float price, Manufacturer manufacturer) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return id == mobile.id &&
                Float.compare(mobile.price, price) == 0 &&
                Objects.equals(model, mobile.model) &&
                Objects.equals(manufacturer, mobile.manufacturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, model, price, manufacturer);
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer.getId() + " - "+ manufacturer.getName() +
                '}';
    }
}
