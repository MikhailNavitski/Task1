package by.tc.task01.service.validation;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorOR implements CommandValidation {

    private final static String REGEX_NUM = "\\d+?(.\\d+)?";

    @Override
    public int execute(String[] fileLine, int secondCount, String parameter) {
        String value = null;
        for (String aLine : fileLine) {
            value = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
            secondCount++;
        }
        return secondCount;
    }
}
