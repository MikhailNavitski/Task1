package by.tc.task01.main;

import by.tc.task01.entity.*;
import by.tc.task01.main.command.Command;
import by.tc.task01.main.command.CommandDirector;

public class PrintApplianceInfo {
    public static void print(Appliance appliance) {
        if (appliance == null) {
            System.out.println("Данный товар не найден");
        } else {
            CommandDirector director = new CommandDirector(appliance);
            Command command;
            command = director.getCommand(appliance.getClass().toString());
            command.printInfo();
        }
    }
}
