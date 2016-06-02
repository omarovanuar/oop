package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.interfacee.AddAction;

import java.util.Scanner;

public class AddHighPowerEquipment implements AddAction {
    public Electronics addNewItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the title:");
        String title = scanner.next();
        System.out.println("Enter the price:");
        double price = scanner.nextDouble();
        System.out.println("Enter consumption per hour:");
        double consumption = scanner.nextDouble();
        System.out.println("Is current equipment plugged in:");
        boolean isPluggedIn = scanner.nextBoolean();
        return new HighPowerEquipment(title, price, consumption, isPluggedIn);
    }
}
