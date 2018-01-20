package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceDAO {
	<E> Appliance find(Criteria<E> criteria) throws IOException;
}
