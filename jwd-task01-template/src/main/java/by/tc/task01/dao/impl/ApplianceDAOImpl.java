package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;


public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException {


        ApplianceDirector director = new ApplianceDirector();

        String type = criteria.getApplianceType();

        Command command = director.getCommand(type);
        Appliance appliance = command.readingFile(criteria);
        return appliance;


    }

}