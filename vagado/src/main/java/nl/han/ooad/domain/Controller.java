package nl.han.ooad.domain;

import nl.han.ooad.dto.PlayerDTO;
import nl.han.ooad.service.authentication.IPlayerAuthentication;
import nl.han.ooad.service.user.IUserState;

import javax.inject.Inject;
import java.util.Scanner;

public class Controller {
    private Scanner scanner = new Scanner(System.in);
    // Test
    private IPlayerAuthentication playerAuthentication;

    @Inject
    public void setPlayerAuthentication(IPlayerAuthentication playerAuthentication) {
        this.playerAuthentication = playerAuthentication;
    }

    private IUserState startGame() {
        System.out.println("Welkom bij Vagado!, Log in om te kunnen spelen");
        System.out.println("Vul alstublieft uw gebruikersnaam in!");

        String username = scanner.next();

        System.out.println("Vul alstublieft uw wachtwoord in");

        String password = scanner.next();

        PlayerDTO player = playerAuthentication.authenticate(username, password);

        playerAuthentication.setState(player.getVagado_id());

        System.out.println("Welkom" + player.getUsername());
        System.out.println("uw balance is" + player.getBalance());

        return playerAuthentication.getUserState();
    }

    private String menu(IUserState userState) {
        return userState.getMenu(scanner);
    }

}
