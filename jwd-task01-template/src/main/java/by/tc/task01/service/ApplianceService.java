package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.main.exception.FileReaderException;

public interface ApplianceService {

    <E> Appliance find(Criteria<E> criteria) throws FileReaderException;

}
