package com.epam.module3.task3.oop.runner;

import com.epam.module3.task3.oop.action.AddBatteryEquipment;
import com.epam.module3.task3.oop.action.AddHighPowerEquipment;
import com.epam.module3.task3.oop.action.AddLowPowerEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;
import com.epam.module3.task3.oop.util.Utils;

import java.util.*;

public class Runner {
    private static final Comparator<Electronics> PRICE_COMPARATOR = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
    private static final Comparator<Electronics> CONSUMPTION_COMPARATOR = (o1, o2) -> o1.getConsumptionPerHour().compareTo(o2.getConsumptionPerHour());

    public static void main(String[] args) {
        boolean repeat = true;
        int action = 0;
        Scanner scanner = new Scanner(System.in);
        List<Electronics> list = new ArrayList<Electronics>();
        Utils utils = new Utils();

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
            switch (action) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    list.add(new AddBatteryEquipment().addNewItem());
                    break;
                case 2:
                    list.add(new AddLowPowerEquipment().addNewItem());
                    break;
                case 3:
                    list.add(new AddHighPowerEquipment().addNewItem());
                    break;
                case 4:
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
                    System.out.println(totalConsumption);
                    break;
                case 5:
                    System.out.println("Enter the searching title");
                    String title = scanner.next();
                    List<Electronics> electronicsByTitle = utils.searchByTitle(title, list);
                    utils.showList(electronicsByTitle);
                    break;
                case 6:
                    System.out.println("Enter min of the consumption");
                    double minConsumption = scanner.nextInt();
                    System.out.println("Enter max of the consumption");
                    double maxConsumption = scanner.nextInt();
                    List<Electronics> electronicsByConsumption = utils.searchByConsumption(minConsumption, maxConsumption, list);
                    utils.showList(electronicsByConsumption);
                    break;
                case 7:
                    utils.showList(list);
                    break;
                case 8:
                    Collections.sort(list, PRICE_COMPARATOR);
                    utils.showList(list);
                    break;
                case 9:
                    Collections.sort(list, CONSUMPTION_COMPARATOR);
                    utils.showList(list);
                    break;
                default:
                    System.out.println("Incorrect input, try again");
                    break;
            }
        }
    }
}
