package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;


public class LaptopDAOImpl implements Command {

    public Appliance makeAppliance(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] strings = fileLine.split(" ");
        Laptop laptop = new Laptop();
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        doubleLine[0] = Double.parseDouble(stringLine[2]);
        doubleLine[1] = Double.parseDouble(stringLine[6]);
        doubleLine[2] = Double.parseDouble(stringLine[6]);
        intLine[0] = Integer.parseInt(stringLine[4]);
        intLine[1] = Integer.parseInt(stringLine[5]);
        intLine[2] = Integer.parseInt(stringLine[7]);
        laptop.setBatteryCapacity(doubleLine[0]);
        laptop.setOs(stringLine[3]);
        laptop.setMemoryRom(intLine[0]);
        laptop.setSystemMemory(intLine[1]);
        laptop.setCpu(doubleLine[1]);
        laptop.setDisplayInchs(intLine[2]);
        return laptop;
    }


}
