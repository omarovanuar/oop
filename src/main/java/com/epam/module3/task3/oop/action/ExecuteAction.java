package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.exception.ConsumptionRangeException;
import com.epam.module3.task3.oop.exception.EquipmentNotFoundException;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;
import com.epam.module3.task3.oop.util.Util;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ExecuteAction {
    private static final Comparator<Electronics> PRICE_COMPARATOR = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
    private static final Comparator<Electronics> CONSUMPTION_COMPARATOR = (o1, o2) -> o1.getConsumptionPerHour().compareTo(o2.getConsumptionPerHour());
    private static boolean repeat = true;

    public static boolean execute(int action, int id, List<Electronics> list) throws NoEquipmentsException, ConsumptionRangeException, EquipmentNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        Util utils = new Util();
        switch (action) {
            case 0:
                repeat = false;
                break;
            case 1:
                id++;
                list.add(new AddBatteryEquipment().addNewItem(id));
                break;
            case 2:
                id++;
                list.add(new AddLowPowerEquipment().addNewItem(id));
                break;
            case 3:
                id++;
                list.add(new AddHighPowerEquipment().addNewItem(id));
                break;
            case 4:
                double totalConsumption = CalculateTotalConsumption.calculate(list);
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
        return repeat;
    }
}
