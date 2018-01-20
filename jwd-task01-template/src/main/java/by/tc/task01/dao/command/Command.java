package by.tc.task01.dao.command;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public interface Command {
    <E>Appliance readingFile(Criteria<E> criteria) throws IOException;
}
