package com.epam.module3.task3.oop.entity;

public class LowPowerEquipment extends Electronics {
    private static final double LOW_POWER_COEFFICIENT = 1.034;
    private boolean isPluggedIn;
    private double consumptionPerMonth;

    public LowPowerEquipment(Integer id, String title, double price, double consumptionPerHour, boolean isPluggedIn) {
        super(id, title, price, consumptionPerHour);
        this.isPluggedIn = isPluggedIn;
        consumptionPerMonth = this.calculateConsumption();
    }

    public double calculateConsumption() {
        return getConsumptionPerHour() * 24 * 30 * LOW_POWER_COEFFICIENT;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public double getConsumptionPerMonth() {
        return consumptionPerMonth;
    }

    @Override
    public String toString() {
        return "LowPowerEquipment: " + super.toString() +
                ", isPluggedIn = " + isPluggedIn;
    }
}
