package me.zodd.spleef.events.senders;

import me.zodd.spleef.Spleef;
import me.zodd.spleef.game.Game;

public class CreateGameEvent extends AbstractSpleefEvent {
    private final Game game;

    public CreateGameEvent(Game game, Spleef instance) {
        super(instance);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}