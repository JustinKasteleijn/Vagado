package nl.han.ooad.dto;

public class PlayerDTO {
    private int vagado_id;
    private int balance;
    private String username;
    private String password;

    public PlayerDTO(int vagado_id, int balance, String username, String password) {
        this.vagado_id = vagado_id;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public int getVagado_id() {
        return vagado_id;
    }

    public int getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
