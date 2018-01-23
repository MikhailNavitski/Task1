package by.tc.task01.dao.creator;

import by.tc.task01.dao.command.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;


public class SpeakersCreator implements Command {

    public Appliance makeAppliance(String [] value) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.parseInt(value[2]));
        speakers.setNumberOfSpeakers(Integer.parseInt(value[3]));
        speakers.setFrequencyRange(value[4]);
        speakers.setCordLENGTH(Integer.parseInt(value[5]));
        return speakers;
    }


}
