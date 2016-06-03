package com.epam.module3.task3.oop.exception;

public class ConsumptionRangeException extends Exception {
    private double minConsumption;
    private double maxConsumption;

    public ConsumptionRangeException(double minConsumption, double maxConsumption) {
        this.minConsumption = minConsumption;
        this.maxConsumption = maxConsumption;
    }

    public String getMessage() {
        return "[ConsumptionRangeException]: Electronic equipment with consumption range: "
                + minConsumption + "-" + maxConsumption + " was not found";
    }
}
