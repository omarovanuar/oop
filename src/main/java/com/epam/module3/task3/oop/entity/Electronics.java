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
    public String toString() {
        return  "id = " + id  +
                ", title = " + title  +
                ", price = " + price +
                ", consumptionPerHour = " + consumptionPerHour;
    }
}
