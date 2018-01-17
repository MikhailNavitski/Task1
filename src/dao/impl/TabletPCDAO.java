package dao.impl;

import entity.Appliance;
import entity.TabletPC;

public class TabletPCDAO {
    public String line;

    public TabletPCDAO(String line) {
        this.line = line;
    }

    public Appliance makeTabletPC() {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        String[] a = line.split(" ");
        for (int i = 2; i < a.length; i++) {
            stringLine[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
        }
        TabletPC tabletPC = new TabletPC();
        intLine[0] = Integer.parseInt(stringLine[2]);
        intLine[1] = Integer.parseInt(stringLine[3]);
        intLine[2] = Integer.parseInt(stringLine[4]);
        intLine[3] = Integer.parseInt(stringLine[5]);
        tabletPC.setBatteryCapacity(intLine[0]);
        tabletPC.setDisplayInches(intLine[1]);
        tabletPC.setMemoryRom(intLine[2]);
        tabletPC.setFlashMemoryCapacity(intLine[3]);
        tabletPC.setColor(stringLine[6]);
        return tabletPC;
    }
}
