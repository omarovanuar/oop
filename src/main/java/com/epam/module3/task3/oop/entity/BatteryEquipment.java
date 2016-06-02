package com.epam.module3.task3.oop.entity;

public class BatteryEquipment extends Electronics {
    private int batteryNumber;

    public BatteryEquipment(String title, double price, double powerConsumption) {
        super(title, price, powerConsumption);
    }

    public BatteryEquipment(String title, double price, double powerConsumption, int batteryNumber) {
        super(title, price, powerConsumption);
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
