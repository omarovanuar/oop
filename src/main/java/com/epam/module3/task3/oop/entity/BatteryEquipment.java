package com.epam.module3.task3.oop.entity;

public class BatteryEquipment extends Electronics {
    private int batteryNumber;

    public BatteryEquipment(Integer id, String title, double price, double consumptionPerHour, int batteryNumber) {
        super(id, title, price, consumptionPerHour);
        this.batteryNumber = batteryNumber;
    }

    public int getBatteryNumber() {
        return batteryNumber;
    }

    public void setBatteryNumber(int batteryNumber) {
        this.batteryNumber = batteryNumber;
    }

    @Override
    public String toString() {
        return "BatteryEquipment: " + super.toString() +
                ", batteryNumber = " + batteryNumber;
    }
}
