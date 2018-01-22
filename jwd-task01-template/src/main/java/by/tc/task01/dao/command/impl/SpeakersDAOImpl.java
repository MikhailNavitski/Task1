package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;


public class SpeakersDAOImpl implements Command {


    public Appliance makeAppliance(String fileLine) {
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


}
