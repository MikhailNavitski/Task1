package by.tc.task01.service.validation.command;

import by.tc.task01.service.validation.*;

import java.util.HashMap;
import java.util.Map;

public class ValidationDirector {
    private Map<String, CommandValidation> map = new HashMap<>();

   public ValidationDirector() {
        map.put("Laptop", new ValidatorL());
        map.put("Oven", new ValidatorOR());
        map.put("Refrigerator", new ValidatorOR());
        map.put("Speakers", new ValidatorTSV());
        map.put("TabletPC", new ValidatorTSV());
        map.put("VacuumCleaner", new ValidatorTSV());
    }

    public CommandValidation getCommand(String type) {
        CommandValidation commandValidation = map.get(type);
        return commandValidation;
    }
}
