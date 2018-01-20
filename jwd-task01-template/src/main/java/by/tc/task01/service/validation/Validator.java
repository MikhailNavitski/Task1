package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.command.CommandValidation;
import by.tc.task01.service.validation.command.ValidationDirector;

import java.util.Map;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        String parameter;
        int firstCount = 0;
        int secondCount = 0;
        String type = criteria.getApplianceType();
        Map<E, Object> map = criteria.getCriteria();

        ValidationDirector director = new ValidationDirector();
        for (Map.Entry entry : map.entrySet()) {
            parameter = entry.getKey() + "=" + entry.getValue() + ",";
            firstCount++;
            String[] fileLine = parameter.split(" ");


            CommandValidation command = director.getCommand(type);
            secondCount = command.execute(fileLine, secondCount, parameter);
        }
        return map.size() == firstCount && map.size() == secondCount;
    }
}

