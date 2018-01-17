package service.impl;

import dao.ApplianceDao;
import dao.DAOFactory;
import entity.Appliance;
import entity.criteria.Criteria;
import service.ApplianceService;
import service.validation.Validator;


public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            System.out.println("\nВалидация не пройдена\n");
            return null;
        }
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDao applianceDao = factory.getApplianceDao();
        Appliance appliance = applianceDao.find(criteria);
        return appliance;
    }
}
