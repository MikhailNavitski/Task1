package dao.impl;

import entity.Appliance;
import entity.Speakers;

public class SpeakersDAO {
    public String line;

    public SpeakersDAO(String line) {
        this.line = line;
    }

    public Appliance makeSpeakers() {
        String[] strinLine = new String[8];
        int[] intLine = new int[8];
        String[] a = line.split(" ");
        for (int i = 2; i < a.length; i++) {
            strinLine[i] = a[i].substring(a[i].indexOf("=") + 1, a[i].indexOf(","));
        }
        intLine[0] = Integer.parseInt(strinLine[2]);
        intLine[1] = Integer.parseInt(strinLine[3]);
        intLine[2] = Integer.parseInt(strinLine[5]);
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(intLine[0]);
        speakers.setNumberOfSpeakers(intLine[1]);
        speakers.setFrequencyRange(strinLine[4]);
        speakers.setCordLENGTH(intLine[2]);
        return speakers;
    }
}
