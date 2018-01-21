package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {
    private Map<String, Command> map = new HashMap<>();

    public ApplianceDirector() {
        map.put("Laptop", new LaptopDAOImpl());
        map.put("Oven", new OvenDAOImpl());
        map.put("Refrigerator", new RefrigeratorDAOImpl());
        map.put("Speakers", new SpeakersDAOImpl());
        map.put("TabletPC", new TabletPCDAOImpl());
        map.put("VacuumCleaner", new VacuumCleanerDAOImpl());
    }

    public Command getCommand(String typeName) {
        Command command;
        command = map.get(typeName);
        return command;
    }
}
