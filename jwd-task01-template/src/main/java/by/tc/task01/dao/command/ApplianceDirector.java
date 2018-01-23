package by.tc.task01.dao.command;

import by.tc.task01.dao.creator.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {
    private Map<String, Command> map = new HashMap<>();

    public ApplianceDirector() {
        map.put("Laptop", new LaptopCreator());
        map.put("Oven", new OvenCreator());
        map.put("Refrigerator", new RefrigeratorCreator());
        map.put("Speakers", new SpeakersCreator());
        map.put("TabletPC", new TabletPCCreator());
        map.put("VacuumCleaner", new VacuumCleanerCreator());
    }

    public Command getCommand(String typeName) {
        Command command;
        command = map.get(typeName);
        return command;
    }
}
