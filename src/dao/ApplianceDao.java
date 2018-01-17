package dao;

import entity.Appliance;
import entity.criteria.Criteria;

public interface ApplianceDao {
    <E> Appliance find(Criteria<E> criteria);
}
