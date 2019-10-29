package nl.han.ooad.percistence;

import nl.han.ooad.dto.PlayerDTO;

import java.util.List;

public interface IPlayerDAO {
    List<PlayerDTO> getUser(String username);
}
