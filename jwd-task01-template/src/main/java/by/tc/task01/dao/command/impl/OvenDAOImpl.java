package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class OvenDAOImpl implements Command {

    private Appliance makeOven(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] strings = fileLine.split(" ");
        Oven oven = new Oven();
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
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


    @Override
    public <E> Appliance readingFile(Criteria<E> criteria) throws IOException {
        Appliance appliance;
        File file = new File("jwd-task01-template//src//main//resources//appliances_db.txt");
        int count = 0;
        Scanner scanner = new Scanner(file);
        Map<E, Object> map = criteria.getCriteria();
        while (scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            fileLine = fileLine.replace(";", ",");
            String parameter;
            for (Map.Entry entry : map.entrySet()) {
                parameter = " " + entry.getKey() + "=" + entry.getValue() + ",";
                if (fileLine.contains(parameter)) {
                    count++;
                }
            }
            if (fileLine.contains("Oven") && map.size() == count) {
                appliance = makeOven(fileLine);
                return appliance;
            }
            count = 0;
        }
        return null;
    }
}
