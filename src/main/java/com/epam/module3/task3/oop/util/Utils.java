package com.epam.module3.task3.oop.util;

import com.epam.module3.task3.oop.entity.Electronics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utils {

    public List<Electronics> searchByTitle(String title, List<Electronics> list) {
        List<Electronics> result = new ArrayList<Electronics>();
        for (Electronics electronics : list) {
            if (electronics.getTitle().equals(title)) {
                result.add(electronics);
            }
        }
        return  result;
    }

    public List<Electronics> searchByConsumption(double minConsumption, double maxConsumption, List<Electronics> list) {
        List<Electronics> result = new ArrayList<Electronics>();
        for (Electronics electronics : list) {
            if (electronics.getConsumptionPerHour() >= minConsumption && electronics.getConsumptionPerHour() <= maxConsumption) {
                result.add(electronics);
            }
        }
        return  result;
    }

    public void showList(List<Electronics> electronics) {
        for (Electronics item : electronics) {
            System.out.println(item);
        }
    }
}
