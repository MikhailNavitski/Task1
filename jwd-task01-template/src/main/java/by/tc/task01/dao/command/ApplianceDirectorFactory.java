package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.ApplianceDirectorImpl;

public class ApplianceDirectorFactory {
    private static final ApplianceDirectorFactory instance = new ApplianceDirectorFactory();

    private final ApplianceDirector applianceDirector = new ApplianceDirectorImpl();

    private ApplianceDirectorFactory() {
    }

    public ApplianceDirector getApplianceDirector() {
        return applianceDirector;
    }

    public static ApplianceDirectorFactory getInstance() {
        return instance;
    }
}
