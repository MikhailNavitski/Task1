package by.tc.task01.main.appliance_information;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.main.command.Command;

public class LaptopInfo implements Command {
    private Appliance appliance;

    public LaptopInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\tLaptop\t\t\t");
        System.out.println("batteryCapacity= " + ((Laptop) appliance).getBatteryCapacity());
        System.out.println("OS = " + ((Laptop) appliance).getOS());
        System.out.println("MemoryRom = " + ((Laptop) appliance).getMemoryRom());
        System.out.println("SystemMemory = " + ((Laptop) appliance).getSystemMemory());
        System.out.println("CPU = " + ((Laptop) appliance).getCpu());
        System.out.println("DisplayInches = " + ((Laptop) appliance).getDisplayInches());
        System.out.println("------------------------------------------------------");
    }
}
