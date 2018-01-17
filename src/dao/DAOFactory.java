package dao;

import dao.impl.ApplianceDAOImpl;

public final class DAOFactory {

    private static DAOFactory instance = new DAOFactory();

    private final ApplianceDao applianceDao = new ApplianceDAOImpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDao getApplianceDao() {
        return applianceDao;
    }
}
