package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.main.exception.FileReaderException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

    public static void main(String[] args) {
        try {
            Appliance appliance;

            ServiceFactory factory = ServiceFactory.getInstance();
            ApplianceService service = factory.getApplianceService();

            //////////////////////////////////////////////////////////////////

            Criteria<Oven> criteriaOven = new Criteria<Oven>();
            criteriaOven.setApplianceType("Oven");
            criteriaOven.add(Oven.CAPACITY, 3);

            appliance = service.find(criteriaOven);


            PrintApplianceInfo.print(appliance);

            //////////////////////////////////////////////////////////////////

            criteriaOven = new Criteria<Oven>();
            criteriaOven.setApplianceType("Oven");
            criteriaOven.add(Oven.HEIGHT, 200);
            criteriaOven.add(Oven.DEPTH, 300);

            appliance = service.find(criteriaOven);

            PrintApplianceInfo.print(appliance);

            //////////////////////////////////////////////////////////////////

            Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
            criteriaTabletPC.setApplianceType("TabletPC");
            criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
            criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
            criteriaTabletPC.add(TabletPC.MEMORY_ROM, 4);

            appliance = service.find(criteriaTabletPC);

            PrintApplianceInfo.print(appliance);

            ///////////////////////////////////////////////////////////////////
            Criteria<Speakers> criteriaSpeakers = new Criteria<Speakers>();
            criteriaSpeakers.setApplianceType("Speakers");
            criteriaSpeakers.add(Speakers.NUMBER_OF_SPEAKERS, 2);
            criteriaSpeakers.add(Speakers.POWER_CONSUMPTION, 15);

            appliance = service.find(criteriaSpeakers);

            PrintApplianceInfo.print(appliance);

            /////////////////////////////////////////////////////////////////////
            Criteria<Laptop> criteriaLaptop = new Criteria<Laptop>();
            criteriaLaptop.setApplianceType("Laptop");
            criteriaLaptop.add(Laptop.CPU, 1.2);
            criteriaLaptop.add(Laptop.BATTERY_CAPACITY, 1);

            appliance = service.find(criteriaLaptop);

            PrintApplianceInfo.print(appliance);


            Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<VacuumCleaner>();
            criteriaVacuumCleaner.setApplianceType("VacuumCleaner");
            criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE,"A2");

            appliance = service.find(criteriaVacuumCleaner);

            PrintApplianceInfo.print(appliance);


        } catch (FileReaderException e) {
            System.out.println(e.getMessage());
        }

    }
}
