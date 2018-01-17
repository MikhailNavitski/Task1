package dao.impl;

import dao.ApplianceDao;
import entity.Appliance;
import entity.criteria.Criteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDao {
    private static Appliance appliance = null;

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        File file = new File("resources//appliances_db");
        int count = 0;
        boolean flag = true;
        try {
            Scanner scanner = new Scanner(file);
            Map<E, Object> map = criteria.getCriteria();
            while (scanner.hasNextLine() && flag == true) {
                String type = criteria.getApplianceType();
                String line = scanner.nextLine();
                line = line.replace(";", ",");
                String s;
                for (Map.Entry entry : map.entrySet()) {
                    s = " " + entry.getKey() + "=" + entry.getValue() + ",";
                    if (line.contains(s)) {
                        count++;
                    }
                }
                if (map.size() == count && type == "Oven" && line.contains("Oven")) {

                    OvenDAO ovenDAO = new OvenDAO(line);
                    appliance = ovenDAO.makeOven();
                    return appliance;

                } else if (map.size() == count && type == "Laptop" && line.contains("Laptop")) {

                    LaptopDAO laptopDAO = new LaptopDAO(line);
                    appliance = laptopDAO.makeLaptop();
                    return appliance;

                } else if (map.size() == count && type == "Refrigerator" && line.contains("Refrigerator")) {

                    RefrigeratorDAO refrigeratorDAO = new RefrigeratorDAO(line);
                    appliance = refrigeratorDAO.makeRefrigerator();
                    return appliance;

                } else if (map.size() == count && type == "VacuumCleaner" && line.contains("VacuumCleaner")) {

                    VacuumCleanerDAO vacuumCleanerDAO = new VacuumCleanerDAO(line);
                    appliance = vacuumCleanerDAO.makeVacuumCleaner();
                    return appliance;

                } else if (map.size() == count && type == "TabletPC" && line.contains("TabletPC")) {

                    TabletPCDAO tabletPCDAO = new TabletPCDAO(line);
                    appliance = tabletPCDAO.makeTabletPC();
                    return appliance;

                } else if (map.size() == count && type == "Speakers" && line.contains("Speakers")) {
                    SpeakersDAO speakersDAO = new SpeakersDAO(line);
                    appliance = speakersDAO.makeSpeakers();
                    return appliance;
                }
                count = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}



