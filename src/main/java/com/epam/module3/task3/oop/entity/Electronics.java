package com.epam.module3.task3.oop.entity;

public class Electronics {
    private Integer id;
    private String title;
    private double price;
    private double consumptionPerHour;

    public Electronics() {
    }

    public Electronics(Integer id, String title, double price, double consumptionPerHour) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.consumptionPerHour = consumptionPerHour;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Double getConsumptionPerHour() {
        return consumptionPerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electronics that = (Electronics) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.consumptionPerHour, consumptionPerHour) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consumptionPerHour);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return  "id = " + id  +
                ", title = " + title  +
                ", price = " + price +
                ", consumptionPerHour = " + consumptionPerHour;
    }
}
