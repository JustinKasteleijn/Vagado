package nl.han.ooad.service.user;

import java.util.Scanner;

public class WorkerService implements IUserState {
    private static final String INPUT_EDITING = "e";

    @Override
    public String getMenu(Scanner scanner) {
        System.out.println("Wat wilt u doen?");
        System.out.println("Druk op " + INPUT_PLAYING + " om het spel te spelen");
        System.out.println("Druk op " + INPUT_SHOP + " om de vagado shop in te gaan");
        System.out.println("Druk op " + INPUT_EDITING + "om de vragenlijst te kunnen beheren");
        String option = scanner.next().substring(0, 1);
        if (!checkInput(option)) getMenu(scanner);
        return option;
    }

    @Override
    public boolean checkInput(String option) {
        if (option.equalsIgnoreCase(INPUT_SHOP)) {
            System.out.println("Happy spendings");
        } else if (option.equalsIgnoreCase(INPUT_PLAYING)) {
            System.out.println("Have fun playing");
        } else if (option.equalsIgnoreCase(INPUT_EDITING)) {
            System.out.println("Have fun editing");
        } else {
            System.out.println("This option is not available");
            return false;
        }
        return true;
    }
}
