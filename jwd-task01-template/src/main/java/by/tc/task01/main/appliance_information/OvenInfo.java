package by.tc.task01.main.appliance_information;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.main.command.Command;

public class OvenInfo implements Command {
    private Appliance appliance;

    public OvenInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\tOven\t\t\t");
        System.out.println("PowerConsumption = " + ((Oven) appliance).getPowerConsumption());
        System.out.println("Weight = " + ((Oven) appliance).getWeight());
        System.out.println("Capacity = " + ((Oven) appliance).getCapacity());
        System.out.println("Depth = " + ((Oven) appliance).getDepth());
        System.out.println("Height = " + ((Oven) appliance).getHeight());
        System.out.println("Width = " + ((Oven) appliance).getWidth());
        System.out.println("------------------------------------------------------");

    }
}
