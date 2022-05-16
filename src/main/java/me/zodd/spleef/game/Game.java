package me.zodd.spleef.game;

import java.util.List;
import java.util.UUID;

public class Game {
    private Game instance;

    int gameId;

    private List<UUID> alivePlayers;

    GameSettings settings;

    public Game(int gameId) {
        this.gameId = gameId;
    }

    public Game(int gameId, GameSettings settings) {
        this.gameId = gameId;
        this.settings = settings;
    }

    public void setupGame() {
        GameSettings settings = new GameSettings();
        //Move players if applicable
        //Generate playfield
        //match countdown
    }

    public void setupGame(GameSettings gameSettings) {
        //TODO setup lobby with settings
    }

    void runGame() {
        //countdown timer
    }

    public void removePlayer(UUID uuid) {
        getAlivePlayers().remove(uuid);
    }

    public List<UUID> getAlivePlayers() {
        return alivePlayers;
    }

    public Game getInstance() {
        return instance;
    }

}
