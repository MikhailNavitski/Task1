package by.tc.task01.main.appliance_information;


import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.main.command.Command;

public class VacuumCleanerInfo implements Command {
    private Appliance appliance;

    public VacuumCleanerInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\tVacuumCleaner\t\t\t");
        System.out.println("PowerConsumption = " + ((VacuumCleaner) appliance).getPowerConsumption());
        System.out.println("FilterType = " + ((VacuumCleaner) appliance).getFilterType());
        System.out.println("BagType = " + ((VacuumCleaner) appliance).getBagType());
        System.out.println("WandType = " + ((VacuumCleaner) appliance).getWandType());
        System.out.println("MotorSpeedRegulation = " + ((VacuumCleaner) appliance).getMotorSpeedRegulation());
        System.out.println("CleaningWidth = " + ((VacuumCleaner) appliance).getCleaningWidth());
        System.out.println("------------------------------------------------------");
    }
}
