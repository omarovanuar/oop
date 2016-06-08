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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BatteryEquipment that = (BatteryEquipment) o;

        return batteryNumber == that.batteryNumber;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + batteryNumber;
        return result;
    }

    @Override
    public String toString() {
        return "BatteryEquipment: " + super.toString() +
                ", batteryNumber = " + batteryNumber;
    }
}
