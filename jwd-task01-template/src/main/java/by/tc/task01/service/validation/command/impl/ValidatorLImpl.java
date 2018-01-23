package by.tc.task01.service.validation.command.impl;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorLImpl implements CommandValidation {

    private final static String REGEX_NUM = "\\d+?(.\\d+)?";
    private final static String REGEX_STR = "[a-zA-Z]+";

    @Override
    public int execute(String value, String parameter, int firstMachCount) {
        if (parameter.contains("OS") && value != null && Pattern.compile(REGEX_STR).matcher(value).matches()) {
            firstMachCount++;
        } else {
            if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
                firstMachCount++;
            }
        }
        return firstMachCount;
    }
}
