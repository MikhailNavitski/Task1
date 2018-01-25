package by.tc.task01.main.command;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;


public class RefrigeratorInfo implements Command {
    private Appliance appliance;

    public RefrigeratorInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\tRefrigerator\t\t\t");
        System.out.println("PowerConsumption = " + ((Refrigerator) appliance).getPowerConsumption());
        System.out.println("Weight = " + ((Refrigerator) appliance).getWeight());
        System.out.println("FreezerCapacity = " + ((Refrigerator) appliance).getFreezerCapacity());
        System.out.println("OverallCapacity= " + ((Refrigerator) appliance).getOverallCapacity());
        System.out.println("Height = " + ((Refrigerator) appliance).getHeight());
        System.out.println("Width = " + ((Refrigerator) appliance).getWidth());
        System.out.println("------------------------------------------------------");
    }
}
