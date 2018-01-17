package dao.impl;

import entity.Appliance;
import entity.Refrigerator;

public class RefrigeratorDAO {
    public String line;

    public RefrigeratorDAO(String line) {
        this.line = line;
    }

    public Appliance makeRefrigerator() {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] a = line.split(" ");
        for (int i = 2; i < a.length; i++) {
            stringLine[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
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
