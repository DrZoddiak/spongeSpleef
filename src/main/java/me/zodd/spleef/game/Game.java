package me.zodd.spleef.game;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;

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

    public Game() {

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

    int time(int timer){
        while (timer < 10){
            BossBar bar = BossBar.bossBar(Component.text("Time until game: " + timer), 2f, BossBar.Color.BLUE, BossBar.Overlay.NOTCHED_6);
            timer++;
        }

    return timer;
    }

    void runGame() {
        time(10);
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
