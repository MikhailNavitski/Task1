package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

public class VacuumCleanerDAOImpl implements Command {


   public Appliance makeAppliance(String fileLine) {
        int[] intLine = new int[10];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            strings[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        intLine[0] = Integer.parseInt(strings[2]);
        intLine[1] = Integer.parseInt(strings[6]);
        intLine[2] = Integer.parseInt(strings[7]);
        vacuumCleaner.setPowerConsumption(intLine[0]);
        vacuumCleaner.setFilterType(strings[3]);
        vacuumCleaner.setBagType(strings[4]);
        vacuumCleaner.setWandType(strings[5]);
        vacuumCleaner.setMotorSpeedRegulation(intLine[1]);
        vacuumCleaner.setCleaningWidth(intLine[2]);
        return vacuumCleaner;
    }


}
