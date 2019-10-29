package nl.han.ooad.service.user;

import java.util.Scanner;

public interface IUserState {
    String INPUT_PLAYING = "s";
    String INPUT_SHOP = "v";

    String getMenu(Scanner scanner);

    boolean checkInput(String option);
}
