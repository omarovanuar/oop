package com.epam.module3.task3.oop.entity;

public class HighPowerEquipment extends Electronics {
    private static final double HIGH_POWER_COEFFICIENT = 1.284;
    private boolean isPluggedIn;
    private double consumptionPerMonth;

    public HighPowerEquipment(String title, double price, double powerConsumption) {
        super(title, price, powerConsumption);
    }

    public HighPowerEquipment(String title, double price, double consumptionPerHour, boolean isPluggedIn) {
        super(title, price, consumptionPerHour);
        this.isPluggedIn = isPluggedIn;
        consumptionPerMonth = this.calculateConsumption();
    }

    public double calculateConsumption() {
        return getConsumptionPerHour() * 24 * 30 * HIGH_POWER_COEFFICIENT;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public double getConsumptionPerMonth() {
        return consumptionPerMonth;
    }

    @Override
    public String toString() {
        return "HighPowerEquipment: " + super.toString() +
                ", isPluggedIn = " + isPluggedIn;
    }
}
