package by.tc.task01.service.validation.command;

import by.tc.task01.service.validation.command.checker.BagTypeChecker;
import by.tc.task01.service.validation.command.checker.FilterTypeChecker;
import by.tc.task01.service.validation.command.checker.StringChecker;
import by.tc.task01.service.validation.command.checker.WandTypeChecker;
import by.tc.task01.service.validation.command.checker.IntegerChecker;
import by.tc.task01.service.validation.command.checker.FrequencyRangeChecker;

import java.util.HashMap;
import java.util.Map;

public class ValidationDirector {
    private Map<String, CommandValidation> map = new HashMap<>();

    public ValidationDirector() {
        map.put("OS", new StringChecker());
        map.put("COLOR", new StringChecker());
        map.put("FILTER_TYPE", new FilterTypeChecker());
        map.put("WAND_TYPE", new WandTypeChecker());
        map.put("BAG_TYPE", new BagTypeChecker());
        map.put("FREQUENCY_RANGE", new FrequencyRangeChecker());
        map.put("POWER_CONSUMPTION", new IntegerChecker());
        map.put("WEIGHT", new IntegerChecker());
        map.put("CAPACITY", new IntegerChecker());
        map.put("DEPTH", new IntegerChecker());
        map.put("HEIGHT", new IntegerChecker());
        map.put("WIDTH", new IntegerChecker());
        map.put("BATTERY_CAPACITY", new IntegerChecker());
        map.put("MEMORY_ROM", new IntegerChecker());
        map.put("SYSTEM_MEMORY", new IntegerChecker());
        map.put("CPU", new IntegerChecker());
        map.put("DISPLAY_INCHES", new IntegerChecker());
        map.put("FREEZER_CAPACITY", new IntegerChecker());
        map.put("OVERALL_CAPACITY", new IntegerChecker());
        map.put("MOTOR_SPEED_REGULATION", new IntegerChecker());
        map.put("CLEANING_WIDTH", new IntegerChecker());
        map.put("FLASH_MEMORY_CAPACITY", new IntegerChecker());
        map.put("NUMBER_OF_SPEAKERS", new IntegerChecker());
        map.put("CORD_LENGTH", new IntegerChecker());
    }

    public CommandValidation getCommand(String type) {
        CommandValidation commandValidation;
        commandValidation = map.get(type);
        return commandValidation;
    }
}
