package entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {
    private Map<E, Object> criteria = new HashMap<>();
    private String applianceType;

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

}
