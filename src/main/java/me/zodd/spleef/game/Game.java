package me.zodd.spleef.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {

    private Game instance;

    private List<UUID> alivePlayers;
    private int matchLength;

    Game game(List<UUID> alivePlayers, int matchLength) {
        this.alivePlayers = alivePlayers;
        this.matchLength = matchLength;
        return instance = this;
    }

    void setupGame() {
        //Move players if applicable
        //Generate playfield
        //match countdown
    }

    void runGame() {
        //countdown timer
        //
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

    public void setMatchLength(int matchLength) {
        this.matchLength = matchLength;
    }

    public int getMatchLength() {
        return matchLength;
    }
}
