package by.tc.task01.service.validation.command;

import by.tc.task01.service.validation.command.impl.ValidatorLImpl;
import by.tc.task01.service.validation.command.impl.ValidatorORImpl;
import by.tc.task01.service.validation.command.impl.ValidatorTSVImpl;

import java.util.HashMap;
import java.util.Map;

public class ValidationDirector {
    private Map<String, CommandValidation> map = new HashMap<>();

   public ValidationDirector() {
        map.put("Laptop", new ValidatorLImpl());
        map.put("Oven", new ValidatorORImpl());
        map.put("Refrigerator", new ValidatorORImpl());
        map.put("Speakers", new ValidatorTSVImpl());
        map.put("TabletPC", new ValidatorTSVImpl());
        map.put("VacuumCleaner", new ValidatorTSVImpl());
    }

    public CommandValidation getCommand(String type) {
        CommandValidation commandValidation;
        commandValidation = map.get(type);
        return commandValidation;
    }
}
