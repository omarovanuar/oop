package com.epam.module3.task3.oop.runner;

import com.epam.module3.task3.oop.action.*;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.exception.ConsumptionRangeException;
import com.epam.module3.task3.oop.exception.EquipmentNotFoundException;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;
import com.epam.module3.task3.oop.interfacee.ReadInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static List<Electronics> list = new ArrayList<>();

    public static void main(String[] args) {

        boolean repeat = true;
        boolean execute = true;
        int action = 0;
        ReadInterface readInterface;
        Scanner scanner = new Scanner(System.in);
        try {
            readInterface = ReadAction.getReadInterface();
            readInterface.read();
            int id = readInterface.getId();
            list = readInterface.getList();
            while (repeat) {
                System.out.println("\nChoose your action:\n" +
                        "1 - add new battery equipment\n" +
                        "2 - add new low power equipment\n" +
                        "3 - add new high power equipment\n" +
                        "4 - calculate total consumption\n" +
                        "5 - search by title\n" +
                        "6 - search by consumption per hour range\n" +
                        "7 - list all electronics\n" +
                        "8 - sort by price\n" +
                        "9 - sort by power consumption\n" +
                        "0 - exit");
                try {
                    action = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Incorrect input");
                }
                try {
                    execute = ExecuteAction.execute(action, id, list);
                } catch (NoEquipmentsException | ConsumptionRangeException | EquipmentNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Something is going wrong... try again");
                }
                repeat = execute;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
