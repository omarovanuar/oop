package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.interfacee.AddInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddBatteryEquipment implements AddInterface {
    private static final String FILE_PATH = "C:\\Users\\Anuar_Omarov\\IdeaProjects\\oop\\electronics-list.txt";

    public Electronics addNewItem(int id) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the title:");
        String title = scanner.nextLine();
        System.out.println("Enter the price:");
        double price = scanner.nextDouble();
        System.out.println("Enter consumption per hour:");
        double consumption = scanner.nextDouble();
        System.out.println("Enter number of batteries:");
        int number = scanner.nextInt();
        File file = new File(FILE_PATH);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(id + ":BatteryEquipment:" + title + ":" + price + ":" + consumption + ":" + number + "\n");
        fileWriter.close();
        return new BatteryEquipment(id, title, price, consumption, number);
    }
}
