package dao.impl;

import entity.Appliance;
import entity.Oven;

public class OvenDAO {
    public String line;

    public OvenDAO(String line) {
        this.line = line;
    }

    public Appliance makeOven() {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] a = line.split(" ");
        Oven oven = new Oven();
        for (int i = 2; i < a.length; i++) {
            stringLine[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
        }
        for (int i = 2; i < stringLine.length - 2; i++) {
            intLine[i] = Integer.parseInt(stringLine[i]);
        }
        doubleLine[0] = Double.parseDouble(stringLine[6]);
        doubleLine[1] = Double.parseDouble(stringLine[7]);
        oven.setPowerConsumption(intLine[2]);
        oven.setWeight(intLine[3]);
        oven.setCapacity(intLine[4]);
        oven.setDepth(intLine[5]);
        oven.setHeight(doubleLine[0]);
        oven.setWidth(doubleLine[1]);
        return oven;
    }
}
