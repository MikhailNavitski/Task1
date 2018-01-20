package by.tc.task01.dao.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class RefrigeratorDAO implements Command {

    private Appliance makeRefrigerator(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        Refrigerator refrigerator = new Refrigerator();
        intLine[0] = Integer.parseInt(stringLine[2]);
        intLine[1] = Integer.parseInt(stringLine[3]);
        intLine[2] = Integer.parseInt(stringLine[4]);
        intLine[3] = Integer.parseInt(stringLine[6]);
        intLine[4] = Integer.parseInt(stringLine[7]);
        doubleLine[0] = Double.parseDouble(stringLine[5]);
        refrigerator.setPowerConsumption(intLine[0]);
        refrigerator.setWeight(intLine[1]);
        refrigerator.setFreezerCapacity(intLine[2]);
        refrigerator.setoverallCapacity(doubleLine[0]);
        refrigerator.setHeight(intLine[3]);
        refrigerator.setWidth(intLine[4]);
        return refrigerator;
    }

    @Override
    public <E> Appliance readingFile(Criteria<E> criteria) throws IOException {
        Appliance appliance;
        File file = new File("jwd-task01-template//src//main//resources//appliances_db");
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
            if (fileLine.contains("Refrigerator") && map.size() == count) {
                appliance = makeRefrigerator(fileLine);
                return appliance;
            }
            count = 0;
        }
        return null;
    }
}
