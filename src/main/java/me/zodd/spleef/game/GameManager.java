package me.zodd.spleef.game;

import java.util.Map;

public class GameManager {

    static Map<Integer, Game> activeGames;

    static int runningGames = 0;

    public GameManager() {

    }

    public Game createGame() {
        Game game = new Game(runningGames);
        activeGames.put(runningGames,game);
        runningGames++;
        return game;
    }

    public void destroyGame(int gameId) {
        activeGames.remove(gameId);
        //todo Breakdown process for the game
    }

}
