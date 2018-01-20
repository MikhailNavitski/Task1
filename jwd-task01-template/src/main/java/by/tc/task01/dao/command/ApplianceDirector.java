package by.tc.task01.dao.command;

import by.tc.task01.dao.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector  {
    private Map<String, Command> map = new HashMap<>();

    public ApplianceDirector() {
        map.put("Laptop", new LaptopDAO());
        map.put("Oven", new OvenDAO());
        map.put("Refrigerator", new RefrigeratorDAO());
        map.put("Speakers", new SpeakersDAO());
        map.put("TabletPC", new TabletPCDAO());
        map.put("VacuumCleaner", new VacuumCleanerDAO());
    }

   public  Command getCommand(String typeName) {
        Command command;
        command = map.get(typeName);
        return command;
    }
}
