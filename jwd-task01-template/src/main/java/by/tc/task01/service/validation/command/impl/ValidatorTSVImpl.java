package by.tc.task01.service.validation.command.impl;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorTSVImpl implements CommandValidation {

    private final static String REGEX_NUM = "\\d+?(.\\d+)?";
    private final static String REGEX_STR = "[a-zA-Z]+";
    private final static String REGEX_FILTER = "[ABC]";
    private final static String REGEX_F = "\\d+-\\d+.?(\\d+)?";
    private final static String REGEX_WAND_TYPE = "[a-z]+-[a-z]+-[a-z]+";
    private final static String REGEX_BAG_TYPE = "[A-Z]+?(\\d+)?(-\\d+)?";

    @Override
    public int execute(String[] fileLine, int secondCount, String parameter) {
        String value = null;
        for (String aLine : fileLine) {
            value = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (parameter.contains("COLOR") || parameter.contains("OS") && value != null && Pattern.compile(REGEX_STR).matcher(value).matches()) {
            secondCount++;
        }
        if (parameter.contains("FILTER_TYPE") && value != null && Pattern.compile(REGEX_FILTER).matcher(value).matches()) {
            secondCount++;
        }
        if (parameter.contains("WAND_TYPE") && value != null && Pattern.compile(REGEX_WAND_TYPE).matcher(value).matches()) {
            secondCount++;
        }
        if (parameter.contains("BAG_TYPE") && value != null && Pattern.compile(REGEX_BAG_TYPE).matcher(value).matches()) {
            secondCount++;
        }
        if (parameter.contains("FREQUENCY_RANGE") && value != null && Pattern.compile(REGEX_F).matcher(value).matches()) {
            secondCount++;
        } else {
            if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
                secondCount++;
            }
        }
        return secondCount;
    }
}

