package by.tc.task01.main;

import by.tc.task01.entity.*;

class PrintApplianceInfo {
    static void print(Appliance appliance) {

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
        } else if (appliance == null) {
            System.out.println("Нужный товар не найден\n");
        }
    }
}
