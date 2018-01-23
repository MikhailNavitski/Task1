package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;


public class RefrigeratorCreator implements Command {

    public Appliance makeAppliance(String[] value) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.parseInt(value[2]));
        refrigerator.setWeight(Integer.parseInt(value[3]));
        refrigerator.setFreezerCapacity(Integer.parseInt(value[4]));
        refrigerator.setoverallCapacity(Double.parseDouble(value[5]));
        refrigerator.setHeight(Integer.parseInt(value[6]));
        refrigerator.setWidth(Integer.parseInt(value[7]));
        return refrigerator;
    }


}
