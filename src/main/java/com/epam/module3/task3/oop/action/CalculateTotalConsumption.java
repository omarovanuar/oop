package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;

import java.util.List;

public class CalculateTotalConsumption {
    public static double calculate(List<Electronics> list) throws NoEquipmentsException {
        double totalConsumption = 0;
        for (Electronics electronics : list) {
            if (LowPowerEquipment.class.isInstance(electronics)) {
                LowPowerEquipment lowPowerEquipment = (LowPowerEquipment) electronics;
                if (lowPowerEquipment.isPluggedIn()) {
                    totalConsumption += lowPowerEquipment.getConsumptionPerMonth();
                }
            } else if (HighPowerEquipment.class.isInstance(electronics)) {
                HighPowerEquipment highPowerEquipment = (HighPowerEquipment) electronics;
                if (highPowerEquipment.isPluggedIn()) {
                    totalConsumption += highPowerEquipment.getConsumptionPerMonth();
                }
            }
        }
        if (totalConsumption == 0) {
            throw new NoEquipmentsException();
        }
        return totalConsumption;
    }
}
