package dao.impl;

import entity.Appliance;
import entity.VacuumCleaner;

public class VacuumCleanerDAO {
    public String line;

    public VacuumCleanerDAO(String line) {
        this.line = line;
    }

    public Appliance makeVacuumCleaner() {
        int[] intLine = new int[10];
        String[] a = line.split(" ");
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
        }
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        intLine[0] = Integer.parseInt(a[2]);
        intLine[1] = Integer.parseInt(a[6]);
        intLine[2] = Integer.parseInt(a[7]);
        vacuumCleaner.setPowerConsumption(intLine[0]);
        vacuumCleaner.setFilterType(a[3]);
        vacuumCleaner.setBagType(a[4]);
        vacuumCleaner.setWandType(a[5]);
        vacuumCleaner.setMotorSpeedRegulation(intLine[1]);
        vacuumCleaner.setCleaningWidth(intLine[2]);
        return vacuumCleaner;
    }
}
