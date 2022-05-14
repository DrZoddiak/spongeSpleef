package me.zodd.spleef.events.listeners;

import me.zodd.spleef.game.Game;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;

public class PlayerDeath {

    Game runningGame;

    PlayerDeath playerDeath(Game game) {
        runningGame = game;
        return this;
    }

    PlayerDeath playerDeath() {
        return this;
    }

    @Listener
    void onPlayerDeath(DestructEntityEvent event) {
        if (!(event.entity() instanceof ServerPlayer)) { return; }
        ServerPlayer p = (ServerPlayer) event.entity();

        runningGame.removePlayer(p.uniqueId());
    }

}
