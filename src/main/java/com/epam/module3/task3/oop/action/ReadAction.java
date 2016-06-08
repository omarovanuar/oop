package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.interfacee.ReadInterface;

import java.util.Scanner;

public class ReadAction {
    private static boolean repeatReading = true;
    private static ReadInterface readInterface;

    public static ReadInterface getReadInterface() {
        int readInt;
        while (repeatReading) {
            System.out.println("Choose database, from:\n" +
                    "1 - file\n" +
                    "2 - h2\n" +
                    "3 - xml\n" +
                    "0 - exit");
            try {
                readInt = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                continue;
            }
            switch (readInt) {
                case 1:
                    readInterface = new ReadFromFileAction();
                    repeatReading = false;
                    break;
                case 2:
                    readInterface = new ReadFromH2Action();
                    repeatReading = false;
                    break;
                case 3:
                    readInterface = new ReadFromXMLAction();
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
        return readInterface;
    }
}
