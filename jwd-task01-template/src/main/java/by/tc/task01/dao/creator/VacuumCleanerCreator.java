package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

public class VacuumCleanerCreator implements Command {


    public Appliance makeAppliance(String[] value) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.parseInt(value[2]));
        vacuumCleaner.setFilterType(value[3]);
        vacuumCleaner.setBagType(value[4]);
        vacuumCleaner.setWandType(value[5]);
        vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(value[6]));
        vacuumCleaner.setCleaningWidth(Integer.parseInt(value[7]));
        return vacuumCleaner;
    }


}
