package by.tc.task01.dao.command;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class CommandCreator {
    public static <E> Appliance createCommand(Criteria<E> criteria, String fileLine) {
        Appliance appliance;
        ApplianceDirectorFactory directorFactory = ApplianceDirectorFactory.getInstance();
        ApplianceDirector director = directorFactory.getApplianceDirector();

        String type = criteria.getApplianceType();
        Command command = director.getCommand(type);
        appliance = command.makeAppliance(getValue(fileLine));
        return appliance;
    }

    private static String[] getValue(String fileLine) {
        fileLine = fileLine.replace(";", ",");
        String[] value = fileLine.split(" ");
        for (int i = 2; i < value.length; i++) {
            value[i] = value[i].substring(value[i].indexOf('=') + 1, value[i].indexOf(','));
        }
        return value;
    }
}
