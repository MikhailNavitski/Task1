package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.main.exception.FileReaderException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.io.IOException;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws FileReaderException {
        try {
            if (!Validator.criteriaValidator(criteria)) {
                return null;
            }
            DAOFactory factory = DAOFactory.getInstance();
            ApplianceDAO applianceDAO = factory.getApplianceDAO();
            Appliance appliance = applianceDAO.find(criteria);
            return appliance;
        } catch (IOException e) {
            throw new FileReaderException("Ошибка чтения данных , нужный файл не найден");
        }

    }
}

