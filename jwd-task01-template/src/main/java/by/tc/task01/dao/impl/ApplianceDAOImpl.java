package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.ApplianceFileReader;
import by.tc.task01.dao.FileReaderFactory;
import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.ApplianceDirectorFactory;
import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException {
        Appliance appliance = null;

        FileReaderFactory factory = FileReaderFactory.getInstance();
        ApplianceFileReader applianceFileReader = factory.getFileReader();

        try (BufferedReader br = new BufferedReader(new FileReader(applianceFileReader.readingFile()))) {
            String fileLine;
            int countOfMatches = 0;
            Map<E, Object> mapOfCriteria = criteria.getCriteria();
            while ((fileLine = br.readLine()) != null) {
                for (Map.Entry entry : mapOfCriteria.entrySet()) {
                    boolean result = match(fileLine, entry.getKey(), entry.getValue());
                    if (result) {
                        countOfMatches++;
                    }
                }
                if (mapOfCriteria.size() == countOfMatches) {
                    appliance = createCommand(criteria,fileLine);
                    break;
                }
                countOfMatches = 0;
            }
            return appliance;
        }
    }

    private static <E> Appliance createCommand(Criteria<E> criteria,String fileLine) {
        Appliance appliance;
        ApplianceDirectorFactory directorFactory = ApplianceDirectorFactory.getInstance();
        ApplianceDirector director = directorFactory.getApplianceDirector();

        String type = criteria.getApplianceType();
        Command command = director.getCommand(type);
        appliance = command.makeAppliance(getValue(fileLine));
        return appliance;
    }

    private static boolean match(String fileLine, Object keyParameter, Object valueParameter) {
        fileLine = fileLine.replace(";", ",");
        String parameter;
        parameter = " " + keyParameter + "=" + valueParameter + ",";
        return fileLine.contains(parameter);
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