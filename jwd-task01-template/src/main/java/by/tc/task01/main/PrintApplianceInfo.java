package by.tc.task01.main;

import by.tc.task01.entity.*;

public class PrintApplianceInfo {
    public static void print(Appliance appliance) {

        if (appliance != null) {
            System.out.println(appliance.toString());
        } else {
            System.out.println("Нужный товар не найден");
        }
    }
}
