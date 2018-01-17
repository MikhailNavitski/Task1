package main;


import entity.Appliance;
import entity.criteria.Criteria;
import service.ApplianceService;
import service.ServiceFactory;

import static entity.criteria.SearchCriteria.*;

public class Main {

    public static void main(String[] args) {

        Appliance appliance;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria<Oven> criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.POWER_CONSUMPTION, 1_000);
        appliance = service.find(criteriaOven);
        PrintApplianceInfo.printApplianceInfo(appliance);

        Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<>();
        criteriaVacuumCleaner.setApplianceType("VacuumCleaner");
        criteriaVacuumCleaner.add(VacuumCleaner.POWER_CONSUMPTION, 100);
        appliance = service.find(criteriaVacuumCleaner);
        PrintApplianceInfo.printApplianceInfo(appliance);

        Criteria<TabletPC> criteriaTabletPC = new Criteria<>();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(TabletPC.BATTERY_CAPACITY, "33HHHH");
        criteriaTabletPC.add(TabletPC.COLOR, "blue");
        appliance = service.find(criteriaTabletPC);
        PrintApplianceInfo.printApplianceInfo(appliance);
    }
}
