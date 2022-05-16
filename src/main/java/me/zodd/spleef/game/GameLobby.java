package me.zodd.spleef.game;

import java.util.List;
import java.util.UUID;

public class GameLobby {
    protected List<UUID> lobbyPlayers;

    private int requiredPlayersToStart;


    public void beginGame() {

    }

    public void addLobbyPlayer(UUID playerId) {
        this.lobbyPlayers.add(playerId);
    }
}