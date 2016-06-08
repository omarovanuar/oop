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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LowPowerEquipment that = (LowPowerEquipment) o;

        if (isPluggedIn != that.isPluggedIn) return false;
        return Double.compare(that.consumptionPerMonth, consumptionPerMonth) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (isPluggedIn ? 1 : 0);
        temp = Double.doubleToLongBits(consumptionPerMonth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "LowPowerEquipment: " + super.toString() +
                ", isPluggedIn = " + isPluggedIn;
    }
}
