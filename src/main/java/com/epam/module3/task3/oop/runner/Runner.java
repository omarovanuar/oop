package com.epam.module3.task3.oop.runner;

import com.epam.module3.task3.oop.action.CreateListFromFileAction;
import com.epam.module3.task3.oop.action.ExecuteAction;
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
    private static final String FILE_PATH = "C:\\Users\\Anuar_Omarov\\IdeaProjects\\oop\\electronics-list.txt";
    private static File file = new File(FILE_PATH);
    private static int id;
    private static List<Electronics> list = new ArrayList<>();

    public static void main(String[] args) {
        String tempString;
        boolean repeat = true;
        boolean execute = true;
        boolean repeatReading = true;
        int action = 0;
        int read = 0;
        ReadInterface readInterface;
        Scanner scanner = new Scanner(System.in);
        try {
            while (repeatReading) {
                System.out.println("Choose database, from:\n" +
                        "1 - file\n" +
                        "2 - h2\n" +
                        "3 - xml\n" +
                        "0 - exit");
                try {
                    read = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Incorrect input");
                }
                switch (read) {
                    case 1:
                        readInterface = new ReadFromFileAction();
                        repeatReading = false;
                        break;
                    case 2:
                        readInterface = new ReadFromH2Action();
                        repeatReading = false;
                        break;
                    case 3:
                        readInterface = new ReadFromXMLACtion();
                        repeatReading = false;
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect input, try again");
                        break;
                }
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] strings = tempString.split(":");
                id = Integer.valueOf(strings[0]);
                list = CreateListFromFileAction.create(strings);
            }
            fileReader.close();
            bufferedReader.close();

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
