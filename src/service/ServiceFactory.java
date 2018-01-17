package service;

import service.impl.ApplianceServiceImpl;

public final class ServiceFactory {

    public final static ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {

    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }
    public static ServiceFactory getInstance(){
        return instance;
    }
}
