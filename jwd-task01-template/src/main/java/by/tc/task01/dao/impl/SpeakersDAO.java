package by.tc.task01.dao.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class SpeakersDAO implements Command {


    private Appliance makeSpeakers(String fileLine) {
        String[] stringLine = new String[8];
        int[] intLine = new int[8];
        String[] strings = fileLine.split(" ");
        for (int i = 2; i < strings.length; i++) {
            stringLine[i] = strings[i].substring(strings[i].indexOf("=") + 1, strings[i].indexOf(","));
        }
        intLine[0] = Integer.parseInt(stringLine[2]);
        intLine[1] = Integer.parseInt(stringLine[3]);
        intLine[2] = Integer.parseInt(stringLine[5]);
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(intLine[0]);
        speakers.setNumberOfSpeakers(intLine[1]);
        speakers.setFrequencyRange(stringLine[4]);
        speakers.setCordLENGTH(intLine[2]);
        return speakers;
    }

    @Override
    public <E> Appliance readingFile(Criteria<E> criteria) throws IOException {
        Appliance appliance;
        File file = new File("resources//appliances_db.txt");
        int count = 0;
        Scanner scanner = new Scanner(file);
        Map<E, Object> map = criteria.getCriteria();
        while (scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            fileLine = fileLine.replace(";", ",");
            String parameter;
            for (Map.Entry entry : map.entrySet()) {
                parameter = " " + entry.getKey() + "=" + entry.getValue() + ",";
                if (fileLine.contains(parameter)) {
                    count++;
                }
            }
            if (fileLine.contains("Speakers") && map.size() == count) {
                appliance = makeSpeakers(fileLine);
                return appliance;
            }
            count = 0;
        }
        return null;
    }
}
