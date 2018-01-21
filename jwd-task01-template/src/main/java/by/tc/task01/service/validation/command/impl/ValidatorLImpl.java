package by.tc.task01.service.validation.command.impl;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorLImpl implements CommandValidation {

    private final static String REGEX_NUM = "\\d+?(.\\d+)?";
    private final static String REGEX_STR = "[a-zA-Z]+";

    @Override
    public int execute(String[] fileLine, int secondCount, String parameter) {
        String value = null;
        for (String aLine : fileLine) {
            value = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (parameter.contains("OS") && value != null && Pattern.compile(REGEX_STR).matcher(value).matches()) {
            secondCount++;
        } else {
            if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
                secondCount++;
            }
        }
        return secondCount;
    }
}
