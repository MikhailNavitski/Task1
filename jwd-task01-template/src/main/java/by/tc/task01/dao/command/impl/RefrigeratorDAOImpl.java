package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;


public class RefrigeratorDAOImpl implements Command {

    public Appliance makeAppliance(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        Refrigerator refrigerator = new Refrigerator();
        intLine[0] = Integer.parseInt(stringLine[2]);
        intLine[1] = Integer.parseInt(stringLine[3]);
        intLine[2] = Integer.parseInt(stringLine[4]);
        intLine[3] = Integer.parseInt(stringLine[6]);
        intLine[4] = Integer.parseInt(stringLine[7]);
        doubleLine[0] = Double.parseDouble(stringLine[5]);
        refrigerator.setPowerConsumption(intLine[0]);
        refrigerator.setWeight(intLine[1]);
        refrigerator.setFreezerCapacity(intLine[2]);
        refrigerator.setoverallCapacity(doubleLine[0]);
        refrigerator.setHeight(intLine[3]);
        refrigerator.setWidth(intLine[4]);
        return refrigerator;
    }


}
