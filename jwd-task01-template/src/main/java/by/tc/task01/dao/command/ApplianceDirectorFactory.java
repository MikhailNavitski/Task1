package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.ApplianceDirectorImpl;

public class ApplianceDirectorFactory {// для того, чтобы использовать объект в единственно экземпляре существует множество подходов
    // не надо тот, что вам показали, засовывать везде
    // например он для решения этой задачи избыточен, обыкновеного синглтона хватило бы с головой
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
