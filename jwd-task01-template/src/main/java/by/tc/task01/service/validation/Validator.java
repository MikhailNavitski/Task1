package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.command.CommandValidation;
import by.tc.task01.service.validation.command.ValidationDirector;

import java.util.Map;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        Map<E, Object> mapCriteria = criteria.getCriteria();
        ValidationDirector director = new ValidationDirector();
        int firstMachCount = 0;
        for (Map.Entry entry : mapCriteria.entrySet()) {
            String parameter = getParameter(entry.getKey(), entry.getValue());
            String value = getValue(entry.getKey(), entry.getValue());
            String type = criteria.getApplianceType();
            CommandValidation command = director.getCommand(type);
            firstMachCount = command.execute(value, parameter,firstMachCount);
        }
        return mapCriteria.size() == firstMachCount;
    }

    private static String getValue(Object keyParameter, Object valueParameter) {
        String parameter;
        parameter = keyParameter + "=" + valueParameter + ",";
        String value = null;
        for (int i = 0; i < parameter.length(); i++) {
            value = parameter.substring(parameter.indexOf("=") + 1, parameter.indexOf(","));
        }
        return value;
    }

    private static String getParameter(Object keyParameter, Object valueParameter) {
        String parameter;
        parameter = keyParameter + "=" + valueParameter + ",";
        return parameter;
    }
}

