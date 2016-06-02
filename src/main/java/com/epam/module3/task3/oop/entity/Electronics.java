package com.epam.module3.task3.oop.entity;

public class Electronics {
    private String title;
    private double price;
    private double consumptionPerHour;



    public Electronics(String title, double price, double consumptionPerHour) {
        this.title = title;
        this.price = price;
        this.consumptionPerHour = consumptionPerHour;
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
        return  "title = " + title  +
                ", price = " + price +
                ", consumptionPerHour = " + consumptionPerHour;
    }
}
