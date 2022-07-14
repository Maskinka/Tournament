package ru.netology.manager;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }
    public int round(String playerName1, String playerName2) {
        Player player1Num = findByName(playerName1);
        Player player2Num = findByName(playerName2);

        if (player1Num == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not found");
        }
        if (player2Num == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not found");
        }

        int strengthPlayer1 = findByName(playerName1).getStrength();
        int strengthPlayer2 = findByName(playerName2).getStrength();
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }
}
