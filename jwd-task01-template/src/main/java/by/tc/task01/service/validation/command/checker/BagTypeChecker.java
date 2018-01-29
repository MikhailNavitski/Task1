package by.tc.task01.service.validation.command.checker;

import by.tc.task01.service.validation.command.CommandValidation;

import java.util.regex.Pattern;

public class BagTypeChecker implements CommandValidation {

    @Override
    public int execute(String value, int firstMachCount) {
        if (value != null && Pattern.compile(ConstantReg.REGEX_BAG_TYPE).matcher(value).matches()) {
            firstMachCount++;
        }
        return firstMachCount;
    }
}
