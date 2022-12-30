package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    protected Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not found");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not found");
        }

        int strengthPlayer1 = player1.getStrength();
        int strengthPlayer2 = player2.getStrength();
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }
}
