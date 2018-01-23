package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;


public class LaptopCreator implements Command {

    public Appliance makeAppliance(String [] value) {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.parseDouble(value[2]));
        laptop.setOs(value[3]);
        laptop.setMemoryRom(Integer.parseInt(value[4]));
        laptop.setSystemMemory(Integer.parseInt(value[5]));
        laptop.setCpu(Double.parseDouble(value[6]));
        laptop.setDisplayInchs(Integer.parseInt(value[7]));
        return laptop;
    }


}
