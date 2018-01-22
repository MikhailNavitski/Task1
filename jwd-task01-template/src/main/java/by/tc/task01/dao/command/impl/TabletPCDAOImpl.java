package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;


public class TabletPCDAOImpl implements Command {


   public Appliance makeAppliance(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
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
