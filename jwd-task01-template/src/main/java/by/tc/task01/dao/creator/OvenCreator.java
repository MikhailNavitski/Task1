package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;


public class OvenCreator implements Command {

    public Appliance makeAppliance(String[] value) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.parseInt(value[2]));// константные знаение в коде должны быть именованы, ты помнишь, что означает твое 2?
        oven.setWeight(Integer.parseInt(value[3]));
        oven.setCapacity(Integer.parseInt(value[4]));
        oven.setDepth(Integer.parseInt(value[5]));
        oven.setHeight(Double.parseDouble(value[6]));
        oven.setWidth(Double.parseDouble(value[7]));
        return oven;
    }


}
