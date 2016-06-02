package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.interfacee.AddAction;

import java.util.Scanner;

public class AddBatteryEquipment implements AddAction {
    public Electronics addNewItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the title:");
        String title = scanner.next();
        System.out.println("Enter the price:");
        double price = scanner.nextDouble();
        System.out.println("Enter consumption per hour:");
        double consumption = scanner.nextDouble();
        System.out.println("Enter number of batteries:");
        int number = scanner.nextInt();
        return new BatteryEquipment(title, price, consumption, number);
    }
}
