package by.tc.task01.main.command;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;

public class TabletPCInfo implements Command {
    private Appliance appliance;

    public TabletPCInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("\t\t\tTabletPC\t\t\t");
        System.out.println("------------------------------------------------------");
        System.out.println("BatteryCapacity = " + ((TabletPC) appliance).getBatteryCapacity());
        System.out.println("DisplayInches = " + ((TabletPC) appliance).getDisplayInches());
        System.out.println("MemoryRom = " + ((TabletPC) appliance).getMemoryRom());
        System.out.println("FlashMemoryCapacity = " + ((TabletPC) appliance).getFlashMemoryCapacity());
        System.out.println("Color = " + ((TabletPC) appliance).getColor());
        System.out.println("------------------------------------------------------");
    }
}
