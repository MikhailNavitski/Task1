package main;

import entity.*;

public class PrintApplianceInfo {
    public static void printApplianceInfo(Appliance appliance) {

        if (appliance instanceof Oven) {
            System.out.println(appliance.toString());
        } else if (appliance instanceof Laptop) {

            System.out.println(appliance.toString());
        } else if (appliance instanceof Refrigerator) {

            System.out.println(appliance.toString());

        } else if (appliance instanceof VacuumCleaner) {

            System.out.println(appliance.toString());

        } else if (appliance instanceof TabletPC) {

            System.out.println(appliance.toString());

        } else if (appliance instanceof Speakers) {

            System.out.println(appliance.toString());
        }
    }
}

