package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisteredException;
import ru.netology.manager.Game;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Joy", 1000);
    Player player2 = new Player(2, "Kevin", 1000);
    Player player3 = new Player(3, "Ann", 2000);
    Player player4 = new Player(4, "Todd", 3000);
    Player player5 = new Player(5, "Dan", 4000);
    Player player6 = new Player(6, "Lin", 0);

    @Test
    public void equalStrength() {
        game.register(player1);
        game.register(player2);

        int actual = game.round("Joy", "Kevin");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWin() {
        game.register(player4);
        game.register(player3);

        int actual = game.round("Todd", "Ann");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        game.register(player4);
        game.register(player5);

        int actual = game.round("Todd", "Dan");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerException() {
        game.register(player4);
        game.register(player5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Todd", "Ann");
        });
    }

    @Test
    public void secondPlayerException() {
        game.register(player1);
        game.register(player5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Kevin", "Dan");
        });
    }
}