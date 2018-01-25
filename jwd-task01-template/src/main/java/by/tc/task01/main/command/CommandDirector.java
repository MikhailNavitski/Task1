package by.tc.task01.main.command;

import by.tc.task01.entity.Appliance;

import java.util.HashMap;
import java.util.Map;

public class CommandDirector{
    private Map<Object, Command> map = new HashMap<>();

    public CommandDirector(Appliance appliance) {
        map.put("class by.tc.task01.entity.Laptop", new LaptopInfo(appliance));
        map.put("class by.tc.task01.entity.Oven", new OvenInfo(appliance));
        map.put("class by.tc.task01.entity.Refrigerator", new RefrigeratorInfo(appliance));
        map.put("class by.tc.task01.entity.Speakers", new SpeakersInfo(appliance));
        map.put("class by.tc.task01.entity.TablePC", new TabletPCInfo(appliance));
        map.put("class by.tc.task01.entity.VacuumCleaner", new VacuumCleanerInfo(appliance));
    }

    public Command getCommand(String appliance) {
        Command command;
        command = map.get(appliance);
        return command;
    }
}
