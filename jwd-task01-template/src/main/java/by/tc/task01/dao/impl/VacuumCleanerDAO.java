package by.tc.task01.dao.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class VacuumCleanerDAO implements Command {


    private Appliance makeVacuumCleaner(String fileLine) {
        int[] intLine = new int[10];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            strings[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        intLine[0] = Integer.parseInt(strings[2]);
        intLine[1] = Integer.parseInt(strings[6]);
        intLine[2] = Integer.parseInt(strings[7]);
        vacuumCleaner.setPowerConsumption(intLine[0]);
        vacuumCleaner.setFilterType(strings[3]);
        vacuumCleaner.setBagType(strings[4]);
        vacuumCleaner.setWandType(strings[5]);
        vacuumCleaner.setMotorSpeedRegulation(intLine[1]);
        vacuumCleaner.setCleaningWidth(intLine[2]);
        return vacuumCleaner;
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
            if (fileLine.contains("VacuumCleaner") && map.size() == count) {
                appliance = makeVacuumCleaner(fileLine);
                return appliance;
            }
            count = 0;
        }
        return null;
    }
}
