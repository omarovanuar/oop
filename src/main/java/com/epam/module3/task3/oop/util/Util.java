package com.epam.module3.task3.oop.util;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.exception.ConsumptionRangeException;
import com.epam.module3.task3.oop.exception.EquipmentNotFoundException;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Electronics> searchByTitle(String title, List<Electronics> list) throws EquipmentNotFoundException {
        List<Electronics> result = new ArrayList<>();
        for (Electronics electronics : list) {
            if (electronics.getTitle().equals(title)) {
                result.add(electronics);
            }
        }
        if (result.size() == 0)
            throw new EquipmentNotFoundException(title);

        return result;
    }

    public List<Electronics> searchByConsumption(double minConsumption, double maxConsumption, List<Electronics> list) throws ConsumptionRangeException {
        List<Electronics> result = new ArrayList<>();
        for (Electronics electronics : list) {
            if (electronics.getConsumptionPerHour() >= minConsumption && electronics.getConsumptionPerHour() <= maxConsumption) {
                result.add(electronics);
            }
        }
        if (result.size() == 0)
            throw new ConsumptionRangeException(minConsumption, maxConsumption);

        return  result;
    }

    public void showList(List<Electronics> electronics) throws NoEquipmentsException {
        if (electronics.size() == 0)
            throw new NoEquipmentsException();
        for (Electronics item : electronics) {
            System.out.println(item);
        }
    }
}
