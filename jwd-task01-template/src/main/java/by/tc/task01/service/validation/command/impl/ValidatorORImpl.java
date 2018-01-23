package by.tc.task01.service.validation.command.impl;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorORImpl implements CommandValidation {

    private final static String REGEX_NUM = "\\d+?(.\\d+)?";

    @Override
    public int execute(String value, String parameter,int firstMachCount) {

        if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
            firstMachCount++;
        }
        return firstMachCount;
    }
}
