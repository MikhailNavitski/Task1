package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException {

        Appliance appliance;
        File file = new File("jwd-task01-template//src//main//resources//appliances_db.txt");
        int count = 0;
        String type = criteria.getApplianceType();
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
            if (map.size() == count ) {
                ApplianceDirector director = new ApplianceDirector();
                Command command = director.getCommand(type);
                appliance = command.makeAppliance(fileLine);
                return appliance;
            }
            count = 0;
        }
        return null;
    }
}