package by.tc.task01.dao.command;

import by.tc.task01.entity.Appliance;

import java.io.IOException;

public interface Command {
    Appliance makeAppliance(String fileLine) throws IOException;
}
