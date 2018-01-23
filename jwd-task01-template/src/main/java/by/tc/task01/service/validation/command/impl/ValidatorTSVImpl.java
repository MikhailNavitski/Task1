package by.tc.task01.service.validation.command.impl;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class ValidatorTSVImpl implements CommandValidation {

    private static final String REGEX_NUM = "\\d+?(.\\d+)?";
    private static final String REGEX_STR = "[a-zA-Z]+";
    private static final String REGEX_FILTER = "[ABC]";
    private static final String REGEX_F = "\\d+-\\d+.?(\\d+)?";
    private static final String REGEX_WAND_TYPE = "[a-z]+-[a-z]+-[a-z]+";
    private static final String REGEX_BAG_TYPE = "[A-Z]+?(\\d+)?(-\\d+)?";

    @Override
    public int execute(String value, String parameter, int firstMachCount) {
        if (parameter.contains("COLOR") || parameter.contains("OS") && value != null && Pattern.compile(REGEX_STR).matcher(value).matches()) {
            firstMachCount++;
        }
        if (parameter.contains("FILTER_TYPE") && value != null && Pattern.compile(REGEX_FILTER).matcher(value).matches()) {
            firstMachCount++;
        }
        if (parameter.contains("WAND_TYPE") && value != null && Pattern.compile(REGEX_WAND_TYPE).matcher(value).matches()) {
            firstMachCount++;
        }
        if (parameter.contains("BAG_TYPE") && value != null && Pattern.compile(REGEX_BAG_TYPE).matcher(value).matches()) {
            firstMachCount++;
        }
        if (parameter.contains("FREQUENCY_RANGE") && value != null && Pattern.compile(REGEX_F).matcher(value).matches()) {
            firstMachCount++;
        } else {
            if (value != null && Pattern.compile(REGEX_NUM).matcher(value).matches()) {
                firstMachCount++;
            }
        }
        return firstMachCount;
    }
}

