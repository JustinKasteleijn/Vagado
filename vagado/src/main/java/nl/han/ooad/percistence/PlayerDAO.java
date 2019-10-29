package nl.han.ooad.percistence;

import nl.han.ooad.dto.PlayerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static nl.han.ooad.percistence.connectionpool.ConnectionFactoryPool.getConnection;

public class PlayerDAO implements IPlayerDAO {
    private static final String SELECT_ALL_FROM_USERS = "SELECT * FROM USERS";

    private int balance;
    private String username;
    private String password;


    @Override
    public List<PlayerDTO> getUser(String username) {
        List<PlayerDTO> players = new ArrayList<>();
        try (
                Connection connection = getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FROM_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                players.add(new PlayerDTO(
                        resultSet.getInt("vagado_id"),
                        resultSet.getInt("balance"),
                        resultSet.getString("user"),
                        resultSet.getString("password"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }
}
