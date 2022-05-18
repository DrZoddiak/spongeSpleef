package me.zodd.spleef.game;

import java.util.List;
import java.util.UUID;

public class GameLobby {
    protected List<UUID> lobbyPlayers;

    private List<UUID> requiredPlayersToStart;


    public void beginGame() {
    if (lobbyPlayers.equals(requiredPlayersToStart)){
        Game game = new Game();
        game.runGame();
    }
    }

    public void addLobbyPlayer(UUID playerId) {
        this.lobbyPlayers.add(playerId);
    }
}