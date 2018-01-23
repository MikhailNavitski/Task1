package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;


public class TabletPCCreator implements Command {


    public Appliance makeAppliance(String [] value) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Integer.parseInt(value[2]));
        tabletPC.setDisplayInches(Integer.parseInt(value[3]));
        tabletPC.setMemoryRom(Integer.parseInt(value[4]));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt(value[5]));
        tabletPC.setColor(value[6]);
        return tabletPC;
    }


}
