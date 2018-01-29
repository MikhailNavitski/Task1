package by.tc.task01.main.appliance_information;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.main.command.Command;

public class SpeakersInfo implements Command {
    private Appliance appliance;

    public SpeakersInfo(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void printInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\tSpeakers\t\t\t");
        System.out.println("PowerConsumption = " + ((Speakers) appliance).getPowerConsumption());
        System.out.println("NumberOfSpeakers = " + ((Speakers) appliance).getNumberOfSpeakers());
        System.out.println("FrequencyRange = " + ((Speakers) appliance).getFrequencyRange());
        System.out.println("CordLength = " + ((Speakers) appliance).getCordLength());
        System.out.println("------------------------------------------------------");
    }
}
