package nl.han.ooad.service.authentication;

import nl.han.ooad.dto.PlayerDTO;
import nl.han.ooad.service.user.IUserState;

public interface IPlayerAuthentication {
    PlayerDTO authenticate(String username, String password);

    void setState(int id);

    IUserState getUserState();
}
