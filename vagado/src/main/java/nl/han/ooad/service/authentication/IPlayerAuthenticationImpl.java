package nl.han.ooad.service.authentication;

import nl.han.ooad.dto.PlayerDTO;
import nl.han.ooad.percistence.IPlayerDAO;
import nl.han.ooad.service.exception.AuthenticationUserFailedException;
import nl.han.ooad.service.user.IUserState;
import nl.han.ooad.service.user.PlayerService;
import nl.han.ooad.service.user.WorkerService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class IPlayerAuthenticationImpl implements IPlayerAuthentication {

    private IPlayerDAO playerDAO;

    @Inject
    public void setPlayerDAO(IPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    private IUserState userState;

    @Override
    public PlayerDTO authenticate(String username, String password) {
        List<PlayerDTO> player = playerDAO.getUser(username);
        Optional<PlayerDTO> optionalPlayer = player.stream().filter((playerDTO -> playerDTO.getPassword().equals(password))).findFirst();
        return optionalPlayer.orElseThrow(AuthenticationUserFailedException::new);
    }

    @Override
    public void setState(int id) {
        if (id == 0) {
            userState = new PlayerService();
        }
        userState = new WorkerService();
    }

    @Override
    public IUserState getUserState() {
        return userState;
    }
}
