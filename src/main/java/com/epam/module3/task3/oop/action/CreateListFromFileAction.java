package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;

import java.util.ArrayList;
import java.util.List;

public class CreateListFromFileAction {
    private static List<Electronics> electronics = new ArrayList<>();

    public static List<Electronics> create(String[] strings) {
        switch (strings[1]) {
            case "BatteryEquipment":
                electronics.add(new BatteryEquipment(Integer.valueOf(strings[0]), strings[2], Double.valueOf(strings[3]), Double.valueOf(strings[4]), Integer.valueOf(strings[5])));
                break;
            case "HighPowerEquipment":
                electronics.add(new HighPowerEquipment(Integer.valueOf(strings[0]), strings[2], Double.valueOf(strings[3]), Double.valueOf(strings[4]), Boolean.valueOf(strings[5])));
                break;
            case "LowPowerEquipment":
                electronics.add(new LowPowerEquipment(Integer.valueOf(strings[0]), strings[2], Double.valueOf(strings[3]), Double.valueOf(strings[4]), Boolean.valueOf(strings[5])));
                break;
            default:
                throw new RuntimeException();
        }
        return electronics;
    }
}
