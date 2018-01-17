package service;

import entity.Appliance;
import entity.criteria.Criteria;

public interface ApplianceService {
    <E>Appliance find(Criteria<E> criteria);
}
