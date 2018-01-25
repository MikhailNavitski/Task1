package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.Command;
import by.tc.task01.dao.creator.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirectorImpl implements ApplianceDirector {
    private Map<String, Command> map = new HashMap<>();

    public ApplianceDirectorImpl()  {
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
