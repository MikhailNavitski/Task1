package dao.impl;

import entity.Appliance;
import entity.Laptop;

public class LaptopDAO {
    public String line;

    public LaptopDAO(String line) {
        this.line = line;
    }

    public Appliance makeLaptop() {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] a = line.split(" ");
        Laptop laptop = new Laptop();
        for (int i = 2; i < a.length; i++) {
            stringLine[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
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
