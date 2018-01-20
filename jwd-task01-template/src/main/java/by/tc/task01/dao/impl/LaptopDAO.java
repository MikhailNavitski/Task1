package by.tc.task01.dao.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class LaptopDAO implements Command {

    private Appliance makeLaptop(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        double[] doubleLine = new double[4];
        String[] strings = fileLine.split(" ");
        Laptop laptop = new Laptop();
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
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

    @Override
    public <E> Appliance readingFile(Criteria<E> criteria) throws IOException {
        Appliance appliance;
        File file = new File("resources//appliances_db.txt");
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
            if (fileLine.contains("Laptop") && map.size() == count) {
                appliance = makeLaptop(fileLine);
                return appliance;
            }
            count = 0;
        }

        return null;
    }
}
